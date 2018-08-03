
<%@page import="Model.Nguoidung"%>

<script>
    $(document).ready(function () {
        if ($(".leftmenu ul.nav-left > li:last-child ul").hasClass("nav-lv2")) {
            $(".leftmenu ul.nav-left li:last-child a span").each(function (index) {
                $(this).attr("style", "border-bottom: 1px dotted #73a0bc !important;");
            });
        }
    });
</script>


<div class="leftmenu">
    <div class="head-box">
        <a href="">Content Manager</a>
    </div>
    <ul class="nav-left">


        <li style="list-style-type: none">
            <a href="Danhsachcongvanden"><span><font style="vertical-align: inherit;">Dispatch In</font></span></a>
            <ul style="list-style-type: none">
                <li><a href="Danhsachcongvanden"><span><font style="vertical-align: inherit;">List Dispatch In<font></span><a></li>
                            <% if (nguoidung.getQuyenhanh() == 2) {%>
                            <li><a class="active" href="Soanthaocongvanden"><span>Add Dispatch In</span></a></li>

                            <%}%>
                            
                            <% if (nguoidung.getQuyenhanh() == 3||nguoidung.getQuyenhanh() == 2) {%>
                            <li><a class="active" href="ServletPhancongxuly"><span>Handing Dispatch In</span></a></li>

                            <%}%>


                            <% if (nguoidung.getQuyenhanh() == 3) {%>

                            <li><a href="Thongkedanhsachphancongcongvan.jsp"><span>List Process Handing</span></a></li>
                                <%}%>

                            <% if (nguoidung.getQuyenhanh() == 4) {%>
                            <li><a href="ServletXulycongvan"><span>Process Dispatch In</span></a></li>
                                <%}%>
                            </ul>
                            </li>
                            <li style="list-style-type: none">
                                <a href="Danhsachcongvandi"><span><font style="vertical-align: inherit;">Dispatch To</font></span></a>
                                <ul style="list-style-type: none">
                                    <li><a href="Danhsachcongvandi"><span><font style="vertical-align: inherit;">List Dispatch To<font></span><a></li>
                                                <% if (nguoidung.getQuyenhanh() == 2) {%>
                                                <li><a href="Soancongvandi.jsp"><span>Add Dispatch To</span></a></li>

                                                <%}%>
                                                </ul>
                                                </li>
                                                
                                                
                                                
                                                <li style="list-style-type: none">
                                                    <a href="Themcoquanbanhanh"><span><font style="vertical-align: inherit;">Manage List Place</font></span></a>


                                                </li>
                                                
                                                </ul>





                                                </div>