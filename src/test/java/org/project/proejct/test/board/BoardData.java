package org.project.proejct.test.board;

import lombok.Builder;
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
