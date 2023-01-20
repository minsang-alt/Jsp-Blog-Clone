
function addReply(data) {

	var replyItem = `<li id="reply-${data.id}" class="media">`;
	replyItem += `<div class="media-body">`;
	replyItem += `<strong class="text-primary">${data.userId}</strong>`;
	replyItem += `<p>${data.content}</p></div>`;
	replyItem += `<div class="m-2">`;

	replyItem += `<i onclick="deleteReply(${data.id})" class="material-icons">delete</i></div></li>`;

	$("#reply__list").prepend(replyItem);
}

function replySave(userId, boardId) {

	var data = {
		userId: userId,
		boardId: boardId,
		content: $("#content").val()
	}

	$.ajax({
		type: "post",
		url: "/blog/reply?cmd=save",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(function(result) {
		if (result.statusCode == 1) {
			
			addReply(result.data);
			$("#content").val("");
			//location.reload();
		} else {
			alert("댓글쓰기 실패");
		}
	});
}

function deleteReply(id) {
	
	$.ajax({
		type: "post",
		url: "/blog/reply?cmd=delete&id=" + id,
		dataType: "json"
	}).done(function(result) {
		if (result.statusCode == 1) {
			console.log(result);
			$("#reply-"+id).remove();
		} else {
			alert("댓글 삭제 실패");
		}
	});
}





function deleteById(boardId) {

	$.ajax({
		type: "post",
		url: "/blog/board?cmd=delete&id=" + boardId,
		dataType: "json"
	}).done(function(result) {
		if (result.statusCode == 1) {
			location.href = "index.jsp";
		} else {
			alert("삭제에 실패하였습니다.");
		}

	});
}