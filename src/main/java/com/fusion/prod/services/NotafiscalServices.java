package com.fusion.prod.services;

import com.fusion.prod.model.Pedido;

public class NotafiscalServices {

  public void gerarNota(Pedido pedido) {

    System.out.println("Gerando nota para o pedido " + pedido.getId() + ".");

  }
}
