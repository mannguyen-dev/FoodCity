<%-- Document : home --%> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageInfo" value="Liên hệ"/>    
<jsp:include page="views/header.jsp" />
<jsp:include page="search_bar" />
<jsp:include page="breadcrumb?pageInfo=${pageInfo }" />
<jsp:include page="views/contact_section.jsp" />
<jsp:include page="views/footer.jsp" />
