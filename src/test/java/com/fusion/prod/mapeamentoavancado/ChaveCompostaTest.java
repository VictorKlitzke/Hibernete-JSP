package com.fusion.prod.mapeamentoavancado;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.fusion.prod.ConsultarTest;
import com.fusion.prod.model.Cliente;
import com.fusion.prod.model.ItemsPedido;
import com.fusion.prod.model.Pedido;
import com.fusion.prod.model.Produto;
import com.fusion.prod.model.StatusPedido;

public class ChaveCompostaTest extends ConsultarTest {

  @Test
  public void SalvarItem() {

    entityManager.getTransaction().begin();

    Cliente cliente = entityManager.find(Cliente.class, 2);

    Produto produto = entityManager.find(Produto.class, 1);

    Pedido pedido = new Pedido();

    pedido.setCliente(cliente);
    pedido.setDataPedido(LocalDateTime.now());
    pedido.setDescricao("Teste do teste");
    pedido.setStatus(StatusPedido.AGUARDANDO);

    ItemsPedido itemPedido = new ItemsPedido();

    itemPedido.setPedido(pedido);
    itemPedido.setPreco_unidade(produto.getPreco());
    itemPedido.setQuantidade(1);
    itemPedido.setProduto(produto);

    entityManager.persist(pedido);
    entityManager.persist(itemPedido);
    entityManager.getTransaction().commit();

    entityManager.clear();

    Pedido pedidoVerfica = entityManager.find(Pedido.class, pedido.getId());
    Assert.assertNotNull(pedidoVerfica);
    Assert.assertFalse(pedidoVerfica.getItens().isEmpty());

  }
}
