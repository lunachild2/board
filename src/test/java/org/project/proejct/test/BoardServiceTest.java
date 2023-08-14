package org.project.proejct.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.project.proejct.board.BoardData;
import org.project.proejct.board.BoardDataForm;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("게시글 저장 테스트")
public class BoardServiceTest {

    private BoardDataForm boardData;

    @BeforeEach
    void init() {
        boardData = getData();
    }

    private BoardDataForm getData() {
        BoardDataForm boardData = new BoardDataForm();
        boardData.setPoster("작성자");
        boardData.setSubject("제목");
        boardData.setContent("내용");

        return boardData;
    }

    @Test
    @DisplayName("게시글 작성 성공시 예외발생 X")
    void addTest() {

    }

}
