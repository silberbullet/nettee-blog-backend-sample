package com.nettee.application.service;

import com.nettee.application.domain.board.Board;
import com.nettee.application.port.BoardQueryPort;
import com.nettee.application.usecase.BoardReadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardQueryService implements BoardReadUseCase {

    private final BoardQueryPort boardQueryPort;

    @Override
    @Transactional(readOnly = true)
    public Page<Board> getBoardList(Pageable pageable)  {

        return boardQueryPort.findAllBoard(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Board getBoard(Long id){

        return boardQueryPort.findBoardById(id).orElseThrow(
                () -> new IllegalArgumentException("Board not found")
        );
    }
}
