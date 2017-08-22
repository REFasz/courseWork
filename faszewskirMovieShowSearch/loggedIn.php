<?php 
	session_start();
	if(!isset($_SESSION['username']) && !isset($_SESSION['adminName'])){ //if login in session is not set
    	header("Location: userLogin.php");
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
		
		<div id="content" s>
			 <h3 style="margin-left: 37%;">You are currently Logged in to Shoovies. </h3><br>
			<section style="margin-left: 35%">	
				Go to the Logout page to successfully log out of your account.
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