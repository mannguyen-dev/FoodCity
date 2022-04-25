<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>Danh mục</span>
                        </div>
                        <ul>
                        	<c:forEach var="cat" items="${listCat }">       
                			<li><a href="restaurant-grid.jsp?category=${cat.idCategory }"  class="cat__home"><i class="fa fa-cutlery" aria-hidden="true"></i>&nbsp ${cat.name }</a></li>
              				</c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
	            <div class="hero__search">
	              <div class="hero__search__form">
	                <form action="restaurant-grid.jsp">
	                  <div class="hero__search__categories">
	                    <i class="fa fa-filter" aria-hidden="true"></i>
	                    <a href="restaurant-grid.jsp?category=-1">&nbspNÂNG CAO</a>
	                    
	                  </div>
	                  <input type="text" placeholder="Địa điểm, món ăn, nhà hàng,..." name="txtSearch"/>
	                  <button type="submit" class="site-btn" >Tìm kiếm</button>
	                </form>
	              </div>
	              <div class="hero__search__phone">
	                <div class="hero__search__phone__icon">
	                  <a href="tel:02811118888"><i class="fa fa-phone"></i></a>
	                </div>
	                <div class="hero__search__phone__text">
	                  <h5><a href="tel:02811118888" style="color: #495057">028 1111 8888</a></h5>
	                  <span>Điện thoại hỗ trợ 24/7</span>
	                </div>
	              </div>
	            </div>
         	 </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->