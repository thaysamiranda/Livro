<%--
  Created by IntelliJ IDEA.
  User: thaysamiranda
  Date: 05/10/22
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Livro</title>
</head>
<body>

<h1>Edite quaisquer dados a seguir:</h1>

<fieldset>
    <legend>Dados</legend>
    <form action="editar-livro" method="post">
        <div>
            <input type="hidden" name="id" value="${livro.id}"> <!-- para identificar na alteracao -->
        </div>
        <div>
            <label for="idNome">Nome livro:</label>
            <input type="text" id="idNome" name="nome" value="${livro.nome}">
        </div>
        <div>
            <label for="idAutor">Autor:</label>
            <input type="text" id="idAutor" name="autor" value="${livro.autor}">
        </div>
        <input type="submit" value="Enviar">
    </form>
</fieldset>

</body>
</html>