<%--
  Created by IntelliJ IDEA.
  User: thaysamiranda
  Date: 05/10/22
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Livro</title>
</head>
<body>
<h1>Cadastro de Livros</h1>
<fieldset>
    <legend>Dados</legend>
    <form action="livro-servlet/cadastrar-livros" method="post">
        <div>
            <label for="id">ID:</label>
            <input type="text" id="id" name="id">
        </div>
        <div>
            <label for="idNome">Nome:</label>
            <input type="text" id="idNome" name="nome">
        </div>
        <div>
            <label for="idAutor">Autor:</label>
            <input type="text" id="idAutor" name="autor">
        </div>
        <input type="submit" value="Enviar">
    </form>
</fieldset>

</body>
</html>