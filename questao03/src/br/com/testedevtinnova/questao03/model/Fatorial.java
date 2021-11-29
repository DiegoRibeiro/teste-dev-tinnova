package br.com.testedevtinnova.questao03.model;

public class Fatorial {
	/**
	 * Funcao que calcula o fatorial de um numero n
	 * @param n numero a ser calculado
	 * @return resultado do fatorial
	 */
	public static int calcula(int n) {
		if(n == 0) {
			return 1;
		}
		
		return n * calcula(n - 1);
	}
}
