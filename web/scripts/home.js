function changedSelector() {
    var e = document.getElementById("genre_selector");
    var genreId = e.options[e.selectedIndex].value;
    document.cookie = "genre = " + genreId;
    location.reload()
}
function openMoviePage(id) {
    location.href = "page?id=" + id;
}

function open_chooser(id) {
    document.getElementById('buy' + id).style.display = 'none';
    document.getElementById('buy_buttons'+ id).style.display = 'flex';
}

function close_chooser(id) {
    document.getElementById('buy' + id).style.display = 'block';
    document.getElementById('buy_buttons' + id).style.display = 'none';
}

function dec(id) {
    var inputId = 'number'.concat(id);
    var input = document.getElementById(inputId).innerHTML;
    var count = parseInt(input) - 1;
    count = count < 1 ? 1 : count;
    document.getElementById(inputId).innerHTML = count.toString();
}

function inc(id) {
    var inputId = 'number'.concat(id);
    var input = document.getElementById(inputId).innerText;
    document.getElementById(inputId).innerHTML = (parseInt(input) + 1).toString();
}

function openCart(id) {
    var numberOfTickets = [$("#number".concat(id)).text()];
    var stringId = [id.toString()];
    $.post("/cart", {movieId: stringId, tickets: numberOfTickets});
    location.href = "/cart"
}