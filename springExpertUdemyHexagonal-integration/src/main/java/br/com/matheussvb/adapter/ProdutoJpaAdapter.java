package br.com.matheussvb.adapter;

import br.com.matheussvb.entity.ProdutoEntity;
import br.com.matheussvb.model.ProdutoDTO;
import br.com.matheussvb.port.driven.ProdutoJpaPort;
import br.com.matheussvb.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Type;
import java.util.List;

@Service("ProdutoJpaAdapter")
public class ProdutoJpaAdapter implements ProdutoJpaPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        final ProdutoEntity p = produtoRepository.save(modelMapper.map(produtoDTO, ProdutoEntity.class));
        return ProdutoDTO.builder()
                .descricao(p.getDescricao())
                .id(p.getId())
                .preco(p.getPreco())
                .build();
    }

    @Override
    public ProdutoDTO getById(Integer id) {
        ProdutoEntity p = produtoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado")
        );
        return ProdutoDTO.builder()
                .preco(p.getPreco())
                .id(p.getId())
                .descricao(p.getDescricao())
                .build();
    }

    @Override
    public List<ProdutoDTO> findAll(ProdutoDTO produtoDTO) {
        ProdutoEntity p = modelMapper.map(produtoDTO, ProdutoEntity.class);
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(p, matcher);
        Type type = new TypeToken<List<ProdutoDTO>>() {
        }.getType();
        return modelMapper.map(produtoRepository.findAll(example), type);
    }

    @Override
    public void update(ProdutoDTO produtoDTO) {
        produtoRepository.save(modelMapper.map(produtoDTO, ProdutoEntity.class));
    }

    @Override
    public void deletar(ProdutoDTO produtoDTO) {
        produtoRepository.delete(modelMapper.map(produtoDTO, ProdutoEntity.class));
    }


}
