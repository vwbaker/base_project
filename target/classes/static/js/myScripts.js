function getPost(id) {
	var post;
	$.ajax({
		url: "http://localhost:8080/post/" + id,
		type: "GET",
	    data: post, // or $("#myform").serializeArray()
	    success: function() { alert("GET success"); }
	});
	return post;
}

function sendPost(post) {
	$.ajax({
		url: "http://localhost:8080/post",
		type: "POST",
		headers: { "Content-Type":"application/json" },
		dataType: "json",
	    data: post, // or $("#myform").serializeArray()
	    success: function() { alert("POST success"); }
	});
}

$(document).ready(function() {
	$("#postSubmit").click(function() {
		var text = JSON.stringify($("#postTextarea").val());
		var post = {
			"message": text
		}
		sendPost(post);
	});
});