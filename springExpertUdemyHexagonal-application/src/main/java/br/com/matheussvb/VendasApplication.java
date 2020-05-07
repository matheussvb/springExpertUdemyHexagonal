package br.com.matheussvb;

import br.com.matheussvb.repository.ClienteRepository;
import br.com.matheussvb.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.matheussvb")
public class VendasApplication {

    @Autowired
    ClienteRepository repositoryClientes;
    @Autowired
    PedidoRepository repositoryPedidos;

    public static void main(String[] args) {

        SpringApplication.run(VendasApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
//
//    @Bean
//    public CommandLineRunner executar() {
//        return args -> {
//            ClienteEntity cliente = new ClienteEntity();
//            cliente.setCpf("12312312");
//            cliente.setNome("Teste");
//
//            ClienteEntity cliente2 = new ClienteEntity();
//            cliente2.setCpf("123123123");
//            cliente2.setNome("Fulano");
//
//            ClienteEntity c1 = repositoryClientes.save(cliente);
//            repositoryClientes.save(cliente2);
//
//            PedidoEntity p = new PedidoEntity();
//            p.setCliente(cliente);
//            p.setDataPedido(LocalDate.now());
//            p.setTotal(BigDecimal.valueOf(1001));
//
//            PedidoEntity p2 = new PedidoEntity();
//            p2.setCliente(cliente);
//            p2.setDataPedido(LocalDate.now());
//            p2.setTotal(BigDecimal.valueOf(1002));
//
//            PedidoEntity p3 = new PedidoEntity();
//            p3.setCliente(cliente);
//            p3.setDataPedido(LocalDate.now());
//            p3.setTotal(BigDecimal.valueOf(1003));
//
//
//            PedidoEntity p1 = repositoryPedidos.save(p);
//            repositoryPedidos.save(p2);
//            repositoryPedidos.save(p3);
//
//
////            repositoryClientes.findClienteFetchPedidos(1);
////            System.out.println(cliente);
////            System.out.println(cliente.getPedidos());
//
//
//        };
//    }
}
