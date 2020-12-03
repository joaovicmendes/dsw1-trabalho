package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.util.Erro;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/clientes/*")
public class ClienteController extends HttpServlet {

    private static final long serialVersionUID = 1L; 
    private ClienteDAO dao;

    @Override
    public void init() {
        dao = new ClienteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }
        // Cliente cliente = (Cliente) request.getSession().getAttribute("clienteLogado");
    	// Erro erros = new Erro();    	
    	// if (cliente == null) {
    	// 	response.sendRedirect(request.getContextPath());
    	// } else {
    	// 	RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/cliente/index.jsp");
        //     dispatcher.forward(request, response);
        // }

        try {
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> listaClientes = dao.getAll();
        request.setAttribute("listaClientes", listaClientes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formCadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String genero = request.getParameter("genero");
        String telefone = request.getParameter("telefone");
        String papel = "USER";
        LocalDate dataNascimento = LocalDate.now();
        try {
            dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
        }
        catch (Exception e) {
            dataNascimento = LocalDate.now();
        }

        Cliente cliente = new Cliente(cpf, nome, email, senha, genero, telefone, dataNascimento, papel);
        dao.insert(cliente);

        RequestDispatcher dispatcher = request.getRequestDispatcher("clientes");
        dispatcher.forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        Cliente cliente = dao.get(cpf);
        dao.delete(cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("clientes");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cpf = request.getParameter("cpf");
        Cliente cliente = dao.get(cpf);
        request.setAttribute("cliente", cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formEdicao.jsp");
        dispatcher.forward(request, response);
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String cpf = request.getParameter("cpf");
        Cliente cliente = dao.get(cpf);

        String nome = request.getParameter("nome");
        if (nome == "") {
            nome = cliente.getNome();
        }
        String email = request.getParameter("email");
        if (email == "") {
            email = cliente.getEmail();
        }
        String senha = request.getParameter("senha");
        if (senha == "") {
            senha = cliente.getSenha();
        }
        String genero = request.getParameter("genero");
        if (genero == "") {
            genero = cliente.getGenero();
        }

        String telefone = request.getParameter("telefone");
        if (telefone == "") {
            telefone = cliente.getTelefone();
        }

        String papel = cliente.getPapel();

        LocalDate dataNascimento = cliente.getDataNascimento();
        try {
            dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
        }
        catch (Exception e) {
            dataNascimento = cliente.getDataNascimento();
        }

        Cliente clienteAtualizado = new Cliente(cpf, nome, email, senha, genero, telefone, dataNascimento, papel);
        dao.update(clienteAtualizado);

        RequestDispatcher dispatcher = request.getRequestDispatcher("clientes");
        dispatcher.forward(request, response);
    }
}
