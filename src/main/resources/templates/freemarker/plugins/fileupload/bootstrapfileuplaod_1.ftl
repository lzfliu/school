<#assign base = request.contextPath />
<!DOCTYPE html>
<!-- release v4.4.4, copyright 2014 - 2017 Kartik Visweswaran -->
<!--suppress JSUnresolvedLibraryURL -->
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Krajee JQuery Plugins - &copy; Kartik</title>
    <link href="${base}/css/bootstrap.min.css" rel="stylesheet">
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
        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-default">Reset</button>
    </form>
</div>
</body>
<script>
    $(document).ready(function () {

        $("#kv-explorer").fileinput({
            language: 'zh', //设置语言
            dropZoneEnabled: false,
            uploadUrl: '/upload/fileupload',// 服务器端上传处理程序
            uploadAsync: true,  //异步上传
            //allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
            maxFileCount: 5     //最大上传文件数为5
        });

       /* $("#kv-explorer").fileinput({
            'theme': 'explorer',
            'uploadUrl': '#',
            overwriteInitial: false,
            initialPreviewAsData: true,
            initialPreview: [
                "http://lorempixel.com/1920/1080/nature/1",
                "http://lorempixel.com/1920/1080/nature/2",
                "http://lorempixel.com/1920/1080/nature/3"
            ],
            initialPreviewConfig: [
                {caption: "nature-1.jpg", size: 329892, width: "120px", url: "{$url}", key: 1},
                {caption: "nature-2.jpg", size: 872378, width: "120px", url: "{$url}", key: 2},
                {caption: "nature-3.jpg", size: 632762, width: "120px", url: "{$url}", key: 3}
            ]
        });*/
    });
</script>
</html>