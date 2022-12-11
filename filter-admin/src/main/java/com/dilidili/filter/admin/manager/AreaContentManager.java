package com.dilidili.filter.admin.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dilidili.entity.BO.FilterAreaContentBO;
import com.dilidili.entity.POJO.FilterAreaDO;
import com.dilidili.filter.admin.entity.DTO.AreaContentListDTO;
import com.dilidili.mapper.FilterAreaContentMapper;
import com.dilidili.mapper.FilterAreaMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class AreaContentManager {

    @Autowired
    private FilterAreaContentMapper filterAreaContentMapper;

    /**
     * 从db查询所有业务方词汇列表
     *
     * @return
     */
    public List<FilterAreaContentBO> queryAreaList(AreaContentListDTO areaContentListDTO) {
        PageHelper.startPage(areaContentListDTO.getPageNum(), areaContentListDTO.getPageSize());
        List<FilterAreaContentBO> list = filterAreaContentMapper.selectList(areaContentListDTO.getArea(), areaContentListDTO.getMode(), areaContentListDTO.getContent(), areaContentListDTO.getSource());
        PageInfo<FilterAreaContentBO> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }
}
