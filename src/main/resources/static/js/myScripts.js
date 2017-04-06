// Local debugging helper
var LOCAL = false;
var domain;

if(LOCAL) {
    domain = "http://localhost:8080";
} else {
    domain = "https://cp-fellowship.herokuapp.com";
}


function template(object) {
    var id = object["id"];

    var template = '' +
        '<div id="' + id + '" class="col-xs-12">' +
            innerTemplate(object) +
        '</div>';
    return template;
}

function innerTemplate(object) {
    var name = object["author"]["name"];
    var message = object["message"];
    var likes = object["likes"];

    var timestamp = object["timeStamp"];
    timestamp = timestamp.replace("T", " ");
    timestamp = new Date(timestamp);
    timestamp = $.format.prettyDate(timestamp);

    var tags = object["tags"];
    tags = tags.split(",");

    var comments = object["comments"];
    if(!comments)
        comments = 0;

    var template = '' +
        '<div class="panel post">' +
            '<div class="panel-heading">' +
                '<h3 class="panel-title"><em> ' + name + ' </em> <small class="pull-right"> ' + timestamp + ' </small></h3>' +
            '</div>' +
            '<div class="panel-body">' +
                '<div class="well">' +
                    message +
                '</div>' +
                '<ul class="tags list-inline">'; 
                    for(i = 0; i < tags.length; i++) {
                        template += '<li><button id="tag" class="btn">' + tags[i] + '</button></li>';
                    }
                    template += '' +
                '</ul>' +
            '</div>' +
            '<div class="panel-footer">' +
                '<ul class="list-inline">' +
                    '<li><a id="likeButton" class="btn btn-sm btn-default">' +
                    likes + '    <span class="glyphicon glyphicon-heart"></span>  </a></li>' +
                    '<li><a id="commentButton" class="btn btn-sm btn-default">' +
                    comments + '    <span class="glyphicon glyphicon-comment"></span>  </a></li>' +
                '</ul>' +
            '</div>' +
        '</div>';
    return template;
}

function getAllPosts() {
    var data;
    $.ajax({
		url: domain + "/posts",
		type: "GET",
	    data: data,
	    success: function(data) {
            $.each(data, function (index, object) {
                $("#listArea").append(template(object));
            });
		}
	});
}

function getPost(id) {
    var data;
    $.ajax({
        url: domain + "/posts/" + id,
        type: "GET",
        data: data,
        success: function(data) {
            return data;
        }
    });
}

function updatePost(input) {
	$.ajax({
		url: domain + "/posts",
		type: "POST",
		headers: {
		    "Content-Type": "application/json",
            "X-Auth-Token": window.sessionStorage.getItem("token")
		},
		dataType: "json",
	    data: JSON.stringify(input),
	    success: function() {
            refreshPosts();
		}
	});
}

function likePost(id) {
    console.log("liking:" + id);
    var data;
    $.ajax({
        url: domain + "/posts/" + id,
        type: "PUT",
        headers: {
            "Content-Type":"application/json",
            "X-Auth-Token": window.sessionStorage.getItem("token")
        },
        // data: data,
        success: function(data) {
            console.log(data);
            refreshPost(data);
        }
    });
}

function removeAllPosts() {
    $("#listArea").children().remove();
}

function refreshPosts() {
    removeAllPosts();
    getAllPosts();
}

function refreshPost(object) {
    var id = object["id"];
    $("#listArea #" + id).html(innerTemplate(object));
}

function sendSignIn(username, password) {
    var creds = {
        "username": username,
        "password": password
    }
    $.ajax({
        url: domain + "/login",
        type: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        dataType: "text",
        data: JSON.stringify(creds),
        success: function(data) {
            window.sessionStorage.token = data;
            window.location.href = domain;
        }
    });
}

function sendSignUp(name, username, password) {
    var creds = {
        "name": name,
        "email": username,
        "password": password
    }
    $.ajax({
        url: domain + "/user",
        type: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        dataType: "text",
        data: JSON.stringify(creds),
        success: function(data) {
            window.location.href = domain + "/sign-in";
        }
    });
}

function getPostsByTags(tags) {
    var data;
    $.ajax({
        url: domain + "/posts/" + tags,
        type: "GET",
        data: data,
        success: function(data) {
            removeAllPosts();
            $.each(data, function (index, object) {
                $("#listArea").append(template(object));
            });
        }
    });
}

$(document).ready(function() {

    // uncomment for production
    refreshPosts();

	$("#postSubmit").on("click", function() {
		var text = $("#postTextarea").val();
		var tagString = $("#postTags").val();
        var tags = tagString.replace(/ /g, '');

		var input = {
            message: text,
            tags: tags
        }
		updatePost(input);
	});

    $("#listArea").on("click", "#likeButton", function () {
        // TODO this needs to be fixed according to new layout
        var div = $(this).parent().parent().parent().parent().parent();
        var id = div[0].id;
        likePost(id);
    });

    $("#listArea").on("click", "#tag", function () {
        var val = $(this)[0].innerText;
        console.log("!!!!!!" + val);
        getPostsByTags(val);
    });

    $("#signIn_Button").on("click", function () {
        var username = $("#signIn_EmailInput").val();
        var password = $("#signIn_PasswordInput").val();
        sendSignIn(username, password);
    });

    $("#signUp_Button").on("click", function () {
        var name = $("#signUp_NameInput").val();
        var username = $("#signUp_EmailInput").val();
        var password = $("#signUp_PasswordInput").val();
        sendSignUp(name, username, password);
    });

    $("#searchButton").on("click", function () {
        var tags = $("#searchBar").val();
        getPostsByTags(tags);
    });
});
