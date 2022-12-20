package com.dilidili.filter.admin.entity.DTO;

import com.dilidili.entity.BaseRequestWithPageSplit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaContentListDTO extends BaseRequestWithPageSplit {
    /**
     * 业务方
     */
    private String area;
    /**
     * 敏感词类型
     */
    private Integer mode;
    /**
     * 来源
     */
    private Integer source;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 敏感词
     */
    private String content;

}
