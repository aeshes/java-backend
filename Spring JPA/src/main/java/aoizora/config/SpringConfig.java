package aoizora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("aoizora")
@EnableTransactionManagement
public class SpringConfig {

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean emfb =
                new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("test-jpa-unit");
        return emfb;
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new JpaTransactionManager();
    }
}
