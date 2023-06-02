package com.scoutplayers.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.scoutplayers.model.DAO;
import com.scoutplayers.model.Jogador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class ScoutController.
 */
@WebServlet(urlPatterns = { "/ControllerScout", "/scoutPage", "/enviar", "/editar", "/salvar", "/delete", "/pdfReport" })
public class ControllerScout extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dao. */
	DAO dao = new DAO();
	
	/** The jogador. */
	Jogador jogador = new Jogador();

	/**
	 * Instantiates a new controller scout.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerScout() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		if (action.equals("/scoutPage")) {
			doScoutPLayerPage(request, response);
		} else if (action.equals("/enviar")) {
			adicionarJogador(request, response);
		} else if (action.equals("/editar")) {
			listarJogador(request, response);
		} else if (action.equals("/salvar")) {
			editarJogador(request, response);
		} else if (action.equals("/delete")) {
			excluirJogador(request, response);
		}  else if (action.equals("/pdfReport")) {
			gerarPDF(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Do scout P layer page.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doScoutPLayerPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Jogador> listaJogadores = dao.listarJogadores();
		request.setAttribute("jogadores", listaJogadores);
		RequestDispatcher rd = request.getRequestDispatcher("Scout.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar jogador.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void adicionarJogador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		jogador.setNome(request.getParameter("nomeJogador"));
		jogador.setIdade(Integer.parseInt(request.getParameter("idadeJogador")));
		jogador.setNacionalidade(request.getParameter("nacionalidadeJogador"));
		String altura = request.getParameter("alturaJogador");
		if(altura.charAt(1) == ','){
			altura = altura.replace(",", ".");
		}
		jogador.setAltura(Double.parseDouble(altura));
		jogador.setPosicao(request.getParameter("posicaoJogador"));
		String clube = request.getParameter("clubeJogador");
		if(clube.equals(""))
			clube = "Livre";
		jogador.setClube(clube);
		jogador.setDescricao(request.getParameter("descricaoJogador"));

		dao.inserirJogador(jogador);
		response.sendRedirect("scoutPage");
	}

	/**
	 * Listar jogador.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarJogador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		jogador.setId(id);

		dao.selecionarJogador(jogador);
		request.setAttribute("idJogador", jogador.getId());
		request.setAttribute("nomeJogador", jogador.getNome());
		request.setAttribute("idadeJogador", jogador.getIdade());
		request.setAttribute("nacionalidadeJogador", jogador.getNacionalidade());
		request.setAttribute("alturaJogador", jogador.getAltura());
		request.setAttribute("posicaoJogador", jogador.getPosicao());
		request.setAttribute("clubeJogador", jogador.getClube());
		request.setAttribute("descricaoJogador", jogador.getDescricao());

		RequestDispatcher rd = request.getRequestDispatcher("Editar.jsp");
		rd.forward(request, response);

	}

	/**
	 * Editar jogador.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarJogador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		jogador.setId(Integer.parseInt(request.getParameter("idJogador")));
		jogador.setNome(request.getParameter("nomeJogador"));
		jogador.setIdade(Integer.parseInt(request.getParameter("idadeJogador")));
		jogador.setNacionalidade(request.getParameter("nacionalidadeJogador"));
		String altura = request.getParameter("alturaJogador");
		if(altura.charAt(1) == ','){
			altura = altura.replace(",", ".");
		}
		jogador.setAltura(Double.parseDouble(altura));
		jogador.setPosicao(request.getParameter("posicaoJogador"));
		jogador.setClube(request.getParameter("clubeJogador"));
		jogador.setDescricao(request.getParameter("descricaoJogador"));

		dao.editarJogador(jogador);

		response.sendRedirect("scoutPage");
	}

	/**
	 * Excluir jogador.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void excluirJogador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		jogador.setId(id);
		dao.excluirJogador(jogador);
		response.sendRedirect("scoutPage");
	}
	
	/**
	 * Gerar PDF.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void gerarPDF(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "jogadores.pdf");
			
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Jogadores"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(7);
			
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Idade"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Nacionalidade"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Altura"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Posição"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Clube"));
			PdfPCell col7 = new PdfPCell(new Paragraph("Descrição"));
			
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			tabela.addCell(col7);
			
			ArrayList<Jogador> listaJogadores = dao.listarJogadores();
			
			for(Jogador jogador: listaJogadores) {
				tabela.addCell(jogador.getNome());
				tabela.addCell(Integer.toString(jogador.getIdade()));
				tabela.addCell(jogador.getNacionalidade());
				tabela.addCell(Double.toString(jogador.getAltura()));
				tabela.addCell(jogador.getPosicao());
				tabela.addCell(jogador.getClube());
				tabela.addCell(jogador.getDescricao());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			documento.close();
		}
	}
	
}
