<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../common/jstl.jsp"%>
<html>
<head>
    <title>用户列表</title>
    <script src="${ctxStatic}/common/jquery-3.3.1.min.js"></script>
</head>
<body>
    <table>
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>状态</th>
            <th>更新时间</th>
            <th>操作</th>
        </tr>
        <c:forEach var="user" items="${userList}" varStatus="idx">
            <tr>
                <td>${idx.index+1}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>
                    <c:choose>
                        <c:when test="${user.status==1}">启用</c:when>
                        <c:otherwise>禁用</c:otherwise>
                    </c:choose>
                </td>
                <td><fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                <td>
                    <button onclick="deleteUser('${user.id}')">删除</button>
                    <button>修改</button>
                    <!-- 此处user.id是user对象id（对应tb_users表中主键） -->
                    <button onclick="updateStatus('${user.id}','${user.status}')">
                        <c:if test="${user.status==1}">禁用</c:if>
                        <c:if test="${user.status==0}">启用</c:if>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
<script>
    function updateStatus(id,sts){
        var status = '';
        if(sts == '1'){//本身为启用状态，按钮显示禁用（操作禁用）
            status = '0';
        } else if(sts == '0') {//本身为禁用状态，按钮显示启用（操作启用）
            status = '1';
        }
        $.ajax({
            url: '/user/updateSts',
            type: 'get', //get请求
            data: {'id':id,'status':status}, //此处一行可以去掉，参数拼接到url后面，如：${ctxStatic}/user/updateSts?id=xx&status=xx
            dataType: 'json',//响应格式是json
            success: function (data, status) {
                console.log(data);
                if(parseInt(data.isOk) > 0){
                    alert('更新成功');
                    //更新成功刷新当前列表
                    window.location.reload();
                } else {
                    alert('更新失败');
                }
            },
            fail: function (err, status) {
                console.log(err);
                alert('更新失败');
            }
        });
    }

    function deleteUser(id){
        $.ajax({
            url: '/user/deleteUser',
            type: 'get', //get请求
            data: {'id':id}, //此处一行可以去掉，参数拼接到url后面，如：${ctxStatic}/user/updateSts?id=xx&status=xx
            dataType: 'json',//响应格式是json
            success: function (data, id) {
                console.log(data);
                if(parseInt(data.isOkk) > 0){
                    alert('更新成功');
                    //更新成功刷新当前列表
                    window.location.reload();
                } else {
                    alert('更新失败1');
                }
            },
            fail: function (err, id) {
                console.log(err);
                alert('更新失败2');
            }
        });
    }
</script>
</body>
</html>
