package br.com.matheussvb.port.driver;

import br.com.matheussvb.model.ProdutoDTO;

import java.util.List;

public interface ProdutoPort {

    ProdutoDTO save(ProdutoDTO produtoDTO);
    ProdutoDTO getById(Integer id);
    List<ProdutoDTO> findAll(ProdutoDTO produtoDTO);
    void update(Integer id, ProdutoDTO produtoDTO);
    void deletar(Integer id);
}
