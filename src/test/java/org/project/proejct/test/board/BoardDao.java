package org.project.proejct.test.board;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
