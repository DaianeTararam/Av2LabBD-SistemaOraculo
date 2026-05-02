<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Escolha seu Time - Oráculo</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body class="bg-dark text-white">
    <div class="container text-center mt-5">
        <h2>Escolha um time para ver uma curiosidade:</h2>
        <div class="row mt-5">
           <div class="col-3">
		        <a href="<spring:url value='/sortear?idTime=1'/>">
		            <img src="<spring:url value='/img/corinthians.png'/>" alt="Corinthians" width="150" class="img-fluid">
		        </a>
		    </div>
            <div class="col-3">
		        <a href="<spring:url value='/sortear?idTime=2'/>">
		            <img src="<spring:url value='/img/palmeiras.png'/>" alt="Palmeiras" width="150" class="img-fluid">
		        </a>
		    </div>
            <div class="col-3">
		        <a href="<spring:url value='/sortear?idTime=3'/>">
		            <img src="<spring:url value='/img/santos.png'/>" alt="Santos" width="150" class="img-fluid">
		        </a>
		    </div>
		    <div class="col-3">
		        <a href="<spring:url value='/sortear?idTime=4'/>">
		            <img src="<spring:url value='/img/saopaulo.png'/>" alt="São Paulo" width="150" class="img-fluid">
		        </a>
		    </div>
        </div>
    </div>
</body>
</html>