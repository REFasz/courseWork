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
					<a href="userLogin.php"><li>Login</li></a>
				</ul>
				<div class="handle">Menu</div>
		</nav>
		
		<div id="content">
			
			<form action = "user.php" method="post">
				<label>email:</label><input type="text" name="email" />
				<br /> <br />
				<label>username:</label><input type="text" name="username" />
				<br /> <br />
				<label>password:</label><input type="password" name="password" />
				<br /> <br />
				<input type="submit" name="Submit" />
				<br /> <br /> 
			</form>
		
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
