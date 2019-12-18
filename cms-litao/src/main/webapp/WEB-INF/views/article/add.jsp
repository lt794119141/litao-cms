<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>
<script>
	function htmlspecialchars(str){
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("\n\r", "");
		return str;
	}
	
	var editor = null;
	$(document).ready( function(){
		KindEditor.ready(function(K) {
			editor = K.create('textarea[name="content1"]', {
				cssPath : '/public/kindeditor/plugins/code/prettify.css',
				uploadJson : '/file/upload',
				fileManagerJson : '/file/manager',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['articleForm'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['articleForm'].submit();
					});
				}
			});
			editor.readonly(false);
			//prettyPrint();
		});
	});

	
</script>
<form id="articleForm" name="articleForm">
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">文章标题</label>
		<div class="col-sm-6">
			<input type="text" name="title" class="form-control" placeholder="请输入标题">
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">文章图片</label>
		<div class="col-sm-6">
			<div class="input-prepend">
				<jsp:include page="../common/uploadImg.jsp" >
					<jsp:param name="feildName" value="picture" />
					<jsp:param name="feildValue" value="${article.picture }"/>
				</jsp:include>
			</div>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">所属频道</label>
		<div class="col-sm-6">
			<select id="inputState" name="channelId" class="form-control">
		        <option selected>请选择频道...</option>
		        <option>科技</option>
		        <option>财经</option>
		        <option>国际</option>
		      </select>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">所属分类</label>
		<div class="col-sm-6">
			<select id="inputState" name="categoryId" class="form-control">
		        <option selected>请选择频道...</option>
		        <option>科技</option>
		        <option>财经</option>
		        <option>国际</option>
		      </select>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">文章内容</label>
		<div class="col-sm-10">
			<textarea name="content1" cols="100" rows="8" style="width:760px;height:200px;visibility:hidden;">${article.content}</textarea>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-10">
			<button type="button" class="btn btn-primary" onclick="save();">保存并提交审核</button>
		</div>
	</div>
</form>
<script type="text/javascript">
	function save(){
		var formData = new FormData($("#articleForm")[0]);
		formData.set("content",editor.html());
		console.log(formData.get("content"));
		console.log(editor.html());
		/* $.post("/article/add",formData,function(res){
			console.log(res);
		}); */
		$.ajax({
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			url:"/admin/user/locked",
			sucess:function(res){
				console.log(res);
			}
		});
	}
</script>
