<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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