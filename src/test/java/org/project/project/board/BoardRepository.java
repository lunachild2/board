package org.project.project.board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    void write(BoardData data);

    Optional<BoardData> view(String id);

    void update(BoardData data);

    void delete(String id);

    List<BoardData> viewList();

}
