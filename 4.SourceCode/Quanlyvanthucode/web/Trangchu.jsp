<%-- 
    Document   : Trangchu
    Created on : 31-07-2018, 12:03:07
    Author     : nguyendoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <%@include file="head.jsp" %>
    <%@include  file="/Menuchinh.jsp" %>
    <body>
        <div class="container">
            <div class="fullcontent">
                <h3 style="font-style: oblique; font-size: 20px;text-align: center">
                    Register Manager Dispatch now!
                </h3>

                <img src="images/project-manager-multitasking.jpg" alt="" style="height: 500px; margin-left: 280px"/>
                <p >     Nowadays, archival and archival work plays a special and important role. Clerical and archival work aims to ensure that written information is timely served for the leadership and management of the work, directly affecting the settlement of daily work, quality and efficiency. the activities of each agency or organization.
                    In  order to be handed over on time, the documents to be issued in time, the archived documents shall be preserved, preserved and scientifically systemized, convenient for the search and provision of information at the present time. at and in the later years are issues that put tremendous pressure on clerical and archivists. Also in today's modern society, the work of leaders, unit heads is increasingly busy and the work pressure is so great, the work space is not just within the scope of the agency, so the view of the office Review, review the documents, manage the work from afar, ensure the normal operation of the organization while leaders, head of the unit is also a practical requirement.
                    It can be said that the application of information technology to the management of clerical documents and records is essential and many organizations are interested in research, the desire to find effective solutions. and put into practical application. To reduce the workload of the clerical, bring certain effects, management, time savings, cost and document storage space. Modernization, renewal and enhancement of the important role of the clerical department contribute to the modernization of the management of organizations and agencies in general.</p>
                <ol>
                    <li>
                        <strong>The role of dispatch :</strong>
                    </li>

                    <p>
                        Official letters are forms of administrative documents commonly used in agencies, organizations and enterprises. Official letters are the official means of communication of State agencies with their superiors, subordinates and citizens. Even social organizations and businesses in daily operations must also prepare and use official letters to carry out their activities and transactions in order to perform their functions and duties.
                    </p>


                    <li>
                        <strong>Requirements when preparing the dispatch :</strong>
                    </li>

                    <p>When preparing an official letter, please note the following requirements:</p>
                    <ul style="list-style-type: circle">
                        <li>Each dispatch contains only one topic, clear and homogeneous.</li>
                        <li>The letter must be short, concise, clear, and the idea must be close to the topic.</li>
                        <li>Use polite, serious, persuasive language.</li>
                        <li>Being able to properly comply with the provisions of the law, the State must have an official letter, even an urgent letter.</li>
                    </ul>

                    <li>
                        <strong>The layout of an official letter :</strong>
                    </li>

                    <p>
                        When drafting an official letter, the layout should have the following elements:
                    <ul style="list-style-type:circle">
                        <li>  Brand names and idioms.</li>
                        <li>  Name and time of dispatch.</li>
                        <li> The name of the managing agency and the agency issuing the official letter.</li>
                        <li>  Theme for getting official letter (agency or individual).</li>
                        <li>  The number and symbol of the dispatch.</li>
                        <li>  Extract the content.</li>
                        <li>  Content of the dispatch.</li>
                        <li>  Signature, seal.</li>
                        <li>  Place of delivery.</li>
                    </ul>
                    </p>
                </ol>
            </div>
        </div>

    </body>
    <%@include file="footer.jsp" %>
</html>
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
