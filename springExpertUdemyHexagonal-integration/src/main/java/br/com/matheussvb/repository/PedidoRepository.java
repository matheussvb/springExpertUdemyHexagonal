package br.com.matheussvb.repository;

import br.com.matheussvb.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    @Query("select p from PedidoEntity p left join fetch p.itens where p.id = :id")
    Optional<PedidoEntity> findByIdFetchItens(@Param("id") Integer id);
}
