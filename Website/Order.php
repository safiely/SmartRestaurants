
<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */






echo <<<_END
<html lang="en">
<head>
  <title>Smart Restaurant</title>
  
	
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<link rel="stylesheet" type="text/css" href="reset.css">
	<link rel="stylesheet" type="text/css" href="main1.css">
        <script src="main.js"></script>
    
</head>
<body>
<div id = 'resto'>
	test
</div>
<button onclick="readFromDB()">View
</button>
<header>
		<div class="wrapper">
			<div class="logo">
				<a href=""><img src="Images\logo.PNG" alt="Res" title=""/></a>
			</div>

			<nav>
				<ul>
					
					<li><a href="index.php">Home</a></li>
					<li><a href="Menu.php">Menu</a></li>
					<li><a href="Order.php">Order</a></li>
				</ul>
			</nav>
		</div>
</header>
<div class="container">
<form>
<div class="row">
  <div class="col-md-12>
  <div class="table-responsive">
  <table id="resto" class="table" >
    <tr>
	<th>Order number</th>
        <th>Customer Name</th>
        <th>Food Items</th>
	<th>Action</th>
    </tr> 
  <!-- <tr>
  	<td></td>
        <td></td>
	<td></td>
	<td><button type="button" class="btn btn-primary btn-sm">Done</button><button type="button" class="btn btn-primary btn-sm">Cancel</button></td>
	</tr>
	<tr>
	
	<td></td>
	<td></td>
	<td></td>
	<td><button type="button" class="btn btn-primary btn-sm">Done</button><button type="button" class="btn btn-primary btn-sm">Cancel</button></td>
	</tr>
	<tr>
	
	<td></td>
	<td></td>
	<td></td>
	<td><button type="button" class="btn btn-primary btn-sm">Done</button><button type="button" class="btn btn-primary btn-sm">Cancel</button></td>
	</tr>
	<tr>
	
	<td></td>
	<td></td>
	<td></td>
	<td><button type="button" class="btn btn-primary btn-sm">Done</button><button type="button" class="btn btn-primary btn-sm">Cancel</button></td>
	</tr>-->
  </table>
  </div>
</div>
</div>
</form>
</div>



</body>
</html>
_END;
?>