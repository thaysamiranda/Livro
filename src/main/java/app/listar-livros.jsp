<%--
  Created by IntelliJ IDEA.
  User: thaysamiranda
  Date: 05/10/22
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de livros</title>
</head>
<body>


<h1>Livros cadastrados</h1>

<c:if test="${idLivroSalvo != null}">
    <h3>Livro de id: ${idLivroSalvo} , cadastrado com sucesso</h3>
</c:if>
<c:if test="${idLivroAlterado != null}">
    <h3>Livro de id: ${idLivroSalvo} , alterado com sucesso</h3>
</c:if>

<table border="solid">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Autor</th>
        <th>Editar</th>
        <th>Deletar</th>
    </tr>
    <c:forEach var="livro" items="${livros}" varStatus="id">
        <tr>
            <td>${livro.id}</td>
            <td>${livro.nome}</td>
            <td>${livro.autor}</td>
            <td>
                <a href="${pageContext.request.contextPath}/livro-servlet/carregar-para-edicao?id=<c:out value='${livro.id}' />">Edit</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/livro-servlet/deletar?id=<c:out value='${livro.id}' />">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/index.jsp">Voltar ao menu iniciar</a>

</body>
</html>