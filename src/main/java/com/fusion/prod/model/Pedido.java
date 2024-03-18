package com.fusion.prod.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

  @Column(name = "idPedidos")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String Descricao;

  @Enumerated(EnumType.STRING)
  private StatusPedido status;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_clientes")
  private Cliente cliente;

  @OneToMany(mappedBy = "pedido")
  private List<ItemsPedido> itens;

  public List<ItemsPedido> getItens() {
    return itens;
  }

  public void setItens(List<ItemsPedido> itens) {
    this.itens = itens;
  }

  @Column(name = "data_pedido")
  private LocalDateTime dataPedido;

  public LocalDateTime getDataPedido() {
    return dataPedido;
  }

  public void setDataPedido(LocalDateTime dataPedido) {
    this.dataPedido = dataPedido;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public StatusPedido getStatus() {
    return status;
  }

  public void setStatus(StatusPedido status) {
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescricao() {
    return Descricao;
  }

  public void setDescricao(String descricao) {
    Descricao = descricao;
  }
}
