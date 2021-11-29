package br.com.testedevtinnova.questao05.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.testedevtinnova.questao05.interfaces.InterfaceGenerica;
import br.com.testedevtinnova.questao05.polimorfismo.ResultadoPesquisa;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class VeiculoEntity extends ResultadoPesquisa implements InterfaceGenerica {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String marca;
	
	private int ano;
	
	private String descricao;
	
	private boolean vendido;
	
	@CreatedDate
	private Instant created;
	
	@LastModifiedDate
	private Instant updated;

	public VeiculoEntity() {
	}
	
	public VeiculoEntity(String nome, String marca, int ano, String descricao, boolean vendido) {
		this.nome = nome;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public Instant getUpdated() {
		return updated;
	}

	public void setUpdated(Instant updated) {
		this.updated = updated;
	}
}
