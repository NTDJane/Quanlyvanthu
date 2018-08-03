<%@page import="Database_Helpers.Nguoidungquerry"%>
<%@page import="Model.Nguoidung"%>

<!DOCTYPE html>

<%
    String title = "Manager Dispatch";
    //if(request.getAttribute("title")!=null)
    //{
    //    title = (String)request.getAttribute("title");
    //}
%>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%= title%></title>
    <link href="include/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="include/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="public_main/fonts/font-awesome-4.3.0/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <link href="include/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <script src="include/JavaScript/jquery.min.js" type="text/javascript"></script>

</head>
<%

    Nguoidung nguoidung = null;
    String tentochuc = "";
    String tenquyennguoidung = "";
    Nguoidungquerry querry = new Nguoidungquerry();

    if (session.getAttribute("nguoidung") != null) {
        nguoidung = (Nguoidung) session.getAttribute("nguoidung");

        if (nguoidung.getQuyenhanh() != 1) {
            tentochuc = "Organize: " + querry.Laytencongtynguoidangky(nguoidung.getIdcanhan());

        }
        tenquyennguoidung = querry.Laytenphanquyennguoidung(nguoidung.getQuyenhanh()) + ": " + nguoidung.getHoten();
    }
%>

<div class="container">

    <div class="head-banner">
        <div class="banner-top">
            <div class="box-bannertop">
                <div class="logo">
                    <img src="images/Logo.png" alt=""/>
                </div>
                <div class="right-banner">
                    <div class="top-menu">
                        <ul>
                            <li>
                                <a>
                                    Map of the port
                                </a>
                            </li>
                            <li>
                                <a href="Congtaclienhe.jsp">
                                    Contact
                                </a>
                            </li>
<!--                            <li>
                                <a href="Khungdangky">
                                    Register
                                </a>
                            </li>-->
                            <%if (nguoidung == null) {%>
                            <li>
                                <a href="Login.jsp">

                                    Login
                                </a>
                            </li>
                            <%}%>
                            <li>
                                <a href="Khungdangxuat">
                                    Logout
                                </a>
                            </li>

                        </ul>
                    </div>
                    <div class="search-c" style="text-align: right !important">
                        <div><strong style="color: #F15A22"><%=tenquyennguoidung%></strong></div>
                        <div><strong style="color: #F15A22"><%=tentochuc%></strong></div>


                    </div>
                </div>

            </div>
        </div>
    </div>


</div>
