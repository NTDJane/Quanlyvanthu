<%
  
    String view = "";
    if (request.getAttribute("view") == null ) {
        view = "Login.jsp";
    } else {
        view = (String) request.getAttribute("view");
    }

    if (view == "Login.jsp") {
%>
<%@include file = "Login.jsp" %>
<%} else if (view == "Themnhanvien.jsp") {

%>
<%@include file="Themnhanvien.jsp" %>
<%
    }
%>
