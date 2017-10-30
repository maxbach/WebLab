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
    document.cookie="lang =" + lang;
    location.reload()
}

function logout() {
    $.ajax({
        url: 'login',
        type: 'DELETE',
        success: function() {
            location.reload()
        }
    });
}

$(function() {
    var loginElement = $('#login');
    var login = loginElement.text();
    if (login) {
        $('#logout').css("display", "block")
    } else {
        loginElement.remove();
    }
});
