<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Skeleton 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20130902

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="css/privy/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/privy/fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
<script type="text/javascript" src="jquery/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/gigr.js"></script>
 
</head>
<body>
<script type="text/javascript">
    $('#ajax').click(getVenue(<%= request.getParameter("id") %>,function(venue) {
        $('#venue-name').html(venue.name);
        var address = venue.address;
        $('#venue-address').html(address.street+' - '+
                address.city+' - '+
                address.state+' - '+
                address.zip);
        
        $('#venue-phone').html(venue.phoneNumber);
        

        var categories = venue.detail.categories.entry;
        
        categories.forEach(function(entry, index, array) {
        	entry.value.features.forEach(function(feature, index, array) {
	        	if (entry.key == "Equipment") {
	        		 $('#venue-equipment').append('<div>'+feature.name+' '+feature.value+'</div>'); 	
	        	} else if (entry.key == "Perks") {
                	$('#venue-perks').append('<div>'+feature.name+' '+feature.value+'</div>');  
                } else if (entry.key == "Loading") {
                	$('#venue-load').append('<div>'+feature.name+' '+feature.value+'</div>');
                } else if (entry.key == "Venue") {
                	$('#venue-venue').append('<div>'+feature.name+' '+feature.value+'</div>');
                } else if (entry.key == "Show") {
                	$('#venue-show').append('<div>'+feature.name+' '+feature.value+'</div>');
                } 
        	});
        });
 
    }));
</script>
<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<img src="css/privy/images/pic02.jpg" alt="" />
			<h1><a href="#">Privy</a></h1>
			<span>Design by <a href="http://www.freecsstemplates.org/" rel="nofollow">FreeCSSTemplates.org</a></span>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="#" accesskey="1" title="">Homepage</a></li>
				<li><a href="#" accesskey="2" title="">Our Clients</a></li>
				<li><a href="#" accesskey="3" title="">About Us</a></li>
				<li><a href="#" accesskey="4" title="">Careers</a></li>
				<li><a href="#" accesskey="5" title="">Contact Us</a></li>
			</ul>
		</div>
	</div>
	<div id="main">
		<!-- div id="banner">
			<img src="css/privy/images/pic01.jpg" alt="" class="image-full" />
		</div -->
		<div id="welcome">
			<div class="title">
				<h2 id="venue-name"></h2>
				<div id="venue-address" class="byline"></div>
				<div id="venue-phone" class="byline"></div>
			</div>
		</div>
		<div id="featured">
				<div class="table">
					<div id="venue-equipment" class="col3"><h3>Equipment</h3></div>
					<div id="venue-venue" class="col3"><h3>Venue</h3></div>
					<div id="venue-perks" class="col3"><h3>Perks</h3></div>
				</div>
				<div class="table">
                    <div id="venue-load" class="col3"><h3>Loading</h3></div>
                    <div id="venue-show" class="col3"><h3>Show</h3></div>
                    <div id="venue-show" class="col3"><h3></h3></div>
                </div>
				<ul class="style1">
				<li class="first">
					<p class="date"><a href="#"><b>E</b></a></p>
					<h3>Equipment</h3>
					<div id="venue-equipment"></div>
				</li>
				<li>
					<p class="date"><a href="#">Jan<b>03</b></a></p>
					<h3>Sagittis diam dolor amet</h3>
					<p><a href="#">Etiam non felis. Donec ut ante. In id eros. Suspendisse lacus turpis, cursus egestas at sem. Mauris quam enim, molestie. Donec leo, vivamus fermentum nibh in augue praesent congue rutrum.</a></p>
				</li>
				<li>
					<p class="date"><a href="#">Jan<b>01</b></a></p>
					<h3>Amet sed volutpat mauris</h3>
					<p><a href="#">Consectetuer adipiscing elit. Nam pede erat, porta eu, lobortis eget, tempus et, tellus. Etiam neque. Vivamus consequat lorem at nisl. Nullam non wisi a sem semper eleifend. Etiam non felis. Donec ut ante.</a></p>
				</li>
				<li>
					<p class="date"><a href="#">Dec<b>31</b></a></p>
					<h3>Sagittis diam dolor amet</h3>
					<p><a href="#">Etiam non felis. Donec ut ante. In id eros. Suspendisse lacus turpis, cursus egestas at sem. Mauris quam enim, molestie. Donec leo, vivamus fermentum nibh in augue praesent congue rutrum.</a></p>
				</li>
			</ul>
		</div>
		<div id="copyright">
			<span>Copyright (c) 2013 Sitename.com. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a></span>
			<span>Design by <a href="http://www.freecsstemplates.org/" rel="nofollow">FreeCSSTemplates.org</a>.</span>
		</div>
	</div>
</div>
</body>
</html>
