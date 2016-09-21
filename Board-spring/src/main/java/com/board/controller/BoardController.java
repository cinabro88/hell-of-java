package com.board.controller;

import com.board.model.Board;
import com.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

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
    public String index(Model model) {
        List<Board> boards = boardService.findAllBoards();
        model.addAttribute("boards", boards);
        return "/board/list";
    }

    @RequestMapping(value = "/board/write", method = GET)
    public String writeBoard() {
        return "/board/write";
    }

    @RequestMapping(value = "/board/write", method = POST)
    public String writeBoard(@SessionAttribute("id") String id,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {

        boardService.writeBoard(title, content, id);
        return "redirect:/";
    }

    @RequestMapping("/board/detail")
    public String boardDetail(Model model,
                              @RequestParam("index") int index) {
        Board board = boardService.findBoardByIndex(index);
        model.addAttribute("board", board);
        return "/board/detail";
    }

}
