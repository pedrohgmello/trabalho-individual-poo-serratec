package Exercicio03;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {
    private List<ItemPedido> itens;
    private BigDecimal total;

    public void fecharPedido(){
        BigDecimal total = new BigDecimal("0.00");
        System.out.println("==================");
        System.out.println("RECIBO DO PEDIDO");
        System.out.println("==================");
        System.out.println();
        for(ItemPedido item : itens){
            System.out.println(item.getNome() + " - R$ " + item.getPreco());
            total = total.add(item.getPreco());
        }
        if(total.compareTo(new BigDecimal("250.00")) > 0){
            System.out.println();
            System.out.println("==================");
            this.total = total;
        }
        else{
            System.out.println("Frete - R$ 25.00");
            System.out.println();
            System.out.println("==================");
            this.total = total.add(new BigDecimal("25.00"));
        }
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
