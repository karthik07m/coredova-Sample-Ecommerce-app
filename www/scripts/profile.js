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
    //document.getElementById("bluetooth").addEventListener("click" ,bluetooth);

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

//function bluetooth() {
    
//    bluetoothle.initialize(initializeSuccess, initializeError, "initialize");
//    bluetoothle.enable(enableSuccess, enableError);
//    bluetoothle.startScan(startScanSuccess, startScanError, true);
//    //bluetoothle.bond(bondSuccess, bondError, true);
//    bluetoothle.connect(connectSuccess, connectError, true);
//    bluetoothle.write(writeSuccess, writeError, true);
//}

//function initializeSuccess(obj) {
//    debugger;
//    alert("Bluetooth is on");
//    return obj;
//}

//function initializeError(obj) {
//    debugger;
//    var err = JSON.stringify(obj);
//    alert("Failure" + err);
//    return false;
//}

//function enableSuccess(obj)
//{
//    debugger;
//    alert("Bluetooth is enabled");
//    return obj;
//}

//function enableError(obj)
//{
//    debugger;
//    var err = JSON.stringify(obj);
//    alert("Unable to on bluetooth :" + err);
//    return false;
//}

//function startScanSuccess(result) {

//    alert("startScanSuccess(" + result.status + ")");

//    if (result.status === "scanStarted") {

//        alert("Scanning for devices (will continue to scan until you select a device)...", "status");
//    }
//    else if (result.status === "scanResult") {

//        if (!foundDevices.some(function (device) {

//            return device.address === result.address;

//        })) {

//            alert('FOUND DEVICE:');
//            alert(result);
//            foundDevices.push(result);
//            addDevice(result.name, result.address);
//        }
//    }
//}
//function startScanError(obj)
//{
//    debugger;
//    var err = JSON.stringify(obj);
//    alert("Scan error :" + err);
//    return false;
//}

//function bondSuccess(obj)
//{
//    debugger;
//    alert("Sucessfully bonded to device");
//    return obj;
//}
//function bondError(obj)
//{
//    debugger;
//    var err = JSON.stringify(obj);
//    alert("Bonding error" + err);
//    return false;
//}

//function connectSuccess(address) {
   
//    alert(address);
//    return address;
//}


//function connectError(obj) {
//    var err = JSON.stringify(obj);

//    alert("Connection fail" + err);
//    return false;
//}

//function writeSuccess(obj)
//{
//    var t = localStorage.getItem('profile_image');
//    return t;
//    alert("Sended successfull!");
//}

//function writeError(obj)
//{
//    var err = JSON.stringify(obj);
//    alert("Send Error" + err);
//    return false;
//}