package com.dilidili.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dilidili.entity.BO.FilterAreaContentBO;
import lombok.Value;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilterAreaContentMapper extends BaseMapper<FilterAreaContentBO> {
    List<FilterAreaContentBO> selectList(@Param("area") String area, @Param("mode") Integer mode,
                                         @Param("content") String filter, @Param("source") Integer source);
}
