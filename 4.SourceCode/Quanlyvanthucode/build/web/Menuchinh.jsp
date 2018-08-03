<!--<link href="include/css/bootstrap.css" rel="stylesheet" type="text/css"/>-->
<!--<link href="include/css/menu.css" rel="stylesheet" type="text/css"/>-->
<!--<link href="include/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
<%@page import="Model.Nguoidung"%>
<link href="include/css/style.css" rel="stylesheet" type="text/css"/>

<style>
    .ul1{
        height: 50px;
        list-style-type: none;
        padding: 0;
        margin: 0;
        background-color: #0071a6;
        overflow: hidden;
        text-align: center;
    }
    .ul1 li{
        display: inline;
        float:left;
    }

    .ul1  li a{
        display: block;
        width:190px;
        padding: 14px 25px;
        background-color: #0071a6;
        color:white;
        text-decoration: none;
        text-align: center;
    }
</style>
<script>
    function Dieuhuong(bien) {

        secssionvalue = "<%=session.getAttribute("nguoidung")%>";
        if (secssionvalue == "null") {
            window.location = 'Khungdangnhap';
        } else
        {
            if (bien == 1) {


                window.location = 'ServerletThemnhanvien';
            }
            if (bien == 2) {
                window.location = 'Danhsachcongvanden';
            }
            if (bien == 3) {
                window.location = 'Capnhatthongtinnguoidung';
            }
            if (bien == 4) {

                alert('LEADER CAN BE ACCESS!');
                window.location = 'Trangchu.jsp';
            }


        }



    }

</script>
<div class="container" style="margin-bottom: 20px">
    <div class="full-content">
        <div id="header"  >

            <nav style="background-color:#0071a6;">
                <ul class="ul1">
                    <li ><a href="Trangchu.jsp" >Home</a></li>
                   
                    <li><a  href="#" onclick="Dieuhuong(1);" >Add personal</a></li>
                   

                    <li><a href="#" onclick="Dieuhuong(2);"  >Dispatch</a></li>
                    <li><a href="Congtaclienhe.jsp" >Contact</a></li>
                    <li><a   href="#"  onclick="Dieuhuong(3)">Update Information</a></li>

                </ul>


            </nav>


        </div>
    </div>
</div>

