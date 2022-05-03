<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- Blog Section Begin -->
    <section class="from-blog spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="section-title from-blog__title">
              <h2><a href="blog.jsp" style="color:#000;">BLOG MỚI NHẤT</a></h2>
            </div>
          </div>
        </div>
        <div class="row">
         <c:forEach var="blog" items="${listBlog }">
          <div class="col-lg-4 col-md-4 col-sm-6">
            <div class="blog__item">
              <div class="blog__item__pic">
                <img src="img/blog/${blog.coverImg}" alt="" />
              </div>
              <div class="blog__item__text">
                <ul>
                  <li><i class="fa fa-calendar-o"></i> ${blog.date}</li>
                  <li><i class="fa fa-heart-o"></i> ${blog.likeCount}</li>
                  <li><i class="fa fa-comment-o"></i> ${blog.cmtCount}</li>
                </ul>
                <h5><a href="blog_details.jsp?idBlog=${blog.idBlog }">${blog.title}</a></h5>
                <p>
                  ${blog.subTitle.length()>80?blog.subTitle.substring(0,80):blog.subTitle }... 
                </p>
              </div>
            </div>
          </div>
         </c:forEach>
        </div>
      </div>
    </section>
    <!-- Blog Section End -->