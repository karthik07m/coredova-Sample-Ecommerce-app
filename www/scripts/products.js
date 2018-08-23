/// <reference path="../low2High.html" />
/// <reference path="../high2Low.html" />
var count = 0;
var clr = '';
localStorage.setItem('iphone', clr);
localStorage.setItem('Lg', clr);
localStorage.setItem('One', clr);
localStorage.setItem('Moto', clr);
localStorage.setItem('Sam', clr);
localStorage.setItem('lg', clr);
localStorage.setItem('md', clr);
localStorage.setItem('sm', clr);



(function () {

    //$("#count").text("0");
    //ClearCart_Click();
    SetLocalProducts();
    ShowProducts();
    $("input[name='AddToCart']").click(AddToCart_Click);
    $("#btnClearCart").click(ClearCart_Click);
    $("#apply").click(apply);

    $("#brand").click(brand);
    $("#lg").click(lg_sorting);
    $("#moto").click(Moto_sorting);
    $("#iphone").click(iphn_sorting);
    $("#samsung").click(Samsung_sorting);
    $("#onePlus").click(One_sorting);

    $("#range").click(range);
    $("#range1").click(range1);
    $("#range2").click(range2);
    $("#range3").click(range3);
})();



function SetLocalProducts() {
    localStorage["Products"] = [];
    var Products =
        [{
            productid: "1",
            name: "iPhone 6",
            image: "images/1.jpg",
            price: "19000",
            link:"about.html"
        },
          
        {
            productid: "2",
            name: "OnePlus 3T",
            image: "images/2.jpg",
            price: "25000"
        },

        {
            productid: "3",
            name: "Moto G5 Plus",
            image: "images/3.jpg",
            price: "30100"
        },


        {
            productid: "4",
            name: "LG G6",
            image: "images/4.jpg",
            price: "25900"
        },


        {
            productid: "5",
            name: "Samsung S7",
            image: "images/5.jpg",
            price: "30900"
        },

      
         {
             productid: "6",
             name: "LG x-venture",
             image: "images/8.jpg",
             price: "32900"
         },
      
        {
        productid: "7",
        name: "iPhone 7(black)",
        image: "images/7.jpg",
        price: "29000"
        },

        {
           productid: "9",
           name: "OnePlus 5",
            image: "images/9.jpg",
            price: "32000"
        },

         {
             productid: "10",
             name: "LG G3",
             image: "images/10.jpg",
             price: "16000"
         },

          {
              productid: "11",
              name: "Moto G4",
              image: "images/11.jpg",
              price: "17000"
          },

          {
              productid: "12",
              name: "Moto G5",
              image: "images/12.jpg",
              price: "22200"
          },

          {
              productid: "13",
              name: "OnePlus 2",
              image: "images/13.jpg",
              price: "17800"
          },

           {
                 productid: "14",
                 name: "Samsung j7(pro)",
                 image: "images/14.jpg",
                 price: "26900"
           },

             {
            productid: "8",
            name: "iPhone 7(red)",
            image: "images/6.jpg",
            price: "34000"
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
        $(Product).find("a").attr("href", Products[i].link);
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
});

function high_low() {
    window.location.href = "high2Low.html";
    //$("#remover").remove();
    //var Products = new Array();
    //Products = JSON.parse(localStorage["Products"]);
    //var cost = [];
    //var cost2 = [];
    //var cost_sorted = [];
    //for (var s = 0; s < Products.length; s++) {
    //    cost[s] = parseInt(Products[s].price);
    //    cost2[s] = parseInt(Products[s].price);
    //    cost_sorted = cost.sort().reverse();

    //}

    ////alert(cost2);


    //for (var i = 0; i < Products.length; i++) {
    //    var Product = $("#PRODUCT_TEMPLATE").clone();
    //    //cost[i] = parseInt(Products[i].price);
    //    //cost_sorted = cost.sort().reverse();
    //    for (var j = 0; j < cost_sorted.length; j++) {
    //        if (cost_sorted[i] == cost2[j]) {
    //            $(".productname", Product).text(Products[j].name);
    //            $(".price", Product).text(Products[j].price);
    //            $(Product).find("img").attr("src", Products[j].image);
    //            $(Product).find("input").attr("data-productid", Products[j].productid);
    //            //alert($(Product).html());
    //            $("#secProducts").append($(Product).html());
    //        }
    //    }
    //}
        
}

function low_high() {
    window.location.href = "low2High.html";
}


function lg_sorting()
{
    var phn = 'LG'
    localStorage.setItem('Lg', phn)
}

function iphn_sorting()
{
    var phn = 'iPhone'
    localStorage.setItem('iphone',phn)
}
function One_sorting() {
    var phn = 'One'
    localStorage.setItem('One', phn);
}

function Samsung_sorting()
{
    //alert("Samsung is Selected");
    var phn = 'Sam';
    localStorage.setItem('Sam', phn);

}
function Moto_sorting()
{
    var phn = 'Moto';
    localStorage.setItem('Moto', phn);

}

function range1()
{
    var sm = 'small';
    localStorage.setItem('sm',sm);
   
}

function range2()
{
    var md = 'medium'
    localStorage.setItem('md', md);
}

function range3()
{
   
    var lg = 'large';
    localStorage.setItem('lg', lg);
}

function apply()
{
    window.location.href = "filter.html";
}

function brand() {
    var x = document.getElementById('brandSort');
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}

function range()
{
    var x = document.getElementById('priceSort');
    if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}

function ClearCart_Click()
{
    var cart = new Array();
    localStorage["cart"] = JSON.stringify(cart);
    alert("Cart is cleared");
    $("#count").text("0");
    count = 0;
}