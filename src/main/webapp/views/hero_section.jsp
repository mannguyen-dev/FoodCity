<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- Hero Section Begin -->
    <section class="hero">
      <div class="container">
        <div class="row">
          <div class="col-lg-3">
            <div class="hero__categories">
              <div class="hero__categories__all">
                <i class="fa fa-bars"></i>
                <span>All departments</span>
              </div>
              <ul>
              <c:forEach var="list" items="${listCat }">       
                <li><a href="#">${list.name }</a></li>
              </c:forEach>
              </ul>
            </div>
          </div>
          <div class="col-lg-9">
            <div class="hero__search">
              <div class="hero__search__form">
                <form action="#">
                  <div class="hero__search__categories">
                    All Categories
                    <span class="arrow_carrot-down"></span>
                  </div>
                  <input type="text" placeholder="What do yo u need?" />
                  <button type="submit" class="site-btn">Tìm kiếm</button>
                </form>
              </div>
              <div class="hero__search__phone">
                <div class="hero__search__phone__icon">
                  <i class="fa fa-phone"></i>
                </div>
                <div class="hero__search__phone__text">
                  <h5>+65 11.188.888</h5>
                  <span>support 24/7 time</span>
                </div>
              </div>
            </div>
            <div class="hero__item set-bg banner_image" data-setbg="img/hero/banner2.jpg">
              <div class="hero__text">
                <span>FOOD CITY</span>
                <h2>Thành phố ẩm thực</h2>
                <p>Góc chia sẻ của những người sành ăn!</p>
                <a href="shop-grid.jsp" class="primary-btn">THAM GIA NGAY</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Hero Section End -->
    
    <!-- Categories Section Begin -->
    <section class="categories">
      <div class="container">
        <div class="row">
          <div class="categories__slider owl-carousel">
          <c:forEach var="cat" items="${listCat }">
            <div class="col-lg-3">
              <div
                class="categories__item set-bg"
                data-setbg="img/categories/${cat.image }"
              >
                <h5><a href="#">${cat.name }</a></h5>
              </div>
            </div>
          </c:forEach>
          </div>
        </div>
      </div>
    </section>
    <!-- Categories Section End -->