package com.dilidili.filter.admin.service;

import com.dilidili.filter.admin.entity.DTO.AreaContentListDTO;
import com.dilidili.filter.admin.entity.VO.AreaContentVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AreaContentService {
    List<AreaContentVO> queryAreaContentList(AreaContentListDTO areaContentListDTO, HttpServletRequest request);

}
