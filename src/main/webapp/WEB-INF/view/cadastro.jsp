<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<title>Cadastro de Candidato</title>
</head>
<body class="bg-dark">
    <div class="container mt-5 mb-5">
        <div class="card-fac shadow">
            <h2 class="text-center mb-4">Cadastro</h2>
            
            <form action="salvarCandidato" method="post">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Nome Completo</label>
                        <input type="text" name="nomeCompleto" class="form-control" placeholder="Seu nome" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">E-mail</label>
                        <input type="email" name="email" class="form-control" placeholder="exemplo@email.com" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Telefone Celular</label>
                        <input type="text" name="telefoneCelular" class="form-control" placeholder="(11) 99999-9999" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Bairro</label>
                        <input type="text" name="bairro" class="form-control" placeholder="Seu bairro" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label class="form-label">Curso de Interesse</label>
                    <select name="cursoInteresse" class="form-select" required>
                        <option value="" disabled selected>Selecione um curso...</option>
	                    <option value="Análise e Desenvolvimento de Sistemas">Análise e Desenvolvimento de Sistemas</option>
	                    <option value="Logística">Logística</option>
	                    <option value="Comércio Exterior">Comércio Exterior</option>
	                    <option value="Gestão de Empresarial">Gestão Empresarial</option>
	                    <option value="Recursos Humanos">Recursos Humanos</option>
                    </select>
                </div>

                <div class="alert alert-secondary mt-3 small" style="background-color: #252525; border-color: #444; color: #bbb;">
                    * Ao finalizar a inscrição, você concorda em receber mensagens da Fatec ZL sobre futuros períodos de vestibular e eventos.
                </div>
				<div class="mt-4 text-center">
                	<button type="submit" class="btn btn-fac w-100 p-3 mt-3">Finalizar Inscrição</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>