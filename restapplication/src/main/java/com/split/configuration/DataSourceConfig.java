package com.split.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Reference;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionDefinition;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.DefaultTransactionDefinition;




@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.split.repositories", entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
//@PropertySource("classpath:application.properties")
public class DataSourceConfig {

	/*@Autowired
	private Environment env;*/

	
	@Resource(name="jdbc/DefaultDB")
	@Bean
	public DataSource dataSource() {
		
		System.out.println("Inside datasource -----> ");
		/*String driverClassName = "com.sap.db.jdbc.Driver";
		String url = "jdbc:sap://localhost:30015";
		String dbUsername = "P1940225222";
		String dbPassword = "Apr@2018";*/
		
		
		/*DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);*/
		
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource("jdbc/DefaultDB");
		   
		return dataSource;
		
	}
	
	@Bean(name = "entityManager")
    public EntityManagerFactory  entityManagerFactory() {
		System.out.println("Inside userEntityManager -----> ");
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		Map<String, String> props = new HashMap<>();
		props.put("eclipselink.weaving","false");
		em.setJpaPropertyMap(props);
		em.setDataSource(dataSource());
		em.setJpaVendorAdapter(jpaVendorAdapter());
		em.setPackagesToScan("com.split.entity");
		em.afterPropertiesSet();
		return em.getObject();
	}
	
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
    	System.out.println("Inside JpaVendorAdapter -----> ");
        EclipseLinkJpaVendorAdapter ecliseLinkJpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
        System.out.println("JpaVendorAdapter 1***********");
        ecliseLinkJpaVendorAdapter.setShowSql(false);
        ecliseLinkJpaVendorAdapter.setGenerateDdl(false);
       
        System.out.println("Inside JpaVendorAdapter before return ");
        return ecliseLinkJpaVendorAdapter;
    }
    
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(){
    	System.out.println("transactionManager -----> ");
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(dataSource());
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        
        System.out.println("transactionManager will COMMIT NOW ");
        TransactionStatus transactionStatus=jpaTransactionManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        jpaTransactionManager.commit(transactionStatus);
        System.out.println("DatasourceConfig transactionStatus is  " +transactionStatus);
        
        return jpaTransactionManager;
    }
	
}
