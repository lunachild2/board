package org.project.proejct.board;

import java.util.Optional;

public interface BoardRepository {

    void write(BoardData data);

    Optional<BoardData> view(String id);

}
