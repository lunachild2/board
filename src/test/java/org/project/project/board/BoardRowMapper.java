package org.project.project.board;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardRowMapper implements RowMapper<BoardData> {
    @Override
    public BoardData mapRow(ResultSet rs, int rowNum) throws SQLException {

        BoardData board = new BoardData();
        board.setId((rs.getLong("ID")));
        board.setPoster(rs.getString("POSTER"));
        board.setSubject(rs.getString("SUBJECT"));
        board.setContent(rs.getString("CONTENT"));
        board.setRegDt(rs.getTimestamp("REGDT").toLocalDateTime());

        return board;
    }
}
