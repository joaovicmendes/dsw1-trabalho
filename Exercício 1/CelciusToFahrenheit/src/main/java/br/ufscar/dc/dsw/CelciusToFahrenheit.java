package br.ufscar.dc.dsw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Conversion" })
public class CelciusToFahrenheit extends HttpServlet {
    
private static final long serialVersionUID = 1L;
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response, String metodo) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Conversão ˚C para ˚F</title>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Conversão Celcius para Fahrenheit</h1>");

        String minValue = request.getParameter("min");
        int min = (minValue == null || minValue == "") ? -100 : Integer.parseInt(minValue);
        String maxValue = request.getParameter("max");
        int max = (maxValue == null || maxValue == "") ?  100 : Integer.parseInt(maxValue);
        String stepValue = request.getParameter("step");
        int step = (stepValue == null || stepValue == "") ?  5 : Integer.parseInt(stepValue);

        if (step <= 0) {
            out.println("<p>Erro nos valores informados. Não usar incremento negativo.</p>");
        }
        else if (min > max) {
            out.println("<p>Erro nos valores informados. \"Mínimo\" deve ser menor que \"Máximo\".</p>");
        }
        else {
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Celsius</th>");
            out.println("<th>Fahrenheit</th>");
            out.println("</tr>");
            for (int celsius = min; celsius <= max; celsius += step) {
                double fahr = 1.8 * celsius + 32;
                out.println("<tr>");
                out.println("<td>" + celsius + "</td>");
                out.println("<td>" + fahr + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }

        out.println("</body>");
        out.println("</html>");
    }
        }
           
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response, "GET");
}
           
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response, "POST");
}
}