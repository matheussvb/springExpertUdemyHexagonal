package br.com.matheussvb.service;

import br.com.matheussvb.model.ProdutoDTO;
import br.com.matheussvb.port.driven.ProdutoJpaPort;
import br.com.matheussvb.port.driver.ProdutoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProdutoAdapter")
public class ProdutoAdapter implements ProdutoPort {

    @Autowired
    private ProdutoJpaPort produtoJpaPort;

    @Override
    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        return produtoJpaPort.save(produtoDTO);
    }

    @Override
    public ProdutoDTO getById(Integer id) {
        return produtoJpaPort.getById(id);
    }

    @Override
    public List<ProdutoDTO> findAll(ProdutoDTO produtoDTO) {
        return produtoJpaPort.findAll(produtoDTO);
    }

    @Override
    public void update(Integer id, ProdutoDTO produtoDTO) {
        ProdutoDTO produtoExists = produtoJpaPort.getById(id);
        produtoDTO.setId(produtoExists.getId());
        produtoJpaPort.update(produtoDTO);
    }

    @Override
    public void deletar(final Integer id) {
        ProdutoDTO produto = produtoJpaPort.getById(id);
        produtoJpaPort.deletar(produto);
    }
}
