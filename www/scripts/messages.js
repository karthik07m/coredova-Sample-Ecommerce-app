function onLoad() {
    if ((/(ipad|iphone|ipod|android)/i.test(navigator.userAgent))) {
        document.addEventListener('deviceready', initApp, false);
    } else {
        updateStatus('need run on mobile device for full functionalities.');
    }
}
var smsList = [];

function initApp() {
    if (!SMS) { alert('SMS plugin not ready'); return; }

    document.addEventListener('onSMSArrive', function (e) {
        var data = e.data;
        smsList.push(data);

        updateStatus('SMS arrived, count: ' + smsList.length);

        var divdata = $('div#data');
        divdata.html(divdata.html() + JSON.stringify(data));

    });
}

function update(id, str) {
    $('div#' + id).html(str);
}
function updateStatus(str) {
    $('div#status2').html(str);
}
function updateData(str) {
    $('div#data').html(str);
}
function listSMS() {
    updateData('');

    if (SMS) SMS.listSMS({}, function (data) {

        //updateData( JSON.stringify(data) );
       
        var html = "";
        if (Array.isArray(data)) {
            for (var i in data) {
                var sms = data[i];
                smsList.push(sms);
                //alert(smsList);
                html += "<div  style ='border-style:solid; border-color:grey; border-width: 1px 0px 0px 0px; border-radius:5px;}'>" + "<h4 onclick='sharing()' style ='color:black ;'>" + sms.address + ":</h4>" + sms.body
                    + "</div>"
                    ;
            }
        }
        
        updateData(html);
        //var smms = new Array();
        //smms = JSON.parse(smsList);
        //alert(smms);

    }, function (err) {
        updateStatus('error list sms: ' + err);
    });
    function test()
    {
        alert("Message clicked");
        
    }
}