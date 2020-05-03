package br.com.matheussvb.port.driven;

import br.com.matheussvb.model.ProdutoDTO;

import java.util.List;

public interface ProdutoJpaPort {

    ProdutoDTO save(ProdutoDTO produtoDTO);

    ProdutoDTO getById(Integer id);

    List<ProdutoDTO> findAll(ProdutoDTO produtoDTO);

    void update(ProdutoDTO produtoDTO);

    void deletar(ProdutoDTO produtoDTO);
}
