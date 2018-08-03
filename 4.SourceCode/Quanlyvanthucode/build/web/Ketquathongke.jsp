
<%@page import="Database_Helpers.Congvanquerry"%>
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

    String ngaydau =(String) request.getAttribute("From");
    String ngaysau =(String) request.getAttribute("To");
    ArrayList<Nguoidung> danhsachnhanvien = (ArrayList) request.getAttribute("Danhsachnhanvien");
    ArrayList<Tinhtrangxuly> danhsachtrangthai = (ArrayList) request.getAttribute("Danhsachtrangthai");
    Congvanquerry congvan = new Congvanquerry();

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
                <form  action="Danhsachphancong" method="get">
                    <div class="search">
                        <h4 style="color: #fff; margin-left: 20px;height: 2%">SEARCH LIST HANDING DISPATCH</h4>
                        <br>

                        <div style="background: #fff;color: #000;font-size: 12px" class="container-fluid" style="display: inline-block">

                            <br>
                            <label style="margin-left: 15%">From:</label>
                            <input type="date" name="From" placeholder="From day" style="margin-left: 5px" >
                            <label style="margin-left: 5%">To:</label>
                            <input type="date" name="To" placeholder="To day" class="col-sm-offset-1" style="margin-left: 5px"><br>
                            <button type="submit" class="col-sm-offset-4 btn btn-primary" value="Submit" style="margin-top: 10px ;margin-bottom: 10px" >Submit</button>
                        </div>
                    </div>
                </form>
                <div>

                    <table >
                        <thead >
                            <tr>
                                <th>
                                    Name personal
                                </th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                String trangthai = "";
                                ArrayList<Congvanden> danhsach = new ArrayList<Congvanden>();
                                for (Nguoidung nhanvien : danhsachnhanvien) {

                            %>
                            <tr>
                                <td><%=nhanvien.getHoten()%></td>
                                <td>
                                    <table>
                                        <thead>
                                        <th>Number of dispatch</th>
                                        <th>Asignment date</th>
                                        <th>Dispatch status</th>
                                    </thead>
                                    <%
                                        danhsach = congvan.Laydanhsachcongvanphancongchonhanvientrongkhoangthoigian(nhanvien.getIdcanhan(), ngaydau, ngaysau);
                                        for (Congvanden congvanden : danhsach) {
                                            trangthai = congvan.Laytentrangthaitheomacongvan(congvanden.getSothutu());

                                    %>

                                    
                                    <tbody>
                                        <tr>
                                            <td><%=congvanden.getSohieu()%></td>
                                            <td><%=congvanden.getThoigianxuly()%></td>
                                            <td><%=trangthai%></td>
                                        </tr>
                                    </tbody>
                                    

                                    <%}%>
                                    </table>

                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>

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
