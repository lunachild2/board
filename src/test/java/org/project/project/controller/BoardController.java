package org.project.project.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.project.board.BoardDao;
import org.project.project.board.BoardData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public String view(@PathVariable("id") String id, Model model) {
        Optional<BoardData> result = boardDao.view(id);
        BoardData data = result.get();
        model.addAttribute("data", data);

        return "board/view";
    }

}
