package com.szpx.service.classGroupsService;

import com.szpx.entity.ClassGroups;

import java.util.List;


public interface ClassGroupsService {
    //    定义查询所有任务分组表信息的接口
    List<ClassGroups> selectAllClassGroups();
    //    根据班级编号查询信息
    List<ClassGroups> getListByClassNumber(ClassGroups classGroups);
}
