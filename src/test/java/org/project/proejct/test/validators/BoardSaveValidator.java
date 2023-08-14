package org.project.proejct.test.validators;

import org.project.proejct.test.board.BoardData;

public class BoardSaveValidator implements Validator<BoardData>, RequiredValidator {
    @Override
    public void check(BoardData data) {
        checkRequired(data.getPoster(), new BoardValidationException("작성자를 입력하세요."));
        checkRequired(data.getSubject(), new BoardValidationException("제목을 입력하세요."));
        checkRequired(data.getContent(), new BoardValidationException("내용을 입력하세요."));
    }
}
