package com.fusion.prod.spring.config;

import javax.persistence.EntityManagerFactory;

import org.spring.context.annotation.Bean;
import org.spring.orm.jpa.JpaTransactionManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Setter
@EnableTransactionManagement
@Configuration
public class JpaConfig {

    @Bean
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();

        bean.setPersistenceUnitName("Ecommerce-PU");
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return bean;
    }
}
