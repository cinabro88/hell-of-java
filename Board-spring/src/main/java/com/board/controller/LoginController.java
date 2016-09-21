package com.board.controller;

import com.board.exception.IdPasswordNotMatchingException;
import com.board.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by mingook on 2016년9월 20일 (화).
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model,
                         HttpSession session,
                         @RequestParam("id") String id,
                         @RequestParam("password") String password) {

        try {
            loginService.login(id, password);
        } catch (IdPasswordNotMatchingException e) {
            model.addAttribute("message", "아이디, 비밀번호를 확인해주세요.");
            return "alert";
        }

        session.setAttribute("id", id);
        return "redirect:/";
    }
}
