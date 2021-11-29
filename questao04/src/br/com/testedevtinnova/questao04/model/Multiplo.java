package br.com.testedevtinnova.questao04.model;

public class Multiplo {
	/**
	 * funcao que calcula a soma dos multiplos de 3 ou 5
	 * @param x limite do somatorio
	 * @return retorna a soma dos multiplos de 3 ou 5 ate um determinado x
	 */
	public static int soma(int x) {
		int soma = 0;
		
		// caso especial
		if(x == 0)
			return soma;		
		
		for(int i = 1; i < x; i++) {
			int multiplo3 = 3 * i;
			int multiplo5 = 5 * i;
			
			if(multiplo3 < x && !isMultiplo5(multiplo3)) {
				soma += multiplo3;
			}
			
			if(multiplo5 < x) {
				soma += multiplo5;
			}
		}
		
		return soma;
	}
	
	/**
	 * funcao que verificar se uma numero eh multiplo de 5
	 * @param n numero a ser verificado
	 * @return retorna true ou false dependendo se o numero eh multiplo ou nao
	 */
	private static boolean isMultiplo5(int n) {
		return n % 5 == 0;
	}
}
