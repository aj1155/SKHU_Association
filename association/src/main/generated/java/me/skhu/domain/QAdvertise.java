package me.skhu.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAdvertise is a Querydsl query type for Advertise
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdvertise extends EntityPathBase<Advertise> {

    private static final long serialVersionUID = 232322288L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAdvertise advertise = new QAdvertise("advertise");

    public final QAdvertiseCategory category;

    public final StringPath company = createString("company");

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath image = createString("image");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath slogan = createString("slogan");

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final StringPath userName = createString("userName");

    public QAdvertise(String variable) {
        this(Advertise.class, forVariable(variable), INITS);
    }

    public QAdvertise(Path<? extends Advertise> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAdvertise(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAdvertise(PathMetadata metadata, PathInits inits) {
        this(Advertise.class, metadata, inits);
    }

    public QAdvertise(Class<? extends Advertise> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QAdvertiseCategory(forProperty("category")) : null;
    }

}

