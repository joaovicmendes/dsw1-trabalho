package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(name = "Login", urlPatterns = {"/login/*", "/logout.jsp"})
public class LoginController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Erro erros = new Erro();
        if (request.getParameter("clienteOK") != null && 
		    request.getParameter("clienteOK") != "cliente_login=&cliente_senha="){
				
            String login = request.getParameter("cliente_login");
			String senha = request.getParameter("cliente_senha");
			if (login == null || login.isEmpty()) {
				erros.add("Login não informado!");
			}
			if (senha == null || senha.isEmpty()) {
				erros.add("Senha não informada!");
			}
            if (!erros.isExisteErros()) {
                ClienteDAO dao = new ClienteDAO();
                Cliente cliente = dao.getbyLogin(login);
                if (cliente != null) {
					if (cliente.getSenha().equals(senha)) {
						request.getSession().setAttribute("clienteLogado", cliente);
						String URL = "/index.jsp";
						RequestDispatcher rd = request.getRequestDispatcher(URL);
						rd.forward(request, response);
						return;
					} else {
						erros.add("Senha inválida!");
					}
				} else {
					erros.add("Cliente não encontrado!");
				}
			}
		}
		else if(request.getParameter("locadoraOK") != null && 
		        request.getParameter("clienteOK") != "locadora_login=&locadora_senha="){
					
            String login = request.getParameter("locadora_login");
			String senha = request.getParameter("locadora_senha");
			if (login == null || login.isEmpty()) {
				erros.add("Login não informado!");
			}
			if (senha == null || senha.isEmpty()) {
				erros.add("Senha não informada!");
			}
            if (!erros.isExisteErros()) {
                LocadoraDAO dao = new LocadoraDAO();
                Locadora locadora = dao.getbyLogin(login);
                if (locadora != null) {
					if (locadora.getSenha().equals(senha)) {
						request.getSession().setAttribute("locadoraLogada", locadora);
						String URL = "/index.jsp";
						RequestDispatcher rd = request.getRequestDispatcher(URL);
						rd.forward(request, response);
						return;
					} else {
						erros.add("Senha inválida!");
					}
				} else {
					erros.add("Locadora não encontrada!");
				}
			}
		}
        request.getSession().invalidate();
		request.setAttribute("mensagens", erros);
		String URL = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);
    }
}
