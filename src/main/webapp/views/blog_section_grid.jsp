     <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- Blog Section Begin -->
    <section class="blog spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-5">
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
                <div class="col-lg-8 col-md-7">
                    <div class="row">
                      <c:if test="${!empty param.txtSearch }">
                    	<div class="col-lg-12 col-md-12 col-sm-12 ketqua__tim">
                    		<div>Kết quả tìm "${param.txtSearch }": ${listBlog.size() } bài viết</div>
                    	</div>
                      </c:if>
                       <c:if test="${!empty param.idCat }">
                    	<div class="col-lg-12 col-md-12 col-sm-12 ketqua__tim">
                    		<div>Danh mục "${category.name }": ${listBlog.size() } bài viết</div>
                    	</div>
                      </c:if>
                      <c:if test="${listBlog.size() != 0 }">
                        <c:forEach var="blog" items="${listBlog }">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <img src="img/blog/${blog.coverImg }" alt="">
                                </div>
                                <div class="blog__item__text">
                                    <ul>
                                        <li><i class="fa fa-calendar-o"></i> ${blog.date }</li>
                                        <li><i class="fa fa-heart-o"></i> ${blog.likeCount}</li>
                                        <li><i class="fa fa-comment-o"></i> ${blog.cmtCount }</li>
                                    </ul>
                                    <h5><a href="blog_details.jsp?idBlog=${blog.idBlog }">${blog.title }</a></h5>
                                    <p>${blog.subTitle.length()>130?blog.subTitle.substring(0,130):blog.subTitle }... </p>
                                    <a href="blog_details.jsp?idBlog=${blog.idBlog }" class="blog__btn">ĐỌC THÊM <span class="arrow_right"></span></a>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                        <div class="col-lg-12">
                            <div class="product__pagination blog__pagination">
                            	<a href="blog.jsp?page=${(page-1>0)?page-1:page}${(!empty param.idCat?'&idCat=':'')}${(!empty param.idCat?param.idCat:'')}${(!empty param.txtSearch?'&txtSearch=':'')}${(!empty param.txtSearch?param.txtSearch:'')}"><i class="fa fa-long-arrow-left"></i></a>
                            <c:forEach var="i" begin="1" end="${totalPage}">
                                <a href="blog.jsp?page=${i}${(!empty param.idCat?'&idCat=':'')}${(!empty param.idCat?param.idCat:'')}${(!empty param.txtSearch?'&txtSearch=':'')}${(!empty param.txtSearch?param.txtSearch:'')}" ${((param.page== null && i==1)||param.page==i?'style=\'background-color:#e67e22;color:#fff;border-color:#e67e22;\'':'') }>${i }</a>
                            </c:forEach>
                                <a href="blog.jsp?page=${(page+1<=totalPage)?page+1:page}${(!empty param.idCat?'&idCat=':'')}${(!empty param.idCat?param.idCat:'')}${(!empty param.txtSearch?'&txtSearch=':'')}${(!empty param.txtSearch?param.txtSearch:'')}"><i class="fa fa-long-arrow-right"></i></a>
                            </div>
                        </div>
                      </c:if>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Section End -->