package me.skhu.repository.custom;

import org.joda.time.DateTime;

/**
 * Created by iljun on 2017-03-21.
 */
public interface OriginUserRepositoryCustom {
    int countToday(int categoryId, DateTime today, DateTime now);
}
