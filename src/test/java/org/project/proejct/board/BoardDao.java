package org.project.proejct.board;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.tree.RowMapper;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardDao implements BoardRepository {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public void write(BoardData data) {
        jdbcTemplate.update("INSERT INTO BOARD_DATA " +
                "(ID, POSTER, SUBJECT, CONTENT) VALUES (BOARD_DATA_SEQ.nextval, ?, ?, ?)",
                data.getPoster(),data.getSubject(),data.getContent());
    }

    @Override
    public Optional<BoardData> view(String id) {
        List<BoardData> result = jdbcTemplate.query("SELECT * FROM BOARD_DATA WHERE id=?", new BoardRowMapper(), id);
        return result.stream().findAny();
    }
}
