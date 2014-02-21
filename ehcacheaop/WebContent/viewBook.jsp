<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>浏览图书</title>
		 <link rel="stylesheet" type="text/css" href="/js/easyUI/themes/default/easyui.css">
 <link rel="stylesheet" type="text/css" href="/js/easyUI/themes/icon.css">
 <link rel="stylesheet" type="text/css" href="/css/demo.css">
 <script type="text/javascript" src="/js/easyUI/jquery.min.js"></script>
 <script type="text/javascript" src="/js/easyUI/jquery.easyui.min.js"></script>
  <script type="text/javascript">
  var editcount = 0; 
  var step1Ok = function () {

      $.messager.progress({ 
          title: '请等待', 
          msg: '加载数据中...', 
          text: '进度' 
      }); 
      var p = $('#tt').datagrid('getPager'); 
      $(p).pagination({ 
          onSelectPage: function (pageNumber, pageSize) { 
              alert('onSelectPage pageNumber:' + pageNumber + ',pageSize:' + pageSize); 
              getData(pageNumber, pageSize); 
          } 
      });

      getData(1,10);

  };
  var getData = function (page, rows) { 
	    $.ajax({ 
	        type: "POST", 
	        url: "pageViewSBook.action", 
	        data: "page=" + page + "&rows=" + rows, 
	        error: function (XMLHttpRequest, textStatus, errorThrown) { 
	            alert(textStatus); 
	            $.messager.progress('close'); 
	        }, 
	        success: function (data) { 
	            //$.each(data, function (i, item) { 
	            //    alert(item); 
	            //}); 
	            $.messager.progress('close'); 
	            $('#tt').datagrid('loadData', data);

	        } 
	    }); 
	};
   function verify(){
		/* $.ajax({
			  type: "GET",
			  "url": "/pageViewSBook.action?page=1&rows=5",
			  success: function(data){
				     alert( "Data Saved: " + data );
				     
			  }
			
			}); */
			
	   $('#tt').datagrid({ 
	        url: "pageViewSBook.action"
	    });
	    $('#tt').datagrid('getPager').pagination({
        	beforePageText: '第',//页数文本框前显示的汉字  
               afterPageText: '页    共 {pages} 页',  
              displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
		      onBeforeRefresh:function(pageNumber, pageSize){
		         $(this).pagination('loading');
		         alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
		         $(this).pagination('loaded');
		      },
		   });
                        
        
			
   }
	  /* $(function(){
		   $('#tt').datagrid({
		    title:'datagrid小例子',
		    iconCls:'icon-ok',
		    width:500,
		    height:320,
		    pageSize:5
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
		     {title:'作者',field:'author',width:'50',rowspan:2,align:'center'},
		     {title:'数量',field:'total',width:'50',rowspan:2,align:'center'},
		     {title:'价格',field:'price',width:'50',rowspan:2,align:'center'},
		     {title:'publisher',field:'publisher',width:'50',rowspan:2,align:'center'}
		 
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
		  }); */
		  $(function(){  
		        $('#tt').datagrid({    
		                 title:'交易码列表',    
		                 iconCls:'icon-edit',//图标    
		                 width:500,
		                 pageSize:10,
		     		    height:400,  
		     		  // fitColumns:true,
		     		   	//toolbar:'#tb',
		                 nowrap: false,    
		                 striped: true,    
		                 border: true,    
		                 collapsible:true,//是否可折叠的    
		                 fit: true,//自动大小    
		               url:'pageViewSBook.action', 
		                 columns:[[
		              		     {title:'id',field:'id',rowspan:2,align:'center'},
		              		     {title:'书名',field:'title',width:'70',align:'center'},
		              		     {title:'作者',field:'author',width:'50',align:'center',
		              		    	 editor:{ 
		              		    	type:'validatebox', 
		              		    	options:{ 
		              		    	validType:'email' 
		              		    	} 
		              		    	} },
		              		     {title:'数量',field:'total',width:'50',rowspan:2,align:'center'},
		              		     {title:'价格',field:'price',width:'50',rowspan:2,align:'center'},
		              		     {title:'publisher',field:'publisher',width:'50',rowspan:2,align:'center'},
		              		     {field:'action',title:'操作',width:70,align:'center', 
		              		    	formatter:function(value,row,index){ 
		              		    	    if (row.editing){ 
		              		    			var s = '<a href="#" onclick="saverow('+index+')">保存</a> '; 
		              		    	    	var c = '<a href="#" onclick="cancelrow('+index+')">取消</a>'; 
		              		    	    	return s+c; 
		              		    	    } else { 
		              		    	    	var e = '<a href="#" onclick="editrow('+index+')">编辑</a> '; 
		              		    			var d = '<a href="#" onclick="deleterow('+index+')">删除</a>'; 
		              		    			return e+d; 
		              		    		} 
		              		    	} 
		              		     } 
		              		 
		              		    ]],
		              		  frozenColumns:[[
		              		                {field:'ck',checkbox:true}
		              		               ]],
		                 //sortName: 'code',    
		                 //sortOrder: 'desc', 
		                 loadMsg:'数据装载中......',
		                 remoteSort:false,     
		                 idField:'id',    
		                 singleSelect:false,//是否单选    
		                 pagination:true,//分页控件    
		                 rownumbers:true,//行号    
		                 onBeforeEdit:function(index,row){ 
		                	 row.editing = true; 
		                	 $('#tt').datagrid('refreshRow', index); 
		                	 editcount++; 
		                	  alert('editcount'+editcount);
		                }, 
		                onAfterEdit:function(index,row){ 
		                	 row.editing = false; 
		                	 $('#tt').datagrid('refreshRow', index); 
		                	 editcount--; 
		                	  alert('editcount'+editcount);
		                }, 
		                onCancelEdit:function(index,row){ 
		                	 row.editing = false; 
		                	 $('#tt').datagrid('refreshRow', index); 
		                	 editcount--; 
		                	    alert('editcount'+editcount);
		                } 
		                
		                 
		     		   
		             });  
		              //设置分页控件    
		        $('#tt').datagrid('getPager').pagination({
		        	beforePageText: '第',//页数文本框前显示的汉字  
	                   afterPageText: '页    共 {pages} 页',  
	                  displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
				    onBeforeRefresh:function(pageNumber, pageSize){
				     $(this).pagination('loading');
				     alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
				     $(this).pagination('loaded');
				    },
				   });
		                        
		        });  
		  
		  
		
		  function editrow(index){ 
		  	$('#tt').datagrid('beginEdit', index); 
		  } 
		  function deleterow(index){ 
		  	$.messager.confirm('确认','是否真的删除?',function(r){ 
		 	 	if (r){ 
		 	 		$('#tt').datagrid('deleteRow', index); 
		 		 } 
			}); 
		  } 
		  function saverow(index){ 
		  	$('#tt').datagrid('endEdit', index); 
		  } 
		  function cancelrow(index){ 
		 	 $('#tt').datagrid('cancelEdit', index); 
		  } 
		  function addrow(){ 
		 	 if (editcount > 0){ 
				$.messager.alert('警告','当前还有'+editcount+'记录正在编辑，不能增加记录。'); 
			 }
		 	 return; 
		  } 
		  
		  
		  
		  $('#tt').datagrid('appendRow',{ 
			  no:'', 
			  name:'', 
			  addr:'', 
			  email:'', 
			  birthday:'' 
			  }); 
			  
			  function saveall(){ 
			  $('#tt').datagrid('acceptChanges'); 
			  } 
			  function cancelall(){ 
			  $('#tt').datagrid('rejectChanges'); 
			  } 
   </script>
	</head>


	<body>
	 <a href="javascript:void(0)" onclick="step1Ok();">测试josn数据</a>
	<h2>Basic Window</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>Window can be dragged freely on screen.</div>
	</div>
	<div style="margin:10px 20px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onClick="$('#w').window('open')">Open</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onClick="$('#w').window('close')">Close</a>
	</div>
	<div id="w" title="Basic Window"   style="width:700px;height:600px;padding:30px;">
		<h2><b>测试easyui的DataGrid</b></h2>
		
   		 <table id="tt">
		 <!--   <div id="tb" style="padding:5px;height:auto">  
		    <div style="margin-bottom:5px">  
		        <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
				<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">编辑</a>
				<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'">搜索</a>
				
				<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-print'">打印</a>
				<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-help'"> 帮助</a>
				<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-save'">保存</a>
				<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'">返回</a>
		    </div>  
		    <div>  
		        Date From: <input class="easyui-datebox" style="width:80px">  
		        To: <input class="easyui-datebox" style="width:80px"> 		                
		        <input   type="button" class="easyui-linkbutton" iconCls="icon-search" value="Search"/> 
		    </div>  
		</div>  -->
   		 </table>
		</div>
	</body>

</html>
