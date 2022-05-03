      <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    <!-- Latest Product Section Begin -->
    <section class="latest-product spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-6 bo__goc">
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
                      <h6>${res.name.length()>26?res.name.substring(0,26):res.name }${res.name.length()>26?'...':''}</h6>
                      <div class="noibat__nhahang">
                      	<fmt:formatNumber var="stars" value="${res.stars/res.reviewCount}" maxFractionDigits="1" minFractionDigits="1"/>
                        <i class="fa fa-star"></i>
                       ${(res.reviewCount!=0?stars :'...')}
                        (${res.reviewCount } đánh giá)
                      </div>
                      <div class="thongtin__danhmuc"><i class="fa fa-bookmark" aria-hidden="true"></i>${latestResCat[i-1].name }</div>
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
          <div class="col-lg-4 col-md-6 bo__goc">
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
                      <h6>${res2.name.length()>26?res2.name.substring(0,26):res2.name }${res2.name.length()>26?'...':''}</h6>
                      <div class="noibat__nhahang">
                      	<fmt:formatNumber var="stars" value="${res2.stars/res2.reviewCount}" maxFractionDigits="1" minFractionDigits="1"/>
                        <i class="fa fa-star"></i>
                         ${(res2.reviewCount!=0?stars :'...')}
                        (${res2.reviewCount } đánh giá)
                      </div>
                      <div class="thongtin__danhmuc"><i class="fa fa-bookmark" aria-hidden="true"></i>${topRateResCat[i-1].name }</div>
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
          <div class="col-lg-4 col-md-6 bo__goc">
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
                      <h6>${res3.name.length()>26?res3.name.substring(0,26):res3.name }${res3.name.length()>26?'...':''}</h6>
                      <div class="noibat__nhahang">
                      	<fmt:formatNumber var="stars" value="${res3.stars/res3.reviewCount}" maxFractionDigits="1" minFractionDigits="1"/>
                        <i class="fa fa-star"></i>
                       	${(res3.reviewCount!=0?stars :'...')}
                        (${res3.reviewCount } đánh giá)
                      </div>
                      <div class="thongtin__danhmuc"><i class="fa fa-bookmark" aria-hidden="true"></i>${topReviewResCat[i-1].name }</div>
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