package Exercicio03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EcommerceMain {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Pedro", "161.173.597-13", "pedro@gmail.com");
        ItemPedido item1 = new ItemPedido();
        item1.setNome("OMO");
        item1.setPreco(new BigDecimal("12.00"));
        ItemPedido item2 = new ItemPedido();
        item2.setNome("Porta Retratos");
        item2.setPreco(new BigDecimal("24.00"));
        Pedido pedido = new Pedido();
        cliente.setPedidos(List.of(pedido));
        List<ItemPedido> lista = new ArrayList<>();
        lista.add(item1);
        lista.add(item2);
        pedido.setItens(lista);
        pedido.fecharPedido();
    }
}
