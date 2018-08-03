
<%@page import="java.util.ArrayList"%>
<%@page import="Database_Helpers.Nguoidungquerry"%>
<%@page import="java.time.format.DateTimeFormatterBuilder"%>
<%@page import="java.util.Date"%>
<%@page import="Model.Nguoidung" %>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
    DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime localdatetime = LocalDateTime.now();
    int idcongvan = Integer.parseInt(request.getParameter("idcongvan"));
    String sohieucongvan = request.getParameter("sohieu");
    Nguoidungquerry nguoidungquerry = new Nguoidungquerry();
    ArrayList<Nguoidung> danhsachnhanvien = nguoidungquerry.Laydanhsachnhanvien();

%>

<%@include file="head.jsp" %>
<%@include  file="/Menuchinh.jsp" %>

<div class="container" >
    <div class="fullcontent">
        <div class="bottom-content">
            <div class="left250 fix-color-left">
                <%@include file="Menutrai.jsp" %>
            </div>

            <div class="right730">
                <div><h4 style="color: #0071A6;margin-left: 30%">Assignment unit handling</h4></div>
                <form action="Phancongxuly" method="get">
                    <div style="background: #fff;color: #000;font-size: 12px" class="container-fluid" style="display: inline-block">
                        <label class="col-lg-3">Number of Dispatch</label>
                        <input class="" type="text" name="sohieucongvan" style="margin-left: 5%;margin-top:10px " value="<%=sohieucongvan%>" readonly=""><br>

                        <br>
                        <label class="col-lg-3">Processedman</label>
                        <select name="processedman" option="Agency" style="margin-left: 5%;margin-top: 10px"  >
                            <%for (Nguoidung  nguoidungnhanvien : danhsachnhanvien) {%>
                            <option value="<%=nguoidungnhanvien.getIdcanhan()%>">
                                <%=nguoidungnhanvien.getHoten()%>

                            </option>
                            <%}%>

                        </select>
                        <br>
                        <br>
                         <label class="col-lg-3">Time process</label>
                        <input type="date" name="timeprocess"  style="margin-left: 5%"   >
                        <br>
                        <input name="idcongvan" value="<%=idcongvan%>" type="hidden">
                        <button type="submit" class="col-sm-offset-4 btn btn-primary" value="Submit" style="margin-top: 10px ;margin-bottom: 10px" >Assign</button>
                    </div>


                </form>
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
    input{
        margin-left: 0%;
        margin-top:10px ;
        width: 250px;

    }
    label{
        margin-top: 10px;
    }
    a {
        color: #0071a6;
        text-decoration: none;
    }
    textarea{
        margin-left: 0%;
        margin-top:10px ;
        width: 50%;
        margin-left: 5%;
    }
</style>
