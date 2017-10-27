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
