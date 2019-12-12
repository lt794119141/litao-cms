<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <form class="form-inline">
	  <div class="form-group mx-sm-3 mb-2">
	    <input type="text" name="name" class="form-control" placeholder="请输入登录名">
	  </div>
	  <div class="form-group mx-sm-3 mb-2">
	    <input type="text" name="nickname" class="form-control" placeholder="请输入昵称">
	  </div>
	  <button type="button" class="btn btn-primary mb-2" onclick="query()">查询</button>
	</form>
  
  	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
      <td>
      	<button type="button" class="btn btn-primary">修改</button>
      </td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
      <td>
      	<button type="button" class="btn btn-primary">修改</button>
      </td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
      <td>
      	<button type="button" class="btn btn-primary">修改</button>
      </td>
    </tr>
  </tbody>
</table>
<div class="row">
	<nav aria-label="Page navigation example col-5" style="margin-right: 10px;">
		<button type="button" class="btn btn-primary">添加</button>
		<button type="button" class="btn btn-primary">批删</button>
	</nav>
   	<nav aria-label="Page navigation example col-4">
	  <ul class="pagination">
	    <li class="page-item"><a class="page-link" href="#">首页</a></li>
	    <li class="page-item"><a class="page-link" href="#">上一页</a></li>
	    <li class="page-item"><a class="page-link" href="#">1</a></li>
	    <li class="page-item"><a class="page-link" href="#">2</a></li>
	    <li class="page-item"><a class="page-link" href="#">3</a></li>
	    <li class="page-item"><a class="page-link" href="#">下一页</a></li>
	    <li class="page-item"><a class="page-link" href="#">尾页</a></li>
	  </ul>
	</nav>
</div>
<script>
	function query(){
		var params = $("form").serialize();
		reload(params);
	}
</script>