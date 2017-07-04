var count = 0;
(function () {
   
 $("#count").text("0");
    //ClearCart_Click();
    SetLocalProducts();
    ShowProducts();
    $("input[name='AddToCart']").click(AddToCart_Click);
    $("#btnClearCart").click(ClearCart_Click);

    

})();
function SetLocalProducts() {
    localStorage["Products"] = [];
    var Products =
        [{
            productid: "1",
            name: "iPhone 6",
            image: "images/1.jpg",
            price: "200"
        },
        {
            productid: "2",
            name: "OnePlus 3T",
            image: "images/2.jpg",
            price: "170"
        },

        {
            productid: "3",
            name: "Moto G5 Plus",
            image: "images/3.jpg",
            price: "100"
        },


        {
            productid: "4",
            name: "LG G6",
            image: "images/4.jpg",
            price: "120"
        },


        {
            productid: "5",
            name: "Samsung S7",
            image: "images/5.jpg",
            price: "140"
        },

        {
             productid: "6",
             name: "iPhone 7(red)",
             image: "images/6.jpg",
             price: "340"
        }


        ]
    localStorage["Products"] = JSON.stringify(Products);
}

function ShowProducts()
{
    var Products = new Array();
    Products = JSON.parse(localStorage["Products"]);
    //alert( JSON.stringify(Products));
    for (var i = 0; i < Products.length; i++) {
        var Product = $("#PRODUCT_TEMPLATE").clone();
        $(".productname", Product).text(Products[i].name);
        $(".price", Product).text(Products[i].price);
        $(Product).find("img").attr("src", Products[i].image);
        $(Product).find("input").attr("data-productid", Products[i].productid);
        //alert($(Product).html());
        $("#secProducts").append($(Product).html());
    }
}

function AddToCart_Click(e) {
  
    //localStorage.setItem("count", count);
    var cart = new Array();
    cart = JSON.parse(localStorage["cart"]);
    cart.push($(this).attr("data-productid"));
    localStorage["cart"] = JSON.stringify(cart);
    localStorage["recent"] = JSON.stringify(cart);
    //alert($(this).attr("data-productid"));
    alert("Added to cart");
    count++;
    localStorage.setItem("count", count);
    var items = localStorage.getItem("count");
    //alert(items);
 
    $("#count").text(items);
    //counter(count);
    
} 

function ClearCart_Click()
{
    var cart = new Array();
    localStorage["cart"] = JSON.stringify(cart);
    alert("Cart is cleared");
    $("#count").text("0");
    count = 0;
}