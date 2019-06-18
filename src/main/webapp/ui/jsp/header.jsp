
	     
	     
	      <c:if test="${pageContext.request.userPrincipal.name != null}">
	         <div class="w3-right  ">
	        	 	<i>Welcome </i><b>${firstLastName} </b> |
	        	 	<a href="${contextPath}/requestToIssue">Open Book Requests</a> |
	        	 	<a href="${contextPath}/issuedBooks">Issued Books</a> |
	        		<a style=" cursor:pointer" onclick="document.forms['logoutForm'].submit()">Logout</a>
	        </div>
	        <form id="logoutForm" method="POST" action="${contextPath}/logout">
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        </form>
	    </c:if>
	     <c:if test="${pageContext.request.userPrincipal.name == null}">
	    
	      <div class="w3-right "><%@ include file="index.jsp"%></div>
	     </c:if>
	    