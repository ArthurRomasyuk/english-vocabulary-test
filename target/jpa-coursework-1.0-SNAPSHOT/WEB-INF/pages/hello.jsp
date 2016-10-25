<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<a href="/web/questionAnswerCard.xhtml" style="font-size: large">Take the test!</a>
	<a href="/web/testHistory.xhtml">See your test history</a>
</head>
<body>
	<h3>Welcome!</h3>
	<h3>Username : ${username}</h3>
	
	<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
	
</body>
</html>