<?php
	

	function is_correct($name,$password){
		
		$email  = " ";
		$conn = new mysqli('localhost', 'root', 'cs304', 'shooviesDB');
		$name = addslashes($name);	
		$password = addslashes($password);
		
		
		$sql = "SELECT * FROM user WHERE username = '$name' and password = '$password' ;";

		$result = mysqli_query($conn, $sql);
		
		if($result){
			while($row=mysqli_fetch_array($result)){
				if($name == $row[1] &&  $password == $row[2]) {
					$email = $row[0];
					$_SESSION['email'] = $email;
					return TRUE;
				}
			}
		}
		else{
			return FALSE;
		}

		return FALSE;
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
					<a href="logout.php"><li>Logout</li></a> 
					<a href="adminLogin.php"><li>Admin</li></a>
				</ul>
				<div class="handle">Menu</div>
		</nav>
		
		<div id="content">
			<section> <?php 
				
				session_start();
				$name = $_POST['username'];
				$password = $_POST['password'];


				if(is_correct($name,$password)) {
					
					
					$_SESSION['username']= $name;
					$_SESSION['password']= $password;
					echo "Welcome ". stripslashes($email). stripslashes($name). ". \n Please use the nav bar above to access the various page Shoovies has to offer";	
				}
				else {
					echo 'invalid username/password !';
					session_destroy();
					header("Location: userLogin.php");
				}?>! 
			</section>
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
