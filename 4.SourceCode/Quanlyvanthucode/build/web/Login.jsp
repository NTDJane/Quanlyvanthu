<link href="include/css/bootstrap.css" rel="stylesheet" type="text/css"/>

<script src="include/JavaScript/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="include/JavaScript/jquery-ui.1.12.2.js" type="text/javascript"></script>
<link href="include/css/form.css" rel="stylesheet" type="text/css"/>

<!--<script src="include/JavaScript/jquery-1.11.1.min.js" type="text/javascript"></script>-->
<script>
    $(document).ready(function () {
        if ($(".leftmenu ul.nav-left > li:last-child ul").hasClass("nav-lv2")) {
            $(".leftmenu ul.nav-left li:last-child a span").each(function (index) {
                $(this).attr("style", "border-bottom: 1px dotted #73a0bc !important;");
            });
        }
    });
    $(function () {
        $("#datepicker").datepicker();
    });


</script>
<%
    String error = "";
    if (request.getAttribute("Loi") != null) {
        error = (String) request.getAttribute("Loi");
    }
%>


<head>

<%@include  file="head.jsp" %>
<%@include  file="Menuchinh.jsp" %>
    
<div class="container" >
    <div class="fullcontent">
        <div class="bottom-content">
            <div class="left250 fix-color-left">

            </div>
            <div class="right730">
                <form style="margin: 100px 0px" action="Nguoidung" method="post">
                    <div class="search" style="width: 460px">
                        <h4 style="color: #fff; margin-left: 20px;height: 2%; text-align: center">Login</h4>
                        <br>

                        <div style="background: #fff;color: #888;font-size: 12px; " class="container-fluid" style="display: inline-block">
                            <input name="command" value="Login" type="hidden">
                            <label class="col-lg-3">Your Mail(*)</label>
                            <input type="text" name="mail"  style="margin-top: 7px"><br>

                            <br>

                            <label class="col-lg-3">Password(*)</label>
                            <input type="password" name="password" option="password" placeholder="Password" style="margin-top: 7px" >


                            <br>


                            <button type="submit" class="col-sm-offset-3 btn btn-primary" value="Submit" style="margin-top: 10px ;margin-bottom: 10px; margin-left: 180px" >Login</button>
                            <h5 style="color: #E42017; margin-left: 25%" ><%=error%></h5>
                        </div>
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
</style>
