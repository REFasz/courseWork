#include <sys/types.h>
#include <sys/sem.h>
#include <sys/ipc.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>



void main(int argc, char *argv[]){
	int remPhil, //remaining philosophers (semaphore)
		fork, //array used to hold fork semaphores
		philNum = 5, //number of philosopher 
		retVal1, //first return value for semaphores
		retVal2, // second return value for semaphores
		count = 0,	//counter used for while statement
		eatCount;  //counter recording the amount of times particular philosopher has eaten
		
	if(argc != 2){
		perror("Please enter correct parameters");
		exit(0);
	}
	if(argv[1][0] >= '0' && argv[1][0] < '5'){
		philNum = atoi(argv[1]);
	}
	else{
		printf("Please enter correct parameters");
		exit(0);
	}

	//4 sembuff structure variables to tell the program which semaphore to work with
	struct sembuf signalLeft;
	signalLeft.sem_flg = 0;
	signalLeft.sem_num = (philNum+1)%5;;
	signalLeft.sem_op = 1;

	struct sembuf signalRight;
	signalRight.sem_flg = 0;
	signalRight.sem_num = philNum;
	signalRight.sem_op = 1;

	struct sembuf waitLeft;
	waitLeft.sem_flg = 0;
	waitLeft.sem_num = (philNum+1)%5;;
	waitLeft.sem_op = -1;

	struct sembuf waitRight;
	waitRight.sem_flg = 0;
	waitRight.sem_num = philNum;
	waitRight.sem_op = -1;

	//used with semaphore which represents the count of how many philosophers are still "alive"
	struct sembuf alive;
	alive.sem_flg = 0;
	alive.sem_num = 0;
	alive.sem_op = -1;

	remPhil = semget(250, 1, IPC_CREAT|0600);

	if(remPhil < 0){
		perror("Less than 0 Philosophers Remaining!!!!!");
		exit(0);
	}

	fork = semget(255, 5, IPC_CREAT|0600); //ARRAY OF SEMAPHORES

	if(fork < 0){
		perror("Less than 0 forks!!!!!");
		exit(0);
	}

	if(philNum == 0){
		retVal1 = semctl(remPhil, 0, SETVAL, 5);
		if(retVal1 < 0){
			perror("Couldn't Create Remaining Philosophers!!!");
			exit(0);
		}
		else{
			while(count < 5){	//initializes fork semaphores
				retVal1 = semctl(fork, count, SETVAL, 1);
				if(retVal1 < 0){
					perror("Couldn't Create Remaining Philosophers!!!!!");
					exit(0);
				}
				count++; //increments count for while statement
			}//end while
		}
	}

	srand((unsigned)(philNum * time(NULL)));
	int timeToWait = rand()%30+60;
	printf("Philosopher # %d waits for %d seconds of time!! \n", philNum, timeToWait);
		fflush(stdout); //flushes the output buffer of a stream
		sleep(timeToWait); //suspends execution for timeToWait interval of time
	int timeToThink = rand()%10+10;
	int timeToEat = rand()%5+5;
	//infinite loop until all philosophers are done eating
	while(1){
		

		printf("Philosopher # %d thinks for %d seconds of time!! \n", philNum, timeToThink);
		fflush(stdout);
		sleep(timeToThink); //suspends execution for timeToThink interval of time
		
		//Philosopher takes right fork?
		retVal1 = semop(fork, &waitRight, 1);
		if(retVal1 < 0){
			perror("Philosopher couldn't manage to pick up the fork on the right..........");
			exit(0);
		}
		else{
			printf("Philosopher # %d takes the fork on the right at %d\n", philNum, philNum);
			fflush(stdout);
		}

		//Philosopher takes left fork?
		retVal1 = semop(fork, &waitLeft, 1);
		if(retVal1 < 0){
			perror("Philosopher couldn't manage to pick up the fork on the left..........");
			exit(0);
		}
		else{
			printf("Philosopher # %d takes the fork on the left at %d\n", philNum, (philNum+1)%5);
			fflush(stdout);
		}

		//Philosophers starts and finishes eating
		printf("Philosopher # %d is eating for %d seconds of time\n", philNum, timeToEat);
		fflush(stdout);
		sleep(timeToEat);

		//Philosopher tries to put down left fork
		retVal1 = semop(fork, &signalLeft, 1);
		if(retVal1 < 0){
			perror("Philosopher couldn't manage to put down the fork on the left..........");
			exit(0);
		}
		else{
			printf("Philosopher # %d puts down the fork on the left at %d\n", philNum, (philNum+1)%5);
			fflush(stdout);
		}

		//Philosopher tries to put down right fork
		retVal1 = semop(fork, &signalRight, 1);
		if(retVal1 < 0){
			perror("Philosopher couldn't manage to put down the fork on the right..........");
			exit(0);
		}
		else{
			printf("Philosopher # %d puts down the fork on the right at %d\n", philNum, philNum);
			fflush(stdout);
		}
		eatCount++;
		//if statement to terminate philosopher that has eaten 3 times
		if(eatCount == 3){
			printf("Philosopher # %d is full\n", philNum);
			fflush(stdout);
			break;
		} //end if
	}//end for

	retVal2 = semctl(remPhil, 0, GETVAL, 0);

	//decrement philosophers
	if(retVal2 > 1){
		retVal1 = semop(remPhil, &alive, 1);
		if(retVal1 < 0){
			perror("Philosopher couldn't leave\n");
			exit(0);
		}//end of inner if
		else{
			printf("Philosopher # %d was able to leave the table\n", philNum);
			fflush(stdout);
		}//end of else
	}//end of if

	//last philosopher reognizes its last and removes semaphores
	else if(retVal2 == 1){ 
		retVal1 = semctl(fork, IPC_RMID, 0);
		if(retVal1 < 0){
			perror("Couldn't clear fork semaphores\n");
			exit(0);
		}//end first inner if
		else{
			printf("Philosopher # %d was able to clear fork semaphores\n", philNum);
			fflush(stdout);
		}//end of else
		retVal1 = semctl(remPhil, 1, IPC_RMID, 0);
		if(retVal1 < 0){
			printf("Couldn't clear remaining Semaphores\n");
			exit(0);
		}//end of second inner if
		else{
			printf(" Philosopher # %d Was able to clear the remaining Semaphores\n", philNum);
			fflush(stdout);
		}//end of else
		exit(0);
	}//end else if
	else if(retVal2 < 0){
		perror("Couldn't seem to get the value from the semaphore\n");
		exit(0);
	}//end of second else if
	exit(0);

}//end main

