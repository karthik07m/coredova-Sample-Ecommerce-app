 (function () {

    document.getElementById("up").addEventListener("click", check);
   
    function check()
    {
        var fn = document.reg.fn.value;
        var ln = document.reg.ln.value;
        var mail = document.reg.mail.value;
        var pass= document.reg.pass.value;
        var pass2 = document.reg.pass2.value;
        var valid = false;

        if (fn == "")
        {
            alert("Enter your first name");
            return false;
        }

        if (ln == "") {
            alert("Enter your last name");
            return false;
        }
        if (mail == "") {
            alert("Enter your email id");
            return false;
        }
        if (pass == "") {
            alert("Enter your Password");
            return false;
        }
        if (pass2 == "") {
            alert("Enter your confirm password");
            return false;
        }
        if (mail == localStorage.getItem("usr"))
        {
            alert("You are already registered!. Redirection to login page");
            window.location.href = "login.html";
            return false;
        }
        if (pass != pass2)
        {
            alert("Passwords doesn't match");
            return false;
        }
        else {
            valid = true
        }

      //localStorage["usrs"] = [];
      // var usrnames = new Array();
      



        localStorage.setItem("usr", mail);
        localStorage.setItem("pass", pass);
        localStorage.setItem("fn", fn);
        localStorage.setItem("ln", ln);


        if (valid)
        {
            alert("Registrated Successfully. Please login")
            window.location.href = "login.html";
            return false;
        }
    
    }
  
              

})();