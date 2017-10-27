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
    document.cookie="lang =" + lang
    location.reload()
}
