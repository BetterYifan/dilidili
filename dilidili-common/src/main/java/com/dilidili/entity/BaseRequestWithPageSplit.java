package com.dilidili.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.value.qual.IntRange;
import org.jetbrains.annotations.NotNull;

/**
 * 接口入参必须继承的基准接口
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRequestWithPageSplit extends BaseRequest {
    @NotNull
    private Integer pageNum;

    @NotNull
    @IntRange(from = 0, to = 50)
    private Integer pageSize;
}
