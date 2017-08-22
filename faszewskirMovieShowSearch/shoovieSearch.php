<?php 
	session_start();
	if(!isset($_SESSION['username']) && !isset($_SESSION['adminName'])){ //if login in session is not set
    	header("Location: userLogin.php");
	}

	include('config.php');

	function search($search){
		$count = 0;
		
		$conn = new mysqli('localhost', 'root', 'cs304', 'shooviesDB');

		$search = addslashes($search);	
		

		$sql = "SELECT * FROM shoovie WHERE name = '$search';";
		$result = mysqli_query($conn, $sql);
		
		if($result){
			while($row=mysqli_fetch_array($result)){
				if($search == $row[0]) {
					echo $row[0];
					echo '		';
					echo $row[1];
					echo "\n";
					$count = 1;
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
				$search = $_POST['search'];
				if(search($search)) {
					
				}
				else {
						echo "Sorry! There aren't any Shows or Movies under that title stored in the Shoovies Database";
				}?>
				
				<form action = "shoovieSearch.php" method="post">
					<label>Would you like to search again?</label>
					<br /> <br />
					<label>Search:</label><input type="text" name="search" />
					<br /> <br />
					<input type="submit" name="Submit" />
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
