let isPickup;
let placemarks = [];

$(function () {
    ymaps.ready(initMap);
    showPickup();
    $('#sum').text(parseInt($("#ticketPrice").text()) * parseInt($("#numberOfTickets").text()));
});

function initMap() {
    let myMap = new ymaps.Map('map', {
        center: [59.964213, 30.312013],
        zoom: 10
    });

    for (let obj of document.getElementsByClassName("cinemaId")) {
        let shopId = obj.innerText;
        let coorX = Number.parseFloat($("#x" + shopId).text());
        let coorY = Number.parseFloat($("#y" + shopId).text());

        let mark = new ymaps.Placemark([coorX, coorY], {
            balloonContent: shopId + ". " + $("#name" + shopId).text()
        }, {
            preset: 'islands#icon',
            iconColor: '#0095b6'
        });

        mark.events.add("click", function (e) {
            $("#choose_cinema_list").val(e.get('target').properties._data.balloonContent.split(".")[0])
            checkButtonInPickup();
        });

        myMap.geoObjects.add(mark);
        placemarks.push({
            id: shopId,
            placemark: mark
        });
    }
}

function showDelivery() {
    setMode(false);
    $('#delivery').css('display', 'flex');
    $('#pickup').css('display', 'none');
    setDark("order_delivery_switcher");
    setWhite("order_pickup_switcher");
}

function showPickup() {
    setMode(true);
    $('#delivery').css('display', 'none');
    $('#pickup').css('display', 'flex');
    setDark("order_pickup_switcher");
    setWhite("order_delivery_switcher");
}

function changedList() {
    let cinemaId = document.getElementById("choose_cinema_list").value;
    checkButtonInPickup();
    for (let mark of placemarks) {
        if (mark.id === cinemaId) {
            mark.placemark.balloon.open();
            return;
        }
    }
}

function buyTickets() {
    if (isPickup) {
        let shopId = document.getElementById("choose_cinema_list").value;
        $.ajax({
            url: 'order',
            type: 'POST',
            data: {"isPickup": isPickup, "shopId": shopId},
            success: function () {
                location.href='profile';
            }
        });
    } else {
        let address = document.getElementById("input_address").innerText;
        $.ajax({
            url: 'order',
            type: 'POST',
            data: {"isPickup": isPickup, "address": address},
            success: function () {
                location.href ='profile';
            }
        });
    }
}

function setDark(element) {
    document.getElementById(element).style.backgroundColor = 'blue';
    document.getElementById(element).style.color = 'white';
}

function setWhite(element) {
    document.getElementById(element).style.backgroundColor = 'lightblue';
    document.getElementById(element).style.color = 'black';
}

function setMode(pickup) {
    isPickup = pickup;
    if (pickup) {
        checkButtonInPickup();
    } else {
        checkButtonInDelivery();
    }
}

function checkButtonInPickup() {
    if (document.getElementById("choose_cinema_list").value === "-1") {
        $('#order_buy_btn').css("display", "none")
    } else {
        $('#order_buy_btn').css("display", "block")
    }
}

function checkButtonInDelivery() {

    if($('#input_address').val().length > 0){
        $("#order_buy_btn").css("display", "block");
    } else {
        $("#order_buy_btn").css("display", "none");
    }
}