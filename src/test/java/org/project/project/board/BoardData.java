package org.project.project.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardData {

    private long id;
    private String poster;
    private String subject;
    private String content;
    private LocalDateTime regDt;
    private LocalDateTime modDt;

}