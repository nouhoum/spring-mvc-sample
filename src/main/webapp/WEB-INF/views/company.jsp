<%@ page session="false" %>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<h2>Details of ${company.name}</h2>
<h3>Creation date</h3>
<p><fmt:formatDate value="${company.creationDate}" pattern="dd-MM-yyyy"/></p>
<h3>Domain</h3>
<p>${company.domain}</p>
<h3>Description</h3>
<p>${company.description}</p>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
