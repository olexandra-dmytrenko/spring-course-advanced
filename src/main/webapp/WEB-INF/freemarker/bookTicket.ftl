<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Ticket Information</h2>
  <form name="tickets" action="/ticket" method="post">
  <table>
    <tr>
  	    <td>Your e-mail:</td>
  	    <td><input type="email" name="user.email" />	</td>
  	</tr>
    <tr>
        <td>Event</td>
        <td><input type="text" name="event.name" /> </td>
    </tr>
    <tr>
  	    <td>Seats:</td>
  	    <td><input type="text" name="seats" /><td>
  	</tr>
  	<tr>
  	    <td colspan = 2><input type="submit" value="   Save   " /> </td>
  	</tr>
  	</table>
  </form>
</body>
</html>