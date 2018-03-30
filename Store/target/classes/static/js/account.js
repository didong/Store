var url = "http://localhost:8082/store";
    function commit(){
                var userName = document.getElementsByName("userName")[0].value;
                var passWord = document.getElementsByName("passWord")[0].value;
                var canSub = true;
                canSub = checkNull("userName","用户名不能为空") && canSub;
                canSub = checkNull("passWord","密码不能为空") && canSub;
                if(canSub){
                    $.ajax({
                        type:'POST',
                        contentType:'application/json;charset=UTF-8',
                        dataType:'json',
                        url:url+'/api/user/logIn',
                        data:JSON.stringify({
                            userName:userName,
                            passWord:passWord,
                        }),
                        success:function(response){
                            if('1' == response.code){
                                setMsg(response.message);
                            }else if('0' == response.code){
                                alert("登陆成功！");
                                window.location.href=url;
                            }
                        }
                    });
                }
	  	}


function checkNull(name,msg){
	 setMsg("");
	  var username = document.getElementsByName(name)[0].value;
	  if(username == ""){
	  		setMsg(msg);
	  		return false;
	  }
	  return true;
}
function setMsg(msg){
	  document.getElementById("message").innerHTML="<font color='red' size='15'>"+msg+"</font>";
}
