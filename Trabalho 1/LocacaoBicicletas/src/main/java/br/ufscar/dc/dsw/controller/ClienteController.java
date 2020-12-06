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
        Erro erros = new Erro();
        Cliente clienteLogado = (Cliente) request.getSession().getAttribute("clienteLogado");
        
        if (clienteLogado == null) {
            erros.add("Precisa estar logado para acessar essa página.");

            request.setAttribute("mensagens", erros);
            String URL = "/login.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
		    rd.forward(request, response);
            return;
        } else if (!clienteLogado.getPapel().equals("ADMIN")) {
            erros.add("Não possui permissão de acesso.");
            erros.add("Apenas [ADMIN] pode acessar essa página.");

            request.setAttribute("mensagens", erros);
            String URL = "/noAuth.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
		    rd.forward(request, response);
            return;
        }
        
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
        String papel = request.getParameter("papel");
        if (papel == null || papel.equals("")) {
            papel = "USER";
        }
        LocalDate dataNascimento = LocalDate.now();
        try {
            dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
        }
        catch (Exception e) {
            dataNascimento = LocalDate.now();
        }

        try {
            Cliente cliente = new Cliente(cpf, nome, email, senha, genero, telefone, dataNascimento, papel);
            dao.insert(cliente);
        } catch (Exception e) {
            Erro erros = new Erro();
            erros.add("Erro nos dados preenchidos.");

            request.setAttribute("mensagens", erros);

            RequestDispatcher rd = request.getRequestDispatcher("/cliente/formCadastro.jsp");
            rd.forward(request, response);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Erro erros = new Erro();
        Cliente clienteLogado = (Cliente) request.getSession().getAttribute("clienteLogado");
        
        if (clienteLogado == null) {
            erros.add("Precisa estar logado para acessar essa página.");

            request.setAttribute("mensagens", erros);
            String URL = "/login.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
		    rd.forward(request, response);
            return;
        } else if (!clienteLogado.getPapel().equals("ADMIN")) {
            erros.add("Não possui permissão de acesso.");
            erros.add("Apenas [ADMIN] pode acessar essa página.");

            request.setAttribute("mensagens", erros);
            String URL = "/noAuth.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
		    rd.forward(request, response);
            return;
        }
        
        String cpf = request.getParameter("cpf");
        Cliente cliente = dao.get(cpf);
        dao.delete(cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("clientes");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Erro erros = new Erro();
        Cliente clienteLogado = (Cliente) request.getSession().getAttribute("clienteLogado");
        
        if (clienteLogado == null) {
            erros.add("Precisa estar logado para acessar essa página.");

            request.setAttribute("mensagens", erros);
            String URL = "/login.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
		    rd.forward(request, response);
            return;
        } else if (!clienteLogado.getPapel().equals("ADMIN")) {
            erros.add("Não possui permissão de acesso.");
            erros.add("Apenas [ADMIN] pode acessar essa página.");

            request.setAttribute("mensagens", erros);
            String URL = "/noAuth.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
		    rd.forward(request, response);
            return;
        }
        
        request.setCharacterEncoding("UTF-8");
        String cpf = request.getParameter("cpf");
        Cliente cliente = dao.get(cpf);
        request.setAttribute("cliente", cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formEdicao.jsp");
        dispatcher.forward(request, response);
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Erro erros = new Erro();
        Cliente clienteLogado = (Cliente) request.getSession().getAttribute("clienteLogado");
        
        if (clienteLogado == null) {
            erros.add("Precisa estar logado para acessar essa página.");

            request.setAttribute("mensagens", erros);
            String URL = "/login.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
		    rd.forward(request, response);
            return;
        } else if (!clienteLogado.getPapel().equals("ADMIN")) {
            erros.add("Não possui permissão de acesso.");
            erros.add("Apenas [ADMIN] pode acessar essa página.");

            request.setAttribute("mensagens", erros);
            String URL = "/noAuth.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
		    rd.forward(request, response);
            return;
        }
        
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

        String papel = request.getParameter("papel");
        if (telefone == "") {
            telefone = cliente.getPapel();
        }

        LocalDate dataNascimento = cliente.getDataNascimento();
        try {
            dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
        }
        catch (Exception e) {
            dataNascimento = cliente.getDataNascimento();
        }

        Cliente clienteAtualizado = new Cliente(cpf, nome, email, senha, genero, telefone, dataNascimento, papel);
        try {
            dao.update(clienteAtualizado);
        } catch (Exception e) {
            erros.add("Erro nos dados preenchidos.");

            request.setAttribute("mensagens", erros);

            RequestDispatcher rd = request.getRequestDispatcher("/cliente/formEdicao.jsp");
            rd.forward(request, response);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("clientes");
        dispatcher.forward(request, response);
    }
}
