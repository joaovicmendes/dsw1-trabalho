package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.domain.Locadora;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/locadoras/*")
public class LocadoraController extends HttpServlet {

    private static final long serialVersionUID = 1L; 
    private LocadoraDAO dao;

    @Override
    public void init() {
        dao = new LocadoraDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {           
        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "/cadastro":
                    //apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    //insere(request, response);
                    break;
                case "/remocao":
                    //remove(request, response);
                    break;
                case "/edicao":
                    //apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    //atualize(request, response);
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
        List<Locadora> listaLocadoras = dao.getAll();
        request.setAttribute("listaLocadoras", listaLocadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locadora/lista.jsp");
        dispatcher.forward(request, response);
    }
}