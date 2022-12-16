package com.dilidili.filter.admin.service.impl;

import com.dilidili.entity.BO.FilterAreaContentBO;
import com.dilidili.filter.admin.entity.DTO.AreaContentListDTO;
import com.dilidili.filter.admin.entity.VO.AreaContentVO;
import com.dilidili.filter.admin.manager.AreaContentManager;
import com.dilidili.filter.admin.service.AreaContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaContentServiceImpl implements AreaContentService {

    @Autowired
    private AreaContentManager areaContentManager;

    @Override
    public List<AreaContentVO> queryAreaContentList(AreaContentListDTO areaContentListDTO, HttpServletRequest request) {
        List<AreaContentVO> areaContentVOS = new ArrayList<>();

        List<FilterAreaContentBO> areaDOList = areaContentManager.queryAreaList(areaContentListDTO);

        areaDOList.forEach(item -> {
            AreaContentVO areaContentVO = AreaContentVO.builder()
                    .id(item.getId())
                    .area(item.getArea())
                    .level(item.getLevel())
                    .filterid(item.getFilterId())
                    .filter(item.getFilter())
                    .ctime(item.getCtime())
                    .mtime(item.getMtime())
                    .build();
            areaContentVOS.add(areaContentVO);
        });
        return areaContentVOS;
    }
}
