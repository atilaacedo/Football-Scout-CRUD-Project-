package com.scoutplayers.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Jogador.
 */
public class Jogador {
	
	/** The id. */
	private Integer id;
	
	/** The nome. */
	private String nome;
	
	/** The idade. */
	private Integer idade;
	
	/** The nacionalidade. */
	private String nacionalidade;
	
	/** The altura. */
	private Double altura;
	
	/** The posicao. */
	private String posicao;
	
	/** The clube. */
	private String clube;
	
	/** The descricao. */
	private String descricao;

	/**
	 * Instantiates a new jogador.
	 */
	public Jogador() {

	}



	/**
	 * Instantiates a new jogador.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param idade the idade
	 * @param nacionalidade the nacionalidade
	 * @param altura the altura
	 * @param posicao the posicao
	 * @param clube the clube
	 * @param descricao the descricao
	 */
	public Jogador(Integer id,String nome, Integer idade, String nacionalidade, Double altura, String posicao, String clube,
			String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.nacionalidade = nacionalidade;
		this.altura = altura;
		this.posicao = posicao;
		this.clube = clube;
		this.descricao = descricao;
	}



	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the idade.
	 *
	 * @return the idade
	 */
	public Integer getIdade() {
		return idade;
	}
	
	/**
	 * Sets the idade.
	 *
	 * @param idade the new idade
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	/**
	 * Gets the nacionalidade.
	 *
	 * @return the nacionalidade
	 */
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	/**
	 * Sets the nacionalidade.
	 *
	 * @param nacionalidade the new nacionalidade
	 */
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	/**
	 * Gets the altura.
	 *
	 * @return the altura
	 */
	public Double getAltura() {
		return altura;
	}
	
	/**
	 * Sets the altura.
	 *
	 * @param altura the new altura
	 */
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	/**
	 * Gets the posicao.
	 *
	 * @return the posicao
	 */
	public String getPosicao() {
		return posicao;
	}
	
	/**
	 * Sets the posicao.
	 *
	 * @param posicao the new posicao
	 */
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	/**
	 * Gets the clube.
	 *
	 * @return the clube
	 */
	public String getClube() {
		return clube;
	}
	
	/**
	 * Sets the clube.
	 *
	 * @param clube the new clube
	 */
	public void setClube(String clube) {
		this.clube = clube;
	}
	
	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Sets the descricao.
	 *
	 * @param descricao the new descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
