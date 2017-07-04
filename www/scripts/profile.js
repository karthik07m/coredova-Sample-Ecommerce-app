(function(){
    var fname = localStorage.getItem("fn");
    var lname = localStorage.getItem("ln");
    var usrid = localStorage.getItem("usr");
    $("#fname").text(fname);
    $("#lname").text(lname);
    $("#uid").text(usrid);
  

    document.getElementById("cameraTakePicture").addEventListener("click", cameraTakePicture);
    document.getElementById("cameraGetPicture").addEventListener("click", cameraGetPicture);
    document.getElementById("popup").addEventListener("click", popup);
    document.getElementById("popup2").addEventListener("click", popup2);
    document.getElementById("bluetooth").addEventListener("click" ,bluetooth);

    if (localStorage.getItem('profile_image') != '') {
        var image = document.getElementById('myImage');
        image.src = localStorage.getItem('profile_image');

    }




    // Initialize a Cache 
//    var cache = new CordovaFileCache({
//        fs: new CordovaPromiseFS({ // An instance of CordovaPromiseFS is REQUIRED 
//            Promise: Promise // <-- your favorite Promise lib (REQUIRED) 
//        }), 
//    });

//    cache.ready.then(function (list) {
//        // Promise when cache is ready. 
//        // Returns a list of paths on the FileSystem that are cached. 
//    })

})();
function test()
{
   
}

function cameraTakePicture() {
        navigator.camera.getPicture(onSuccess, onFail, {
        quality: 50,
        destinationType: Camera.DestinationType.FILE_URI,
        encodingType: Camera.EncodingType.JPEG,
        mediaType: Camera.MediaType.PICTURE,
        allowEdit: true,
        correctOrientation: true
        
    });

    function onSuccess(imageData) {
        var image = document.getElementById('myImage');

        //image.src = "data:image/jpeg;base64," + imageData;
        //localStorage.setItem("imageTest", imageData);
        //image.src = "data:image/jpeg;base64," + localStorage.getItem('imageTest');
        //cache.add(imageData);
        //image.src = cache.toDataURL(imageData).then(function (base64) { alert("Success") }, function (err) { alert(err) });

        localStorage.setItem('profile_image', imageData);
        image.src = localStorage.getItem('profile_image');
        window.location.reload();
    }

    function onFail(message) {
        alert(message);
    }
}

function cameraGetPicture() {
    navigator.camera.getPicture(onSuccess, onFail, {
        quality: 50,
        encodingType: Camera.EncodingType.JPEG,
        mediaType: Camera.MediaType.PICTURE,
        allowEdit: true,
        correctOrientation: true,
        sourceType: Camera.PictureSourceType.PHOTOLIBRARY
    });

    function onSuccess(imageURL) {
        var image = document.getElementById('myImage');
        //image.src = imageURL;
        targetHeight = 150;
        targetWidth = 150;
        localStorage.setItem('profile_image', imageURL);
        image.src = localStorage.getItem('profile_image');
        window.location.reload();
    }

   function onFail(message) {
        alert(message);
    }

}

function popup()
{
    var popup = document.getElementById("myPopup");
    popup.classList.toggle("show");
}

function popup2() {
    var popup2 = document.getElementById("myPopup2");
    popup2.classList.toggle("show2");
}

function bluetooth() {

    bluetoothle.initialize(initializeSuccess, initializeError, true);
    bluetoothle.enable(enableSuccess, enableError);
    bluetoothle.startScan(startScanSuccess, startScanError, true);
    bluetoothle.bond(bondSuccess, bondError, true);
    bluetoothle.connect(connectSuccess, connectError, true);
    bluetoothle.write(writeSuccess, writeError, true);
}

function initializeSuccess(obj) {
    alert("Bluetooth is on");
    return false;
}

function initializeError(obj) {
    var err = JSON.stringify(obj);
    alert("Failure" + err);
    return false;
}

function enableSuccess(obj)
{
}

function enableError(obj)
{
    var err = JSON.stringify(obj);
    alert("Unable to on bluetooth :" + err);
    return false;
}

function startScanSuccess(obj)
{
    alert("Scan started sucessfully");
    return false;
}
function startScanError(obj)
{
    var err = JSON.stringify(obj);
    alert("Scan error :" + err);
    return false;
}

function bondSuccess(obj)
{
    alert("Sucessfully bonded to device");
    return false;
}
function bondError(obj)
{
    var err = JSON.stringify(obj);
    alert("Bonding error" + err);
    return false;
}

function connectSuccess(obj) {
    alert("Sucessfully bonded to device");
    return false;
}

function connectError(obj) {
    var err = JSON.stringify(obj);
    alert("Connection fail" + err);
    return false;
}

function writeSuccess(obj)
{
    var t = localStorage.getItem('profile_image');
    return t;
    alert("Sended successfull!");
}