(function () {

    document.getElementById("log").addEventListener("click", lout);

    function lout()
    {
        localStorage.removeItem("usrid");
      
        alert("You have succesfully logout");
    }



})();