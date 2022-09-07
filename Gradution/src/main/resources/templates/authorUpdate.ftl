<#--小说后台作者上传小说章节页面-->
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<!DOCTYPE html>
<meta charset="utf-8">
<title>智行小说网 </title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
</html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>作者更新小说</title>
    <style type="text/css">
        .indexP p a{
            color:#4c6978;
        }
    </style>
</head>
</body>

<div class="x-nav">

    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<body style="background-color: #f0f9fd;text-align: center">
<div style="font-size:25px">上传小说章节</div>

<hr />
<div align="center">
    <form action="/audit/updateScore" method="get" enctype="multipart/form-data">
        <table>
            <tr>
                <td style="text-align: center">小说名：</td>
            </tr>
            <tr>
                <td style="text-align: center"><input type="text" name="title" class="el-input__inner"></td>
            </tr>
            <tr>
                <td style="text-align: center">章节目录：</td>
            </tr>
            <tr>
                <td style="text-align: center"><input type="text" name="chap" class="el-input__inner"></td>
            </tr>
            <tr>
                <td style="text-align: center">章节内容：</td>
            </tr>
            <tr>
                <td style="text-align: center"><textarea style="width: 400px;height: 500px" class="el-textarea__inner" name="content"></textarea></td>
            </tr>
        </table>
        <input type="submit" class="button btn-p" value="提交" />&emsp;
    </form>
</div>

</body>
