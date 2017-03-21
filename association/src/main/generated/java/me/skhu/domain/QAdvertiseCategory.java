package me.skhu.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdvertiseCategory is a Querydsl query type for AdvertiseCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdvertiseCategory extends EntityPathBase<AdvertiseCategory> {

    private static final long serialVersionUID = -156621298L;

    public static final QAdvertiseCategory advertiseCategory = new QAdvertiseCategory("advertiseCategory");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QAdvertiseCategory(String variable) {
        super(AdvertiseCategory.class, forVariable(variable));
    }

    public QAdvertiseCategory(Path<? extends AdvertiseCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdvertiseCategory(PathMetadata metadata) {
        super(AdvertiseCategory.class, metadata);
    }

}

