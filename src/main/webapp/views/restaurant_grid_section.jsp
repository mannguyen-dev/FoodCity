<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 
    Document   : breadcrumb
--%>

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container" id="my__product">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>Danh mục</h4>
                            <ul>
                            	<li><a href="restaurant-grid.jsp?category=-1" class="cat__list">Tất cả</a></li>
                            <c:forEach var="cat" items="${listCat }">                            
                                <li><a href="restaurant-grid.jsp?category=${cat.idCategory }" class="cat__list"><i class="fa fa-cutlery" aria-hidden="true"></i>&nbsp ${cat.name}</a></li>
                            </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7 khampha">
                    <div class="hero__search">
              			<div class="hero__search__form">
                			<form action="restaurant-grid.jsp">
                  				<div class="hero__search__categories">
                    				<a>Thông tin</a>
                  				</div>
                  				<input type="text" name="txtSearch" placeholder="Nhà hàng, địa điểm, món ăn,..." value="${param.txtSearch }" />
                  				<select name="category" id="category" class="form-control Category">
    										<option value="">-- Danh mục --</option>
    										<c:forEach var="cat" items="${listCat }">
    										<option value="${cat.idCategory }" ${(param.category == cat.idCategory?'selected=\'selected\'':'') }>${cat.name }</option>
    										</c:forEach>
  								</select>
                  				<div class="khuvuc">
                  					<div class="label hero__search__categories">
                    					<a>Khu vực</a>
                  					</div>
	                  				<div class="khuvuc_inner">
		                  				<select name="ward" id="gender" class="form-control">
    										<option value="">-- Phường/Xã --</option>
    										<c:forEach var="ward" items="${listWard }">
    										<option value="${ward }" ${(param.ward == ward?'selected=\'selected\'':'') }>${ward }</option>
    										</c:forEach>
  										</select>
	                  				</div>
    	              				<div class="khuvuc_inner">
		                  				<select name="district" id="gender" class="form-control">
    										<option value="">-- Quận/Huyện --</option>
    										<c:forEach var="dist" items="${listDist }">
    										<option value="${dist }" ${(param.district == dist?'selected=\'selected\'':'') }>${dist }</option>
    										</c:forEach>
  										</select>
	                  				</div>
        	          				<div class="khuvuc_inner">
		                  				<select name="city" id="gender" class="form-control">
    										<option value="">-- Tỉnh/TP --</option>
    										<c:forEach var="city" items="${listCity }">
    										<option value="${city }" ${(param.city == city?'selected=\'selected\'':'') }>${city }</option>
    										</c:forEach>
  										</select>
	                  				</div>
                  				</div>
                  				<button type="submit" class="site-btn">Tìm kiếm</button>
                			</form>
              			</div>
            		</div>
                    <div class="filter__item">
                        <div class="row">
                            <div class="col-lg-4 col-md-5">
                                <div class="filter__sort">
                                    <span>Sắp xếp theo</span>
                                    <select>
                                        <option value="0">Đúng nhất</option>
                                        <option value="1">Gần tôi</option>
                                        <option value="2">Phổ biến</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="filter__found">
                                    <h6>Tìm thấy <span>${listRes.size()}</span>nhà hàng</h6>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-3">
                                <div class="filter__option">
                                    <span class="icon_grid-2x2"></span>
                                    <span class="icon_ul"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row featured__filter">
                    <c:set var="pageNum" value="1" />
                    <c:set var="itemNum" value="1" />
                    <c:set var="i" value="0" />
                    <c:forEach var="res" items="${listRes }">
                        <div class="col-lg-4 col-md-6 col-sm-6 mix page${pageNum }" ${((pageNum != 1)?'style=\'display: none;\'':'')}>
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
							                 <a href="restaurant-details.jsp?idRes=${res.idRestaurant}">${res.name.length()>26?res.name.substring(0,26):res.name }${res.name.length()>26?'...':''}</a>
					                 </h6>
						             <fmt:formatNumber var="stars" value="${res.stars/res.reviewCount}" maxFractionDigits="1" minFractionDigits="1"/>
						             <div class="sanpham_thongtin">
						             	<span class="hero__search__phone__icon">${(res.reviewCount!=0?stars:'...')}</span>
						             	<div class="thongtin__diachi">
						            	 	<div><i class="fa fa-bookmark" aria-hidden="true"></i>${listCatRes[i].name }</div>
					    	        	 	<div><i class="fa fa-map-marker" aria-hidden="true"></i>${listAdd[i].district }, ${listAdd[i].city }</div>
						             	</div>
						             </div>
					           </div>
                            </div>
                        </div>
                        <c:if test="${itemNum == 9 }">
                        	<c:set var="itemNum" value="0"/>
                        	<c:set var="pageNum" value="${pageNum +1 }"/>
                        </c:if>
                        <c:set var="itemNum" value="${itemNum+1 }"/>
                        <c:set var="i" value="${i+1 }"/>
                    </c:forEach>
                    </div>
                    <div class="product__pagination featured__controls">
                    	<ul>
                    	<c:forEach var="i" step="1" begin="1" end="${listRes.size()/9+1}">
	                        <li ${(i==1?'class=\'active\'':'') }><a href="#my__product" data-filter=".page${i }">${i }</a></li>
                    	</c:forEach>
                    	</ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->
