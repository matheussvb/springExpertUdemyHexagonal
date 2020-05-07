package br.com.matheussvb.adapter;

import br.com.matheussvb.entity.ClienteEntity;
import br.com.matheussvb.entity.ItemPedidoEntity;
import br.com.matheussvb.entity.PedidoEntity;
import br.com.matheussvb.entity.ProdutoEntity;
import br.com.matheussvb.exception.RegraNegocioException;
import br.com.matheussvb.model.ClienteDTO;
import br.com.matheussvb.model.ProdutoDTO;
import br.com.matheussvb.model.StatusPedido;
import br.com.matheussvb.model.pedido.PedidoRequestDTO;
import br.com.matheussvb.model.pedido.PedidoResponseDTO;
import br.com.matheussvb.model.pedido.itempedido.InformacaoPedidoDTO;
import br.com.matheussvb.model.pedido.itempedido.ItemPedidoDTO;
import br.com.matheussvb.port.driven.PedidoJpaPort;
import br.com.matheussvb.repository.ClienteRepository;
import br.com.matheussvb.repository.ItemPedidoRepository;
import br.com.matheussvb.repository.PedidoRepository;
import br.com.matheussvb.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service("PedidoJpaAdapter")
public class PedidoJpaAdapter implements PedidoJpaPort {


    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteJpaAdapter clienteJpaAdapter;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoJpaAdapter produtoJpaAdapter;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public PedidoResponseDTO save(PedidoRequestDTO pedidoRequestDTO) {
        ClienteDTO clienteDTO = clienteJpaAdapter.getClienteById(pedidoRequestDTO.getCliente());
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(clienteDTO.getNome());
        clienteEntity.setCpf(clienteDTO.getCpf());
        clienteEntity.setId(clienteDTO.getId());

        Type type = new TypeToken<Set<PedidoEntity>>() {}.getType();

        Set<PedidoEntity> pedEntitys = modelMapper.map(clienteDTO.getPedidos(), type);
        clienteEntity.setPedidos(pedEntitys);


        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setTotal(pedidoRequestDTO.getTotal());
        pedidoEntity.setDataPedido(LocalDate.now());
        pedidoEntity.setCliente(clienteEntity);
        pedidoEntity.setStatus(StatusPedido.REALIZADO);

        List<ItemPedidoEntity> itemPedidoEntities = converterItens(pedidoEntity, pedidoRequestDTO.getItens());

        pedidoRepository.save(pedidoEntity);
        itemPedidoRepository.saveAll(itemPedidoEntities);
        pedidoEntity.setItens(itemPedidoEntities);

//        Type type1 = new TypeToken<List<ItemPedidoDTO>>() {}.getType();
//        Set<ItemPedidoDTO> itensPedidoDTO = modelMapper.map(pedEntitys, type1);

        return PedidoResponseDTO.builder()
                .id(pedidoEntity.getId())
                .total(pedidoEntity.getTotal())
                .status(StatusPedido.REALIZADO)
                .dataPedido(pedidoEntity.getDataPedido())
                .cliente(clienteDTO)
//                .itens(itensPedidoDTO)
                .build();

    }

    @Override
    public InformacaoPedidoDTO obterPedidoCompleto(Integer id) {
        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findByIdFetchItens(id);
        System.out.println(pedidoEntity);
        return null;
    }


    private List<ItemPedidoEntity> converterItens(PedidoEntity pedido, List<ItemPedidoDTO> items) {
        if (items.isEmpty()) {
            throw new RegraNegocioException("Não é possível realizar um pedido sem itens.");
        }
        return items.stream()
                .map(itemPedidoDTOItemIndividual -> {
                    Integer idProduto = itemPedidoDTOItemIndividual.getProduto();
                    ProdutoDTO produtoDTO = produtoJpaAdapter.getById(idProduto);
                    ProdutoEntity produtoEntity = modelMapper.map(produtoDTO, ProdutoEntity.class);

                    ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();
                    itemPedidoEntity.setPedido(pedido);
                    itemPedidoEntity.setProduto(produtoEntity);
                    itemPedidoEntity.setQuantidade(itemPedidoDTOItemIndividual.getQuantidade());
                    return itemPedidoEntity;
                }).collect(Collectors.toList());
    }
}
