function openRu() {
    replace("ru")
}

function openEn() {
    replace("en")
}

function openFr() {
    replace("fr")
}

function replace(lang) {
    document.cookie = "lang =" + lang;
    location.reload()
}

function logout() {
    $.ajax({
        url: 'login',
        type: 'DELETE',
        success: function () {
            location.reload()
        }
    });
}

$(function () {
    let loginElement = $('#login');
    let sum = $('#tickets');
    let login = loginElement.text();
    if (login) {
        $('#logout').css("display", "block");

    } else {
        loginElement.remove();
    }
    if (Number.parseInt(sum.text()) === 0) {
        $('#header_checkout').remove();
    }
    sum.remove();
});
