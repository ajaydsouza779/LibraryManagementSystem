
<c:forEach items="${allbooks}" var="book">
	<div id="book_${book.id}" class="w3-modal">
	  <div class="w3-modal-content w3-animate-zoom">
	    <div class="w3-container w3-black w3-display-container">
	      <span onclick="document.getElementById('book_${book.id}').style.display='none'" 
	      	class="w3-button w3-display-topright w3-large">x</span>
	      <h3>${book.title}</h3>
	    </div>
	    <div class="w3-container">
	      <h5>ISIN <b>${book.isin}</b></h5>
	      <h5>Category <b>${book.category}</b></h5>
	      <h5>Author <b>${book.author}</b></h5>
	    </div>
	    <div class="w3-container w3-black">
	      <h3>About the book</h3>
	    </div>
	    <div class="w3-container ">
	    	<img  class="w3-half  w3-padding" src="${urlOfImg}/${book.imageName}" alt="${book.title}" style="max-height: 250px; overflow: hidden"/>
	
	       <div class="w3-half w3-padding">
	       	<p>${book.synopsis}</p>
		    
		    </div>
	    </div>
	     <div class="w3-container w3-black">
	      <h3>Issue Details</h3>
	    </div> 
	    <div class="w3-container w3-center">
	    	<div class="w3-half w3-left-align w3-padding">
		    	<h5>Total Copies:  <b>${book.totalNoOfCopies}</b></h5>
		    	<h5>Copies Available:  <b>${book.noOfCopiesAvailable}</b></h5>
		      	<h5>Copies Issued:  <b>${book.noOfCopiesIssues}</b></h5>
		      	
	    	</div>
	    	<div class="w3-half w3-center w3-padding">
	      		<a class="w3-button w3-black" href="${contextPath}/requestToIssue?userId=${userId}&bookId=${book.id}">Request To Issue</a>
	    	</div>
	    </div> 
	  </div>
	</div>
</c:forEach>


