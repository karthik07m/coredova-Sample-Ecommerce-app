var paisa = 0;
(function () {

    document.getElementById('btnCheckOut').addEventListener('click', function (event) {
        RazorpayCheckout.open(rzpOptions, successCallback, cancelCallback);
        event.preventDefault();
    })


    $("#btnClearCart").click(ClearCart_Click);
    totalPrice();
    var cart = new Array();
    var str = localStorage["cart"];
    if (str == "") {
        alert("cart is empty");
       
    }
    cart = JSON.parse(localStorage["cart"]);
    
    var Products = new Array();
    Products = JSON.parse(localStorage["Products"]);
    for (var j = 0; j < cart.length; j++) {
        for (var i = 0; i < Products.length; i++) {
            if (Products[i].productid == cart[j]) {
                var Product = $("#CART_TEMPLATE").clone();
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                //alert($(Product).html());
                $("#secProducts").append($(Product).html());
                
            } }
    }
  ;
})();




function ClearCart_Click() {
    var cart = new Array();
  
    localStorage["cart"] = JSON.stringify(cart);
    alert("Cart is cleared");
    window.location.reload();
}
function totalPrice() {
   var cart = new Array();
   var total = 0;
    cart = JSON.parse(localStorage["cart"]);
    var Products = new Array();
    Products = JSON.parse(localStorage["Products"]);
    for (var j = 0; j < cart.length; j++) {
        for (var i = 0; i < Products.length; i++) {
            if (Products[i].productid == cart[j]) {
                total = parseInt(Products[i].price) + total;
            }
       }
   }
    //alert("Total Price:" + total);
    $("#total").text(total);
    paisa = total * 100;
}

var rzpOptions = {
    key: "rzp_test_1DP5mmOlF5G5ag",
    currency: 'INR',
    amount: paisa, 
    name: "Karthik",
    description: "Purchase Description",
    image: "images/icon.jpg",
    handler: function (response) {
        alert(response.razorpay_payment_id);
    },
    prefill: {
        name: "karthik ",
        email: "Karthik07m@gmail.com"
    },
    notes: {
        address: "Dehradun"
    },
    theme: {
        color: "darkcyan"
    }
};

var successCallback = function (payment_id) {
    alert('payment_id: ' + payment_id)
};

var cancelCallback = function (error) {
    alert(error.description + ' (Error ' + error.code + ')')
};


