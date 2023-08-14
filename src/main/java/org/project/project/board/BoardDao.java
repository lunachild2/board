package org.project.project.board;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardDao implements BoardRepository {

    private final JdbcTemplate jdbcTemplate;

    /** 게시글 작성 */
    @Override
    public void write(BoardData data) {
        jdbcTemplate.update("INSERT INTO BOARD_DATA " +
                "(ID, POSTER, SUBJECT, CONTENT) VALUES (BOARD_DATA_SEQ.nextval, ?, ?, ?)",
                data.getPoster(),data.getSubject(),data.getContent());
    }

    /** 게시글 보기 */
    @Override
    public Optional<BoardData> view(String id) {
        List<BoardData> result = jdbcTemplate.query("SELECT * FROM BOARD_DATA WHERE id=?", new BoardRowMapper(), id);
        return result.stream().findAny();
    }

    /** 게시글 수정 */
    @Override
    public void update(BoardData data) {
        jdbcTemplate.update("UPDATE BOARD_DATA SET SUBJECT=(수정)?, CONTENT=?, MODDT=SYSDATE WHERE ID=?",
                data.getSubject(), data.getContent(), data.getId());
    }

    /** 게시글 삭제 */
    @Override
    public void delete(String id) {
        jdbcTemplate.update("DELETE FROM BOARD_DATA WHERE ID=?", id);
    }

    /** 게시글 전체 보기 */
    @Override
    public List<BoardData> viewList() {
        return jdbcTemplate.query("SELECT * FROM BOARD_DATA ORDER BY ID", new BoardRowMapper());
    }

}
