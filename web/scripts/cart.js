$(function() {
    var priceElement = $("#ticketPrice");
    var numberElement = $("#numberOfTickets");

    var ticketPrice = parseInt(priceElement.text());
    var numberOfTickets = parseInt(numberElement.text());

    priceElement.remove();
    numberElement.remove();

    sessionStorage.setItem("ticketPrice", ticketPrice);
    sessionStorage.setItem("numberOfTickets", numberOfTickets);

    updatePrice();
    localStorage.clear();


});

$(window).bind('beforeunload', function() {
    var keys = [];
    var values = [];

    for (var obj in localStorage) {
        keys.push(obj);
        values.push(localStorage.getItem(obj))
    }

    keys = keys.slice(0, localStorage.length);
    values = values.slice(0, localStorage.length);

    $.ajax({
        url: 'cart',
        type: 'POST',
        dataType: "json",
        async: false,
        data: {"movieId": keys, "tickets": values}
    });

});

function deleteMovie(id) {
    localStorage.removeItem(id);
    $.ajax({
        url: 'cart?id=' + id,
        type: 'DELETE',
        success: function() {
            location.reload()
        }
    });
}

function dec(id) {
    var inputId = 'number'.concat(id);
    var input = document.getElementById(inputId).innerHTML;
    var count = parseInt(input) - 1;
    if (count < 1) {
        count = 1;
    } else {
        updateLocalStorage(id, false)
    }
    document.getElementById(inputId).innerHTML = count.toString();
}

function inc(id) {
    var inputId = 'number'.concat(id);
    var input = document.getElementById(inputId).innerText;
    updateLocalStorage(id, true);
    document.getElementById(inputId).innerHTML = (parseInt(input) + 1).toString();
}

function updateLocalStorage(id, isPlus) {
    var counter = isPlus ? 1 : -1;
    if (localStorage.hasOwnProperty(id)) {
        var oldVar = localStorage.getItem(id);
        localStorage.removeItem(oldVar);
        localStorage.setItem(id, parseInt(oldVar) + counter)
    } else {
        localStorage.setItem(id, counter)
    }

    var ticketNumber = parseInt(sessionStorage.getItem("numberOfTickets"));
    sessionStorage.removeItem("numberOfTickets");
    sessionStorage.setItem("numberOfTickets", ticketNumber + counter);
    updatePrice();

}

function updatePrice() {
    var ticketPrice = parseInt(sessionStorage.getItem("ticketPrice"));
    var numberOfTickets = parseInt(sessionStorage.getItem("numberOfTickets"));

    $("#sum").text(ticketPrice * numberOfTickets);
}

function openMoviePage(id) {
    location.href = "page?id=" + id;
}

