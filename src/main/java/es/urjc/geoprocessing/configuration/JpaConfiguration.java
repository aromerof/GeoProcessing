package es.urjc.geoprocessing.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "es.urjc.geoprocessing.dao")
@PropertySource(value = "classpath:db.properties")
public class JpaConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    @Autowired
    public JpaTransactionManager transactionManager() {
        JpaDialect dialect = new HibernateJpaDialect();

        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory());
        manager.setJpaDialect(dialect);

        return manager;
    }

    @Bean
    @Autowired
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(Boolean.getBoolean(environment.getProperty("jpa.generate_ddl")));
        adapter.setShowSql(Boolean.getBoolean(environment.getProperty("jpa.show_sql")));
        adapter.setDatabasePlatform(environment.getProperty("jpa.dialect"));

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(adapter);
        factory.setJpaProperties(additionalProperties());
        factory.setPackagesToScan("es.urjc.geoprocessing.model");
        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());

        return factory.getObject();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.jdbc.batch_size", environment.getProperty("hibernate.jdbc.batch_size"));
        properties.setProperty("hibernate.order_inserts", environment.getProperty("hibernate.order_inserts"));
        properties.setProperty("hibernate.order_updates", environment.getProperty("hibernate.order_updates"));
        properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", environment.getProperty("hibernate.temp.use_jdbc_metadata_defaults"));
        properties.setProperty("hibernate.jdbc.use_get_generated_keys", environment.getProperty("hibernate.jdbc.use_get_generated_keys"));
        properties.setProperty("hibernate.jdbc.use_scrollable_resultset", environment.getProperty("hibernate.jdbc.use_scrollable_resultset"));
        properties.setProperty("reWriteBatchedInserts", environment.getProperty("reWriteBatchedInserts"));

        return properties;
    }

    @Bean
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        hikariDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        hikariDataSource.setUsername(environment.getProperty("jdbc.username"));
        hikariDataSource.setPassword(environment.getProperty("jdbc.password"));
        hikariDataSource.setConnectionTestQuery("SELECT 1");
        hikariDataSource.setPoolName("GeoProcessing-HikariDataSource");
        hikariDataSource.setMaximumPoolSize(NumberUtils.toInt(environment.getProperty("hikari.maximumPoolSize"), 30));
        hikariDataSource.setIdleTimeout(NumberUtils.toLong(environment.getProperty("hikari.idleTimeout"), 12000));

        return hikariDataSource;
    }
}
