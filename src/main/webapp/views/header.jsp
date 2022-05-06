<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : header
--%>

<!DOCTYPE html>
<html lang="zxx">
  <head>
    <meta charset="UTF-8" />
    <meta name="description" content="Ogani Restaurant" />
    <meta name="keywords" content="Ogani, unica, creative, html" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>FoodCity | Thành phố ẩm thực</title>
    <link rel="icon" href="img/favicon.png" />
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Barlow+Condensed:ital,wght@0,200;0,300;0,400;0,600;0,900;1,800&display=swap" rel="stylesheet">
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;600;900&family=Roboto:wght@100;300;400;500;700;900&family=Yanone+Kaffeesatz:wght@200;300;400;600;700&display=swap"
      rel="stylesheet"
    />

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />  
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css" />
    <link rel="stylesheet" href="css/nice-select.css" type="text/css" />
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css" />
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css" />
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css" />
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <link rel="stylesheet" href="css/bootstrap2.min.css" type="text/css" /> 
    <link rel="stylesheet" href="css/owl2.carousel.min.css" type="text/css" />  
    <link rel="stylesheet" href="css/bootstrap2.min.css.map" type="text/css" /> 
    <link rel="stylesheet" href="css/style2.css" type="text/css" />   
    
    
  </head>

  <body>
    <!-- Page Preloder 
    <div id="preloder">
      <div class="loader"></div>
    </div>-->
    

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
      <div class="humberger__menu__logo">
        <a href="#"><img src="img/logo.svg" alt=""/></a>
      </div>
      <div class="humberger__menu__cart menu__anhdaidien">
      <c:if test="${!empty sessionScope.user }">
        <div class="header__avatar">
            <a href="#"><img src="img/user/${sessionScope.user.avatar }" alt="user avatar"></a>
        </div>
        <div class="header__cart__price"><span>${sessionScope.user.name }</span></div>
        <ul>
          <li>
            <a href="#"><i class="fa fa-gift"></i> <span>1</span></a>
          </li>
          <li>
            <a href="#"><i class="fa fa-inbox"></i> <span>3</span></a>
          </li>
        </ul>
      </c:if>
      </div>
      <div class="humberger__menu__widget menu_dangnhap">
	      <div class="header__top__right__language">
	         <img src="img/language.png" alt="" />
	         <div>Vietnam
		         <span class="arrow_carrot-down"></span>
	         </div>
	         <ul>
	            <li><a href="#">Vietnam</a></li>
	            <li><a href="#">English</a></li>
	         </ul>
	      </div>
	      <div class="header__top__right__auth">
	      <c:if test="${empty sessionScope.user }">
	         <a href="login_page.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i></a>
	         <a href="signup_page.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i></a>
	      </c:if>
	      <c:if test="${not empty sessionScope.user }">
	         <a href="logout"><i class="fa fa-sign-out" aria-hidden="true"></i></a>
	      </c:if>
	      </div>
      </div>
      <nav class="humberger__menu__nav mobile-menu">
        <ul>
          <li class="active"><a href="./index.jsp">Trang chủ</a></li>
          <li><a href="./restaurant-grid.jsp?category=-1">Khám phá</a></li>
          <li><a href="./blog.jsp">Blog</a></li>
          <li>
          <c:if test="${not empty sessionScope.user && sessionScope.user.idRole <= 2 }">
            <a href="#">Nhà hàng</a>
            <ul class="header__menu__dropdown">
              <li><a style="font-weight: normal;" href="./restaurant-details.jsp?idRes=1"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;Thông tin</a></li>
              <li><a style="font-weight: normal;" href="#"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;Thêm mới</a></li>
              <li><a style="font-weight: normal;" href="#"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;Chỉnh sửa</a></li>
              <li><a style="font-weight: normal;" href="./blog-details.jsp?idBlog=1"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;Blog của tôi</a></li>
            </ul>
       	  </c:if>
          </li>
          <li><a href="./contact.jsp">Liên hệ</a></li>
        </ul>
      </nav>
      <div id="mobile-menu-wrap"></div>
      <div class="header__top__right__social">
        <a href="#"><i class="fa fa-facebook"></i></a>
        <a href="#"><i class="fa fa-twitter"></i></a>
        <a href="#"><i class="fa fa-linkedin"></i></a>
        <a href="#"><i class="fa fa-pinterest-p"></i></a>
      </div>
      <div class="humberger__menu__contact">
        <ul>
         <c:if test="${not empty sessionScope.user}">
         	<li><i class="fa fa-envelope"></i> ${sessionScope.user.email }</li>
         	<li>Xin chào, ${sessionScope.user.name }!</li>
         </c:if>
         <c:if test="${empty sessionScope.user }">
        	<li><i class="fa fa-envelope"></i> Chào mừng bạn đến với FoodCity</li>
        	<li>Đăng nhập để nhận nhiều ưu đãi hấp dẫn</li>
        </c:if>
        </ul>
      </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
      <div class="header__top">
        <div class="container">
          <div class="row">
            <div class="col-lg-6 col-md-6">
              <div class="header__top__left">
                <ul>
                <c:if test="${not empty sessionScope.user}">
                  <li><i class="fa fa-envelope"></i> ${sessionScope.user.email }</li>
                  <li>Xin chào, <strong>${sessionScope.user.name }</strong>!</li>
                </c:if>
                <c:if test="${empty sessionScope.user }">
                  <li><i class="fa fa-envelope"></i> Chào mừng bạn đến với FoodCity</li>
                  <li>Đăng nhập để nhận nhiều ưu đãi hấp dẫn</li>
                </c:if>
                </ul>
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="header__top__right">
                <div class="header__top__right__social">
                  <a href="#"><i class="fa fa-facebook"></i></a>
                  <a href="#"><i class="fa fa-twitter"></i></a>
                  <a href="#"><i class="fa fa-linkedin"></i></a>
                  <a href="#"><i class="fa fa-pinterest-p"></i></a>
                </div>
                <div class="header__top__right__language">
                  <img
                    src="img/language.png"
                    alt="vietnam"
                  />
                  <div>Việt Nam</div>
                  <span class="arrow_carrot-down"></span>
                  <ul>
                    <li><a href="#">Vietnam</a></li>
                    <li><a href="#">English</a></li>
                  </ul>
                </div>
                <c:if test="${empty sessionScope.user }">
                <div class="header__top__right__auth">
                	<a href="login_page.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i> Đăng nhập</a>
               
                	<a href="signup_page.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i> Đăng ký</a>
                </div>
                </c:if>
                <c:if test="${not empty sessionScope.user }">
                <div class="header__top__right__auth">
                	<a href="logout"><i class="fa fa-sign-out" aria-hidden="true"></i> Đăng xuất</a>
                </div>
                </c:if>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-lg-3">
            <div class="header__logo">
              <a href="./index.jsp"><img src="img/logo.svg" alt="logo.png" /></a>
            </div>
          </div>
          <div class="col-lg-5">
            <nav class="header__menu">
              <ul>
                <li class="active"><a href="./index.jsp">Trang chủ</a></li>
                <li><a href="./restaurant-grid.jsp?category=-1">Khám phá</a></li>
                <li><a href="./blog.jsp">Blog</a></li>
                <c:if test="${not empty sessionScope.user && sessionScope.user.idRole <= 2 }">
                <li>
                  <a href="#">Nhà hàng</a>
                  <ul class="header__menu__dropdown">
                    <li><a href="./restaurant-details.jsp?idRes=1">Thông tin</a></li>
                    <li><a href="#">Thêm mới</a></li>
                    <li><a href="#">Chỉnh sửa</a></li>
                    <li><a href="./blog_details.jsp?idBlog=1">Blog của tôi</a></li>
                  </ul>
                </li>
                </c:if>
          		<li><a href="./contact.jsp">Liên hệ</a></li>

              </ul>
            </nav>
          </div>
          <div class="col-lg-4">
          <c:if test="${not empty sessionScope.user}">
            <div class="header__cart">
              <ul>
                <li>
                  <a href="#"><i class="fa fa-gift" aria-hidden="true"></i></i> <span>1</span></a>
                </li>
                <li>
                  <a href="#"
                    ><i class="fa fa-inbox" aria-hidden="true"></i><span>3</span></a
                  >
                </li>
              </ul>
              <div class="header__cart__name"><span>${sessionScope.user.name }</span></div>
              <div class="header__avatar">
              	<a href="#"><img src="img/user/${sessionScope.user.avatar }" alt="user avatar"></a>
              </div>
            </div>
          </c:if>
          </div>
        </div>
        <div class="humberger__open">
          <i class="fa fa-bars"></i>
        </div>
      </div>
    </header>
    <!-- Header Section End -->
