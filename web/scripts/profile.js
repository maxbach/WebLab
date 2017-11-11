let timer;
$(function () {
    loadComments();
    checkText();
    $('#input_comment').bind('input propertychange', function() {
        checkText()
    });
    timer = setInterval(updateTime, 1000)
});

function loadComments() {
    $.ajax({
        url: 'comments',
        type: 'GET',
        success: function (data) {
            $('#comments').html(data)
        }
    });
}

function addComment() {
    $.ajax({
        url: 'comments',
        type: 'POST',
        data: {"commentText": $('#input_comment').val()},
        success: function () {
            loadComments();
            $('#input_comment').val("");
            $("#add_comment_btn").css('display', 'none');
        }
    });
}

function updateTime() {
    let time = new Date();
    $('#time').text(time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds());
}

function checkText() {
    if($('#input_comment').val().length){
        $("#add_comment_btn").css('display', 'block');
    } else {
        $("#add_comment_btn").css('display', 'none');
    }
}