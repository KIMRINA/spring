<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSelect</title>
</head>
<body>
	<h3 class="page_title">내 정보 조회</h3>
	<div><span class="label">아디</span><span>${member.id}</span></div>
	<div><span class="label">패스워드</span><span>${member.pw}</span></div>
	<div><span class="label">직업</span><span>${member.job}</span></div>
	<div><span class="label">가입동기</span><span>${member.reason}</span></div>
	<div><span class="label">성별</span><span>${member.gender}</span></div>
	<div><span class="label">메일수신여부</span><span>${member.mailyn}</span></div><br>
	<button type="button" id="btnPage">목록으로 </button>
<script>
	btnPage.addEventListener("click",goPage);
	function goPage(){
		// history.back();
		// history.go(-1);  // 이전페이지로 이동
		// location.href="memberAll.jsp";
		location.assign("memberAll.jsp");  // 네가지가 다 같은 방법 = 이전페이지로 이동
	}
</script>
</body>
</html>