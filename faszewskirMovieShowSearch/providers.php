<?php 
	session_start();
	if(!isset($_SESSION['username']) && !isset($_SESSION['adminName'])){ //if login in session is not set
    	header("Location: userLogin.php");
	}

	function getProviders(){
		
		$conn = new mysqli('localhost', 'root', 'cs304', 'shooviesDB');

		$sql = "SELECT DISTINCT provider FROM shoovie;";
		$result = mysqli_query($conn, $sql);
		
		if($result){
			while($row=mysqli_fetch_array($result)){
					echo "<a href='byProvider.php'>".$row[0]."</a>"; 
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
		
		<div id="content" s>
			 <h2 style="margin-left: 15%;">Providers currently in our database: Please click on the image of the provider below to list movies or shows under provider.</h2><br>
			<section style="margin-left: 45%">	
				<?php 
					getProviders();
				?>
				
			</section>
			<div class="slideshow-container" >
				<div class="mySlides fade">
				    <div class="numbertext"></div>
				    <img onclick="imageClick('navigation.php?provider=example1')" src="example1.jpg" style="width:400px; height:320px;margin-left: 300px; ">
				</div>

			    <div class="mySlides fade">
				    <div class="numbertext"></div>
				    <img src="example2.jpg" onclick="imageClick('navigation.php?provider=example2')" style="width:400px; height:320px; margin-left: 300px;">
				</div>

				<div class="mySlides fade">
				    <div class="numbertext"></div>
				    <img src="example3.jpg" onclick="imageClick('navigation.php?provider=example3')" style="width:400px; height:320px; margin-left: 300px;">
			    </div>

			    <div class="mySlides fade">
				    <div class="numbertext"></div>
				    <img src="example4.jpg" onclick="imageClick('navigation.php?provider=example4')" style="width:400px; height:320px;margin-left: 300px;">
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