package com.hell.board;

import com.hell.board.model.Member;
import com.hell.board.repository.MemberRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by mingook on 2016년7월 27일 (수).
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        setupDatabase();
    }

    private void setupDatabase() {
        Member admin = new Member();
        admin.setId("admin");
        admin.setPassword("1");
        MemberRepository.getInstance().save(admin);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
