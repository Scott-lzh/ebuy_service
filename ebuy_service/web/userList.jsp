<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript">
       function find(){
           // alert();
           var name = document.getElementById("username").value;
           location.href="byname.do?name="+name;
       }
    </script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${uname}</span> , 欢迎你！</p>
        <a href="login.do">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="billList.html">账单管理</a></li>
                <li><a href="providerList.html">供应商管理</a></li>
                <li id="active"><a href="userList.do">用户管理</a></li>
                <c:if test="${type == 1}">
                <li><a href="password.html">密码修改</a></li>
                </c:if>
                <li><a href="login.do">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面</span>
        </div>
        <div class="search">
            <span>用户名：</span>
            <input id = "username" type="text" placeholder="请输入用户名"/>
            <input onclick="find()" type="button" value="查询"/>
            <a href="userAdd.jsp">添加用户</a>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">用户编码</th>
                <th width="20%">用户名称</th>
                <th width="10%">性别</th>
                <th width="10%">年龄</th>
                <th width="10%">电话</th>
                <th width="10%">用户类型</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach var="user" items="${requestScope.userList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.sex}</td>
                    <td>${user.age}</td>
                    <td>${user.tel}</td>
                    <td>
                        <c:if test="${user.type == 1}">一级管理员</c:if>
                        <c:if test="${user.type == 2}">二级管理员</c:if>
                        <c:if test="${user.type == 3}">普通用户</c:if>
                    </td>

                    <td>
                        <a href="userView.do?name=${user.name}&flag=1"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="userView.do?name=${user.name}&flag=2"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <c:if test="${type == 1}">
                            <a href="javascript:del(${user.id})" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div>
            <%--<div class="fy" style=" width:700px;">--%>
            <c:if test="${requestScope.pageNo != 1}">
                <a href="userList.do?pageNo=1">首页</a>&nbsp;&nbsp;&nbsp;
            </c:if>
            <c:if test="${requestScope.pageNo >1}">
                <a href="userList.do?pageNo=${requestScope.pageNo - 1 }">上一页</a>&nbsp;&nbsp;&nbsp;
            </c:if>
            <c:if test="${requestScope.pageNo < requestScope.sumPage}">
                <a href="userList.do?pageNo=${requestScope.pageNo + 1 }">下一页</a>&nbsp;&nbsp;&nbsp;
            </c:if>
            <c:if test="${requestScope.pageNo != requestScope.sumPage}">
                <a href="userList.do?pageNo=${requestScope.sumPage}">尾页</a>&nbsp;&nbsp;&nbsp;
            </c:if>
            <c:out value="共${requestScope.sumPage }页"></c:out>
            页次：${requestScope.pageNo}/${requestScope.sumPage}页&nbsp;&nbsp;&nbsp;
            <%--${requestScope.mesCount}个产品/页 转到：--%>
            <c:if test="${requestScope.pageNo != requestScope.sumPage}">${requestScope.size}</c:if>
            <c:if test="${requestScope.pageNo == requestScope.sumPage}">${requestScope.mesCount % requestScope.size}</c:if>个产品/页
        </div>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao" ></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
            <input id="flag" type="hidden" value=""/>
        </div>
    </div>
</div>732049142

<footer class="footer">
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>