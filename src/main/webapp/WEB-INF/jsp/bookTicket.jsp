<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Ticket Information</h2>
<form:form method="POST" action="/bookTicket">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="event">Age</form:label></td>
            <td><form:input path="event" /></td>
        </tr>
        <tr>
            <td><form:label path="seats">id</form:label></td>
            <td><form:input path="seats" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>