<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/sideBarAjax.js"></script>
<div id="sidebar">
  <div class="inner">

    <!-- Menu -->
      <nav id="menu">
        <header class="major">
          <h2>Menu</h2>
            <a href="/logout">로그아웃</a>
        </header>
        <ul>
          <li><a href="/admin/myInfo">마이페이지</a></li>
          <li><a href="/user/list">동문관리</a></li>
          <li><a href="/user/typeList">회원유형</a></li>
          <li>
            <span class="opener">인문학습원 소개</span>
            <ul>
              <li><a href="/admin/introduceEdit">안내페이지 수정</a></li>
              <li><a href="/admin/introduce">보기</a></li>
            </ul>
          </li>
          <li><span class="opener">커뮤니티</span>
					<ul id="community">
					</ul>
				</li>
				<li><span class="opener">광고</span>
					<ul id="advertise">
					</ul>
				</li>
          <li><a href="/admin/list">관리자 권한 부여</a></li>
          <li><a href="/admin/mailSend">문자/메일 발송</a></li>
            <li><span class="opener">회원변경사항</span>
                <ul>
                    <li><a href="/user/phoneNumberEditList">아이디변경</a></li>
                    <li><a href="/user/userEditList">회원 정보 변경</a></li>
                </ul>
            </li>
        </ul>
      </nav>

      <!-- Footer -->
		  <footer id="footer">
			   <p class="copyright">
				     &copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>
             . Design: <a href="https://html5up.net">HTML5 UP</a>.
			   </p>
		</footer>

  </div>
</div>
