<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<title>Painel Administrativo - Oráculo</title>
</head>
<body class="bg-dark text-white">
    <div class="container-fluid p-5">
        <div class="card-fac shadow-lg">
            <div class="d-flex justify-content-between align-items-center mb-4 border-bottom border-secondary pb-3">
                <h2 class="text-white">Relatório de Candidatos</h2>
                <a href="${pageContext.request.contextPath}/login/" class="btn btn-outline-secondary btn-sm">Sair</a>
            </div>

            <div class="row mb-4 align-items-end">
                <div class="col-md-5">
                    <div class="btn-group w-100">
                        <a href="${pageContext.request.contextPath}/admin/painel" class="btn btn-outline-light btn-sm">Todos</a>
                        <a href="${pageContext.request.contextPath}/admin/primeiros" class="btn btn-outline-light btn-sm">Top 10</a>
                        <a href="${pageContext.request.contextPath}/admin/ultimos" class="btn btn-outline-light btn-sm">Últimos 10</a>
                    </div>     
                </div>
                
                <div class="col-md-7">
                    <div class="row">
                        <div class="col-6">
                            <form action="${pageContext.request.contextPath}/admin/filtroBairro" method="get" class="d-flex gap-1">
                                <input type="text" name="bairro" class="form-control bg-dark text-white border-secondary" placeholder="Bairro">
                                <button type="submit" >🔍</button>
                            </form>
                        </div>
                        <div class="col-6">
                            <form action="${pageContext.request.contextPath}/admin/filtroCurso" method="get" class="d-flex gap-1">
                                <select name="curso" class="form-select bg-dark text-white border-secondary" required>
                                    <option value="" disabled selected>Escolha...</option>
                                    <option value="Análise e Desenvolvimento de Sistemas">Análise e Desenvolvimento de Sistemas</option>
                                    <option value="Logística">Logística</option>
                                    <option value="Comércio Exterior">Comércio Exterior</option>
                                    <option value="Gestão Empresarial">Gestão</option>
                                    <option value="Recursos Humanos">Recursos Humanos</option>
                                </select>
                                <button type="submit">🔍</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div class="table-responsive border border-secondary rounded">
                <table class="table table-dark table-hover mb-0">
                    <thead class="table-danger">
                        <tr>
                            <th class="py-3">Nome</th>
                            <th class="py-3">E-mail</th>
                            <th class="py-3">Celular</th>
                            <th class="py-3">Bairro</th>
                            <th class="py-3">Curso</th>
                            <th class="py-3">Inscrição</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${candidatos}">
                            <tr class="align-middle">
                                <td>${c.nomeCompleto}</td>
                                <td class="text-info">${c.email}</td>
                                <td>${c.telefoneCelular}</td>
                                <td>${c.bairro}</td>
                                <td>${c.cursoInteresse}</td>
                                <td>${c.dtHoraFormatada}</td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty candidatos}">
                            <tr>
                                <td colspan="6" class="text-center py-4 text-secondary italic">Nenhum candidato encontrado.</td>
                            </tr>
                        </c:if>
                    </tbody>
                </table>
            </div>

            <div class="row mt-4">
                <div class="col-md-12">
                    <a href="cadastraTipo" class="btn btn-fac w-100 p-3 fw-bold">
                       ⚙️ Gerenciar mensagens 
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>