package br.com.matheussvb.adapter;

import br.com.matheussvb.entity.ClienteEntity;
import br.com.matheussvb.entity.ItemPedidoEntity;
import br.com.matheussvb.entity.PedidoEntity;
import br.com.matheussvb.exception.ClienteNotFoundException;
import br.com.matheussvb.model.ClienteDTO;
import br.com.matheussvb.model.pedido.PedidoDTO;
import br.com.matheussvb.model.pedido.itempedido.ItemPedidoDTO;
import br.com.matheussvb.port.driven.ClienteJpaPort;
import br.com.matheussvb.repository.ClienteRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("ClienteJpaAdapter")
public class ClienteJpaAdapter implements ClienteJpaPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteDTO getClienteById(final Integer id) {
        ClienteEntity c = clienteRepository.findById(id)
                .orElseThrow(
                        () -> new ClienteNotFoundException("Cliente não encontrado")
                );

        List<PedidoDTO> lista = new ArrayList<>();


        for(PedidoEntity pedidoEntity : c.getPedidos()){
            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setCliente(pedidoEntity.getCliente().getId());
            pedidoDTO.setTotal(pedidoEntity.getTotal());
            for(ItemPedidoEntity itemPedidoEntity : pedidoEntity.getItens()){
                ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
                itemPedidoDTO.setProduto(Integer.valueOf());
                pedidoDTO.setItens(pedidoEntity.getItens());
            }
        }

        CollectionUtils.addAll(lista, c.getPedidos());

;        for(PedidoDTO pedidoDTO : c.getPedidos()){

        }

        PedidoDTO pedidoDTO = PedidoDTO.builder()
                .itens(c.getPedidos())



        return ClienteDTO.builder()
                .nome(c.getNome())
                .cpf(c.getCpf())
                .id(c.getId())
                .pedidos(pedidosDtoSet)
                .build();
    }

    @Override
    public ClienteDTO save(final ClienteDTO cliente) {
        final ClienteEntity c = clienteRepository.save(modelMapper.map(cliente, ClienteEntity.class));
        return ClienteDTO.builder()
                .id(c.getId())
                .cpf(c.getCpf())
                .nome(c.getNome())
                .build();
    }

    @Override
    public void deletar(Integer id) {
        clienteRepository.findById(id).
                map(clienteEntity -> {
                    this.clienteRepository.delete(clienteEntity);
                    return clienteEntity;
                }).orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado"));
    }

    @Override
    public void update(ClienteDTO cliente) {
        final ClienteEntity c = modelMapper.map(cliente, ClienteEntity.class);
        clienteRepository.save(c);
    }

    @Override
    public List<ClienteDTO> findAll(ClienteDTO cliente) {
        ClienteEntity c = modelMapper.map(cliente, ClienteEntity.class);
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(c, matcher);

        Type listType = new TypeToken<List<ClienteDTO>>() {}.getType();
        return modelMapper.map(clienteRepository.findAll(example), listType);

    }
}
