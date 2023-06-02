<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Jogador</title>
<link rel="icon" href="Images/IconeBola.png">
<link rel="stylesheet" href="Style.css">
</head>
<body>
	<h1>Editar Jogador</h1>
	<div id="formularioNovoJogador">
		<form name="frmNovoJogador" action="salvar">
			<table>
				<tr>
					<td class="labelForm">ID:</td>
					<td><input type="text" name="idJogador" id="boxId" readonly value="<%out.print(request.getAttribute("idJogador"));%>"></td>
				</tr>
				<tr>
					<td class="labelForm">Nome:</td>
					<td><input type="text" name="nomeJogador" class="boxL" value="<%out.print(request.getAttribute("nomeJogador"));%>"></td>
				</tr>
				<tr>
					<td class="labelForm">Idade:</td>
					<td><input type="text" name="idadeJogador" class="boxS" value="<%out.print(request.getAttribute("idadeJogador"));%>"></td>
				</tr>
				<tr>
					<td class="labelForm">Nacionalidade:</td>
					<td><input type="text" name="nacionalidadeJogador"
						class="boxL"value="<%out.print(request.getAttribute("nacionalidadeJogador"));%>"> </td>
				</tr>
				<tr>
					<td class="labelForm">Altura:</td>
					<td><input type="text" name="alturaJogador" class="boxS" value="<%out.print(request.getAttribute("alturaJogador"));%>"></td>
				</tr>
				<tr>
					<td class="labelForm">Posição:</td>
					<td><input type="text" name="posicaoJogador" class="boxS" value="<%out.print(request.getAttribute("posicaoJogador"));%>"></td>
				</tr>
				<tr>
					<td class="labelForm">Clube:</td>
					<td><input type="text" name="clubeJogador" class="boxL" value="<%out.print(request.getAttribute("clubeJogador"));%>"></td>
				</tr>
				<tr>
					<td class="labelForm">Descrição:</td>
					<td><textarea class="areaDescricao" name="descricaoJogador"
							id="descricaoJogador" cols="30" rows="10"  placeholder="<%out.print(request.getAttribute("descricaoJogador"));%>"></textarea></td>
				</tr>

			</table>

			<input type="button" name="salvar" value="Salvar Jogador"
				class="BotaoMain" onclick="validar()">
		</form>
	</div>

	<script src="Scripts/Validador.js"></script>
</body>
</html>