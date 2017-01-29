<hr>
<i>
<p>
   <h3> Upload Events </h3>
   <table>
    <tr>
        <td>
          <form method="post" action="/events">
            <input type="submit" value="  From Code  "
                style="font-size:10pt;color:white;background-color:green;border:2px groove #336600;padding:3px"/>
            <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>

          </form>
        </td>
        <td>
          <form method="post" action="/eventsPDF">
            <input type="button" id="loadFilePDF" value="   From PDF   " onclick="document.getElementById('file').click();"
                style="font-size:10pt;color:white;background-color:red; border:2px ridge #336600;padding:3px"/>
            <input type="file" style="display:none;" id="file" name="file" accept="application/pdf">
            <#--
             <input type= "file" value="From PDF" accept="application/pdf"
                style="font-size:10pt;color:white;background-color:red;border:2px solid #336600;padding:3px"/>
            -->
             <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
          </form>
        </td>
     </tr>
    </table>
<br>
</i>