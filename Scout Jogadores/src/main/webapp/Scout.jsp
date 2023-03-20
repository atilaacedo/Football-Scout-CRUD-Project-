<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import ="com.scoutplayers.model.Jogador"%>
<%@ page import ="java.util.ArrayList"%>
<%ArrayList<Jogador> listaJogadores = (ArrayList<Jogador>) request.getAttribute("jogadores");%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Scout Players</title>
<link rel="icon" href="Images/IconeBola.png">
<link rel="stylesheet" href="Style.css">
</head>
<body>
	<h1>Scout Players</h1>
	
	<a href="NovoJogador.html" class="BotaoMain" id="BotaoNovoJogador">Novo Jogador</a>
	<a href="pdfReport" class="BotaoExcluir">Relatório PDF</a>
	
	<table id="tabelaJogadores">

		<thead>
			<tr>
				<th><a href="">ID</a></th>
				<th><a href="">Nome</a></th>
				<th><a href="">Idade</a></th>
				<th><a href="">Nacionalidade</a></th>
				<th><a href="">Altura</a></th>
				<th><a href="">Posição</a></th>
				<th><a href="">Clube</a></th>
				<th><a href="">Descrição</a></th>
				<th><a href="">Opções</a></th>
			</tr>
		</thead>
				<% for(Jogador jogador: listaJogadores){%>
					<tr>
						<td><%=jogador.getId()%></td>
						<td><%=jogador.getNome()%></td>
						<td><%=jogador.getIdade()%></td>
						<td><%=jogador.getNacionalidade()%></td>
						<td><%=jogador.getAltura()%></td>
						<td><%=jogador.getPosicao()%></td>
						<td><%=jogador.getClube()%></td>
						<td><%=jogador.getDescricao()%></td>
						<td>
						<a href="editar?id=<%=jogador.getId()%>" class="BotaoMain">Editar</a>
						<a href="javascript: confirmar(<%=jogador.getId()%>)" class="BotaoExcluir">Excluir</a>
						</td>
					</tr>
				<%}%>
		<tbody>

		</tbody>
	</table>
	<script src="Scripts/Confirmar.js"></script>
</body>
</html>