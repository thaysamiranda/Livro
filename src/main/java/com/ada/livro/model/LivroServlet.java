package com.ada.livro.model;

import com.ada.livro.bo.LivroBusinessObject;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(value = "/livro-servlet/*")
public class LivroServlet extends HttpServlet{

    LivroBusinessObject livroBusinessObject;

    @Inject
    public LivroServlet(LivroBusinessObject livroBusinessObject) {
        this.livroBusinessObject = livroBusinessObject;
    }
    @Override
    public void init(){
        System.out.println("Início do Servlet");

    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Iniciando o service");

        String caminho = request.getPathInfo();

        switch (caminho) {
            case "/cadastrar-livros":
                doPost(request, response);
                break;
            case "/editar-livro":
                doPut(request, response);
                break;
            case "/deletar":
                doDelete(request, response);
                break;
            case "/listar-livros":
                listarLivros(request,response);
                break;
            default:
                super.service(request, response);
        }
    }

    private void listarLivros(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Iniciando o metodo post");
        Livro livro = criarLivro(request);
        livroBusinessObject.save(livro);
        List<Livro> livros = livroBusinessObject.findAll();
        Collections.reverse(livros);
        request.setAttribute("livros", livros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-livros.jsp");
        dispatcher.forward(request,response);
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Iniciando o metodo put");

        String id = request.getParameter("id");
        Livro livro = criarLivro(request);
        livro.setId(Long.parseLong(id));
        Livro livroAlterado = livroBusinessObject.update(livro);

        request.setAttribute("idLivroAlterado", livroAlterado.getId());
        List<Livro> livros = livroBusinessObject.findAll();

        request.setAttribute("livros", livros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-livros.jsp");
        dispatcher.forward(request,response);
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        livroBusinessObject.delete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-livros.jsp");
        dispatcher.forward(request,response);
    }
    @Override
    public void destroy() {
        System.out.println("Destruir Servlet");
    }
    private Livro criarLivro(HttpServletRequest request) {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String autor = request.getParameter("autor");
        return new Livro(id, nome, autor);
    }

    protected void carregarParaEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idLivro = request.getParameter("id");
        Livro livro = livroBusinessObject.getById(idLivro);
        request.setAttribute("livro", livro);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editar-livro.jsp");
        dispatcher.forward(request,response);
    }

    protected void carregarBanco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Livro> livros = livroBusinessObject.findAll();
        request.setAttribute("livros",livros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-livros.jsp");
        dispatcher.forward(request,response);
    }
    }
