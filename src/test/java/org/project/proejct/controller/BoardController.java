package org.project.proejct.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.proejct.board.BoardDao;
import org.project.proejct.board.BoardData;
import org.project.proejct.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardDao boardDao;

    @GetMapping("/write")
    public String write(@ModelAttribute("data") BoardData data) {

        return "board/write";
    }

    @PostMapping("/save")
    public String save(@Valid BoardData data) {

        boardDao.write(data);

        return "redirect:/board/view/";
    }

}
