<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <header class="Main_header">
   <h1 class="Main_h1">초특가 여기어때</h1>
   <div class="Signin-signup">
  <c:choose>
        <c:when test="${sessionScope.id != null}"> 
           <a href="/MyPageForm.do" class="Main_a">마이페이지</a>                       
           <a href="/logout.do" class="Main_a">로그아웃</a>
        </c:when>
        <c:otherwise>
           <!-- <a href="/views/member/login.jsp">로그인</a> -->
           <a href="/SigninForm.do" class="Main_a">로그인</a>
<!--            <a href="/registerForm.do">회원가입</a> -->
           <a href="/form/registerForm.do" class="Main_a">회원가입</a>
           
        </c:otherwise>
     </c:choose>
   </div>
 </header>
 
 
 
 
 
 
 