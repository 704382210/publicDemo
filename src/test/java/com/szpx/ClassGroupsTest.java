package com.szpx;

import com.szpx.entity.ClassGroups;
import com.szpx.service.classGroupsService.ClassGroupsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@SpringBootTest
public class ClassGroupsTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private ClassGroupsService classGroupsService;
    @Test
    public void  testDataSource() throws Exception{
        System.out.println("数据源:"+dataSource.getClass());
        Connection con = dataSource.getConnection();
        System.out.println("连接对象:"+con);
    }

    /**
     * 测试任务分配表接口函数
     */
    @Test
    public void selectAllClassGroups(){
        List<ClassGroups> classGroupsList = classGroupsService.selectAllClassGroups();
        if(classGroupsList != null){
            for (ClassGroups cg:classGroupsList){
                System.out.println(cg.toString());
                System.out.println(cg.getClass_number());
            }
        }else{
            System.out.println("error!");
        }
    }

    @Test
    public void classGroupsMapperTest(){
        ClassGroups newClassGroups = new ClassGroups();
        newClassGroups.setClass_number("软件工程2班");
        List<ClassGroups> cg = classGroupsService.getListByClassNumber(newClassGroups);
        for (ClassGroups sqlcg:cg){
            System.out.println(sqlcg.toString());
        }
    }

}
