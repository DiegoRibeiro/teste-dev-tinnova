package br.com.testedevtinnova.questao01;

import java.text.DecimalFormat;

import br.com.testedevtinnova.questao01.model.Urna;

public class Main {
	
	public static void main(String[] args) {
		int totalEleitores = 1000;
		int validos = 800;
		int votosBrancos = 150;
		int nulos = 50;
		
		Urna urna = new Urna(totalEleitores);
		
		// usando o formatter para gerar o resultado com duas casas de precisão
		DecimalFormat formatter = new DecimalFormat( "#.##" );
		
		System.out.println("percentual votos válidos: " + formatter.format(urna.calculaPercentualVotosValidos(validos) * 100) + "%.");
		System.out.println("percentual votos em branco: " + formatter.format(urna.calculaPercentualVotosBrancos(votosBrancos) * 100) + "%");
		System.out.println("percentual votos nulos: " + formatter.format(urna.calculaPercentualVotosNulos(nulos) * 100) + "%");
	}

}
