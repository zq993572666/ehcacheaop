<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加图书</title>
       <link rel="stylesheet" type="text/css" href="/js/easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/js/easyUI/themes/icon.css">
	<script type="text/javascript" src="/js/easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="/js/easyUI/jquery.easyui.min.js"></script>
 	<script type="text/javascript">
 	function sub(){
 		var flag = true;

 	 	$('#uiform input').each(function () {
 	 		options=$(this).attr('data-options');
 	 		validTypeFlag=$(this).attr('validType');
 	 		if(options){
 	 			debugger
 	 			requiredIndex=options.indexOf("required");
 	 			if(requiredIndex==-1){
 	 				;
 	 			}else{
 	 				if (!$(this).validatebox('isValid')) {
 	 			        flag = false;
 	 			        return true;
 	 			    } 
 	 				if (!$(this).validatebox()) {
 	 			        flag = false;
 	 			        return true;
 	 			    }
	 	 	      
	 	 	    }
 	 		}
 	 		if(validTypeFlag){
 	 			if (!$(this).validatebox('isValid')) {
	 			        flag = false;
	 			        return true;
	 			 } 
	 			
	 			
 	 		}
 	 		
 	 	})

 	 	if (flag){
 	 	    alert('验证通过！');
 	 		$('#uiform').submit();
 	 	}
 	 	else{
 	 	    alert('验证失败！');
 	 	}
 	}
	function submitForm(){
		$('#uiform').form('submit');
	}
 	</script>
  </head>
<body>
<form action="updateSBook" method="post" id="uiform">
<div class="easyui-panel" title="Register" style="width:400px;padding:10px">
<table width="474" height="170" border="1">
<tr>
  <td>书名:</td>
  <td><input  name="sbook.title" type="text" value="${sbook.title}" class="easyui-validatebox"  data-options="required:true"validType='length[3,10]'/></td>
   <td><input name="" type="button" value="提交" onclick="submitForm();"><input name="" type="reset" value="重置"> </td>
				
</tr>

</table>
</div>
</form>
</body>
</html>