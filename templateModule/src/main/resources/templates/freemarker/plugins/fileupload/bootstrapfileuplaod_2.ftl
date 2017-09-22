<#assign base = request.contextPath />
<!DOCTYPE html>
<!-- release v4.4.4, copyright 2014 - 2017 Kartik Visweswaran -->
<!--suppress JSUnresolvedLibraryURL -->
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Krajee JQuery Plugins - &copy; Kartik</title>
    <link href="${base}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${base}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${base}/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="${base}/themes/explorer/theme.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="${base}/js/jquery.min.js"></script>
    <script src="${base}/js/plugins/sortable.js" type="text/javascript"></script>
    <script src="${base}/js/fileinput.js" type="text/javascript"></script>
    <script src="${base}/js/locales/zh.js" type="text/javascript"></script>
    <script src="${base}/themes/explorer/theme.js" type="text/javascript"></script>
    <script src="${base}/js/bootstrap.min.js" type="text/javascript"></script>

</head>
<body>
<div class="container kv-main">
    <div class="page-header">
        <h1>Bootstrap File Input Example</h1>
    </div>
    <form enctype="multipart/form-data" method="post">
        <input id="kv-explorer" type="file" name="file" multiple>
        <br>
        <button type="submit" class="btn btn-primary ">Submit</button>
        <button type="reset" class="btn btn-default">Reset</button>
    </form>
</div>
</body>
<script>
    $(document).ready(function () {
        $("#kv-explorer").fileinput({
            language: 'zh', //设置语言
            uploadUrl: '/upload/fileupload',// 服务器端上传处理程序
            uploadAsync: true, //默认异步上传
            showUpload: true,//是否显示上传按钮
            showPreview:true, //是否显示文件预览
            showClose:false, //布尔值，是否显示预览界面的关闭图标。默认为true。只有当showPreview为true或者在预览模板中使用{close}标签时才会被解析。
            showCancel:true, //是否显示文件上传取消按钮
            showRemove: false,//是否显示删除按钮
            showCaption: true,//是否显示输入框
            dropZoneEnabled: false,//是否显示拖拽区域
            maxFileCount: 5    //最大上传文件数为5
          /*  initialPreview: [
                '<img src="/img/111.jpg" class="kv-preview-data file-preview-image" style="height:160px">',
            ]*/

        });

        //异步上传返回结果处理
        $("#kv-explorer").on("fileuploaded", function (event, data, previewId, index) {
           alert("上传成功，回调函数！");

        });

    });
</script>
</html>