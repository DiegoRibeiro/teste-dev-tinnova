package br.com.testedevtinnova.questao04;

import java.util.Scanner;

import br.com.testedevtinnova.questao04.model.Multiplo;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite um número natural para o cálculo da soma dos multiplos de 3 ou 5:");
		int x = scanner.nextInt();
		
		System.out.println("O somatório é: "+ Multiplo.soma(x));
		scanner.close();
	}
}
