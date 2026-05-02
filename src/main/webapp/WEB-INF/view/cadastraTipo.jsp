<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<title>Gerenciar Mensagens | Oráculo</title>
</head>
<body class="bg-dark text-white">
    <div class="container mt-5">
        <div class="card-fac">
            <h2 class="text-center mb-4">Gerenciar Oráculo</h2>
            <hr class="border-secondary mb-4">
            
            <h5 class="mb-3">Cadastrar Nova Curiosidade</h5>
            <form action="${pageContext.request.contextPath}/admin/salvarMensagem" method="post">
                <div class="row g-3">
                    <div class="col-md-7">
                        <label class="form-label">Mensagem da Curiosidade</label>
                        <input type="text" name="texto" class="form-control" placeholder="Ex: Ganhou a Libertadores em 2012" required>
                    </div>
                    <div class="col-md-3">
                        <label class="form-label">Time Relacionado</label>
                        <select name="idTime" class="form-select" required>
                            <option value="" disabled selected>Escolha o time...</option>
                            <c:forEach var="t" items="${times}">
                                <option value="${t.id}">${t.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-2 d-flex align-items-end">
                        <button type="submit" class="btn btn-fac w-100">ADICIONAR</button>
                    </div>
                </div>
            </form>

            <div class="mt-5">
                <h5 class="mb-3">Mensagens Cadastradas</h5>
                <div class="table-responsive">
                    <table class="table table-dark table-hover border-secondary">
                        <thead class="table-danger">
                            <tr>
                                <th>ID</th>
                                <th>Time</th>
                                <th>Mensagem</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="m" items="${mensagens}">
                                <tr>
                                    <td>${m.id}</td>
                                    <td>${m.time.nome}</td>
                                    <td>${m.mensagem}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="mt-4 d-flex justify-content-between">
                <a href="${pageContext.request.contextPath}/admin/painel" class="btn btn-outline-light">Voltar</a>
                <a href="/Faculdade/" class="btn btn-secondary">Sair</a>
            </div>
        </div>
    </div>
</body>
</html>