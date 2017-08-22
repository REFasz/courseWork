<?php
	include('config.php');

	function is_there($email,$name){
		$there = TRUE;
		
		$conn = new mysqli('localhost', 'root', 'cs304', 'shooviesDB');

		$sql1 = "SELECT * FROM user WHERE email = '$email';";
		$sql2 = "SELECT * FROM user WHERE username = '$name';";
		$result1 = mysqli_query($conn, $sql1);
		$result2 = mysqli_query($conn, $sql2);
		if($result1){
			while($row=mysqli_fetch_array($result1)){
				if($email==$row[0] ) {
					$there = FALSE;
				}
			}
		}
		
		if($result2){
			while($row=mysqli_fetch_array($result2)){
				if($name==$row[1] ) {
					$there = FALSE;
				}
			}
		}
		
		return $there;
		

		
	}
	function userCreate($email, $name, $password){
		$conn = new mysqli('localhost', 'root', 'cs304', 'shooviesDB');
		$name = addslashes($name);	
		$password = addslashes($password);
		$email = addslashes($email);		
		$sql3 = "insert into user values('$email', '$name', '$password');";

		$result3 = mysqli_query($conn, $sql3);

		return TRUE;
	}

	$email = $_POST['email'];
	$name = $_POST['username'];
	$password = $_POST['password'];	
	if(is_there($email,$name)) {
		if(userCreate($email,$name,$password)){	
			session_start();
			$_SESSION['email'] = $email;
			$_SESSION['username']= $name;
			$_SESSION['password']= $password;
		}		
	}
	else {
		echo 'Invalid User Creation: Username or Email Already in Use.';	
	}
	
?>

<!DOCTYPE html>
<html>
<head>
	<title>Shoovies</title>
	<link rel="stylesheet" href="final.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id = "header">

				<h1>Shoovies</h1>

		</div>
		<nav>
				<ul>
					<a href="final.php"><li>Home</li></a>
					<a href="accountPage.php"><li>Account Page</li></a>
					<a href="providers.php"><li>Providers</li></a>
					<a href="search.php"><li>Search</li></a>
					<a href="userLogin.php"><li>Login</li></a>
					<a href="logout.php"><li>Logout</li></a>
					<a href="adminLogin.php"><li>Admin</li></a>
				</ul>
				<div class="handle">Menu</div>
		</nav>
		
		<div id="content">
			<section style="text-align:center"> <?php echo 'Welcome '.$name;?>! Navigate throughout the site using the nav bar above!</section>
		</div>

	</div>
		<script >
			$('.handle').on('click', function(){
				$('nav ul').toggleClass('showing')
			});

		</script>
	<footer>
		<h2>Contact Information: <a href=mailto:aasdewasdsarfewrfasdfg@gmail.com>Email</a> Or By Phone: <u>809-907-1212<u></h2>
		


	</footer>
	

</body>
</html>
