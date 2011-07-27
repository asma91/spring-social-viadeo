<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>

<h3>Your Viadeo Feed</h3>
	
<div class="feed">
<ul class="feedList">
<c:forEach items="${feed}" var="post">
	<li class="post">
		<p><c:if test="${not empty post.from.largeImageUrl}"><img src="<c:out value="${post.from.profileUrl}"/>" align="top"/></c:if>
		<c:out value="${post.message}" /> - <c:out value="${post.from.firstName} ${post.from.lastName}" /></p>
	</li>
</c:forEach>
</ul>
</div>
