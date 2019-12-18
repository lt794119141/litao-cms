//全选操作
$("#chkALL,#checkAll").click(function(){
	var chkAllValue = $(this).prop("checked");
	$('input[name="chk_list"]').prop("checked",chkAllValue);
	$("#checkAll").prop("checked",chkAllValue);
	$("#chkALL").prop("checked",chkAllValue);
	$("#antiChecked").prop("checked",false);
});
//反选操作
$("#antiChecked").click(function(){
	var flag = true;
	$('input[name="chk_list"]').each(function(index,value){
		$(value).prop("checked",$(value).prop("checked")?false:true);
		if($(value).prop("checked") == false && flag){
			flag = false;
		}
	});
	$("#checkAll").prop("checked",flag);
	$("#chkALL").prop("checked",flag);
	$("#antiChecked").prop("checked",true);
});
//单选操作
$('input[name="chk_list"]').click(function(){
	var flag = true;
	$('input[name="chk_list"]').each(function(index,value){
		if($(value).prop("checked") == false){
			flag = false;
			return false;
		}
	});
	$("#checkAll").prop("checked",flag);
	$("#chkALL").prop("checked",flag);
	$("#antiChecked").prop("checked",false);
});