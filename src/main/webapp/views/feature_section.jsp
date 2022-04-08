  <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <!-- Featured Section Begin -->
    <section class="featured spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="section-title">
              <h2>Featured Product</h2>
            </div>
            <div class="featured__controls">
              <ul>
              <c:set var="i" value="${1 }"/>
                <li class="active" data-filter="*">All</li>
                <c:forEach var="cat" items="${listCat }">
                	<li data-filter=".category_${cat.idCategory }" ${(i>= 9)?"hidden":"" }>${cat.name }</li>
                	<c:set var="i" value="${i+1 }"/>
                </c:forEach>
              </ul>
            </div>
          </div>
        </div>
        <div class="row featured__filter">
        <c:forEach var="res" items="${listRes }">
          <div class="col-lg-3 col-md-4 col-sm-6 mix category_${res.idCategory } fresh-meat">
            <div class="featured__item">
              <div
                class="featured__item__pic set-bg"
                data-setbg="img/restaurant/${res.image }"
              >
                <ul class="featured__item__pic__hover">
                  <li>
                    <a href="#"><i class="fa fa-heart"></i></a>
                  </li>
                  <li>
                    <a href="#"><i class="fa fa-retweet"></i></a>
                  </li>
                  <li>
                    <a href="${res.linkToBuy }"><i class="fa fa-shopping-cart"></i></a>
                  </li>
                </ul>
              </div>
              <div class="featured__item__text">
                <h6><a href="#">${res.name }</a></h6>
                <h5>$30.00</h5>
              </div>
            </div>
          </div>
        </c:forEach>
        </div>
      </div>
    </section>
    <!-- Featured Section End -->