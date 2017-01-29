<html>
<head>
    <title>Welcome!</title>
</head>
<body>
    <h1>
         Welcome ${message!"Admin, our beloved leader"!}!
        <#if message??> <p> Have a look on the events.</#if>
    </h1>

<p>
    <#include "/loadUsers.ftl">
<p>
    <#include "/loadEvents.ftl">
<div>
       <a href="${eventsUrl!"/events"!}">${events!"See events"!}</a>
      <p>
       <a href="${bookTicketUrl!"/bookTicket"!}">${bookTicketName!"Book ticket"!}</a>
</div>
    <#include "/logoutRedirect.ftl">
<br>
    <#include "/copyright.ftl">

</body>
</html>
