<?php 
	session_start();
	if(!isset($_SESSION['username'])){ //if login in session is not set
    	header("Location: userLogin.php");
	}

	function getHBOGO(){
		
		$conn = new mysqli('localhost', 'root', 'cs304', 'shooviesDB');

		$sql = "SELECT * FROM provider WHERE name='$provider';";
		$result = mysqli_query($conn, $sql);
		
		if($result){
			while($row=mysqli_fetch_array($result)){
					echo $row[0]; 
					echo "<br>";	

			}
		
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
					<a href="logout.php"><li>Logout</li></a>
				</ul>
				<div class="handle">Menu</div>
		</nav>
		
		<div id="content" s>
			 <h2 style="margin-left: 35%;">Providers currently in our database: </h2><br>
			<section style="margin-left: 45%">	
				<?php 
					getProviders();
				?>
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