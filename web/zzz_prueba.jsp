<%-- 
    Document   : zzz_prueba
    Created on : 19-ago-2015, 14:39:41
    Author     : Dormitorio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
  <HEAD>
    <TITLE>Using the switch Statement</TITLE>
  </HEAD>

  <BODY>
    <H1>Using the switch Statement</H1>
    <%
        int day = 4;

        switch(day) {
            case 0:
                out.println("It\'s Sunday.");
                break;
            case 1:
                out.println("It\'s Monday.");
                break;
            case 2:
                out.println("It\'s Tuesday.");
                break;
            case 3:
                out.println("It\'s Wednesday.");
                break;
            case 4:
                out.println("It\'s Thursday.");
                break;
            case 5:
                out.println("It\'s Friday.");
                break;
            default:
                out.println("It must be Saturday.");
        }
    %>
  </BODY>
</HTML>