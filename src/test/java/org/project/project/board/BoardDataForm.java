package org.project.project.board;

import lombok.Data;

@Data
public class BoardDataForm {

    private long id;
    private String poster;
    private String subject;
    private String content;

}