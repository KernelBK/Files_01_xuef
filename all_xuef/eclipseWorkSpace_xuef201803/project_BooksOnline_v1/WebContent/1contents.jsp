<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="simditor/styles/simditor.css" />

<script type="text/javascript" src="simditor/scripts/jquery.min.js"></script>  
<script type="text/javascript" src="simditor/scripts/module.js"></script>  
<script type="text/javascript" src="simditor/scripts/hotkeys.js"></script>
<script type="text/javascript" src="simditor/scripts/uploader.js"></script>  
<script type="text/javascript" src="simditor/scripts/simditor.js"></script> 

<script type="text/javascript">
	
	$(function(){
		Simditor.locale = 'zh-CN';//设置中文
        var editor = new Simditor({
            textarea: $('#editor'),  //textarea的id
            placeholder: '这里输入文字...',
            toolbar:  ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'], //工具条都包含哪些内容
            pasteImage: true,//允许粘贴图片
            defaultImage: '/res/simditor/images/image.png',//编辑器插入的默认图片，此处可以删除
            upload : {
                url : 'richtext_img_upload.do', //文件上传的接口地址
                params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
                fileKey: 'upload_file', //服务器端获取文件数据的参数名
                connectionCount: 3,
                leaveConfirm: '正在上传文件'
            }
        });
        // call setValue to set content
        editor.setValue('#hello world')
	});
</script>

</head>
<body>

	<textarea id="editor" placeholder="Balabala" autofocus></textarea>
</body>
</html>