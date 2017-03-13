package me.skhu.repository.Impl;

import me.skhu.domain.BoardImage;
import me.skhu.domain.QBoardImage;
import me.skhu.repository.custom.BoardImageRepositoryCustom;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 * Created by iljun on 2017-03-07.
 */
public class BoardImageRepositoryImpl extends QueryDslRepositorySupport implements BoardImageRepositoryCustom{
    private QBoardImage qBoardImage = QBoardImage.boardImage;

    public BoardImageRepositoryImpl(){
        super(BoardImage.class);
    }

    @Override
    public void deleteAuto(){
        delete(qBoardImage)
                .where(qBoardImage.boardId.eq(-1))
                .where(qBoardImage.createdDate.eq(qBoardImage.lastModifiedDate))
                .execute();
    }
}
