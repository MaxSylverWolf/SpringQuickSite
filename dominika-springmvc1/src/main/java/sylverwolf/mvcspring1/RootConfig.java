package sylverwolf.mvcspring1;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.spi.PersistenceProvider;
import javax.servlet.FilterRegistration;
import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by szkolenia on 2017-07-07.
 */

@EnableTransactionManagement
@EnableJpaRepositories(transactionManagerRef = "jtm", entityManagerFactoryRef = "lcemf", basePackages = "sylverwolf.mvcspring1.repository")
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "sylverwolf")
public class RootConfig {


    @Bean
    public SpringResourceTemplateResolver srtr() {
        SpringResourceTemplateResolver springr = new SpringResourceTemplateResolver();
        springr.setPrefix("/WEB-INF/views/");
        springr.setSuffix(".html");
        springr.setCharacterEncoding("UTF-8");
        springr.setTemplateMode(TemplateMode.HTML);
        return springr;
    }

    @Bean
    public SpringTemplateEngine ste(SpringResourceTemplateResolver srtr) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(srtr);
        return engine;
    }

    @Bean
    public ThymeleafViewResolver tvr(SpringTemplateEngine ste) {
        ThymeleafViewResolver restvr = new ThymeleafViewResolver();
        restvr.setTemplateEngine(ste);
        return restvr;
    }

    @Bean
    public DataSource ds()  {
        HikariConfig hc = new HikariConfig();

        hc.setJdbcUrl("jdbc:mysql://localhost:3306/ludziki");

      //  hc.setDataSourceClassName("com.mysql.jdbc.Driver");
       hc.addDataSourceProperty("serverName", "localhost");
       hc.addDataSourceProperty("port",3306);
       hc.addDataSourceProperty("databaseName","ludziki");
       // hc.setUsername("root");
       // hc.setPassword("");
        hc.addDataSourceProperty("user", "root");
        hc.addDataSourceProperty("password", "");
        hc.addDataSourceProperty("cachePrepStmts", "true");
        hc.addDataSourceProperty("prepStmtCacheSize", "250");
        hc.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        hc.setDriverClassName("com.mysql.jdbc.Driver");
        return new HikariDataSource(hc);

    }


    @Bean
    public HibernateJpaVendorAdapter hjva() {
        HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        hjva.setDatabase(Database.MYSQL);
        return hjva;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean lcemf(DataSource ds, HibernateJpaVendorAdapter hjva) {
        LocalContainerEntityManagerFactoryBean lcemf = new LocalContainerEntityManagerFactoryBean();
        lcemf.setDataSource(ds);
        lcemf.setJpaVendorAdapter(hjva);
        lcemf.setPackagesToScan("sylverwolf.mvcspring1.entity");
        return lcemf;
    }

    @Bean
    JpaTransactionManager jtm(EntityManagerFactory lcemf) {
        JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setEntityManagerFactory(lcemf);
        return jtm;
    }

    public class BootStraped extends WebMvcConfigurerAdapter {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {

            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }

}
