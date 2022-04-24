<%-- Document : home --%> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageInfo" value="Thông tin nhà hàng"/>

<jsp:include page="views/header.jsp" />
<jsp:include page="search_bar" />
<jsp:include page="breadcrumb?pageInfo=${pageInfo }" />
<jsp:include page="views/restaurant_details_section.jsp" />
<jsp:include page="views/related_restaurant_section.jsp" />
<jsp:include page="views/footer.jsp" />
