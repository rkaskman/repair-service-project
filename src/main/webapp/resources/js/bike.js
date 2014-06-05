var req;
var mozillus = 0;
var appServerUrl = "http://imbi.ld.ttu.ee:7500/bike2/"

function initializeDc() {
    try {
        req = new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch (e) {
        try {
            req = new ActiveXObject("Microsoft.XMLHTTP");
        }
        catch (oc) {
            req = null;
        }
    }

    if (!req && typeof XMLHttpRequest != "undefined") {
        req = new XMLHttpRequest();
        mozillus = 1;
    }
}

function showDiv(divid) {
    if (document.layers) {
        document.layers[divid].visibility = "show";
    }
    else {
        document.getElementById(divid).style.visibility = "visible";
    }
}

function hideDiv(divid) {
    if (document.layers) {
        document.layers[divid].visibility = "hide";
    }
    else {
        document.getElementById(divid).style.visibility = "hidden";
    }
}

function showDescriptionForm() {
    showDiv("descriptionFormDiv");
}

function evaluateDescriptionForm(bicycleId, description) {
    document.forms['descriptionForm'].bicycleId.value = bicycleId;
    document.forms['descriptionForm'].description.value = description;
}

function showBikeDescription(bicycleId, description) {
    showDescriptionForm();
    evaluateDescriptionForm(bicycleId, description);
}

function hideDescriptionForm() {
    hideDiv("descriptionFormDiv");
}

function getBicycle(bicycleId) {

    initializeDc();
    var start = new Date();
    var time = start.getTime();
    var url = appServerUrl + "bikeservice?id=" + bicycleId + '&tm=' + time;
    url = encodeURI(url);
    if (req != null) {
        req.onreadystatechange = processRequest;
        req.open("GET", url, true);
        req.send(null);
    }
}

function processRequest() {

    if (req.readyState == 4) {
        if (req.status == 200) {
            var bicycle;
            if (mozillus == 1) {
                bicycle = JSON.parse(req.responseText);
            }
            else {
                // IE-ga JSON.parse ei toota.
                bicycle = eval(req.responseText);
            }
            var bicycleId = bicycle.id;
            var description = bicycle.description;
            showBikeDescription(bicycleId, description);
        }
        else {
            document.getElementById("bicycleServiceResponse").innerHTML =
                "Error getting data from webservice:<br>" + req.statusText;
        }
    }
}


function searchForClient() {

    var name = $("input[name='requestClientSearchField']").val();

    $.ajax({
        type: "GET",
        async: false,
        url: "/bike/service-request/getCustomerDataByName",
        data: {"name": name},
        success: function (data) {
            $("input[name='customerIdTemp']").val("");
            $('#customerData').empty();

            if (data.length == 0) {
                $('#customerData').html("No customer found")
            } else {
                $('#customerData').html('<span id="customerTempName">'+data[0].name+'</span><button onclick="addCustomerToServiceOrderRequest()">Add customer</button>')
                $("input[name='customerIdTemp']").val(data[0].id);
            }

        },
        error: function () {
            alert("error!");
        }
    });

}

function addCustomerToServiceOrderRequest() {
    $("input[name='customerId']").val($("input[name='customerIdTemp']").val());
    $('#customerName').html("Customer: " + $('#customerTempName').html());
    $('#customerData').empty();

}