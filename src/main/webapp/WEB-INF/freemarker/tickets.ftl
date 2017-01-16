<html>
<head>
    <title>Welcome!</title>
</head>
<body>
    <p>We have these animals:
    <table border=1>
        <#if allTickets?size == 0>
              <p>There is no info to display because there are ${fn:length(allTickets)} tickets.
        <#else>
              <p>There is info to display. There are ${fn:length(allTickets)} tickets.
              <#list allTickets as ticket>
                <tr><td>${ticket.id}
                    <td>${ticket.event}
                    <td>${ticket.dateTime}
                    <td>${ticket.seats}
                    <td>${ticket.user.email}
                    <td>${ticket.price}
                </tr>
              </#list>
        </#if>
    </table>
</body>
</html>