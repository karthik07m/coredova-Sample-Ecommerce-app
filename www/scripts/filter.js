var Products = new Array();
var bran = localStorage.getItem('iphone');
var bran1 = localStorage.getItem('Lg');
var bran2 = localStorage.getItem('One');
var bran3 = localStorage.getItem('Sam');
var bran4 = localStorage.getItem('Moto');
var brand = new Array();
brand.push(bran);
brand.push(bran1);
brand.push(bran2);
brand.push(bran3);
brand.push(bran4);
var count = 0;
Products = JSON.parse(localStorage["Products"]);
var s = 'small';
var m = 'medium';
var l = 'large';

var priceCheck = new Array();
priceCheck.push(localStorage.getItem('sm'));
priceCheck.push(localStorage.getItem('md'));
priceCheck.push(localStorage.getItem('lg'));


(function () {
    
    $("#count").text("0");
    if (brand != ",,,,")
    {
        //alert(priceCheck);
        for (var a = 0; a <= brand.length; a++) {
            if (brand[a] == 'LG') {
                lgFiltering();
            }
            else if (brand[a] == 'Moto') {
                motoFiltering();
            }
            else if (brand[a] == 'iPhone') {
                iPhoneFiltering();
            }
            else if (brand[a] == 'One') {
                OnePlusFiltering();
            }
            else if (brand[a] == 'Sam') {
                SamsungFiltering();
            }
        }
    }
    else {
        alert("Please select a brand");
        window.location.href = "products.html";
        return false;
    }
    if (priceCheck == ",,")
    {
        alert("Please select prize range!");
        window.location.href = "products.html";
        return false;
    }
 
})();

function iPhoneFiltering()
{
    if (s == localStorage.getItem('sm')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            //alert(name.slice(0, 6));
            if (name.slice(0, 6) == bran && cost >= 10000 && cost <= 20000)
            {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }
    if (m == localStorage.getItem('md')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            //alert(name.slice(0, 6));
            if (name.slice(0, 6) == bran && cost >= 20000 && cost <= 30000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }

    if (l == localStorage.getItem('lg')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            //alert(name.slice(0, 6));
            if (name.slice(0, 6) == bran && cost >= 30000 && cost <= 40000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }

}

function lgFiltering()
    //lg sorting
{
    if (s == localStorage.getItem('sm')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            //alert(name.slice(0, 6));
            if (name.slice(0, 2) == bran1 && cost >= 10000 && cost <= 20000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }
    if (m == localStorage.getItem('md')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            if (name.slice(0, 2) == bran1 && cost >= 20000 && cost <= 30000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }

    if (l == localStorage.getItem('lg')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            if (name.slice(0, 2) == bran1 && cost >= 30000 && cost <= 40000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }
}

function OnePlusFiltering()
    //Oneplus Sorting
{
    if (s == localStorage.getItem('sm')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;

            var cost = parseInt(Products[i].price);
            //alert(name.slice(0, 6));
            if (name.slice(0, 3) == bran2 && cost >= 10000 && cost <= 20000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }
    if (m == localStorage.getItem('md')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            if (name.slice(0, 3) == bran2 && cost >= 20000 && cost <= 30000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }

    if (l == localStorage.getItem('lg')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            if (name.slice(0, 3) == bran2 && cost >= 30000 && cost <= 40000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }
}

function motoFiltering() {
    //moto sorting
    if (s == localStorage.getItem('sm')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            if (name.slice(0, 4) == bran4 && cost >= 10000 && cost <= 20000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }
    if (m == localStorage.getItem('md')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            if (name.slice(0, 4) == bran4 && cost >= 20000 && cost <= 30000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }

    if (l == localStorage.getItem('lg')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            if (name.slice(0, 4) == bran4 && cost >= 30000 && cost <= 40000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }
}

function SamsungFiltering() {    //Samsung sorting
    var valid = false;
    if (s == localStorage.getItem('sm')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            if (name.slice(0, 3) == bran3 && cost >= 10000 && cost <= 20000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
                valid = true
            }
            else {
                valid = false
            }
        }
        if (valid == false) {
            alert("No Samsung product is found in this range");
        }
    }
   
    
    if (m == localStorage.getItem('md')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            if (name.slice(0, 3) == bran3 && cost >= 20000 && cost <= 30000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }

    if (l == localStorage.getItem('lg')) {
        for (var i = 0; i < Products.length; i++) {
            var Product = $("#PRODUCT_TEMPLATE").clone();
            var name = Products[i].name;
            var cost = parseInt(Products[i].price);
            if (name.slice(0, 3) == bran3 && cost >= 30000 && cost <= 40000) {
                $(".productname", Product).text(Products[i].name);
                $(".price", Product).text(Products[i].price);
                $(Product).find("img").attr("src", Products[i].image);
                $(Product).find("input").attr("data-productid", Products[i].productid);
                $("#secProducts").append($(Product).html());
            }
        }
    }

}
    $("input[name='AddToCart']").click(AddToCart_Click)


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