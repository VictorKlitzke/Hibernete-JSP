package com.fusion.prod.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

public class NotaFiscal extends EntityMapsId {

  @Column(name = "data")
  private Date dataEm;

  @MapsId
  @OneToOne(optional = false)
  @JoinColumn(name = "pedido_id", nullable = false)
  private Pedido pedido;

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public Date getDataEm() {
    return dataEm;
  }

  public void setDataEm(Date dataEm) {
    this.dataEm = dataEm;
  }
}
