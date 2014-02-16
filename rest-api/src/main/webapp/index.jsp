<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <!-- Place this asynchronous JavaScript just before your </body> tag -->
    <script type="text/javascript">
      (function() {
       var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
       po.src = 'https://apis.google.com/js/client:plusone.js';
       var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
     })();
    </script>

<body>
<span id="signinButton">
  <span
    class="g-signin"
    data-callback="onSignInCallback"
    data-clientid="249121464147-gnslq9d5g0e4c5dlen9g01tpis2n8c9o.apps.googleusercontent.com"
    data-cookiepolicy="single_host_origin"
    data-requestvisibleactions="http://schemas.google.com/AddActivity"
    data-scope="openid profile email https://www.googleapis.com/auth/plus.login">
  </span>
</span>
</body>
<script type="text/javascript">

	function onSignInCallback(authResult) {
		if (authResult['status']['signed_in']) {
			// Update the app to reflect a signed in user
			// Hide the sign-in button now that the user is authorized, for example:
		    console.log('Sign-in state: ' + authResult['status']['signed_in'] + authResult['access_token']);
			document.getElementById('signinButton').setAttribute('style',
					'display: none');
		} else {
			// Update the app to reflect a signed out user
			// Possible error values:
			//   "user_signed_out" - User is signed-out
			//   "access_denied" - User denied access to your app
			//   "immediate_failed" - Could not automatically log in the user
			console.log('Sign-in state: ' + authResult['error']);
		}
	}
</script>
</html>