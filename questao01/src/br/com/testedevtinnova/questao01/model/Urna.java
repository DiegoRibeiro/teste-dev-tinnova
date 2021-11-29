package br.com.testedevtinnova.questao01.model;

public class Urna {
	private int totalDeEleitores;
	
	public Urna(int totalDeEleitores) {
		this.totalDeEleitores = totalDeEleitores;
	}
	
	/**
	 * Calcula o percentual dos votos válidos
	 * @param votosValidos
	 * @return retorna a proporção de votos válidos
	 */
	public float calculaPercentualVotosValidos(int votosValidos) {
		return (float)votosValidos / totalDeEleitores;
	}
	
	/**
	 * Calcula o percentual dos votos em brancos
	 * @param votosBrancos
	 * @return retorna a proporção de votos em brancos
	 */
	public float calculaPercentualVotosBrancos(int votosBrancos) {
		return (float)votosBrancos / totalDeEleitores;
	}
	
	/**
	 * Calcula o percentual dos votos nulos
	 * @param votosNulos
	 * @return retorna a proporção de votos nulos
	 */
	public float calculaPercentualVotosNulos(int votosNulos) {
		return (float)votosNulos / totalDeEleitores;
	}
}
