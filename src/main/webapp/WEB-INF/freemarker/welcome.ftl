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
    <#include "/loadEvents.ftl">

   <a href="${bookTicketUrl!"/bookTicket"!}">${bookTicketName!"Book ticket"!}</a>

<br>
    <#include "/copyright.ftl">

</body>
</html>
