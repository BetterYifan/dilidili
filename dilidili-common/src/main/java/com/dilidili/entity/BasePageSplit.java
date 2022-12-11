package com.dilidili.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.value.qual.IntRange;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePageSplit {
    @NotNull
    private Integer pageNum;

    @NotNull
    @IntRange(from = 0, to = 50)
    private Integer pageSize;
}
