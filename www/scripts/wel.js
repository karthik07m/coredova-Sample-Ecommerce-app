
(function () {
    
   
     // var s = localStorage.getItem("usrid");
    //document.getElementById("wel").innerHTML = s;
    //alert(localStorage.getItem("usrid"));

     localStorage["recent"] = localStorage["cart"];

     if (localStorage.getItem('profile_image') != '') {

         var image = document.getElementById('myImage');
         image.src = localStorage.getItem('profile_image');

     }
     
    var cart = new Array();
    var str = localStorage["cart"];
    if (str == "") {
      alert("cart is empty");
      return;
   }

  //cart = JSON.parse(localStorage["recent"]);
  //var Products = new Array();
  // Products = JSON.parse(localStorage["Products"]);
  //  for (var j = 0; j < cart.length; j++) {
  //     for (var i = 0; i < Products.length; i++) {
  //        if (Products[i].productid == cart[j]) {
  //            var Product = $("#CART_TEMPLATE").clone();
  //           $(".productname", Product).text(Products[i].name);
  //             $(".price", Product).text(Products[i].price);
  //               $(Product).find("img").attr("src", Products[i].image);
  //          $(Product).find("input").attr("data-productid", Products[i].productid);
  //          //alert($(Product).html());
  //           $("#secProducts").append($(Product).html());

  //         }
  //      }
  //}

    document.getElementById("closeNav").addEventListener("click", closeNav);
    document.getElementById("openNav").addEventListener("click", openNav);
 }());

 function clear_Cache()
 {
    
     if (flag == 0)
     {
         var empty = new Array();
         localStorage["recent"] = JSON.stringify(empty);
         flag++;
     }
     
 }

 function openNav() {
     document.getElementById("mySidenav").style.width = "200px";
 }

 function closeNav() {
     document.getElementById("mySidenav").style.width = "0";
 }
 function Profile_Image(imageURL)
 {  var image = document.getElementById('myImage');
     image.src = imageURL;
 }
