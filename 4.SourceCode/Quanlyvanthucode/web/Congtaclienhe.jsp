<%@include  file="/head.jsp" %>
<%@include  file="/Menuchinh.jsp" %>
<div class="container" >
    <div class="fullcontent">
        <div class="map_container" style="border: 3px; margin: 10px">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d244.90736277946758!2d106.78659982914499!3d10.848165316655715!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317527136a359b7f%3A0x1b48baf4a56470a2!2zSOG7jWMgVmnhu4duIELGsHUgY2jDrW5o!5e0!3m2!1sen!2s!4v1520152797921" width="100%" height="507px" frameborder="0" style="border:0" allowfullscreen></iframe>
        </div>
        <div>
            <h3>Contact us</h3>
            <p>You can contact to us:</p>
            <div>
                <p>+1234 567 890</p>
                <p>nguyentrungdoan@gmail.com</p>
                <p>97 Manthien, HiepPhu province, Distric 9, Ho Chi Minh City</p>
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
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyDSFyd0XhX7QY8rKw1ijVcAKmxO2QxEwPI"></script>
