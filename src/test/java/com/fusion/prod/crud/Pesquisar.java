package com.fusion.prod.crud;

import org.junit.Assert;
import org.junit.Test;

import com.fusion.prod.ConsultarTest;
import com.fusion.prod.model.Cliente;
import com.fusion.prod.model.Pedido;
import com.fusion.prod.model.StatusPedido;

public class Pesquisar extends ConsultarTest {

  @Test
  public void Pesquisar() {
    Cliente cliente = entityManager.find(Cliente.class, 1);

    Assert.assertNotNull(cliente);
    Assert.assertEquals("Fernando Medeiros", cliente.getNome());
  }

  @Test
  public void Insert() {

    Cliente cliente = entityManager.find(Cliente.class, 5);

    Pedido pedido = new Pedido();

    pedido.setStatus(StatusPedido.CANCELADO);

    if (StatusPedido.CANCELADO != StatusPedido.CANCELADO) {
      System.out.println("Não é possivel fazer a inserção: " + pedido.getDescricao());
    } else {

      pedido.setDescricao("Fanta Laranja");

      pedido.setCliente(cliente);

      entityManager.getTransaction().begin();
      entityManager.persist(pedido);
      entityManager.getTransaction().commit();

      entityManager.clear();

      Pedido VerificarPedido = entityManager.find(Pedido.class, pedido.getId());
      Assert.assertNotNull(VerificarPedido);

    }

  }

  @Test
  public void InsertCliente() {

    Cliente cliente = new Cliente();

    cliente.setNome("null");

    entityManager.getTransaction().begin();
    entityManager.persist(cliente);
    entityManager.getTransaction().commit();

    Cliente VerificarCliente = entityManager.find(Cliente.class, cliente.getId());
    Assert.assertNotNull(VerificarCliente);

  }

}
