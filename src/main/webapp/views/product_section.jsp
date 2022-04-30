      <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <!-- Latest Product Section Begin -->
    <section class="latest-product spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-6">
            <div class="latest-product__text">
              <h4>Nổi bật gần đây</h4>
              <div class="latest-product__slider owl-carousel">
                <div class="latest-prdouct__slider__item">
                <c:set var="i" value="${1 }" />
                <c:forEach var="res" items="${latestRes }">
                  <a href="restaurant-details.jsp?idRes=${res.idRestaurant}" class="latest-product__item">
                    <div class="latest-product__item__pic">
                      <img src="img/restaurant/${res.image }" alt="${res.name }" />
                    </div>
                    <div class="latest-product__item__text">
                      <h6>${res.name }</h6>
                      <span>$30.00</span>
                    </div>
                  </a>
                  <c:if test="${i==3 }">
                   </div>
                <div class="latest-prdouct__slider__item">
                  </c:if>
                  <c:set var="i" value="${i+1 }"/>
                </c:forEach>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6">
            <div class="latest-product__text">
              <h4>Đánh giá cao nhất</h4>
              <div class="latest-product__slider owl-carousel">
                <div class="latest-prdouct__slider__item">
                <c:set var="i" value="${1 }" />
                <c:forEach var="res2" items="${topRateRes }">
                  <a href="restaurant-details.jsp?idRes=${res2.idRestaurant}" class="latest-product__item">
                    <div class="latest-product__item__pic">
                      <img src="img/restaurant/${res2.image }" alt="${res2.name }" />
                    </div>
                    <div class="latest-product__item__text">
                      <h6>${res2.name }</h6>
                      <c:set var="star" value="${res2.stars/res2.reviewCount }"/>
                      <span>Stars: ${star}</span>
                    </div>
                  </a>
                  <c:if test="${i==3 }">
                   </div>
                <div class="latest-prdouct__slider__item">
                  </c:if>
                  <c:set var="i" value="${i+1 }"/>
                </c:forEach>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6">
            <div class="latest-product__text">
              <h4>Quan tâm nhiều nhất</h4>
              <div class="latest-product__slider owl-carousel">
                <div class="latest-prdouct__slider__item">
                  <c:set var="i" value="${1 }" />
                <c:forEach var="res3" items="${topReviewRes }">
                  <a href="restaurant-details.jsp?idRes=${res3.idRestaurant}" class="latest-product__item">
                    <div class="latest-product__item__pic">
                      <img src="img/restaurant/${res3.image }" alt="${res3.name }" />
                    </div>
                    <div class="latest-product__item__text">
                      <h6>${res3.name }</h6>
                      <span>Reviews: ${res3.reviewCount}</span>
                    </div>
                  </a>
                  <c:if test="${i==3 }">
                   </div>
                <div class="latest-prdouct__slider__item">
                  </c:if>
                  <c:set var="i" value="${i+1 }"/>
                </c:forEach>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Latest Product Section End -->