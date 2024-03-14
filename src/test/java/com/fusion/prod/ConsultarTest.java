package com.fusion.prod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fusion.prod.model.Cliente;

public class ConsultarTest {

  protected static EntityManagerFactory entityManagerFactory;
  protected EntityManager entityManager;

  @BeforeClass
  public static void setUpBeforeClass() {
    entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
  }

  @AfterClass
  public static void tearDownAfterClass() {
    entityManagerFactory.close();
  }

  @Before
  public void setUp() {
    entityManager = entityManagerFactory.createEntityManager();
  }

  @After
  public void tearDown() {
    entityManager.close();
  }

  @Test
  public void Search() {
    Cliente cliente = entityManager.find(Cliente.class, 2);

    Assert.assertNotNull(cliente);
    Assert.assertEquals("Testando", cliente.getNome());
  }

}
