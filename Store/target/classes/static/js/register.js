var url = "http://localhost:8082/store";
var md5VerificationCode = null;
    function checkFormAndCommit(){
                var userName = document.getElementsByName("username")[0].value;
                var phoneNumber = document.getElementsByName("phone_number")[0].value;
                var passWord = document.getElementsByName("password")[0].value;
                var email = document.getElementsByName("email")[0].value;
                var confirm_password = document.getElementsByName("confirm_password")[0].value;
                var nickName = document.getElementsByName("nickname")[0].value;
                var verification_code = document.getElementsByName("verification_code")[0].value;
	  			var canSub = true;
				canSub = checkUsername() && canSub;
				canSub = checkNull("password","密码不能为空") && canSub;
				canSub = checkConfirmPassWord() && canSub;
				canSub = checkNull("nickname","昵称不s能为空") && canSub;
				canSub = checkEmail() && canSub;
				canSub = checkPhoneNumber() && canSub;
	  			if(canSub){
                    $.ajax({
                        type:'POST',
                        contentType:'application/json;charset=UTF-8',
                        dataType:'json',
                        url:url+'/api/user/registerUser',
                        data:JSON.stringify({
                            userName:userName,
                            passWord:passWord,
                            confirmPassWord:confirm_password,
                            nickName:nickName,
                            email:email,
                            phoneNumber:phoneNumber,
                            verificationCode:verification_code,
                            md5VerificationCode:md5VerificationCode
                        }),
                        success:function(response){
                            if('1' == response.code){
                                setMsg(response.message);
                            }else if('0' == response.code){
                                alert("注册成功！");
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


function checkConfirmPassWord(){
	  			var flag = checkNull("confirm_password","确认密码不能为空");
	  			if(flag){
	  				var psw = document.getElementsByName("password")[0].value;
					var confirm_password = document.getElementsByName("confirm_password")[0].value;
		  			if(psw!="" && confirm_password!=""){
		  				if(psw != confirm_password){
		  					setMsg("两次密码不一致");
		  					flag = false;
		  				}
		  			}
	  			}
	  			return flag;
}

function checkEmail(){
	var flag = checkNull("email","邮箱不能为空");
	if(flag){
    var email = document.getElementsByName("email")[0].value;
	if(!/^\w+@\w+(\.\w+)+$/.test(email)){
	    setMsg("请输入一个合法的邮箱地址");
	  	    flag = false;
	  	}
	 }
	 return flag;
}

function checkPhoneNumber(){
    var flag = checkNull("phone_number","电话号码不能为空");
    if(flag){
        var phoneNumber = document.getElementsByName("phone_number")[0].value;
        var isMob=/13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7}$/;
        if(!isMob.test(phoneNumber)){setMsg("请输入一个正确的电话号码");flag=false;}
     }
    return flag;
}


function setMsg(msg){
	  document.getElementById("message").innerHTML="<font color='red' size='15'>"+msg+"</font>";
}

function checkUsername(){
	var flag = checkNull("username","用户名不能为空");
	if(flag){
        var userName = document.getElementsByName("username")[0].value;
            $.ajax({
              type: 'POST',
              contentType:'application/json;charset=UTF-8',
              url:url+"/api/user/checkUserName",
              data:JSON.stringify({
                userName:userName
              }),
              success: function(response){
              if("1" ==response.code )
                   setMsg(response.message)
                   flag=false;
              },
              dataType: 'json'
            });
	}
	return flag;
}



function getVerificationCode(obj){
      $.ajax({
                  type: 'POST',
                  contentType:'application/json;charset=UTF-8',
                  url:url+"/api/user/getVerificationCode",
                  data:"",
                  success: function(response){
                      if("0" ==response.code ){
                           var imgWithBase64 = response.data.imgWithBase64;
                           //alert(imgWithBase64)
                           obj.src ='data:image/gif;base64,'+imgWithBase64;
                           md5VerificationCode = response.data.imgWithMd5;
                      }
                  },
                  dataType: 'json'
                });
}

