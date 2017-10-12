<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.Calendar"%>
<%
   request.setCharacterEncoding("EUC-KR");
   
   Calendar cal = Calendar.getInstance();
      int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH) + 1;
    int day = cal.get(Calendar.DATE);
    int endday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입 상세입력</title>
<script>
function btn_idcheck(){
   url = "Idcheck.jsp?id="+document.getElementById("m_id").value;
   window.open(url,'opner','width=400,height=300');
}
function sel_mobile(){
   var mobile1 = document.joinIdForm.m_mobile1;
   if (mobile1.value != 0){
      document.joinIdForm.m_mobile2.focus();
   }
}
function in_mobile(){
   var mobile2 = document.joinIdForm.m_mobile2;
   if (mobile2.value.length >= 4) {
      document.joinIdForm.m_mobile3.focus();
   }
}
function sel_domain(){
   var domain1 = document.joinIdForm.m_domain1;
   var domain2 = document.joinIdForm.m_domain2;
   if (domain2.value == 0){
      domain1.readOnly = true;
      domain1.value = "";
   } else if (domain2.value == 9) {
      domain1.readOnly = false;
      domain1.value = "";
   } else {
      domain1.readOnly = true;
      domain1.value = domain2.value;
   }
}
function checkpw(value){
   if (document.joinIdForm.m_pw.value != value){
      document.getElementById("pw_comment").innerText = "비밀번호가 일치하지 않습니다.";
      document.getElementById("pw_comment").style.color = "red";
   } else {
      document.getElementById("pw_comment").innerText = "비밀번호가 일치합니다.";
      document.getElementById("pw_comment").style.color = "blue";
   }
}
function popup1(value){
   if (value == "Y"){
      document.getElementById("s_pop").innerText = "";
   } else {
      document.getElementById("s_pop").innerText = "이벤트 등 행사에 관한 불이익을 받으실 수 있습니다.";
      document.getElementById("s_pop").style.color = "red";
   }
}
function popup2(value){
   if (value == "Y"){
      document.getElementById("e_pop").innerText = "";
   } else {
      document.getElementById("e_pop").innerText = "이벤트 등 행사에 관한 불이익을 받으실 수 있습니다.";
      document.getElementById("e_pop").style.color = "red";
   }
}
</script>
</head>
<body>
<h4>회원 가입</h4>
<form name="joinIdForm" action="${PATH}/MemberController" method="post">
<input type="hidden" name="m_kname" value="<%= request.getParameter("kFamily")+request.getParameter("kName") %>">
<input type="hidden" name="m_eFamily" value="<%= request.getParameter("eFamily") %>">
<input type="hidden" name="m_eName" value="<%= request.getParameter("eName") %>">
<input type="hidden" id="action" name="action" value="m_insert">
<table border="1" width="700px">
   <tr>
