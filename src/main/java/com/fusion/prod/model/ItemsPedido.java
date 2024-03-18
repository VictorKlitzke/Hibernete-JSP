package com.fusion.prod.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items_pedidos")
public class ItemsPedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "pedido_id")
  private Pedido pedido;

  @ManyToOne(optional = false)
  @JoinColumn(name = "produto_id")
  private Produto produto;

  @Column(name = "preco_unidade")
  private BigDecimal preco_unidade;

  private Integer quantidade;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Produto getProduto() {
    return produto;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public BigDecimal getPreco_unidade() {
    return preco_unidade;
  }

  public void setPreco_unidade(BigDecimal preco_unidade) {
    this.preco_unidade = preco_unidade;
  }
}
