package org.project.proejct.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.project.proejct.test.board.BoardDao;
import org.project.proejct.test.board.BoardData;
import org.project.proejct.test.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("게시글 저장 테스트")
public class BoardServiceTest {

    private BoardData boardData = null;
    @Autowired
    private BoardService service;

    @Autowired
    private BoardDao boardDao;


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
        boardDao.write(boardData);
    }

}
