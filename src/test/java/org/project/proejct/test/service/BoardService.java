package org.project.proejct.test.service;

import lombok.RequiredArgsConstructor;
import org.project.proejct.test.board.BoardData;
import org.project.proejct.test.board.BoardRepository;
import org.project.proejct.test.validators.BoardSaveValidator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private static BoardRepository repository;
    private static BoardSaveValidator validator;

    public void write(BoardData data) {
        validator.check(data);
        repository.write(data);
    }

}
