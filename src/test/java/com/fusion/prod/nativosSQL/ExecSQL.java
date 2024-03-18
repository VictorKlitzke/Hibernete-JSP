package com.fusion.prod.nativosSQL;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.fusion.prod.ConsultarTest;

public class ExecSQL extends ConsultarTest {

  @Test
  public void SQLCliente() {

    String sql = "SELECT * FROM " + "items_pedidos";
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
