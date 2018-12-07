package main.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import main.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("application.properties")
public class HibernateConfig {

    @Value("${datasource.driver}")
    private String driver;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlauto;

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource source) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(source);
        sessionFactory.setPackagesToScan("main.domain");
        Properties props = new Properties();
        props.setProperty("dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        sessionFactory.setHibernateProperties(props);
        return sessionFactory;
    }

    @Bean
    public DataSource configureDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        return new HikariDataSource(config);
    }


    @Bean
    public HibernateTransactionManager hibernateTransactionManager(){
        return new HibernateTransactionManager(sessionFactory(configureDataSource()).getObject());
    }

    @Bean
    public UserRepository userRepository(SessionFactory sessionFactory) {
        return new UserRepository(sessionFactory);
    }
}
