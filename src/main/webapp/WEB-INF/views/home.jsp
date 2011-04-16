<%@ page session="false" %>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<h2>Welcome to Corporate Base Service!</h2>

<p>
This is a database that lists relevant information on a large number of companies. 
</p>
<h4><a href="<spring:url value="/cb/companies/"/>">Go here to see the list!</a></h4>

<%@ include file="/WEB-INF/views/__list.jsp" %>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
