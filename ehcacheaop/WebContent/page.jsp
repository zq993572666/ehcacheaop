<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/js/easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/js/easyUI/themes/icon.css">
	<script type="text/javascript" src="/js/easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="/js/easyUI/jquery.easyui.min.js"></script>
 	<script type="text/javascript">
		  $(function(){
		   $('#tt').datagrid({
		    title:'datagrid小例子',
		    iconCls:'icon-ok',
		    width:500,
		    height:320,
		    pageSize:5,
		    pageList:[5,10,15,20],
		    nowrap:false,
		    striped: true,
		    collapsible:true,
		    url:'pageViewSBook.action',
		    loadMsg:'数据装载中......',
		    sortName:'code',
		    sortOrder:'desc',
		    remoteSort:false,
		    frozenColumns:[[
		     {field:'ck',checkbox:true}
		    ]],
		    columns:[[
		     {title:'id',field:'id',width:'50',rowspan:2,align:'center'},
		     {title:'书名',field:'title',width:'60',rowspan:2,align:'center'},
		     {title:'数量',field:'author',width:'50',rowspan:2,align:'center'}
		    ]],
		    pagination:true,
		    rownumbers:true
		    
		   });
		   $('#tt').datagrid('getPager').pagination({
		    displayMsg:'当前显示从{from}到{to}共{total}记录',
		    onBeforeRefresh:function(pageNumber, pageSize){
		     $(this).pagination('loading');
		     alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
		     $(this).pagination('loaded');
		    },
		   });
		   
		   //$('#tt').datagrid({url:'easyAction.action'});
		  });
		  function verify(){
				/* $.ajax({"url":"pageViewSBook.action?page=1&rows=5",
						"type":"post",
						"success":function(data){
							rows=data.rows;
							total=data.total;
							$('#dg').datagrid('loadData',rows);
						},
						"dataType":"json"
					}); */
				$.ajax({
					  type: "GET",
					  url: "/viewSBook.action",
					  success: function(msg){
						     alert( "Data Saved: " + msg );
					 }
					});
			   
		   }
	</script>
</head>
<body>
	<div id="w" class="easyui-window" title="Basic Window" data-options="iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
		 <a href="javascript:void(0)" onclick="verify()">测试josn数据</a>
    <h2><b>测试easyui的DataGrid</b></h2>
    <table id="tt">
    </table>
	</div>

</body>
</html>