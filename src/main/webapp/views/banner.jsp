   <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
   <!-- Banner Begin -->
    <div class="banner">
      <div class="container">
        <div class="row">
			<div class="Uudai-title">
              <h2>ƯU ĐÃI CHO BẠN &nbsp;&nbsp;<i class="fa fa-flag" style="color: #e67e22;" aria-hidden="true"></i></h2>
            </div>
	        <div class="latest-product__slider owl-carousel">
	        <c:forEach var="ad" items="${listAd }">
	          <div class="col-lg-12 col-md-12 col-sm-12">
	            <div class="banner__pic"> 
	            	<a href="restaurant-details.jsp?idRes=${ad.idRestaurant }">
	              		<img src="img/advertisement/${ad.image }" alt="" />
	            	</a>
	            </div>
	          </div>
	        </c:forEach>
	        </div>

        </div>
      </div>
    </div>
    <!-- Banner End -->