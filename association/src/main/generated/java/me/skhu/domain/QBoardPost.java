package me.skhu.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardPost is a Querydsl query type for BoardPost
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoardPost extends EntityPathBase<BoardPost> {

    private static final long serialVersionUID = -683612817L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardPost boardPost = new QBoardPost("boardPost");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QBoard board;

    public final CollectionPath<Comment, QComment> commentList = this.<Comment, QComment>createCollection("commentList", Comment.class, QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createdDate = _super.createdDate;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath title = createString("title");

    public final NumberPath<Integer> writer_id = createNumber("writer_id", Integer.class);

    public final StringPath writer_name = createString("writer_name");

    public QBoardPost(String variable) {
        this(BoardPost.class, forVariable(variable), INITS);
    }

    public QBoardPost(Path<? extends BoardPost> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardPost(PathMetadata metadata, PathInits inits) {
        this(BoardPost.class, metadata, inits);
    }

    public QBoardPost(Class<? extends BoardPost> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board")) : null;
    }

}

