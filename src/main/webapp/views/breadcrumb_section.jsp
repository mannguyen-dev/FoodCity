<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : breadcrumb
--%>

 <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/restaurant/${(res!=null?res.image:'breadcrumb.jpg') }">
        <div class="container">
            <div class="row breadcrumb__banner">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>${pageInfo }</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.jsp">Trang chủ &nbsp</a>
                            <span>${pageInfo }</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    
