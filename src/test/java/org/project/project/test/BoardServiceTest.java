package org.project.project.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.project.project.board.BoardDao;
import org.project.project.board.BoardData;
import org.project.project.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("게시판 테스트")
public class BoardServiceTest {

    private BoardData boardData = null;

    @Autowired
    private BoardService service;


    @BeforeEach
    void getData() {
        boardData = new BoardData();
        boardData.setPoster("작성자");
        boardData.setSubject("제목");
        boardData.setContent("내용");
    }

    @Test
    @DisplayName("게시글 작성 테스트")
    void addTest() {
        service.write(boardData);
    }

    @Test
    @DisplayName("게시글 보기 테스트")
    void viewTest() {
        service.write(boardData);

        Optional<BoardData> find = service.view("21");

        assertThat(find.get().getPoster()).isEqualTo(boardData.getPoster());
    }

    @Test
    @DisplayName("게시글 수정 테스트")
    void editTest() {
        boardData.setId(21);
        boardData.setSubject("제목(수정)");
        boardData.setContent("내용(수정)");
        service.update(boardData);
    }

    @Test
    @DisplayName("게시글 삭제 테스트")
    void deleteTest() {

        service.delete("22");
    }

}
