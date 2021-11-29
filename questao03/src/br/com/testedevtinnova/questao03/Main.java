package br.com.testedevtinnova.questao03;

import java.util.Scanner;

import br.com.testedevtinnova.questao03.model.Fatorial;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		do {
			System.out.println("Digite um número natural para cálculo do fatorial:");
			n = scanner.nextInt();
			
			if(n < 0)
				System.out.println("Por favor entre com um número natural");
		} while(n < 0);
		System.out.println("O fatorial de " + n + " = " + Fatorial.calcula(n));
		
		scanner.close();
	}
}
