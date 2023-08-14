package org.project.project.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.project.board.BoardDao;
import org.project.project.board.BoardData;
import org.project.project.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    /** 게시글 작성 */
    @GetMapping("/write")
    public String write(@ModelAttribute("data") BoardData data) {

        return "board/write";
    }

    @PostMapping("/save")
    public String save(BoardData data, Errors errors) {

        if(errors.hasErrors()) {
            return "board/write";
        }

        service.write(data);

        return "redirect:/board";
    }

    /** 게시글 보기 */
    @GetMapping("/{id}")
    public String view(@PathVariable("id") String id, Model model) {
        Optional<BoardData> result = service.view(id);
        BoardData data = result.get();
        model.addAttribute("data", data);

        return "board/view";
    }

    /** 게시글 전체 보기 */
    @GetMapping()
    public String viewList(Model model) {
        List<BoardData> viewList = service.viewList();
        model.addAttribute("viewList", viewList);
        return "board/viewList";
    }

    /** 게시글 삭제 */
    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/board";
    }

    /** 게시글 수정 */
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") String id, Model model) {
        Optional<BoardData> result = service.view(id);
        BoardData data = result.get();
        model.addAttribute("data", data);

        return "board/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable String id, @ModelAttribute("data") BoardData data) {
        service.update(data);
        return "redirect:/board/{id}";
    }

    /** 에러 새창 출력 */
    @ExceptionHandler(RuntimeException.class)
    public String errorHandler(RuntimeException e, Model model) {

        String script = String.format("alert('%s');history.back();", e.getMessage());
        model.addAttribute("script", script);

        e.printStackTrace();

        return "commons/execute_script";
    }

}
