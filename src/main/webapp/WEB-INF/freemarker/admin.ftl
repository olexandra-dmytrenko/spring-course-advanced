<%@ page session=true %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
    <h1>
         Welcome ${message!"Admin, our beloved leader"!}!
        <#if message??> <p> Have a look on the events.</#if>
        ${pageContext.request.userPrincipal.name}
                   | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>
    </h1>
</body>
</html>