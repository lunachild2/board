package org.project.project.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardData {

    private long id;
    @NotBlank(message = "작성자를 입력하세요.")
    private String poster;
    @NotBlank(message = "제목을 입력하세요.")
    private String subject;
    @NotBlank(message = "내용을 입력하세요.")
    private String content;
    private LocalDateTime regDt;
    private LocalDateTime modDt;

}
