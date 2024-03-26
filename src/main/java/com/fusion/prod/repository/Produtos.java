package com.fusion.prod.repository;

import java.io.Serializable;
import java.util.List;

import com.fusion.prod.model.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class Produtos implements Serializable {

  @PersistenceContext
  private EntityManager entityManager;

  public Produto buscar(Integer id) {
    return entityManager.find(Produto.class, id);
  }

  public Produto salvar(Produto produto) {
    return entityManager.merge(produto);
  }

  public List<Produto> listar() {
    return entityManager
        .createQuery("select p from Produto p", Produto.class)
        .getResultList();
  }

}
