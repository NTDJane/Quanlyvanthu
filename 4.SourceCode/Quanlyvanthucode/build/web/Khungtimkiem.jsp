<form  action="Timkiemcongvanden" method="get">
                    <div class="search">
                        <h4 style="color: #fff; margin-left: 20px;height: 2%">ADVANCED SEARCH</h4>
                        <br>

                        <div style="background: #fff;color: #000;font-size: 12px" class="container-fluid" style="display: inline-block">
                            <label class="">Key word</label>
                            <input type="text" name="keyword" style="margin-left: 7%;margin-top:10px "><br>
                            <label class="">Agency issued</label>
                            <select name="agency"  style="margin-left: 17px;margin-top: 10px">
                            <%for (Coquanbanhanhcongvan coquan : danhsachcoquan) {%>
                                <option value="<%=coquan.getIdcoquan()%>">
                                    <%=coquan.getTencoquan()%>

                                </option>
                                <%}%>
                            </select>
                            <br>
                            <label class="">Effective status</label>
                            <select name="status"  style="margin-left:12px ;margin-top: 10px">
                            <%for (Tinhtrangxuly tinhtrang : danhsachtrangthai) {%>
                                <option value="<%=tinhtrang.getIdXuly()%>">
                                    <%=tinhtrang.getTentrangthai()%>

                                </option>
                                <%}%>
                            </select>
                            <br>
                            <label class="">Date issued</label>
                            <input type="date" name="From" placeholder="From day" style="margin-left: 5%" >
                            <input type="date" name="To" placeholder="To day" class="col-sm-offset-1"><br>
                            <button type="submit" class="col-sm-offset-4 btn btn-primary" value="Submit" style="margin-top: 10px ;margin-bottom: 10px" >Submit</button>
                        </div>
                    </div>
                </form>
                