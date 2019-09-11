
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">

    <table>
        <tr>
            <td>uid</td>
            <td>物料名称</td>
            <td>物料编码</td>
        </tr>
        <#list userList as gg>
        <tr>
            <td> <input type="checkbox" name="uid" value="${gg.uid}"></td>
            <td>${gg.userName}</td>
            <td>${gg.userPass}</td>
        </tr>
        </#list>
    </table>
</form>

</body>
</html>
