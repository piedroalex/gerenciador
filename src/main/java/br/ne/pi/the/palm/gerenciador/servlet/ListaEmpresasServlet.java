package br.ne.pi.the.palm.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/listaempresas")
public class ListaEmpresasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> lista = banco.getLista();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<ul>");
		
		for (Empresa empresa : lista) {
			out.println("<li>" + empresa.getNome() + "</li>");
		}
		
		out.println("</ul>");
		out.println("</body></html>");
	}

}
