<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="15;url=cadastro">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<title>O Oráculo Responde</title>
</head>
<body>
    <div class="bg-full">
        <div class="container text-center">
            <div class="card-fac mx-auto" style="max-width: 700px;">
                <h1 class="display-4 mb-4" style="color: #b20000;">O Oráculo diz...</h1>
                
                <div class="py-4">
                    <h2 class="fst-italic">"${curiosidade.mensagem}"</h2>
                </div>

                <div class="mt-4">
                    <p class="text-secondary">A processar o seu destino...</p>
                    <div class="spinner-border text-danger" role="status">
                        <span class="visually-hidden">A carregar...</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>