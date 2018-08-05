
<%@page import="Model.Congvanden"%>
<%@page import="Model.Coquanbanhanhcongvan"%>

<%@page import="java.util.ArrayList"%>

<%@page import="java.time.format.DateTimeFormatterBuilder"%>
<%@page import="java.util.Date"%>
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
    
    function Kiemtracongvanden(){
        
    var sohieu=document.getElementById("sohieu");
    var ngaybanhanh=document.getElementById("ngaybanhanh");
    var nguoiky=document
    
    if(ten_san_pham.value == "")
    {
        alert("");
        ten_san_pham.focus();
        return false;
    }
    else if(Number(ten_san_pham.value))
    {
        alert("");
        ten_san_pham.select();
        return false;
    }
    
    
    return true;
        
        
        
    }
</script>
<%
    DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime localdatetime = LocalDateTime.now();
    Congvanden congvanden = (Congvanden) request.getAttribute("thongtincongvan");

%>

<%@include  file="/head.jsp" %>
<%@include  file="/Menuchinh.jsp" %>
<div class="container" >
    <div class="fullcontent">
        <div class="bottom-content">
            <div class="left250 fix-color-left">
                <%@include file="Menutrai.jsp" %>
            </div>
            <div class="right730">
                <form action="Themvaocosodulieusuacongvan" method="get" enctype="multipart/form-data" >
                    <div class="search">
                        <h4 style="color: #fff; margin-left: 20px;height: 2%;text-align: center">UPDATE DISPATCH TO </h4>
                        <br>
                        <input type="hidden" value="<%=congvanden.getSothutu() %>" name="idcongvanden">
                        <div style="background: #fff;color: #000;font-size: 12px" class="container-fluid" style="display: inline-block">
                            <label class="col-lg-3">Number of symbols</label>
                            <input class="" type="text" name="sohieu" id="sohieu" style="margin-left: 5%;margin-top:10px "  value="<%=congvanden.getSohieu() %>"><br>

                            <br>

                            <label class="col-lg-3">Date public</label>
                            <input type="date" name="Daypublic" id="ngaybanhanh" style="margin-left: 5%" value="<%=congvanden.getNgaybanhanh() %>">
                            <br>

                            <label class="col-lg-3">The signer</label>
                            <input type="text" name="husmansign"  id="nguoiky" style="margin-left: 5%" value="<%=congvanden.getNguoiky() %>" >
                            <br>

                            <br>

                            <br>
                            <label class="col-lg-3">SubContent</label>
                            <textarea name="Subcontent" class="text-info" placeholder="" id="trichdan" value="" style="color: #000"><%=congvanden.getTrichdan().replace("<br>","\n") %></textarea>

                            <br>
                            <button type="submit" class="col-sm-offset-4 btn btn-primary" value="Submit" style="margin-top: 10px ;margin-bottom: 10px" onclick="Kiemtracongvanden()" >Update</button>
                        </div>
                    </div>
                </form>

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
    input{
        margin-left: 0%;
        margin-top:10px ;
        width: 250px;

    }
    option{
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
