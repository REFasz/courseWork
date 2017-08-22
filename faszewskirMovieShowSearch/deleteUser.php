<?php 
	session_start();
	if (!isset($_SESSION['adminName'])) {
		header("Location: adminLogin.php");
	}


	include('config.php');

	function search($userDelete){
		$count = 0;
		
		$conn = new mysqli('localhost', 'root', 'cs304', 'shooviesDB');

		$sql = "DELETE FROM user WHERE username = '$userDelete';";
		$result = mysqli_query($conn, $sql);
		
		if($result){
			while($row=mysqli_fetch_array($result)){
				if($userDelete == $row[0]) {
					echo $row[0];
					$count = 1;
				}else{

				}
			}
		}
		if($count > 0){
			return TRUE;
		}else{
			return FALSE;
		}

		
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
					<!--<a href="E:\everythingElse\ecommerce\finalProject/logout.html"><li>Logout</li></a> -->
					<a href="logout.php"><li>Logout</li></a> 
				</ul>
				<div class="handle">Menu</div>
		</nav>
		
		<div id="content">
			<section>

				<?php 
				$userDelete = $_POST['usertoDelete'];
				if(search($userDelete)) {
					echo " has been deleted!";
				}
				else {
						echo "User has been deleted if they are in the User Database";
				}?>
				
				<form action = "deleteUser.php" method="post">
					<label>Would you like to Delete another user? </label>
					<br /> <br />
					<label>Username:</label><input type="text" name="usertoDelete" />
					<br /> <br />
					<input type="submit" name="Delete User" />
					<br /> <br /> 
				</form>
					
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
