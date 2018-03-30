var url = "http://localhost:8082/store";
var page = 1:
$(document).ready(function(){
    $("#content-top_index").show(function(){
        $.ajax({
                          type: 'POST',
                          contentType:'application/json;charset=UTF-8',
                          url:url+"api/product/loadNewestProduct",
                          data:"",
                          success: function(response){
                              if("0" ==response.code ){
                                var products = response.data;
                                var index_div1= "":
                                var index_div2= "":
                                 for(var i=0; i<products.length; i++)
                                  {
                                    if(i<4){
                                        var product = "<div class='col-md-3 col-md2'><div class='col-md1 simpleCart_shelfItem'><img class='img-responsive' width='185' height='207'  src='data:image/gif;base64,'"+products[i].image+" alt='' onclick='getProductDetail("+products[i].identification+")'/><h3><a href='"+url+"/'>"+products[i].name+"</a></h3><div class='price'><h5 class='item_price'>￥"+products[i].price+"</h<a href='"+url+"/' class='item_add'>加入购物车</a><div class='clearfix'> </div></div></div></div>"
                                        index_div1 = index_div1 + product;
                                    }else{
                                        var product = "<div class='col-md-3 col-md2'><div class='col-md1 simpleCart_shelfItem'><img class='img-responsive' width='185' height='207'  src='data:image/gif;base64,'"+products[i].image+" alt='' onclick='getProductDetail("+products[i].identification+")'/><h3><a href='"+url+"/'>"+products[i].name+"</a></h3><div class='price'><h5 class='item_price'>￥"+products[i].price+"</h<a href='"+url+"/' class='item_add'>加入购物车</a><div class='clearfix'> </div></div></div></div>"
                                        index_div2 = index_div2 + product;
                                    }
                                  }
                                  document.getElementById("content-top1_index_1").innerHTML=index_div1;
                                  document.getElementById("content-top1_index_2").innerHTML=index_div2;
                              }
                          },
                          dataType: 'json'
          });
    });
});
var type = 0;
function skipPage(){
        $.ajax({
                          type: 'POST',
                          contentType:'application/json;charset=UTF-8',
                          url:url+"store/api/user/checkIsLogin",
                          data:JSON.stringify({
                              pageNumber:page,
                              type:type
                           }),
                          success: function(response){
                              if("0" ==response.code ){
                                var products = response.data;
                                var index_div1= "":
                                var index_div2= "":
                                 for(var i=0; i<products.length; i++)
                                  {
                                    if(i<4){
                                        var product = "<div class='col-md-3 col-md2'><div class='col-md1 simpleCart_shelfItem'><img class='img-responsive' width='185' height='207'  src='data:image/gif;base64,'"+products[i].image+" alt='' onclick='getProductDetail("+products[i].identification+")'/><h3><a href='"+url+"/'>"+products[i].name+"</a></h3><div class='price'><h5 class='item_price'>￥"+products[i].price+"</h<a href='"+url+"/' class='item_add'>加入购物车</a><div class='clearfix'> </div></div></div></div>"
                                        index_div1 = index_div1 + product;
                                    }else{
                                        var product = "<div class='col-md-3 col-md2'><div class='col-md1 simpleCart_shelfItem'><img class='img-responsive' width='185' height='207'  src='data:image/gif;base64,'"+products[i].image+" alt='' onclick='getProductDetail("+products[i].identification+")'/><h3><a href='"+url+"/'>"+products[i].name+"</a></h3><div class='price'><h5 class='item_price'>￥"+products[i].price+"</h<a href='"+url+"/' class='item_add'>加入购物车</a><div class='clearfix'> </div></div></div></div>"
                                        index_div2 = index_div2 + product;
                                    }
                                  }
                                  document.getElementById("content-top1_index_1").innerHTML=;index_div1;
                                  document.getElementById("content-top1_index_2").innerHTML=;index_div2;
                              }
                          },
                          dataType: 'json'
          });
    });
});

