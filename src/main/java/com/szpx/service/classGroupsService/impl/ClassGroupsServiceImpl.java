package com.szpx.service.classGroupsService.impl;
import com.szpx.entity.ClassGroups;
import com.szpx.mapper.ClassGroupsMapper;
import com.szpx.service.classGroupsService.ClassGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional //事务处理策略
public class ClassGroupsServiceImpl implements ClassGroupsService {

    @Autowired
    private ClassGroupsMapper classGroupsMapper;

    @Override
    public List<ClassGroups> selectAllClassGroups() {
        return classGroupsMapper.selectAll();
    }

    @Override
    public List<ClassGroups> getListByClassNumber(ClassGroups classGroups) {
        return classGroupsMapper.select(classGroups);
    }

}
