<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign in</title>

    <!-- css -->
    <style>
        <%@ include file="../css/style.css" %>
        <%@ include file="../css/signInForm.css" %>
    </style>

    <!-- fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Architects+Daughter&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  	<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css'>
</head>

<body>
	<svg id="svg-source" height="0" version="1.1"  xmlns="http://www.w3.org/2000/svg" 
	xmlns:xlink="http://www.w3.org/1999/xlink" style="position: absolute">	
		<g id="man-people-user"><g id="Expanded"><g><g><path d="M24.042,30c-7.145,0-12.958-6.729-12.958-15S16.896,0,24.042,0C31.187,0,37,6.729,37,15S31.187,30,24.042,30z M24.042,2     c-6.042,0-10.958,5.832-10.958,13s4.916,13,10.958,13S35,22.168,35,15S30.084,2,24.042,2z"/></g><g><path d="M47.982,48H0.019v-6.771c0-2.951,1.867-5.601,4.645-6.592L17,31.238v-4.155h2v5.679l-13.735,3.78     c-1.913,0.687-3.247,2.579-3.247,4.687V46h43.964v-4.771c0-2.107-1.333-4-3.319-4.709L29,32.762v-5.637h2v4.113l12.265,3.376     c2.85,1.015,4.717,3.663,4.717,6.614V48z"/></g><g><path d="M32.799,13.218c-0.068,0-0.136-0.001-0.205-0.004c-2.251-0.082-4.875-1.506-6.542-3.431     c-1.166,1.486-2.831,2.442-4.892,2.792c-3.605,0.619-7.728-0.765-8.982-1.982l1.393-1.436c0.604,0.587,4.035,1.994,7.254,1.446     c1.998-0.339,3.438-1.366,4.28-3.051l0.836-1.671l0.927,1.622c1.107,1.938,3.763,3.637,5.8,3.712     c0.906,0.024,1.55-0.247,1.961-0.857l1.659,1.117C35.528,12.604,34.295,13.218,32.799,13.218z"/></g></g></g></g>
		<g id="lock-locker"><g id="Expanded"><g><g><circle cx="24" cy="30" r="2"/></g><g><path d="M24,38c-0.553,0-1-0.447-1-1v-6c0-0.553,0.447-1,1-1s1,0.447,1,1v6C25,37.553,24.553,38,24,38z"/></g><g><path d="M42,48H6V18h36V48z M8,46h32V20H8V46z"/></g><g><path d="M36,19h-2v-7c0-5.514-4.486-10-10-10S14,6.486,14,12v7h-2v-7c0-6.617,5.383-12,12-12s12,5.383,12,12V19z"/></g></g></g></g>
	</svg>

	
    <header class="header">
    	<div class="container__header">
    		<div class="header__inner">
    			<div class="header__logo">
    				Library Project
    			</div>
    			<nav class="nav">
    				<button class="nav__link" id="button__autorization">Sign in</button>
    			</nav>
    		</div>
    	</div>
    </header>


	<section class="wrapper">
		<div class="inner__wrapper" id="inner__wrapper">
			<div class="supform">
				<h3 class="sign-in">Sign in</h3>
				<button class="button__register">
		  			Register
			    </button>
		  	</div>
		  	<div class="clear"></div>
		    <form action="#">
		        <div>
		            <label class="user" for="user-name">
		            	<svg viewBox="0 0 64 64">
		            		<g filter="">
		            			<use xlink:href="#man-people-user"></use>
		            		</g>
		            	</svg>
		         	</label>
		        <input class="user-input" type="text" name="user-name" id="user-name" placeholder="My name is">
		      	</div> 
		      	<div>
		        	<label class="lock" for="user-password">
		          		<svg viewBox="0 0 64 64">
			             	<g filter="">
			               		<use xlink:href="#lock-locker"></use>
			              	</g>
		            	</svg>  
		        	</label>
		        	<input type="password" name="user-password" id="user-password" placeholder="Password">
		      	</div> 
		        <div>
		      		<input type="submit" value="Sign in" />
		    	</div>
		    	<div class="radio-check">   
		      		<input type="radio" class="radio-no" id="no" name="remember" value="no" checked>
	      			<label for="no"><i class="fa fa-times"></i></label>  
		      		<input type="radio" class="radio-yes" id="yes" name="remember" value="yes">
	      			<label for="yes"><i class="fa fa-check"></i></label>
		      		<span class="switch-selection"></span>
		    	</div>
		      		<span class="check-label">Remember me</span>
		      		<span class="forgot-label">Lost your password?</span>
		      	<div class="clear"></div>
		      	<div class="error">${error_login_placeholder}</div>
		  	</form>  
		</div>
	</section>


    <footer class="footer"></footer>
    
    <script>
        <%@ include file="../libs/jquery/jquery-3.6.0.min.js" %>
        <%@ include file="../js/login.js" %>
  	</script>
</body>
</html>