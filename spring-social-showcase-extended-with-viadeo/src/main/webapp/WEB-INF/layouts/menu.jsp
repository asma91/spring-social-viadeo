<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<h4><a href="<c:url value="/twitter"/>">Twitter</a></h4>
<c:if test="${connectedToTwitter}">
<ul class="menu">
	<li><a href="<c:url value="/twitter"/>">User Profile</a></li>
	<li><a href="<c:url value="/twitter/timeline"/>">Timeline</a></li>
	<li><a href="<c:url value="/twitter/friends"/>">Friends</a></li>
	<li><a href="<c:url value="/twitter/followers"/>">Followers</a></li>
	<li><a href="<c:url value="/twitter/messages"/>">Messages</a></li>
	<li><a href="<c:url value="/twitter/trends/current"/>">Current Trends</a></li>
</ul>
</c:if>

<h4><a href="<c:url value="/facebook"/>">Facebook</a></h4>
<c:if test="${connectedToFacebook}">
<ul class="menu">
	<li><a href="<c:url value="/facebook"/>">User Profile</a></li>
	<li><a href="<c:url value="/facebook/feed"/>">Feed</a></li>
	<li><a href="<c:url value="/facebook/friends"/>">Friends</a></li>
	<li><a href="<c:url value="/facebook/albums"/>">Albums</a></li>
</ul>
</c:if>

<h4><a href="<c:url value="/viadeo"/>">Viadeo</a></h4>
<c:if test="${connectedToViadeo}">
<ul class="menu">
	<li><a href="<c:url value="/viadeo"/>">User Profile</a></li>
	<li><a href="<c:url value="/viadeo/feed"/>">Feed</a></li>
</ul>
</c:if>
