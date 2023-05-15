<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Board List</title>
</head>
<body>
    <h1>게시판</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Content</th>
                <th>Author</th>
                <th>Created At</th>
                <th>Updated At</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${empty boardList}">
                    <tr>
                        <td colspan="6">게시물이 없습니다.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${boardList}" var="board">
                        <tr>
                            <td>${board.id}</td>
                            <td>${board.title}</td>
                            <td>${board.content}</td>
                            <td>${board.author}</td>
                            <td>${board.createdAt}</td>
                            <td>${board.updatedAt}</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
    
    <!-- 페이징 처리 -->
    <div>
        <c:if test="${not empty boardList}">
            <ul>
                <c:set var="currentPage" value="${page.currentPage}" />
                <c:set var="totalPages" value="${page.totalPages}" />
                
                <li>
                    <c:if test="${currentPage > 1}">
                        <a href="?page=${currentPage - 1}">이전</a>
                    </c:if>
                </li>
                
                <c:forEach begin="1" end="${totalPages}" var="pageNum">
                    <li>
                        <c:choose>
                            <c:when test="${pageNum == currentPage}">
                                <strong>${pageNum}</strong>
                            </c:when>
                            <c:otherwise>
                                <a href="?page=${pageNum}">${pageNum}</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </c:forEach>
                
                <li>
                    <c:if test="${currentPage < totalPages}">
                        <a href="?page=${currentPage + 1}">다음</a>
                    </c:if>
                </li>
            </ul>
        </c:if>
    </div>
</body>
</html>
