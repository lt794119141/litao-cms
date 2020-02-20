<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  	<form class="form-inline" id="queryForm">
  		 <input type="hidden" name="pageNum" value="1">
  	</form>
  
 
  	<table class="table">
  <thead>
    <tr>
      <th scope="col"><input type="checkbox" value="" id="chkALL" name="chkALL"></th>
      <th scope="col">标题</th>
      <th scope="col">收藏时间</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${pageInfo.list }" var="item">
       <tr>
	      <th><input type="checkbox" value="${item.id }"  name="chk_list"></th>
	      <td >${item.text}</td>
	      <td>${item.created }</td>
	      <td>
	      		<button type="button" class="btn btn-primary" onclick="view('${item.article_id}')">查看</button>
	      </td>
	    </tr>
   	</c:forEach>
  </tbody>
</table>
<div class="row">
	<div class="col-2">
		<button type="button" class="btn btn-danger" onclick="delAlert();">删除</button>
	</div>
	<div class="col-10">
		<jsp:include page="../common/page.jsp"></jsp:include>
	</div>
</div>
<div class="alert alert-danger" role="alert" style="display: none"></div>

<div class="modal" tabindex="-1" role="dialog" id="delModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">确认框</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        	你确认删除选择的数据吗？
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="batchDel();">确认删除</button>
      </div>
    </div>
  </div>
</div>

<script src="/public/js/checkbox.js?v1.00"></script>
<script>
	function query(){
		var params = $("form").serialize();
		reload(params);
	}
	
	function edit(id){
		openPage("/article/add?id="+id);
	}
	
	function gotoPage(pageNo){
		$("[name=pageNum]").val(pageNo);
		query();
	}
	
	function view(id){
		window.open("/article/"+id+".html");
	}
	
	function delAlert(){
		var ids = getCheckboxIds();
		if(ids==""){
			$(".alert").html("请选择要删除的文章");
			$(".alert").show();
			return;
		}
		$('#delModal').modal('show')
	}
	
	function batchDel(){
		var ids = getCheckboxIds();
		console.log(ids);
		$.post("/collect/delByIds",{ids:ids},function(res){
			if(res.result){
				$("#queryForm #pageNum").val(1);
				$('#delModal').modal('hide');
				query();
			}else{
				$(".alert").html(res.message);
				$(".alert").show();
				$('#delModal').modal('hide');
			}
		});
	}
	
</script>