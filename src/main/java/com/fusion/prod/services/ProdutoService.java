package com.fusion.prod.services;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.inject.Inject;

import com.fusion.prod.model.Produto;
import com.fusion.prod.repository.Produtos;

import jakarta.transaction.Transactional;

public class ProdutoService implements Serializable {

  @Inject
  private Produtos produtos;

  @Transactional
  public Produto salvar(Produto produto) {
    if (produto.getId() == 0) {
      produto.setDatatime(LocalDateTime.now());
    } else {
      produto.setDatatime(LocalDateTime.now());
    }

    return produtos.salvar(produto);
  }

  public Produto atualizar(Produto produto) {

  }
}
