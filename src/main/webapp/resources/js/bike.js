var req;
var mozillus = 0;
var appServerUrl = "http://imbi.ld.ttu.ee:7500/repair/"

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
        url: "/repair/service-request/getCustomerDataByName",
        data: {"name": name},
        success: function (data) {
            $("input[name='customerIdTemp']").val("");
            $('#customerData').empty();

            if (data.length == 0) {
                $('#customerData').html("No customer found")
            } else {
                $('#customerData').html('<h3>Search result:</h3>' +
                    '<span id="customerTempName">'+data[0].name+'</span><button class="btn btn-default" onclick="addCustomerToServiceOrderRequest()">Add customer</button>')
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

function searchForDevices() {

    var searchDeviceForm = new Object();
    var device = new Object();

    device.name = $("#deviceSearchForm input[name='device.name']").val();
    device.regNo = $("#deviceSearchForm input[name='device.regNo']").val();
    device.model =  $("#deviceSearchForm input[name='device.model']").val();

    searchDeviceForm.device = device;
    searchDeviceForm.deviceTypeId = $("#deviceSearchForm #deviceTypeId").val();
    searchDeviceForm.clientName = $("#deviceSearchForm input[name='clientName']").val();

    $.ajax({
        type: "POST",
        contentType : 'application/json;',
        dataType : 'json',
        async: false,
        url: "/repair/device/searchForDevices",
        data: JSON.stringify(searchDeviceForm),
        success: function (foundDevices) {
            showDevicesSearchResult(foundDevices);
        },
        error: function () {
            alert("error!");
        }
    });
}

function showDevicesSearchResult(devices) {
    $("#foundDevices").empty();
    $("#foundDevices").append('<h3>Search result:</h3>');

    if(devices.length == 0) {
        $("#foundDevices").append('<div id="foundDevicesList">No devices found</div>');
    } else {
        $("#foundDevices").append('<div id="foundDevicesList"><table id="foundDevicesTable" class="table table-striped"><tr><th>Name</th><th>Model</th><th>RegNo</th><th>Add to order</th></tr></table></div>');

        $.each(devices, function(i, device) {
            $("#foundDevicesTable").append("<tr id="+device.device.device+"><td>"+device.device.name +"</td><td>"+device.device.model+"</td><td>"+device.device.regNo+"</td><td><button class='btn btn-default' onclick='addToServiceOrder("+device.device.device+",\""+device.device.name+"\")'>Add</button></td></tr>");
        });
    }
}

function addToServiceOrder(id, deviceName) {
    $('#alert').remove();

    if(!$('#devices').find($('input#'+id).length)) {
        $('#container').prepend('<div id="alert" class="alert alert-danger">Device ' +deviceName+' is already added!</div>')
    }else {
        $('#deviceTable').append("<tr><td>"+deviceName+"</td><td><button class='btn btn-default' onclick='removeFromOrder(this)'>Remove</button></td><input id='"+id+"' type='hidden' value='"+id+"'></tr>");
        $("#foundDevicesTable").find("#"+id).remove();
    }
}

function removeFromOrder(obj) {
    $(obj).closest('tr').remove();
}

function validateNewDevice(addDeviceForm) {
    $('.err-empty').remove();

    var valid = true;
    if(jQuery.isEmptyObject(addDeviceForm.device.name)) {
        valid = false;
        $("#addDeviceForm input[name='device.name']").after("<span class='err-empty'>Cannot be empty</span>")
    }
    if(jQuery.isEmptyObject(addDeviceForm.device.regNo)) {
        valid = false;
        $("#addDeviceForm input[name='device.regNo']").after("<span class='err-empty'>Cannot be empty</span>")
    }
    if(jQuery.isEmptyObject(addDeviceForm.device.model)) {
        valid = false;
        $("#addDeviceForm input[name='device.model']").after("<span class='err-empty'>Cannot be empty</span>")
    }
    if(jQuery.isEmptyObject(addDeviceForm.device.description)) {
        valid = false;
        $("#addDeviceForm input[name='device.description']").after("<span class='err-empty'>Cannot be empty</span>")
    }
    if(jQuery.isEmptyObject(addDeviceForm.device.manufacturer)) {
        valid = false;
        $("#addDeviceForm input[name='device.manufacturer']").after("<span class='err-empty'>Cannot be empty</span>")
    }
    if($.inArray([1, 2, 3], addDeviceForm.deviceTypeId)) {
        valid = false
        $("#addDeviceForm #deviceTypeId").after("<span class='err-empty'>Cannot add supertype device!</span>")
    }
    return valid;

}
function addNewDevice() {

    var addDeviceForm = new Object();
    var device = new Object();

    device.name = $("#addDeviceForm input[name='device.name']").val();
    device.regNo = $("#addDeviceForm input[name='device.regNo']").val();
    device.model =  $("#addDeviceForm input[name='device.model']").val();
    device.description =  $("#addDeviceForm textarea[name='device.description']").val();
    device.manufacturer = $("#addDeviceForm input[name='device.manufacturer']").val();

    addDeviceForm.device = device;
    addDeviceForm.deviceTypeId = $("#addDeviceForm #deviceTypeId").val();

    if(!validateNewDevice(addDeviceForm)) {
        return;
    }

    $.ajax({
        type: "POST",
        contentType : 'application/json;',
        dataType : 'json',
        async: false,
        url: "/repair/device/addNewDevice",
        data: JSON.stringify(addDeviceForm),
        success: function (responseDevice) {
            addToServiceOrder(responseDevice.device, responseDevice.name);
            $('#addDeviceForm')[0].reset();
        },
        error: function () {
            alert("error!");
        }
    });
}

function submitServiceOrder() {
    $('#alert').remove();

    if($('#deviceTable input').length == 0) {
        showNoDevicesAlert();
    } else {
        var devicesIds = getServiceOrderDeviceIds();

        var newServiceOrder = new Object();
        newServiceOrder.devices = devicesIds;
        newServiceOrder.serviceRequestId = $('#serviceRequestId').val();
        newServiceOrder.note = $('#note').val();

        $.ajax({
            type: "POST",
            contentType : 'application/json;',
            dataType : 'json',
            async: false,
            url: "/repair/service-order/saveNewServiceOrder",
            data: JSON.stringify(newServiceOrder),
            success: function (serviceOrderId) {
                window.location.replace("http://localhost:8888/repair/service-order/updateServiceOrder?serviceOrderId="+serviceOrderId);
            },
            error: function () {
                alert("error!");
            }
        });

    }
}


function showNoDevicesAlert() {
    $('#container').prepend('<div id="alert" class="alert alert-danger">No devices were added to order!</div>')
}
function submitEditedServiceOrder() {

    $('#alert').remove();
    if($('#deviceTable input').length == 0) {
        showNoDevicesAlert();
    } else {
        var devicesIds = getServiceOrderDeviceIds();

        var serviceOrder = new Object();
        serviceOrder.devices = devicesIds;
        serviceOrder.serviceOrderId = $('#serviceOrderId').val();
        serviceOrder.note = $('#note').val();
        serviceOrder.employeeNote = $('#employeeNote').val();
        serviceOrder.serviceOrderStatusType = $('#serviceOrderStatusType').val();

        $.ajax({
            type: "POST",
            contentType : 'application/json;',
            dataType : 'json',
            async: false,
            url: "/repair/service-order/saveUpdatedServiceOrder",
            data: JSON.stringify(serviceOrder),
            success: function (serviceOrderId) {
                window.location.replace("http://localhost:8888/repair/service-order/updateServiceOrder?serviceOrderId="+serviceOrderId);
            },
            error: function () {
                alert("error!");
            }
        });

    }

}

function getServiceOrderDeviceIds() {
    var devicesIds = [];
    $.each($('#deviceTable input'), function (i, input) {
        devicesIds.push($(input).val());
    });
    return devicesIds;
}
