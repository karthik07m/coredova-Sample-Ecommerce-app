(function () {

    document.getElementById("logoff").addEventListener("click", lout);

    function lout()
    {
        localStorage.removeItem("usrid");
        disableBackButton();
        alert("You have succesfully logout");
   
    }
    function disableBackButton() {
        window.history.forward()
    }
    disableBackButton();
    window.onload = disableBackButton();
    window.onpageshow = function (evt) { if (evt.persisted) disableBackButton() }
    window.onunload = function () { void (0) }


})();