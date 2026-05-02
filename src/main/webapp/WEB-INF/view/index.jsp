<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<title>Oráculo de Futebol</title>
</head>
<body>
    <div class="bg-full">
        <div class="container text-center">
            <div class="card-fac d-inline-block p-5 shadow-lg" style="max-width: 600px; background-color: rgba(30, 30, 30, 0.9);">
                <h1 class="display-4 fw-bold mb-3">Oráculo do Futebol</h1>
                <p class="lead mb-4 text-light">Descubra as melhores curiosidades do seu time!</p>
                
                <div class="d-grid gap-3">
                    <a href="escolha" class="btn btn-fac btn-lg py-3">Consultar o Oráculo</a>
                </div>

                <div class="mt-4">
                    <hr class="border-secondary">
                    <a href="login" class="text-secondary small text-decoration-none hover-link">
                        🔒 Acesso Administrativo
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>