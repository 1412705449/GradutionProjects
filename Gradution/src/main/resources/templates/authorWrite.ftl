<#--小说后台作者上传小说页面-->
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
    <title>作者上传小说</title>
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
<div style="font-size:25px">上传小说</div>
<hr />
<div align="center">
        <form action="/audit/addScore" method="post" enctype="multipart/form-data">
        <table>
            <tr style="height: 50px">
                <td>名称：</td>
                <td><input type="text" name="title" class="el-input__inner"></td>
            </tr>
            <tr style="height: 50px">
                <td>所属分类：</td>
                <td>
                    <select name="typename" class="el-select__inner inner2">
                        <#list allclassify as classify>
                            <option value="${classify.id}">${classify.typename}</option>
                        </#list>
                    </select>
                    <br>
                </td>
            </tr>
            <tr style="height: 50px">
                <td rowspan="3">封面：</td>
                <td rowspan="3">
                    <label id="file_upload1_label" for="file_upload1">
                        <span id="uploadtip">添加图书封面</span>
                        <img id="uploadimg" src="" alt="" width="118px" height="143px" />
                    </label>
                    <input type="file" name="cover" class="" id="file_upload1"	onchange="upload_review()">
                </td>
            </tr>

            <tr style="height: 50px">
                <td>笔名：</td>
                <td><input type="text" name="author" class="el-input__inner"></td>
            </tr>
            <tr style="height: 50px;width: 1000px">
                <td>内容简介：</td>
                <td rowspan="2"><textarea class="el-textarea__inner" name="intro"></textarea></td>
            </tr>
        </table>
        <input type="submit" class="button btn-p" value="提交" />

    </form>
</div>

</script>
    <script>
        function upload_review() {
        var img = document.getElementById("uploadimg");
        var input = document.getElementById("file_upload1");
        var tip = document.getElementById("uploadtip");

        var file = input.files.item(0);
        var freader = new FileReader();
        freader.readAsDataURL(file);
        freader.onload = function(e) {
        img.src = e.target.result;
        tip.style.display = "none";
    };
    }
</script>
</body>
