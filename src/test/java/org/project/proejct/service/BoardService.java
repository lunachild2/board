package org.project.proejct.service;

import lombok.RequiredArgsConstructor;
import org.project.proejct.board.BoardData;
import org.project.proejct.board.BoardRepository;
import org.project.proejct.validators.BoardSaveValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private static BoardRepository repository;
    private static BoardSaveValidator validator;

    public void write(BoardData data) {
        validator.check(data);
        repository.write(data);
    }

    public Optional<BoardData> view(String id) {
        return repository.view(id);
    }

}
