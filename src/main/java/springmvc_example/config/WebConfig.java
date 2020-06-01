package springmvc_example.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="springmvc_example")
public class WebConfig extends WebMvcConfigurerAdapter {
    
     @Autowired
     DataSource dataSource;
     
     @Bean
     public NamedParameterJdbcTemplate getNameParameterJdbcTemplate() {
    	 return new NamedParameterJdbcTemplate(dataSource);
     }
     
     @Bean
     public DataSource getDataSource() throws NamingException {
    	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	 dataSource.setUrl("jdbc:mysql://localhost:3306/DB1");
    	 dataSource.setUsername("root");
    	 dataSource.setPassword("1234");
    	 return dataSource;
     }
     
     @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	 registry.addResourceHandler("/resources/***").addResourceLocations("/resources");
     }
     @Bean
     public InternalResourceViewResolver viewResolver() {
    	 InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    	 viewResolver.setViewClass(JstlView.class);
    	 viewResolver.setPrefix("/WEB-INF/jsp/");
    	 viewResolver.setSuffix(".jsp");
    	 return viewResolver;
     }
     
     
}
