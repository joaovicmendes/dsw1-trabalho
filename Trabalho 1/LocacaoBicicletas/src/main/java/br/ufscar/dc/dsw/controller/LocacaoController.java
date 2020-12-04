package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.LocacaoDAO;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.util.Erro;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/locacoes/*")
public class LocacaoController extends HttpServlet {

    private static final long serialVersionUID = 1L; 
    private LocacaoDAO dao;

    @Override
    public void init() {
        dao = new LocacaoDAO();
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
                case "/locacao":
                    locacao(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
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
        List<Locacao> listaLocacoes = null;
        Erro erros = new Erro();
        Cliente clienteLogado = (Cliente) request.getSession().getAttribute("clienteLogado");
        Locadora locadoraLogada = (Locadora) request.getSession().getAttribute("locadoraLogada");
        System.out.println("CHEGOUUUUUUU##########");
        if (clienteLogado == null && locadoraLogada == null) {
            erros.add("Precisa estar logado para acessar essa página.");

            request.setAttribute("mensagens", erros);
            String URL = "/login.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
		    rd.forward(request, response);
            return;
        } else if (clienteLogado != null && locadoraLogada == null) {
            listaLocacoes = dao.getByCpf(clienteLogado.getCpf());
        }
        else if (clienteLogado == null && locadoraLogada != null) {
            listaLocacoes = dao.getByCnpj(locadoraLogada.getCnpj());
        }

        request.setAttribute("listaLocacoes", listaLocacoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locacao/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void locacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
