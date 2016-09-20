package com.board.config;

import com.board.controller.BoardController;
import com.board.controller.LoginController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mingook on 2016년9월 17일 (토).
 */
@Configuration
public class ControllerConfig {

    @Bean
    public BoardController boardController() {
        return new BoardController();
    }

    @Bean
    public LoginController loginController() {
        return new LoginController();
    }
}
