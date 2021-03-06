<?php 
	session_start();
	if(!isset($_SESSION['username']) && !isset($_SESSION['adminName'])){ //if login in session is not set
    	header("Location: userLogin.php");
	}


	function getProviderList($provider){
		
		$conn = new mysqli('localhost', 'root', 'cs304', 'shooviesDB');
		


		$sql = "SELECT * FROM shoovie WHERE provider = '$provider';";
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
	<script type="text/javascript" src="providerSlide.js"></script>
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
		
		<div id="content" style="text-align: center;">
			
			<?php 
				$provider = $_GET['provider'];
				if($provider == 'example1'){
					$provider = "example1";
				}
				if($provider == 'example2'){
					$provider = "example2";
				}
				if($provider == 'example3'){
					$provider = "example3";
				}
				if($provider == 'example4'){
					$provider = "example4";
				}
				echo "<h2>Listings by ". $provider. " are listed below:</h2>";
				echo "<br>";
				getProviderList($provider);
				echo "<h2>Navigate to other provider's listings below by clicking on a slide you are interested in.</h2>";
			?>

			<div class="slideshow-container" >
				<div class="mySlides fade">
				    <div class="numbertext"></div>
				    <img onclick="imageClick('navigation.php?provider=example1')" src="example1.jpg" style="width:400px; height:350px;margin-left: 5px; ">
			    </div>

			    <div class="mySlides fade">
				    <div class="numbertext"></div>
				    <img src="example2.jpg" onclick="imageClick('navigation.php?provider=example2')" style="width:400px; height:350px; margin-left: 5px;">
			    </div>

		    	<div class="mySlides fade">
				    <div class="numbertext"></div>
				    <img src="example3.jpg" onclick="imageClick('navigation.php?provider=example3')" style="width:400px; height:350px; margin-left: 5px;">
				</div>

				<div class="mySlides fade">
				    <div class="numbertext"></div>
				    <img src="example4.jpg" onclick="imageClick('navigation.php?provider=example4')" style="width:400px; height:350px; margin-left: 5px;">
			    </div>

				  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
				  <a class="next" onclick="plusSlides(1)">&#10095;</a>
			</div>
			<br>
			
			
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