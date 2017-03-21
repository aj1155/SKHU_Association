package me.skhu.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOriginUserPhone is a Querydsl query type for OriginUserPhone
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOriginUserPhone extends EntityPathBase<OriginUserPhone> {

    private static final long serialVersionUID = -955550234L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOriginUserPhone originUserPhone = new QOriginUserPhone("originUserPhone");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final BooleanPath agree = createBoolean("agree");

    public final QCategory category;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createdDate = _super.createdDate;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath loginId = createString("loginId");

    public final QUser user;

    public QOriginUserPhone(String variable) {
        this(OriginUserPhone.class, forVariable(variable), INITS);
    }

    public QOriginUserPhone(Path<? extends OriginUserPhone> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOriginUserPhone(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOriginUserPhone(PathMetadata metadata, PathInits inits) {
        this(OriginUserPhone.class, metadata, inits);
    }

    public QOriginUserPhone(Class<? extends OriginUserPhone> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

