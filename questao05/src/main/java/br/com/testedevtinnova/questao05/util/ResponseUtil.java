package br.com.testedevtinnova.questao05.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
	
	/**
	 * Metodo utilitario para facilitar a criacao de um map para as respostas em json
	 * @param status
	 * @param mensagem
	 * @param erro
	 * @return
	 */
	public static ResponseEntity<Object> generate(HttpStatus status, String mensagem, boolean erro) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("erro", erro);		
		map.put("mensagem", mensagem);
		
		return new ResponseEntity<Object>(map,status);
	}
}
