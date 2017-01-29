 <form method="post" action="/logout">
             <input type="submit" value="  Logout  "
                 style="font-size:10pt;color:white;background-color:green;border:2px inset #336600;padding:3px"/>
             <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
           </form>
