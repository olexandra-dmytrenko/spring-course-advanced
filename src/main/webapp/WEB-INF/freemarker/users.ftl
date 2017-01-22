<html>
<head>
    <title>Welcome!</title>
</head>
<body>
    <p>Users that are registered:
    <table border=1>
            <tr>
                <th>ID</th>
                <th>User Name</th>
                <th>Email</th>
                <th>Birthday</th>
            </tr>
        <#list users as user>
            <tr>
                <td>${user.id}
                <td>${user.name}
                <td>${user.email}
                <td>${user.birthday}
            </tr>
          </#list>
    </table>
</body>
</html>