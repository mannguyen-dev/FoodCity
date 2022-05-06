   <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- Blog Details Section Begin -->
    <section class="blog-details spad__top">
    	<div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-5 order-md-1 order-2">
                    <div class="blog__sidebar">
                        <div class="blog__sidebar__search">
                            <form action="blog.jsp">
                                <input type="text" name="txtSearch" placeholder="Tìm kiếm blog...">
                                <button type="submit"><span class="icon_search"></span></button>
                            </form>
                        </div>
                        <div class="blog__sidebar__item">
                            <h4>Danh mục</h4>
                            <ul>
                                <li><a href="blog.jsp">Tất cả</a></li>
                                <c:forEach var="i" begin="0" end="${listCatAndAmt.size()-1 }" step="3">
                                <li><a href="blog.jsp?idCat=${listCatAndAmt[i+2] }">${listCatAndAmt[i] } (${listCatAndAmt[i+1] })</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="blog__sidebar__item">
                            <h4>Blog nổi bật</h4>
                            <div class="blog__sidebar__recent">
                            	<c:forEach var="out" items="${listOutStanding }">
                                <a href="blog_details.jsp?idBlog=${out.idBlog }" class="blog__sidebar__recent__item">
                                    <div class="blog__sidebar__recent__item__pic">
                                        <img src="img/blog/${out.coverImg}" alt="">
                                    </div>
                                    <div class="blog__sidebar__recent__item__text">
                                        <h6>${out.title.length()>40?out.title.substring(0,40):out.title }...</h6>
                                        <span>${out.date }</span>
                                    </div>
                                </a>
                            	</c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8 col-md-7 order-md-1 order-1">
                	<div class="blog__details__hero__text">
                        <h2>${blog.title }</h2>
                        <ul>
                            <li>Đăng bởi: ${poster.name }</li>
                            <li>${blog.date }</li>
                            <li>${blog.cmtCount } bình luận (${blog.likeCount} lượt thích)</li>
                        </ul>
                    </div>
                    <div class="blog__details__text">
                    	<div class="chude__blog"><strong>${blog.subTitle }</strong></div>
                    	<div class="noidung__blog">${blog.content }</div>
                    </div>
                    <div class="blog__details__content">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="blog__details__author">
                                    <div class="blog__details__author__pic">
                                        <img src="img/user/${poster.avatar }" alt="">
                                    </div>
                                    <div class="blog__details__author__text">
                                        <h6>${poster.name }</h6>
                                        <span>${posterRole.name}</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="blog__details__widget">
                                    <ul>
                                        <li><span>Danh mục:</span> ${thisCat.name }</li>
                                        <li><span>Tags:</span> All, Trending, Cooking, Healthy Food</li>
                                    </ul>
                                    <div class="blog__details__social">
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                        <a href="#"><i class="fa fa-google-plus"></i></a>
                                        <a href="#"><i class="fa fa-linkedin"></i></a>
                                        <a href="#"><i class="fa fa-envelope"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
					    <div class="col-md-12 col-sm-12">
					        <div class="comment-wrapper" id="comment_id">
					            <div class="panel panel-info">
					                <div class="panel-body">
					                <c:if test="${(empty sessionScope.user ) }">
					                <div >
					                	<i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
					                	<a href="login_page.jsp">Đăng nhập</a> hoặc <a href="signup_page.jsp">Đăng ký</a> để bình luận
					                </div>
					                </c:if>
					                <c:if test="${!(empty sessionScope.user ) }">
						                <form action="post_blog_comment">
						                	<div class="panel-heading">
					                    		Bình luận của bạn&nbsp;&nbsp;<i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
					                		</div>
						                	<div class="danh__gia">
						                		<label>Yêu thích bài viết: &nbsp;</label>
						                		<input id="heart" type="checkbox" name="like"/>
												<label for="heart">❤ +1</label>
						                	</div>
						                	<div class="form-group">
						                		<input type="text" name="idBlog" value="${blog.idBlog }" hidden/>
						                		<input type="text" name="idUser" value="${sessionScope.user.idUser }" hidden/>
						                    	<textarea required="required" name="content" class="form-control" placeholder="Viết bình luận của bạn..." rows="3"></textarea>
						                	</div>
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
					                                <strong class="text-username">${listUserReview[i].name }&nbsp;</strong>
					                                <div class="binhluan_title">
							                            <span class="comment__like__icon">
							                              <c:if test="${ review.title=='like'}">
							                            	<i class="fa fa-heart" aria-hidden="true"></i>
							                              </c:if>
							                              <c:if test="${ review.title!='like'}">
							                                <i class="fa fa-heart-o" aria-hidden="true"></i>
							                              </c:if>						                            
							                            </span>
						                                <!-- <div><strong>❤ ${review.title=="like"?"Thích":"Không thích" }</strong></div>  -->
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
					                            Hãy là người đầu tiên bình luận cho bài viết này! <i class="fa fa-smile-o" aria-hidden="true"></i>
					                            </div>
					                        </li>
					                    </c:if>
					                    </ul>
					                    </div>
					                    <div class="product__pagination featured__controls">
					                    	<ul>
					                    	<c:forEach var="i" step="1" begin="1" end="${listReview.size()/8+1}">
						                        <li ${(i==1?'class=\'active\'':'') }><a href="#comment_id" data-filter=".page${i }">${i }</a></li>
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
    </section>
    <!-- Blog Details Section End -->

    <!-- Related Blog Section Begin -->
    <section class="related-blog spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title related-blog-title">
                        <h2>Có thể bạn quan tâm</h2>
                    </div>
                </div>
            </div>
            <div class="row">
              <c:forEach var="blogNew" items="${blogNews }">
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic">
                            <img src="img/blog/${blogNew.coverImg }" alt="">
                        </div>
                        <div class="blog__item__text">
                            <ul>
                                <li><i class="fa fa-calendar-o"></i> ${blogNew.date }</li>
                                <li><i class="fa fa-heart-o"></i> ${blogNew.likeCount}</li>
                                <li><i class="fa fa-comment-o"></i> ${blogNew.cmtCount}</li>
                            </ul>
                            <h5><a href="blog_details.jsp?idBlog=${blogNew.idBlog }">${blogNew.title }</a></h5>
                            <p>${blogNew.subTitle.length()>80?blogNew.subTitle.substring(0,80):blogNew.subTitle }...  </p>
                        </div>
                    </div>
                </div>
              </c:forEach>
            </div>
        </div>
    </section>
    <!-- Related Blog Section End -->