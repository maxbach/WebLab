function showMain() {
    document.getElementById("film-short").style.display = 'block';
    document.getElementById("film-long").style.display = 'none';
    document.getElementById("film-review").style.display = 'none';
    setDark("film-short-title");
    setWhite("film-long-title");
    setWhite("film-review-title");
}

function showLong() {
    document.getElementById("film-short").style.display = 'none';
    document.getElementById("film-long").style.display = 'block';
    document.getElementById("film-review").style.display = 'none';
    setWhite("film-short-title");
    setDark("film-long-title");
    setWhite("film-review-title");
}

function showReview() {
    document.getElementById("film-short").style.display = 'none';
    document.getElementById("film-long").style.display = 'none';
    document.getElementById("film-review").style.display = 'block';
    setWhite("film-short-title");
    setWhite("film-long-title");
    setDark("film-review-title");
}

function setDark(element) {
    document.getElementById(element).style.backgroundColor = 'blue';
    document.getElementById(element).style.color = 'white';
}

function setWhite(element) {
    document.getElementById(element).style.backgroundColor = 'lightblue';
    document.getElementById(element).style.color = 'black';
}

function open_chooser() {
    $('#buy').css("display", "none");
    $('.buy_buttons').css("display", "flex");
}

function close_chooser() {
    $('#buy').css("display", "block");
    $('.buy_buttons').css("display", "none");
}

function dec() {
    var inputId = 'number';
    var input = document.getElementById(inputId).innerHTML;
    var count = parseInt(input) - 1;
    count = count < 1 ? 1 : count;
    document.getElementById(inputId).innerHTML = count.toString();
}

function inc() {
    var inputId = 'number';
    var input = document.getElementById(inputId).innerText;
    document.getElementById(inputId).innerHTML = (parseInt(input) + 1).toString();
}

function openCart(id) {
    var numberOfTickets = [$("#number").text()];
    var stringId = [id.toString()];
    $.post("/cart", {movieId: stringId, tickets: numberOfTickets});
    location.href = "/cart"
}