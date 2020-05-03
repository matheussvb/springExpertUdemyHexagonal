package br.com.matheussvb.controller;

import br.com.matheussvb.model.ProdutoDTO;
import br.com.matheussvb.model.RestResponse;
import br.com.matheussvb.model.produto.ProdutoRequest;
import br.com.matheussvb.model.produto.ProdutoResponse;
import br.com.matheussvb.port.driver.ProdutoPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoPort produtoPort;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(CREATED)
    public RestResponse<ProdutoResponse> save(@RequestBody @Valid ProdutoRequest produtoRequest) {
        ProdutoDTO produtoSalvo = produtoPort.save(modelMapper.map(produtoRequest, ProdutoDTO.class));
        return new RestResponse<>(ProdutoResponse.builder()
                .descricao(produtoSalvo.getDescricao())
                .id(produtoSalvo.getId())
                .preco(produtoSalvo.getPreco())
                .build());
    }

    @GetMapping("/{id}")
    public RestResponse<ProdutoResponse> getById(@PathVariable Integer id) {
        ProdutoDTO produto = produtoPort.getById(id);
        return new RestResponse<>(ProdutoResponse.builder()
                .descricao(produto.getDescricao())
                .id(produto.getId())
                .preco(produto.getPreco())
                .build());
    }

    @GetMapping
    public RestResponse<List<ProdutoResponse>> find(ProdutoRequest produtoRequest) {
        List<ProdutoDTO> all = produtoPort.findAll(modelMapper.map(produtoRequest, ProdutoDTO.class));
        List<ProdutoResponse> response = all.stream().map(
                prod -> ProdutoResponse.builder()
                        .preco(prod.getPreco())
                        .id(prod.getId())
                        .descricao(prod.getDescricao())
                        .build()

        ).collect(Collectors.toList());
        return new RestResponse<>(response);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid ProdutoRequest produtoRequest) {
        ProdutoDTO produtoDTO = ProdutoDTO.builder()
                .descricao(produtoRequest.getDescricao())
                .preco(produtoRequest.getPreco())
                .build();
        produtoPort.update(id, produtoDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable(value = "id") Integer id){
        produtoPort.deletar(id);
    }
}
