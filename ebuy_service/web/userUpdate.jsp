<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <style type="text/css">
        <!--
        -->
    </style>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${uname}</span> , 欢迎你！</p>
        <a href="login.html">退出</a>
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
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <section class="publicInfo">
            <span id="info">提示信息一</span>
        </section>


        <div class="providerAdd">
            <form action="userUpdate.do" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" placeholder="${requestScope.user.name}"/>
                    <span>*</span>
                </div>

                <div>
                    <label>用户性别：</label>

                    <select name="sex">
                        <c:if test="${requestScope.user.sex == '男'}">
                            <option value="男" selected>男</option>
                            <option value="女">女</option>
                        </c:if>
                        <c:if test="${requestScope.user.sex == '女'}">
                            <option value="男">男</option>
                            <option value="女" selected>女</option>
                        </c:if>
                    </select>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <input type="date" name="birth" id="data" placeholder="${requestScope.user.birth}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="userphone" id="userphone" placeholder="${requestScope.user.tel}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress" placeholder="${requestScope.user.address}"/>
                </div>
                <div>
                    <label>用户类别：</label>
                    <c:if test="${requestScope.user.type == 1}">
                        <input type="radio" name="userlei" value="1" checked/>一级管理员
                        <input type="radio" name="userlei" value="2"/>二级管理员
                        <input type="radio" name="userlei" value="3"/>普通用户
                    </c:if>
                    <c:if test="${requestScope.user.type == 2}">
                        <input type="radio" name="userlei" value="1"/>一级管理员
                        <input type="radio" name="userlei" value="2" checked/>二级管理员
                        <input type="radio" name="userlei" value="3"/>普通用户
                    </c:if>
                    <c:if test="${requestScope.user.type == 3}">
                        <input type="radio" name="userlei" value="1"/>一级管理员
                        <input type="radio" name="userlei" value="2"/>二级管理员
                        <input type="radio" name="userlei" value="3" checked/>普通用户
                    </c:if>

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="submit" value="保存"/>
                    <input type="button" value="返回" onClick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>
