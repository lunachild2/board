package org.project.project.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.project.board.BoardDao;
import org.project.project.board.BoardData;
import org.project.project.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/write")
    public String write(@ModelAttribute("data") BoardData data) {

        return "board/write";
    }

    @PostMapping("/save")
    public String save(BoardData data) {

        service.write(data);

        return "redirect:/board";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable("id") String id, Model model) {
        Optional<BoardData> result = service.view(id);
        BoardData data = result.get();
        model.addAttribute("data", data);

        return "board/view";
    }

    @GetMapping()
    public String viewList(Model model) {
        List<BoardData> viewList = service.viewList();
        model.addAttribute("viewList", viewList);
        return "board/viewList";
    }


}
