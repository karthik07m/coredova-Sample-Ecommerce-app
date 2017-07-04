(function () {
    document.getElementById("rSet").addEventListener("click", reset);

})();

function reset()
{
    var old = document.rSet.old_pas.value;
    var p1 = document.rSet.pas1.value;
    var p2 = document.rSet.pas2.value;

    if (old == "")
    {
        alert("Please enter your old password");
        return false;
    }

    if (p1 == "")
    {
        alert("Please enter new password");
        return false;
    }
    if (p2 == "")
    {
        alert("please enter confirm password");
        return false;
    }
    if (old != localStorage.getItem("pass"))
    {
        alert("Old password is wrong!!. Please try again");
        return false;
    }

    if (p1 != p2)
    {
        alert("Password doesn't match");
        return false;
    }
    else {
        localStorage.getItem("pass");
        localStorage.setItem("pass", p1);
        alert("password has been succefully changed. Please login again");
        window.location.href = "login.html";
        return false;
       
    }
}