<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
  

  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('img/bg_1.jpg');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3>Đăng nhập</h3>
            <p class="mb-4">Chào mửng bạn đến với <strong>Food City</strong> - Thế giới ẩm thực dành cho người sành ăn!</p>
            <p style="color:blue">${mess2}<p>
            <c:if test="${empty sessionScope.user }">
            <form action="login_page.jsp" method="post">
              <div class="form-group first">
                <label for="username">Email/Số điện thoại</label>
                <input type="text" class="form-control" placeholder="email_cua_ban@gmail.com" name="email" id="username">
              </div>
              <div class="form-group last mb-3">
                <label for="password">Mật khẩu</label>
                <input type="password" class="form-control" placeholder="Nhập mật khẩu" name="password" id="password">
              </div>
              
              <p style="color:red">${mess}<p>
              
              
              <div class="d-flex mb-5 align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                  <input type="checkbox" checked="checked"/>
                  <div class="control__indicator"></div>
                </label>
                <span class="ml-auto"><a href="login_page_forgot_pass.jsp" class="forgot-pass">Forgot Password</a></span> 
              </div>

              <input type="submit" value="Đăng nhập" class="btn btn-block btn-primary">

            </form>
            </c:if>
            <p style="color:blue">${mess1}<p>
          </div>
        </div>
      </div>
    </div>

    
  </div>
    
    <script src="js/jquery2-3.3.1.min.js"></script>
    <script src="js/bootstrap2.min.js"></script>
    <script src="js/main2.js"></script>
    <script src="js/owl2.carousel.min.js"></script>
    <script src="js/popper2.min.js"></script>


</html>