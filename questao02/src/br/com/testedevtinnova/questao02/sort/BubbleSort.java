package br.com.testedevtinnova.questao02.sort;

public class BubbleSort {
	
	/**
	 * Ordenacao bubble sort (Complexida pior caso O(n²))
	 * @param v vetor a ser ordenado
	 */
	public static void sort(int v[]) {
		for(int i = 0; i < v.length - 1; i++) {
			for(int j = 0; j < v.length - i - 1; j++) {
				// se for maior realizar a troca
				if(v[j] > v[j+1]) {
					int aux = v[j];
					v[j] = v[j+1];
					v[j+1] = aux;
				}
			}
		}
	}
}
