
<%@page import="Model.Tinhtrangxuly"%>
<%@page import="Model.Coquanbanhanhcongvan"%>
<%@page import="Model.Congvanden"%>
<%@page import="java.util.ArrayList"%>
<link href="include/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="include/css/form.css" rel="stylesheet" type="text/css"/>
<script>
    $(document).ready(function () {
        if ($(".leftmenu ul.nav-left > li:last-child ul").hasClass("nav-lv2")) {
            $(".leftmenu ul.nav-left li:last-child a span").each(function (index) {
                $(this).attr("style", "border-bottom: 1px dotted #73a0bc !important;");
            });
        }
    });
</script>

<%
    ArrayList<Congvanden> danhsachcongvan = (ArrayList) request.getAttribute("Danhsachtatcacongvan");
    String soluongcongvan = request.getParameter("count");
    ArrayList<Coquanbanhanhcongvan> danhsachcoquan = (ArrayList) request.getAttribute("Danhsachcoquan");
    ArrayList<Tinhtrangxuly> danhsachtrangthai = (ArrayList) request.getAttribute("Danhsachtrangthai");


%>
<%@include file="head.jsp" %>
<%@include  file="/Menuchinh.jsp" %>

<div class="container" >
    <div class="fullcontent">
        <div class="bottom-content">
            <div class="left250 fix-color-left">
                <%@include file="Menutrai.jsp" %>
            </div>
            <div ></div>
            <div class="right730">
                <%@include file="Khungtimkiem.jsp" %>

                <table >
                    <thead >
                        <tr>
                            <th>
                                Number of symbols
                            </th>
                            <th>Content</th>
                            <th>Date issued</th>
                            <th>Dispatch status</th>
                            <th>Assignment</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            String trichdan = "";
                            String trangthai="";
                            for (Congvanden congvan : danhsachcongvan) {
                                if (congvan.getTrichdan().length() > 200) {

                                    trichdan = congvan.getTrichdan().substring(0, 200/*(int) congvan.getTrichdan().length() * 1 / 8*/);
                                } else {
                                    trichdan=congvan.getTrichdan();
                                }
                                for(Tinhtrangxuly tinhtrang: danhsachtrangthai){
                                if(congvan.getTinhtranghieuluc()==tinhtrang.getIdXuly()){
                                trangthai=tinhtrang.getTentrangthai();
                                break;
                                }
                                }
                        %>
                        <tr style="height: 70px">
                            <td style="width: 75px;text-align: left">
                                <a href="Khungthongtincua1congvan?idcongvan=<%=congvan.getSothutu()%>&sohieu=<%= congvan.getSohieu()%>">  <%= congvan.getSohieu()%></a>
                            </td>
                                <td style="height: 70px"> <%=trichdan%></td>
                            <td style="width: 100px;text-align: center"><%=congvan.getNgaybanhanh()%></td>
                            <td  style="width: 100px;text-align: center"> <%=trangthai%></td>
                            <td style="width: 50px;text-align: center"><a href="Phancongchonguoixuly.jsp?idcongvan=<%=congvan.getSothutu()%>&sohieu=<%=congvan.getSohieu()%>"><img src="images/Icon-phancon.jpg"></a> </</td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <div>
                    <%

                        if ((request.getAttribute("count")) != null) {%> 
                    <% int count = Integer.parseInt(String.valueOf(request.getAttribute("count")));%>        
                    <ul class="pagination">
                        <%
                            int dem = 0;
                            if (count % 6 == 0) {
                                dem = count / 6;
                            } else {
                                dem = count / 6 + 1;
                            }
                            for (int i = 1; i <= dem; i++) {%>
                        <li><a href="ServletPhancongxuly?pages=<%= i%>"><%= i%></a></li>

                        <%
                            }
                        %>
                    </ul>
                    <%
                        }
                    %>
                </div>
            </div>

        </div>

    </div>
</div>

<%@include file="footer.jsp" %>
<style>

    .container{
        margin: 0;
        padding: 0;
        z-index: 1;
        display: inline-block;
        width: 100%;
    }
    .container .fullcontent{
        width: 1000px;
        margin: 0 auto; /*padding: 15px 0;*/
    }

    .bottom-content {
        float: left;
        width: 100%;
    }

    .bottom-content .left250 {
        width: 250px;
        float: left;
    }
    .bottom-content .right730 {
        width: 730px;
        float: right;
    }
    .fix-color-left .leftmenu .head-box {
        background: #0071A6 !important;
        min-height: 41px !important;
    }

    .right730 .right-home .head-box a {
        background: none !important;
        padding-left: 0 !important;
    }
    .leftmenu ul.nav-left {
        background: #e1edf3;
        padding: 10px;
    }

    .leftmenu ul.nav-left li {
        background: url(images/icon-listnew.png) no-repeat scroll left 14px;
        padding-left: 10px;
        background-position-y: 13px;
    }

    .leftmenu ul.nav-left li a {
        color: #004f80;
    }

    .leftmenu ul.nav-left li a span {
        border-bottom: 1px dotted #73a0bc;
        width: 100%;
        display: block;
        line-height: 35px;
    }

    .leftmenu ul.nav-left li:last-child a span {
        border-bottom: none;
    }

    table {
        width: 100%;
        margin-top: 10px;
        font-size: 14px;

    }

    table thead tr th {
        background-color: #0071A6 !important;
        font-weight: bold;
        border-top: solid 1px #004f80;
        border-left: solid 1px #004f80;
        height: 30px;
        color: white;
        text-align: center;
        vertical-align: middle;
    }

    table tr th:last-child {
        border-right: solid 1px #004f80;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    table tr td {
        border-top: 1px solid #004f80;
        border-left: 1px solid #004f80;
        vertical-align: middle;
        padding: 5px;
    }

    table tr td:last-child {
        border-right: 1px solid #004f80;
    }

    table tr:last-child td {
        border-bottom: 1px solid #004f80;
    }
</style>
