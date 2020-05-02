package br.com.matheussvb.repository;

import br.com.matheussvb.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

//    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
//    List<Cliente> encontrarPorNome(@Param("nome") String nome);
//
//    @Query(" delete from Cliente c where c.nome =:nome ")
//    @Modifying
//    void deleteByNome(String nome);
//
//    boolean existsByNome(String nome);

//    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id  ")
//    Cliente findClienteFetchPedidos(@Param("id") Integer id);

}

