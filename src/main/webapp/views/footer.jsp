<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- 
    Document   : footer
--%>

   <!-- Footer Section Begin -->
    <footer class="footer spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="footer__about">
              <div class="footer__about__logo">
                <a href="./index.jsp"><img src="img/logo.svg" alt="" /></a>
              </div>
              <ul>
              	<li>Công Ty Cổ Phần FoodCity</li>
              	<li>244 Cống Quỳnh, P.Phạm Ngũ Lão, Q1, TP.HCM</li>
                <li>Điện thoại: 028 1111 8888</li>
                <li>Email: hello@foodcity.com</li>
              </ul>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
            <div class="footer__widget">
              <h6>Liên kết hữu ích</h6>
              <ul>
                <li><a href="#">Về chúng tôi</a></li>
                <li><a href="#">Trợ giúp</a></li>
                <li><a href="#">Việc làm</a></li>
                <li><a href="#">Góp ý</a></li>
                <li><a href="#">Chính sách bảo mật</a></li>
              </ul>
              <ul>
                <li><a href="#">Ứng dụng mobile</a></li>
                <li><a href="#">Dịch vụ khác</a></li>
                <li><a href="#">Các dự án</a></li>
                <li><a href="#">Liên hệ</a></li>
                <li><a href="#">Nhà đầu tư</a></li>
              </ul>
            </div>
          </div>
          <div class="col-lg-4 col-md-12">
            <div class="footer__widget">
              <h6>Đăng ký nhận thông tin khuyến mãi</h6>
              <p>
                Để có cơ hội nhận các ưu đãi đặc biệt sớm nhất.
              </p>
              <form action="email_sub">
                <input type="email" name="email" required="required" placeholder="Nhập email của bạn" />
                <button type="submit" class="site-btn">Đăng ký</button>
              </form>
              <div class="footer__widget__social">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-instagram"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-pinterest"></i></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
     <script src="js/jquery-ui.min.js"></script>  
    <script src="js/jquery.slicknav.js"></script> 
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>