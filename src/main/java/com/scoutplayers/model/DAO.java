package com.scoutplayers.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;


// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	Properties prop = getProperties();
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	final String url = prop.getProperty("banco.url");
	final String user = prop.getProperty("banco.usuario");
	final String senha =prop.getProperty("banco.senha");

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	

	private static Properties getProperties() {
		Properties pro = new Properties();
		String caminho = "/conexao.properties";
		try {
			pro.load(DAO.class.getResourceAsStream(caminho));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pro;
	}
	
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, senha);
			return con;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	/**
	 * Inserir jogador.
	 *
	 * @param jogador the jogador
	 */
	public void inserirJogador(Jogador jogador) {
		String create = "insert into jogadores (nome, idade, nacionalidade, altura, posicao, clube, anotacoes) values (?,?,?,?,?,?,?)";

		try {
			Connection connection = conectar();

			PreparedStatement psmt = connection.prepareStatement(create);
			psmt.setString(1, jogador.getNome());
			psmt.setInt(2, jogador.getIdade());
			psmt.setString(3, jogador.getNacionalidade());
			psmt.setDouble(4, jogador.getAltura());
			psmt.setString(5, jogador.getPosicao());
			psmt.setString(6, jogador.getClube());
			psmt.setString(7, jogador.getDescricao());

			psmt.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Listar jogadores.
	 *
	 * @return the array list
	 */
	public ArrayList<Jogador> listarJogadores(){
		String listar = "select * from jogadores order by nome";
		ArrayList<Jogador> listaJogadores = new ArrayList<>();
		try {
			Connection connection = conectar();
			PreparedStatement psmt = connection.prepareStatement(listar);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt(1);
				String nome = rs.getString(2);
				Integer idade = rs.getInt(3);
				String nacionalidade = rs.getString(4);
				Double altura = rs.getDouble(5);
				String posicao = rs.getString(6);
				String clube = rs.getString(7);
				String descricao = rs.getString(8);

				listaJogadores.add(new Jogador(id, nome,idade, nacionalidade, altura, posicao, clube, descricao));
			}

			connection.close();
			return listaJogadores;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Selecionar jogador.
	 *
	 * @param jogador the jogador
	 */
	public void selecionarJogador(Jogador jogador) {
		String jogadorTemporario = "select * from jogadores where id = ?";

		try {
			Connection connection = conectar();
			PreparedStatement psmt = connection.prepareStatement(jogadorTemporario);
			psmt.setInt(1, jogador.getId());
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				jogador.setId(rs.getInt(1));
				jogador.setNome(rs.getString(2));
				jogador.setIdade(rs.getInt(3));
				jogador.setNacionalidade(rs.getString(4));
				jogador.setAltura(rs.getDouble(5));
				jogador.setPosicao(rs.getString(6));
				jogador.setClube(rs.getString(7));
				jogador.setDescricao(rs.getString(8));

			}
			connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Editar jogador.
	 *
	 * @param jogador the jogador
	 */
	public void editarJogador(Jogador jogador) {
		String create = "update jogadores set nome =?, idade=?, nacionalidade=?, altura=?, posicao=?, clube=?, anotacoes=? where id=?";
		
		try {
			Connection connection = conectar();
			PreparedStatement psmt = connection.prepareStatement(create);
			psmt.setString(1, jogador.getNome());
			psmt.setInt(2, jogador.getIdade());
			psmt.setString(3, jogador.getNacionalidade());
			psmt.setDouble(4, jogador.getAltura());
			psmt.setString(5, jogador.getPosicao());
			psmt.setString(6, jogador.getClube());
			psmt.setString(7, jogador.getDescricao());
			psmt.setInt(8, jogador.getId());
			
			psmt.executeUpdate();
			connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Excluir jogador.
	 *
	 * @param jogador the jogador
	 */
	public void excluirJogador(Jogador jogador) {
		String delete = "delete from jogadores where id=?";
		
		try {
			Connection connection = conectar();
			PreparedStatement psmt = connection.prepareStatement(delete);
			psmt.setInt(1, jogador.getId());
			
			psmt.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}

