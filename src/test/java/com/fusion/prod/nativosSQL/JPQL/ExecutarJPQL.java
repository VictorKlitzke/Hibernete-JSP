package com.fusion.prod.nativosSQL.JPQL;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.Test;

import com.fusion.prod.ConsultarTest;
import com.fusion.prod.dto.ClienteDTO;
import com.fusion.prod.model.Cliente;
import com.fusion.prod.model.Pedido;

public class ExecutarJPQL extends ConsultarTest {

  @Test
  public void testExecutar() {

    TypedQuery<Pedido> typedQuery = entityManager.createQuery("SELECT p FROM Pedido p WHERE p.id = 1",
        Pedido.class);

    Pedido pedido = typedQuery.getSingleResult();
    Assert.assertNotNull(pedido);

  }

  @Test
  public void Typed() {

    String SQL = "SELECT c FROM Cliente c";
    TypedQuery<Cliente> typedQuery = entityManager.createQuery(SQL, Cliente.class);

    Cliente cliente = typedQuery.getSingleResult();
    Assert.assertNotNull(cliente);

    Query query = entityManager.createQuery(SQL);
    // Cliente cliente1 = (Cliente) query.getSingleResult();

    List<Cliente> list = query.getResultList();
    Assert.assertNotNull(list);

  }

  @Test
  public void SelecionarAtributosRetornos() {

    String SQLJPQL = "SELECT c.Nome FROM Cliente c";
    TypedQuery<String> typedQuery = entityManager.createQuery(SQLJPQL, String.class);
    List<String> list = typedQuery.getResultList();
    Assert.assertTrue(String.class.equals(list.get(0).getClass()));

    String SQLPedido = "SELECT p.cliente FROM Pedido p";
    TypedQuery<Cliente> typedQueryCliente = entityManager.createQuery(SQLPedido, Cliente.class);
    List<Cliente> listCliente = typedQueryCliente.getResultList();
    Assert.assertTrue(Cliente.class.equals(listCliente.get(0).getClass()));

  }

  @Test
  public void ProjetarResultado() {

    String PROD = "select p.id, p.Descricao, p.dataPedido from Pedido p";
    TypedQuery<Object[]> typedQueryResultado = entityManager.createQuery(PROD, Object[].class);
    List<Object[]> listCliente = typedQueryResultado.getResultList();

    Assert.assertTrue(listCliente.get(0).length == 3);

    Assert.assertNotNull(listCliente);

    for (Object[] obj : listCliente) {
      for (int i = 0; i < obj.length; i++) {
        System.out.print(obj[i]);
        if (i < obj.length - 1) {
          System.out.print(obj[0] + ", " + obj[1] + ", " + obj[2]);
        }

      }
    }
  }

  @Test
  public void dto() {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<ClienteDTO> query = criteriaBuilder.createQuery(ClienteDTO.class);
    Root<Cliente> root = query.from(Cliente.class);
  }

}
