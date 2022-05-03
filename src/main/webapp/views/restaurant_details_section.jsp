<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large"
                                src="img/album/${listFeatureImg[0].name}" alt="">
                        </div>
                        <div class="product__details__pic__slider owl-carousel">
                        <c:forEach var="featureImg" items="${listFeatureImg }">
                            <img data-imgbigurl="img/album/${featureImg.name }"
                                src="img/album/${featureImg.name }" alt="">
                        </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>${res.name }</h3>
	                    <div class="thongtin__nhahang">
	                        <div class="thongtin__danhgia">
	                        <!-- <div class="product__details__price">  -->
	                        <fmt:formatNumber var="stars" value="${res.stars/res.reviewCount}" maxFractionDigits="1" minFractionDigits="1"/>
	                            <i class="fa fa-star"></i>
	                            <span>${(res.reviewCount!=0?stars:'...')}</span>
	                            (${res.reviewCount } đánh giá)
	                        </div>
	                        <div class="thongtin__cat"><i class="fa fa-bookmark" aria-hidden="true"></i>${cat.name }</div>
	                        <div class=""><i class="fa fa-map-marker" aria-hidden="true"></i>${address }</div>
	                        <fmt:setLocale value="vi-VN"/>
	                        <fmt:formatNumber type="number" var="minPrice" value="${res.minPrice}" maxFractionDigits="0" groupingUsed = "true"/>
	                        <fmt:formatNumber type="number" var="maxPrice" value="${res.maxPrice}" maxFractionDigits="0" groupingUsed = "true"/>
	                        <div class="thongtin__thoigian"><i class="fa fa-clock-o" aria-hidden="true"></i>Giờ mở cửa: <strong>${res.openTime }</strong>-<strong>${res.closeTime }</strong></div>
	                        <div class="thongtin__gia"><i class="fa fa-tags" aria-hidden="true"></i><strong>${minPrice} VNĐ</strong>-<strong>${maxPrice} VNĐ</strong></div>
	                    </div>
                        <c:if test="${res.linkToBuy != null }">
	                        <a href="${res.linkToBuy }" class="primary-btn">GỌI MÓN NGAY!</a>                
                  		</c:if>
                        <ul>
                            <li><b>Chia sẻ</b>
                                <div class="share">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                </div>
                            </li>
                            <li><b>Người đăng</b> <span>${poster.name }</span></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist" id="nav__tabs">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                    aria-selected="true">Giới thiệu</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                                    aria-selected="false">Album</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                    aria-selected="false">Bình luận <span>(${listReview.size() })</span></a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    
                                    <p class="restaurant__description">${res.description}</p>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <div class="container">
                                		<h5 class="album__tittle">Món ăn</h5>
								        <div class="row">
								          <div class="categories__slider owl-carousel">
								          <c:forEach var="img" items="${listFoodImg }">
								            <div class="col-lg-3">
								              <div
								                class="categories__item set-bg"
								                data-setbg="img/album/${img.name }"
								              >
								              </div>
								            </div>
								          </c:forEach>
								          </div>
								        </div>
								    </div>
                                    <div class="container">
								    	<h5 class="album__tittle">Không gian</h5>
								        <div class="row">
								          <div class="categories__slider owl-carousel">
								          <c:forEach var="img" items="${listReviewImg }">
								            <div class="col-lg-3">
								              <div
								                class="categories__item set-bg"
								                data-setbg="img/album/${img.name }"
								              >
								              </div>
								            </div>
								          </c:forEach>
								          </div>
								        </div>
								    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <div class="product__details__tab__desc">
									<div class="row comment__section">
									    <div class="col-md-12 col-sm-12">
									        <div class="comment-wrapper">
									            <div class="panel panel-info">
									                <div class="panel-body">
									                <c:if test="${(empty sessionScope.user ) }">
									                <div >
									                	<i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
									                	<a href="login_page.jsp">Đăng nhập</a> hoặc <a href="signup_page.jsp">Đăng ký</a> để bình luận
									                </div>
									                </c:if>
									                <c:if test="${!(empty sessionScope.user ) }">
										                <form action="post_review?idRes=${res.idRestaurant }">
										                	<div class="panel-heading">
									                    		Bình luận của bạn&nbsp;&nbsp;<i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
									                		</div>
										                	<div class="danh__gia">
										                	<label><i class="fa fa-star-o" aria-hidden="true"></i>&nbsp;&nbsp;Đánh giá: </label>
											                	<select name="stars" id="cars">
																    <option value="10">10 điểm</option>
																    <option value="9">9 điểm</option>
																    <option value="8">8 điểm</option>
																    <option value="7">7 điểm</option>
																    <option value="6">6 điểm</option>
																    <option value="5">5 điểm</option>
																    <option value="4">4 điểm</option>
																    <option value="3">3 điểm</option>
																    <option value="2">2 điểm</option>
																    <option value="1">1 điểm</option>
																</select>
										                	</div>
										                	<div class="form-group">
										                		<input type="text" name="idRes" value="${res.idRestaurant }" hidden/>
										                		<input type="text" name="idUser" value="${sessionScope.user.idUser }" hidden/>
										                		<input required="required" type="text" name="title" class="form-control" placeholder="Tiêu đề..."/>
										                	</div>
										                    <textarea required="required" name="content" class="form-control" placeholder="Viết bình luận của bạn..." rows="3"></textarea>
										                	<br>
										                    <button class="site-btn" type="submit" class="btn btn-info pull-right">Gửi</button>
										                </form>
									                    <br>
										              </c:if>
									                    <div class="clearfix"></div>
									                    <hr>
									                    <div class="">
									                    <!-- <div class="featured__filter"> -->
									                    <c:set var="pageNum" value="1" />
									                    <c:set var="itemNum" value="1" />
									                    <ul class="media-list">
									                    <c:set var="i" value="0"/>
									                    <c:forEach var="review" items="${listReview }">
									                        <li class="media mix page${pageNum }" ${((pageNum != 1)?'style=\'display: none;\'':'')}>
									                            <a href="#" class="pull-left">
									                                <img src="img/user/${listUserReview[i].avatar }" alt="" class="img-circle">
									                            </a>
									                            <div class="media-body">
									                                <span class="text-muted pull-right">
									                                    <small class="text-muted">${review.date }</small>
									                                </span>
									                                <strong class="text-username">${listUserReview[i].name }</strong>
									                                <div class="binhluan_title">
										                                <div><strong>${review.title }</strong></div>
										                                <div><strong><i class="fa fa-star-o" aria-hidden="true"></i>&nbsp; ${review.stars } điểm</strong></div>
									                                </div>
									                                <div>
									                                    ${review.content }
									                                </div>
									                            </div>
									                        </li>
									                        <c:set var="i" value="${i+1}"/>
									                        <c:if test="${itemNum == 8 }">
									                        	<c:set var="itemNum" value="0"/>
									                        	<c:set var="pageNum" value="${pageNum +1 }"/>
									                        </c:if>
									                        <c:set var="itemNum" value="${itemNum+1 }"/>
									                    </c:forEach>
									                    <c:if test="${listReview.size() == 0 }">
									                    	<li class="media">
									                            <div class="media-body">
									                            Hãy là người đầu tiên bình luận cho nơi này! <i class="fa fa-smile-o" aria-hidden="true"></i>
									                            </div>
									                        </li>
									                    </c:if>
									                    </ul>
									                    </div>
									                    <div class="product__pagination featured__controls">
									                    	<ul>
									                    	<c:forEach var="i" step="1" begin="1" end="${listReview.size()/8+1}">
										                        <li ${(i==1?'class=\'active\'':'') }><a href="#nav__tabs" data-filter=".page${i }">${i }</a></li>
									                    	</c:forEach>
									                    	</ul>
									                    </div>
									                </div>
									            </div>
									        </div>
									    </div>
									</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Details Section End -->