package org.project.project.scheduling;

import lombok.RequiredArgsConstructor;
import org.project.project.board.BoardData;
import org.project.project.board.BoardRowMapper;
import org.project.project.service.BoardService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private final BoardService service;

    private final JdbcTemplate jdbcTemplate;

    @Scheduled(cron = "0 0 1 * * *")
    public void Stat() {
        String sql = "select TO_CHAR(REGDT, 'YY-MM-DD HH')" +
                "AS DATES, count(*) AS COUNT" +
                "FROM BOARD_DATA" +
                "group by TO_CHAR(REGDT, 'YY-MM-DD HH');";
        jdbcTemplate.query(sql, new BoardRowMapper());

    }

}
