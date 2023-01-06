<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<div class="container">
	<form action="/blog/user?cmd=join" method="post" onsubmit = "return valid()">
		<div class="d-flex justify-content-end">
		<button type="button" class="btn btn-info" onClick="usernameCheck()">중복체크</button>
		</div>
		<div class="form-group">
			<input type="text" name="username" id="username" class="form-control"  placeholder="Enter Username" required>
		</div>
		<div class="form-group">
			<input type="password" name="password" class="form-control" placeholder="Enter password" required>
		</div>
		<div class="form-group">
			<input type="email" name="email"class="form-control" placeholder="Enter email" required>
		</div>
		<div class="d-flex justify-content-end">
		<button type="button" class="btn btn-info" onClick="goPopup();">주소 검색</button>
		</div>
		<div class="form-group">
			<input id="address" type="text" name="address" class="form-control" placeholder="Enter Address" required readonly>
		</div>
		
		<br>
		<button type="submit" class="btn btn-primary">회원가입완료</button>
	</form>
</div>

<script	>

let isChecking = false;
function valid(){
		if(isChecking==false){
			alert("아이디 중복 체크를 해주세요");
		}
		return isChecking;
}

function usernameCheck(){
	//document.querySelector와 같은 의미를 갖고있는 jQuery메소드
	let username = $("#username").val();
	//DB에서 확인해서 중복이 아니면 isChecking=true
	$.ajax({
		type: "POST",
		url:"/blog/user?cmd=usernameCheck",
		data: username,
		contentType: "text/plain;  charset=utf-8",
		dataType: "text" // 응답받을 데이터의 형태를 적는데 만약 json이면 자바스크립트 오브젝트로 파싱해줌.
		
	}).done(function(data){ //요청이 끝나면 이 함수 실행
		if(data==='ok'){ //유저네임이 있다는것
			alert("유저네임이 중복되었습니다.");
			isChecking=false;
		}else{
			isChecking=true;
			alert("해당 유저네임을 사용할 수 있습니다.");
		}
	});
}
function goPopup(){
	
	var pop = window.open("/blog/user/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	
}


function jusoCallBack(roadFullAddr){
		var addressEI = document.querySelector("#address")
		addressEI.value = roadFullAddr
		
}

</script>
</body>
</html>