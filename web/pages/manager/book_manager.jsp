<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%--静态包含base标签、CSS样式、jQuery文件--%>
    <%@ include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            //给删除的a标签绑定单击事件，用于删除的确认提示操作
            $("a.deleteClass").click(function () {
                //在事件的function函数中，有一个this对象，这个this对象，是当前正在响应事件的dom对象

                /**
                 * confirm是确认提示框函数
                 * 参数是它的提示内容
                 * 它有两个按钮，一个确认，一个是取消
                 * 返回true表示点击了：确认，返回false表示点击了：取消
                 *
                 * return false表示阻止元素的默认行为===不提交
                 */
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】？");

            })

            $("#searchPageBtn").click(function () {
                var $pageNo = $("#pn_input").val();
                if (($pageNo > ${requestScope.page.pageTotal}) || ($pageNo < 1)) {
                    alert("输入的页码有误！");
                    return;
                }
                //javaScript语言中提供了一个location地址栏对象
                //它有一个属性叫href,它可以获取l浏览器地址栏中的地址
                //href属性可读，可写
                location.href = "${pageContext.getAttribute("basePath")}${requestScope.page.url}&pageNo=" + $pageNo;
            });

        })


    </script>
    <script type="text/javascript">

        $(function () {

        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%--静态包含manager管理模块的菜单--%>
    <%@ include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.page.items}" var="book">

            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>

        </c:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>

    <%--静态包含分页条--%>
    <%@include file="/pages/common/page_nav.jsp"%>

</div>

<%--静态包含页脚内容--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>