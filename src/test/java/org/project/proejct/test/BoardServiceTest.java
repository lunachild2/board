package org.project.proejct.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.project.proejct.board.BoardDao;
import org.project.proejct.board.BoardData;
import org.project.proejct.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("게시글 저장 테스트")
public class BoardServiceTest {

    private BoardData boardData = null;

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
    @DisplayName("게시글 조회 테스트")
    void addTest() {
        boardDao.write(boardData);
    }

    @Test
    @DisplayName("게시글 보기 테스트")
    void viewTest() {
        boardDao.write(boardData);

        Optional<BoardData> find = boardDao.view("21");

        assertThat(find.get().getPoster()).isEqualTo(boardData.getPoster());
    }

}
