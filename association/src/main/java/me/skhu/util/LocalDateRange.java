package me.skhu.util;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Created by iljun on 2017-03-06.
 */
@Getter
@Builder
@Setter
public class LocalDateRange {
    private LocalDate createDate;

    public static LocalDateRange of(LocalDate createDate){
        return LocalDateRange.builder()
                .createDate(createDate)
                .build();
    }
}
