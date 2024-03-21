package com.fusion.prod.nativosSQL;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.fusion.prod.ConsultarTest;

public class ExecSQL extends ConsultarTest {

  @Test
  public void SQLCliente() {

    String sql = "SELECT it.id AS item_id, p.id AS produto_id, p.nome AS produto_nome FROM items_pedido it INNER JOIN produto p ON it.produto_id = p.id";
    Query query = entityManager.createNativeQuery(sql);

    List<Object[]> lista = query.getResultList();

    for (Object[] obj : lista) {
      for (int i = 0; i < obj.length; i++) {
        System.out.print(obj[i]);
        if (i < obj.length - 1) {
          System.out.print(", ");
        }
      }
    }
  }
}
