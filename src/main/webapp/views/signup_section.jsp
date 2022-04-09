<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

  <section class="signup_section">

  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('img/bg_1.jpg');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7 py-5">
            <h3>Đăng ký</h3>
            <p class="mb-4" style="color: #495057">Trở thành thành viên của Food City để khám phá thế giới ẩm thực và nhận nhiều ưu đãi hấp dẫn!</p>
            <form action="#" method="post">
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group first">
                    <label for="fname">Tên đăng nhập</label>
                    <input type="text" class="form-control" placeholder="e.g. Nguyên Trịnh" id="fname">
                  </div>    
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="birthday">Ngày sinh</label>
                    <input type="text" class="form-control" placeholder="e.g. 07/05/1995" id="birthday">
                  </div>    
                </div>
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="avatar">Ảnh đại diện</label>
  					<input type="file" id="avatar" name="avatar" alt="Ảnh đại diện" class="upload-btn form-control">
                  </div>    
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group first">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" placeholder="e.g. nguyentrinh@gmail.com" id="email">
                  </div>    
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group first">
                    <label for="phone">Số điện thoại</label>
                    <input type="text" class="form-control" placeholder="+00 0000 000 000" id="phone">
                  </div>    
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="phone">Bạn là một</label>
                    <select name="role" id="role" class="form-control">
    					<option value="customer">Thực khách</option>
    					<option value="manager">Quản lý</option>
  					</select>
                  </div>    
                </div>
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="gender">Giới tính</label>
                    <select name="gender" id="gender" class="form-control">
    					<option value="nam">Nam</option>
    					<option value="nu">Nữ</option>
  					</select>
                  </div>    
                </div>
              </div><br>
              <div class="row">
                <div class="col-md-6">
              
                  <div class="form-group last mb-3">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" placeholder="Your Password" id="password">
                  </div>
                </div>
                <div class="col-md-6">
              
                  <div class="form-group last mb-3">
                    <label for="re-password">Re-type Password</label>
                    <input type="password" class="form-control" placeholder="Your Password" id="re-password">
                  </div>
                </div>
              </div>
              
              <div class="d-flex mb-5 mt-4 align-items-center">
                <div class="d-flex align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Creating an account means you're okay with our <a href="#">Terms and Conditions</a> and our <a href="#">Privacy Policy</a>.</span>
                  <input type="checkbox" checked="checked"/>
                  <div class="control__indicator"></div>
                </label>
              </div>
              </div>

              <input type="submit" value="Register" class="btn px-5 btn-primary">

            </form>
          </div>
        </div>
      </div>
    </div>
    
    

    <script src="js/jquery2-3.3.1.min.js"></script>
    <script src="js/bootstrap2.min.js"></script>
    <script src="js/main2.js"></script>
    <script src="js/owl2.carousel.min.js"></script>
    <script src="js/popper2.min.js"></script>
</section>