package me.skhu.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserDiscloser is a Querydsl query type for UserDiscloser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserDiscloser extends EntityPathBase<UserDiscloser> {

    private static final long serialVersionUID = 1391709254L;

    public static final QUserDiscloser userDiscloser = new QUserDiscloser("userDiscloser");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isCompanyNumber = createBoolean("isCompanyNumber");

    public final BooleanPath isEmail = createBoolean("isEmail");

    public final BooleanPath isImage = createBoolean("isImage");

    public final BooleanPath isPhoneNumber = createBoolean("isPhoneNumber");

    public final BooleanPath isStatus = createBoolean("isStatus");

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QUserDiscloser(String variable) {
        super(UserDiscloser.class, forVariable(variable));
    }

    public QUserDiscloser(Path<? extends UserDiscloser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserDiscloser(PathMetadata metadata) {
        super(UserDiscloser.class, metadata);
    }

}

