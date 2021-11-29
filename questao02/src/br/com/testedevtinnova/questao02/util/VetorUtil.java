package br.com.testedevtinnova.questao02.util;

public class VetorUtil {
	/**
	 * Funcao utilitaria para imprimir um vetor na saida padrao do java
	 * @param v vetor de qualquer dimensao
	 * @return representacao em string do vetor
	 */
	public static String print(int v[]) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("v = {");
		
		for(int i = 0; i < v.length - 1; i++) {
			sb.append(v[i]).append(", ");
		}
		
		sb.append(v[v.length - 1]).append("}");
		
		return sb.toString();
	}
}
