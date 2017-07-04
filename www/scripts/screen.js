(function () {

    document.getElementById("test").addEventListener("click", myFunction);
    function myFunction() {
        var x = "Total Width: " + screen.hei + "px";
        document.getElementById("demo").innerHTML = x;
        var y = "Total Width: " + screen.height + "px";
        document.getElementById("demo2").innerHTML = y;
    }
})();