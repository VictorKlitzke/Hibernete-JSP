package com.fusion.prod.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IniciarEntity {

  public static void main(final String[] args) {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.close();
    entityManagerFactory.close();
  }

  @Override
  public String toString() {
    return "IniciarEntity []";
  }

}
