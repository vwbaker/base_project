//var domain = "http://localhost:8080";
var domain = "https://cp-fellowship.herokuapp.com";

function template(object) {
    var id = object["id"];
    var name = object["author"]["name"];
    var message = object["message"];
    var likes = object["likes"];
    console.log(id + ":  post:" + message + "  likes:" + likes);

    var template = '' +
        '<div id="'+id+'" class="col-md-6 col-xs-12">' +
            '<div class="well">' +
                '<h4 id="postHeader"><em>' + name + '</em></h4>' +
                message + '<br><br>' +
                '<a id="likeButton" href="#" class="btn btn-sm">' +
                    likes + '   <span class="glyphicon glyphicon-thumbs-up"></span> Like </a>' +
            '</div>' +
        '</div>';
    return template;
}

function getPosts() {
    var data;
    $.ajax({
		url: domain + "/posts",
		type: "GET",
	    data: data,
	    success: function(data) {
            $.each(data, function (index, object) {

                $("#listArea").append(template(object));
                $("#likeButton").click(function () {
                   updatePost($(this).parent().parent().attr("id"));
                });
            });
		}
	});
}

function sendPost(input) {
	$.ajax({
		url: domain + "/posts",
		type: "POST",
		headers: { "Content-Type":"application/json" },
		dataType: "json",
	    data: JSON.stringify(input),
	    success: function() {
		    console.log("success");
            refreshPosts();
		}
	});
}

function updatePost(id) {
    var data;
    $.ajax({
        url: domain + "/posts/" + id,
        type: "PUT",
        headers: { "Content-Type":"application/json" },
        dataType: "json",
        data: data,
        success: function() {
            console.log("success");
            refreshPosts();
        }
    });
}

function removeAll() {
    $("#listArea").children().remove();
}

function refreshPosts() {
    removeAll();
    getPosts();
}

$(document).ready(function() {
	
	refreshPosts();

	$("#postSubmit").click(function() {
		var text = $("#postTextarea").val();
		var input = {
            message: text,
            tags: ["fresh", "lit"]
        }
		sendPost(input);

	});

});
