package org.project.project.service;

import lombok.RequiredArgsConstructor;
import org.project.project.board.BoardDao;
import org.project.project.board.BoardData;
import org.project.project.board.BoardRepository;
import org.project.project.validators.BoardSaveValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    public void write(BoardData data) {

        repository.write(data);
    }

    public Optional<BoardData> view(String id) {
        return repository.view(id);
    }

    public void update(BoardData data) {
        repository.update(data);
    }

    public void delete(String id) {
        repository.delete(id);
    }

    public List<BoardData> viewList() {
        return repository.viewList();
    }

}
