<%@tag import="javax.el.ELContext"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@attribute name="roles" required="true" description="Required roles separeted by comas with no space (i.e. ADMIN,MANAGER,XPTO)"%>

<c:set var="allowed" value="false"/>

<c:forTokens items="roles" delims="," var="role">
	<c:set var="isUserInRole" value='<%=request.isUserInRole(pageContext.getAttribute("role"))%>'/>
	
	<c:if test="${isUserInRole}">
		<c:set var="allowed" value="true"/>
	</c:if>
</c:forTokens>

<c:if test="${allowed}">
	<jsp:doBody/>
</c:if>