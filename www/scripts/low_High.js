var count = 0;

(function ()
{
 $("#count").text("0");
var Products = new Array();
Products = JSON.parse(localStorage["Products"]);
var cost = [];
var cost2 = [];
var cost_sorted = [];

for (var s = 0; s < Products.length; s++) {
    cost[s] = parseInt(Products[s].price);
    cost2[s] = parseInt(Products[s].price);
    cost_sorted = cost.sort();
}

for (var i = 0; i < Products.length; i++) {
    var Product = $("#PRODUCT_TEMPLATE").clone();
    for (var j = 0; j < cost_sorted.length; j++) {
        if (cost_sorted[i] == cost2[j] ) {
            $(".productname", Product).text(Products[j].name);
            $(".price", Product).text(Products[j].price);
            $(Product).find("img").attr("src", Products[j].image);
            $(Product).find("input").attr("data-productid", Products[j].productid);
            //alert($(Product).html());
            $("#secProducts").append($(Product).html());
        }   }
}

$("input[name='AddToCart']").click(AddToCart_Click)
})();

var activities = document.getElementById("sortByPrice");
activities.addEventListener("click", function () {
    var options = activities.querySelectorAll("option");
    var count = options.length;
    if (typeof (count) === "undefined" || count < 2) {
        //addActivityItem();
    }
});

activities.addEventListener("change", function () {
    if (activities.value == "h2l") {
        high_low();
    }
    if (activities.value == "l2h") {
        low_high();
    }
    if (activities.value == "default") {
        first();
    }
});
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

function high_low() {
    window.location.href = "high2Low.html";

}

function low_high() {
    window.location.href = "low2High.html";
}


function first() {
    window.location.href = "products.html";
}