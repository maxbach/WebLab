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