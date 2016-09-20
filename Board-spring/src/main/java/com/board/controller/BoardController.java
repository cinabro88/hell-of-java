package com.board.controller;

import com.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mingook on 2016년8월 10일 (수).
 */
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/")
    public String index() {
        return "/board/list";
    }

    @RequestMapping("join")
    public String join() {
        return "/member/join";
    }

    @RequestMapping(value = "writeBoard", method = GET)
    public String writeBoard() {
        return "/board/write";
    }

    @RequestMapping(value = "writeBoard", method = POST)
    public String writeBoard(@SessionAttribute("id") String id,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {

        boardService.writeBoard(title, content, id);
        return "/";
    }

    @RequestMapping("logout")
    public String logout() {
        return "/member/logout";
    }

    @RequestMapping("alert")
    public String alert() {
        return "/alert";
    }

    @RequestMapping("boardDetail")
    public String boardDetail() {
        return "/board/detaeil";
    }
}
