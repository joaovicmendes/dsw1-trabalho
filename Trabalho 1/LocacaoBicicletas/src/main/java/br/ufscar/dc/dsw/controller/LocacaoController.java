package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.LocacaoDAO;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.util.Erro;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
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
    private LocadoraDAO daoLocadora;
   
    @Override
    public void init() {
        dao = new LocacaoDAO();
        daoLocadora = new LocadoraDAO();
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
                	apresentaFormCadastro(request, response);
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

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Locadora> listaLocadoras = daoLocadora.getAll();
        request.setAttribute("listaLocadoras", listaLocadoras);
        
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/locacao/formCadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	Erro erros = new Erro();
    	Cliente clienteLogado = (Cliente) request.getSession().getAttribute("clienteLogado");
    	
    	if (clienteLogado == null) {
    		erros.add("Precisa estar logado para acessar essa página.");

            request.setAttribute("mensagens", erros);
            String URL = "/login.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
		    rd.forward(request, response);
            return;
    	}
    	
    	try {
	        String cnpj = request.getParameter("locadoras");
	        String dma = request.getParameter("data");
	        String horario = request.getParameter("horario");
	
	        Locadora locadora = daoLocadora.get(cnpj);
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	        Date date = dateFormat.parse(dma + " " + horario + ":00");
	        
	        Locacao locacao = new Locacao(clienteLogado, locadora, date);
	        Locacao existente = dao.get(clienteLogado.getCpf(), locadora.getCnpj(), date);

	        if (existente == null) {
	        	dao.insert(locacao);
	        } else {
	        	erros.add("Esse horário está ocupado.");
	    		
	    		request.setAttribute("mensagens", erros);
	            String URL = "/locacoes/locacao";
	            RequestDispatcher rd = request.getRequestDispatcher(URL);
			    rd.forward(request, response);
	            return;
	        }
    	} catch (Exception e) {
    		System.out.print(e.toString());
    		
    		erros.add("Erro nos dados preenchidos.");
    		
    		request.setAttribute("mensagens", erros);
            String URL = "/locacoes";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
		    rd.forward(request, response);
            return;
    	}

        RequestDispatcher dispatcher = request.getRequestDispatcher("/locacoes/locacoes");
        dispatcher.forward(request, response);
    }
}
