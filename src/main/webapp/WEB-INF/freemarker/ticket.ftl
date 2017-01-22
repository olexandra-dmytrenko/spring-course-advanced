<html>
<head>
    <title>Booked Ticket</title>
</head>
<body>
    <p>You've just booked the ticket:
    <table border=1>
                <tr><td>${ticket.id}
                    <td>${ticket.event.name}
                    <td>${ticket.event.dateTime}
                    <td>${ticket.event.auditorium.name}
                    <td>${ticket.event.basePrice}
                    <td>${ticket.dateTime}
                    <td>${ticket.seats}
                    <td>${ticket.user.email}
                    <td>${ticket.price}
                </tr>
    </table>
</body>
</html>