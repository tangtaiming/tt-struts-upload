<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
    </head>
    <body>
        <div>
            <label>sku:</label>
            <input type="text" id="fileNameSku" />
        </div>
        <div>
            <input type="file" id="file-1" />
            <div id="show-file"></div>
        </div>
        <div>
            <input type="button" value="提交" onclick="upload()" />
        </div>
    </body>
    <script src="/mystatic/js/prototype.js" type="application/javascript"></script>
    <script>
        function upload() {
            var files = $('file-1').files;
            var fileNameSku = $('fileNameSku').value;
            var formData = new FormData();
            formData.append('fileUpload', files[0]);
            formData.append('fileNameSku', fileNameSku);
            new Ajax.Request('/doUpload', {
                method: 'post',
                contentType: false,
                postBody: formData,
                onSuccess: function (transport) {
                    console.log('transport = ' + transport.responseText);
                    var responseJson = JSON.parse(transport.responseText);
                    if (responseJson.code == 200) {
                        //添加图片和隐藏域
                        var appendHtml = '<input type="hidden" id="file-path" value="' + responseJson.result + '"/>' + '<img src="' + responseJson.result + '" width="100" height="100" />';
                        $('show-file').insert(appendHtml);
                    }
                }
            });
        }
    </script>
</html>
