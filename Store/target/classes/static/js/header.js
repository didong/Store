var url = "http://localhost:8082/store";
$(document).ready(function(){
    $("#logAndRegiest").show(function(){
        $.ajax({
                          type: 'POST',
                          contentType:'application/json;charset=UTF-8',
                          url:"http://localhost:8082/store/api/user/checkIsLogin",
                          data:"",
                          success: function(response){
                              if("0" ==response.code ){
                                   document.getElementById("logAndRegiest").innerHTML="<a>"+response.message+"您好，欢迎回来！</a><span>|</span><a  href='"+url+"/api/user/logOut' >注销</a><div class='cart box_1'><a href='/'><h3> <div class='total'/><img src='"+url+"/images/cart.png' alt=''/></h3></a>  <p><a href='"+url+"/' class='simpleCart_empty'>清空购物车</a></p></div>";
                              }else{
                                  document.getElementById("logAndRegiest").innerHTML='<p class="log"><a href="'+url+'/api/user/loadLogIn" >登陆</a><span>|</span> <a  href="'+url+'/api/user/loadRegister" >注册</a></p>';
                              }
                          },
                          dataType: 'json'
          });
    });
});



