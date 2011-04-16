<%@ page session="false" %>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<h2>Companies list</h2>

<table>
  <tr>
    <th>Company name</th>
    <th>Domain of activity</th>
  </tr>
  <c:forEach var="company" items="${companies}">
  <tr>
    <td><a href="${company.id}">${company.name}</a></td>
    <td>${company.domain}</td>
  </tr>
  </c:forEach>
</table>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
