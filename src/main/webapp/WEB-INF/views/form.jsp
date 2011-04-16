<%@ page session="false" %>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

<div>
	<h2>Company creation</h2>
	<form:form modelAttribute="company" commandName="company" method="post">
		<p>
			<label>Company name</label>
			<input type="text" name="name" value="${company.name}" />
			<form:errors path="name" cssClass="error"/>
		</p>
		
		<p>
			<label>Company SIRET</label>
			<input type="text" name="siret" value="${company.siret}" />
			<form:errors path="siret" cssClass="error"/>
		</p>
		
		<p>
			<label>Domain</label>
			<input type="text" name="domain" value="${company.domain}" />
			<form:errors path="domain" cssClass="error"/>
		</p>
		
		<p>		
			<label>Creation date</label>			
			<input type="text" name="creationDate" value ="<fmt:formatDate value="${company.creationDate}" pattern="dd-MM-yyyy"/>"/>(dd-mm-yyyy)
			<form:errors path="creationDate" cssClass="error"/>
		</p>
		
		<p>
			<label>Description</label>
			<textarea name="description" rows="5" cols="40">${company.description}</textarea>
			<form:errors path="description" cssClass="error"/>			
		</p>
	
		<input type="submit" value="Create" />
	</form:form>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>