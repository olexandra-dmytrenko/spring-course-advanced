<form method="get" action="/bookTicket">
   <input type="submit" value="  Book Ticket  "
          style="font-size:10pt;color:Cornsilk;background-color:Crimson;border:2px inset #336600;padding:3px"/>
   <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
</form>
