<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

  <section class="signup_section">

  <div class="container d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('img/bg_1.jpg');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-11 py-5">
            <h3>Đăng ký</h3>
            <p style="color: red">${warning }</p>
            <p class="mb-4" style="color: #495057">Trở thành thành viên của Food City để khám phá thế giới ẩm thực và nhận nhiều ưu đãi hấp dẫn!</p>
            <form action="signup_page.jsp" method="post" enctype="multipart/form-data">
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group first">
                    <label for="fname">Tên đăng nhập <span style="color: red">*</span></label>
                    <input type="text" class="form-control" placeholder="Vd: Nguyễn Văn A" id="fname" name="fname" required="required" value="${param.fname }">
                  </div>    
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="birthday">Ngày sinh</label>
                    <input type="text" class="form-control" placeholder="Vd: 01/01/2000" id="birthday" name="birthday" value="${param.birthday }">
                  </div>    
                </div>
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="avatar">Ảnh đại diện</label>
  					<input type="file" id="avatar" name="file" alt="Ảnh đại diện" class="upload-btn form-control" value="${param.file }">
                  </div>    
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group first">
                    <label for="email">Email <span style="color: red">*</span></label>
                    <input type="email" class="form-control" placeholder="Vd: nguyenvana@gmail.com" id="email" name="email" required="required" value="${param.email }">
                  </div>    
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group first">
                    <label for="phone">Số điện thoại <span style="color: red">*</span></label>
                    <input type="text" class="form-control" placeholder="Vd: 0900 000 000" id="phone" name="phone" required="required" value="${param.phone }">
                  </div>    
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="phone">Bạn là một <span style="color: red">*</span></label>
                    <select name="role" id="role" class="form-control">
    					<option value="customer" ${(param.role == "customer"?'selected=\'selected\'':'') }>Thực khách</option>
    					<option value="manager" ${(param.role == "manager"?'selected=\'selected\'':'') }>Quản lý nhà hàng</option>
  					</select>
                  </div>    
                </div>
                <div class="col-md-6">
                  <div class="form-group first">
                    <label for="gender">Giới tính</label>
                    <select name="gender" id="gender" class="form-control">
    					<option value="nam" ${(param.gender == "nam"?'selected=\'selected\'':'') }>Nam</option>
    					<option value="nu" ${(param.gender == "nu"?'selected=\'selected\'':'') }>Nữ</option>
  					</select>
                  </div>    
                </div>
              </div><br>
              <div class="row">
                <div class="col-md-6">
              
                  <div class="form-group last mb-3">
                    <label for="password">Mật khẩu <span style="color: red">*</span></label>
                    <input type="password" class="form-control" placeholder="Mật khẩu của bạn" id="password" name="password" required="required">
                  </div>
                </div>
                <div class="col-md-6">
              
                  <div class="form-group last mb-3">
                    <label for="re-password">Nhập lại mật khẩu <span style="color: red">*</span></label>
                    <input type="password" class="form-control" placeholder="Mật khẩu của bạn" id="re-password" name="re-password" required="required">
                  </div>
                </div>
              </div>
              
              <div class="d-flex mb-5 mt-4 align-items-center">
                <div class="d-flex align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Việc tạo tài khoản là bạn đã đồng ý với các <a href="#">Điều khoản, điều kiện</a> và <a href="#">Chính sách bảo mật</a> của chúng tôi.</span>
                  <input type="checkbox" name="term" value="yes"/>
                  <div class="control__indicator"></div>
                </label>
              </div>
              </div>
			  
              <input type="submit" value="Đăng ký" class="btn btn-block btn-primary">

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