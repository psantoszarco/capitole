package com.project.multi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.project.multi.repository.custom.CustomProductRepositoryImpl;


@Configuration
@EntityScan("com.project.multi.entities")
@EnableJpaRepositories(value = "com.project.multi.repository", repositoryBaseClass = CustomProductRepositoryImpl.class)
@EnableTransactionManagement
public class JpaConfig extends HibernateJpaAutoConfiguration {
	
	/**
	 * Instantiates a new persistence config.
	 *
	 * @param dataSource the data source
	 * @param jpaProperties the jpa properties
	 * @param jtaTransactionManagerProvider the jta transaction manager provider
	 * @param transactionManagerCustomizers the transaction manager customizers
	 */
	public JpaConfig(DataSource dataSource, JpaProperties jpaProperties,
			ObjectProvider<JtaTransactionManager> jtaTransactionManagerProvider,
			ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
		super(dataSource, jpaProperties, jtaTransactionManagerProvider, transactionManagerCustomizers);
	}
}

