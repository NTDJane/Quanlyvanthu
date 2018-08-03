<%@page import="Model.Congvandi"%>
<%@page import="Model.Congvanden"%>
<link href="include/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="include/css/form.css" rel="stylesheet" type="text/css"/>
<link href="include/css/style.css" rel="stylesheet" type="text/css"/>
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
Congvandi congvan=(Congvandi)request.getAttribute("Thongtincua1congvan");
%>
<%@include  file="/head.jsp" %>
<%@include  file="/Menuchinh.jsp" %>

<div class="container" >
    <div class="fullcontent">
        <div class="bottom-content">
            <div class="left250 fix-color-left">
                <%@include file="Menutrai.jsp" %> </div>
            <div class="right730">
                <div >
                    <h4>
                        Title: 
                    </h4>
                </div>
                <div>
                    <h5>
                        Briefly:<%=congvan.getTrichdan()%>
                    </h5>
                </div>
                <div>
                    <span>File download:<a href="<%=congvan.getDuongdan()%>"><%=congvan.getDuongdan().substring(5)%></a></span>




                </div>
                <table >
                    <div style="background-color: #aed2e7;height: 50px; text-align: left">
                        <p>Validity: Issudate: Effective Date:</p>
                    </div>
                    <label>Information Dispatch:</label>
                    <thead >
                        <tr></tr>
                        <tr></tr>
                        <tr></tr>
                        <tr></tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Number of symbols</td>
                            <td><%=congvan.getSohieuvanbandi()%></td>
                            <td>Date issued</td>
                            <td><%=congvan. getNgayphathanh()%></td>
                        </tr>
                        <tr>
                            <td>The signer</td>
                            <td><%=congvan. getNguoiky()%></td>
                            <td>Where issued</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Expiry date</td>
                            <td></td>
                            <td>Where to send</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Validity status</td>
                            <td></td>
                            <td>Processer</td>
                            <td></td>                                
                        </tr>


                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
<%@include file="/footer.jsp" %>

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
