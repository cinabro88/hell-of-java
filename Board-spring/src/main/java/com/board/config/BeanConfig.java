package com.board.config;

import com.board.repository.BoardRepository;
import com.board.repository.MemberRepository;
import com.board.service.BoardService;
import com.board.service.LoginService;
import com.board.service.MemberService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by mingook on 2016년9월 17일 (토).
 */

@Configuration
@EnableWebMvc
public class BeanConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp().prefix("/WEB-INF/view/").suffix(".jsp");
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass("org.h2.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        dataSource.setJdbcUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository(dataSource());
    }

    @Bean
    public MemberService memberService() {
        return new MemberService();
    }

    @Bean
    public BoardRepository boardRepository() {
        return new BoardRepository(dataSource());
    }

    @Bean
    public BoardService boardService() {
        return new BoardService();
    }

    @Bean
    public LoginService loginService() {
        return new LoginService();
    }
}
