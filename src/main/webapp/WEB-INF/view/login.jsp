<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<title>Oráculo de Futebol - Admin</title>
</head>
<body>
    <div class="bg-full">
        <div class="card-fac p-4 shadow-lg" style="width: 400px;">
            <h3 class="text-center text-white mb-4">Acesso Administrativo</h3>
            <hr class="border-secondary mb-4">
            <form action="validarLogin" method="post">
                <div class="mb-3">
                    <label>Login:</label>
                    <input type="text" name="usuario" class="form-control bg-dark text-white border-secondary" required>
                </div>
                <div class="mb-3">
                    <label>Senha:</label>
                    <input type="password" name="senha" class="form-control bg-dark text-white border-secondary" required>
                </div>
                <button type="submit" class="btn btn-fac">Entrar</button>
            </form>
            <c:if test="${not empty erro}">
                <div class="text-danger mt-2 text-center">${erro}</div>
            </c:if>
        </div>
    </div>
</body>
</html>