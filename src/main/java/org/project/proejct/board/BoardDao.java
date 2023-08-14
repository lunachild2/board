package org.project.proejct.board;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardDao {

    private final JdbcTemplate jdbcTemplate;



}
