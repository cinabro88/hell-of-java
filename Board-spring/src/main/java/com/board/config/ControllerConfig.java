package com.board.config;

import com.board.controller.BoardController;
import com.board.controller.CommonController;
import com.board.controller.LoginController;
import com.board.controller.LogoutController;
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

    @Bean
    public LogoutController logoutController() {
        return new LogoutController();
    }

    @Bean
    public CommonController commonController() {
        return new CommonController();
    }
}
