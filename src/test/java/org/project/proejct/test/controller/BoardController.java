package org.project.proejct.test.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.proejct.test.board.BoardData;
import org.project.proejct.test.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/write")
    public String write(@ModelAttribute BoardData data) {

        return "board/write";
    }

    @PostMapping("/save")
    public String save(@Valid BoardData data) {

        service.write(data);

        return "redirect:/board/view/";
    }

}
