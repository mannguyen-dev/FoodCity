<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Related Product Section Begin -->
    <section class="related-product">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title related__product__title">
                        <h2>Cùng danh mục</h2>
                    </div>
                </div>
            </div>
            <div class="row">
            <c:set var="i" value="0"/>
            <c:forEach var="res" items="${listRes }">
                <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="img/restaurant/${res.image }">
                            <ul class="product__item__pic__hover">
                                <li><a href=${(empty sessionScope.user )?'login_page.jsp':('restaurant-details.jsp?idRes=') }${(empty sessionScope.user )?'':res.idRestaurant }><i class="fa fa-heart"></i></a></li>
                                <li><a href=${(empty sessionScope.user )?'login_page.jsp':('restaurant-details.jsp?idRes=') }${(empty sessionScope.user )?'':res.idRestaurant }><i class="fa fa-retweet"></i></a></li>
                                <c:if test="${res.linkToBuy != null }">
                                <li><a href="${res.linkToBuy}"><i class="fa fa-shopping-cart"></i></a></li>
          						</c:if>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6 class="sanpham_title">
                            <fmt:formatNumber var="stars" value="${res.stars/res.reviewCount}" maxFractionDigits="1" minFractionDigits="1"/>
                            	<span class="hero__search__phone__icon">${(res.reviewCount!=0?stars:'...')}</span>
                            	<a href="restaurant-details.jsp?idRes=${res.idRestaurant}">${res.name}</a>
                            </h6>
                            <h5>$30.00</h5>
                            <p style="font-size: 12px"><i class="fa fa-map-marker" aria-hidden="true"></i>${listAdd[i] }</p>
                        </div>
                    </div>
                </div>
                <c:set var="i" value="${i+1 }"/>
            </c:forEach>
          </div>
        </div>
    </section>
    <!-- Related Product Section End -->