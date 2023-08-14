package org.project.project.board;

import java.util.Optional;

public interface BoardRepository {

    void write(BoardData data);

    Optional<BoardData> view(String id);

    void update(BoardData data);


}
