package br.com.testedevtinnova.questao05.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.com.testedevtinnova.questao05.entity.VeiculoEntity;
import br.com.testedevtinnova.questao05.interfaces.PesquisaVeiculoPorFabricante;
import br.com.testedevtinnova.questao05.interfaces.PesquisarVeiculoPorDecada;

public interface VeiculoRepository extends CrudRepository<VeiculoEntity, Long> {
	@Query(value = "SELECT * FROM veiculo_entity WHERE vendido=?1", nativeQuery = true)
	List<VeiculoEntity> findAllStatusVendido(boolean isVendido);
	
	@Query(value = "SELECT v.decada as anoDecada,count(*) as quantidade from (select (ano - mod(ano, 10)) as decada FROM veiculo_entity) as v group by (v.decada)", nativeQuery = true)
	List<PesquisarVeiculoPorDecada> countVeiculosByDecada();
	
	@Query(value = "SELECT marca AS marca, count(*) as quantidade FROM veiculo_entity GROUP BY (marca)", nativeQuery = true)
	List<PesquisaVeiculoPorFabricante> countFabricanteByMarca();
	
	@Query(value = "SELECT * FROM veiculo_entity WHERE created between ?1 and ?2", nativeQuery = true)
	List<VeiculoEntity> findAllVeiculosRegistradosUltimaSemana(LocalDate ultimoDomingo, LocalDate ultimoSabado);
}
