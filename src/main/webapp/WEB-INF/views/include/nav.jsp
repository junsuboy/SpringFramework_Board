<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>

<script src="https://kit.fontawesome.com/023885ae63.js" crossorigin="anonymous"></script>

<ul>
    <li>
        <a href="/board/listPageSearch?num=1">글 목록(페이징+검색)</a>
    </li>

    <li>
        <a href="/board/listPage?num=1">글 목록(페이징)</a>
    </li>

    <li>
        <a href="/board/list">글 목록</a>
    </li>

    <li>
        <a href="/board/write">글 작성</a>
    </li>

    <c:catch>
        <c:choose>
            <c:when test="${empty authInfo}">
                <li>
                    <a href="/login"><i class="fa fa-sign-in"></i> 로그인</a>
                </li>
                <li>
                    <a href="/register/step1"><i class="fa fa-user"></i> 회원가입</a>
                </li>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${authInfo.grade eq '1'}">
                        <li>
                            <p>관리자 ${authInfo.name}님, 환영합니다.</p>
                        </li>
                        <li>
                            <a href="/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <p>${authInfo.name}${authInfo.id}님, 반갑습니다!</p>
                        </li>
                        <li>
                            <a href="/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </c:catch>
</ul>
</body>
</html>