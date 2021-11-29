package br.com.testedevtinnova.questao02;

import br.com.testedevtinnova.questao02.sort.BubbleSort;
import br.com.testedevtinnova.questao02.util.VetorUtil;

public class Main {
	public static void main(String[] args) {
		int v[] = {5, 3, 2, 4, 7, 1, 0, 6};
		
		System.out.println("Antes da ordenação: " + VetorUtil.print(v));
		
		BubbleSort.sort(v);
		
		System.out.println("Vetor ordenado: " + VetorUtil.print(v));
	}
}
