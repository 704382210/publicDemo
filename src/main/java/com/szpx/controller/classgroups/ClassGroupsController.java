package com.szpx.controller.classgroups;


import com.szpx.entity.ClassGroups;
import com.szpx.service.classGroupsService.ClassGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lishihui
 * @date 2022/8/1 14:59
 */

@Controller()
public class ClassGroupsController {


    @Autowired
    private ClassGroupsService classGroupsService;

    /**
     * 去系统首页
     */
//    @RequestMapping("/index")
//    public String toIndex(){
//        return "index";
//    }

    /**
     * 去三班任务书页面
     */
    @RequestMapping("/toClassGroupsThree")
    public String toClassGroupsThree(Model model) {
        ClassGroups classGroups = new ClassGroups();
        classGroups.setClass_number("软件工程3班");
        List<ClassGroups>  classGroupsList = classGroupsService.getListByClassNumber(classGroups);
        if(classGroupsList != null){
            model.addAttribute("classGroupsList",classGroupsList);
            return "classgroups/classgroup_three"; //逻辑视图
        }else{
            return null;
        }
    }
    @GetMapping("/toClassGroupsTwo")
    public String toClassGroupsTwo(Model model) {
        ClassGroups classGroups = new ClassGroups();
        classGroups.setClass_number("软件工程2班");
        List<ClassGroups>  classGroupsList = classGroupsService.getListByClassNumber(classGroups);
        if(classGroupsList != null){
            model.addAttribute("classGroupsList",classGroupsList);
            return "classgroups/classgroup_two"; //逻辑视图
        }else{
            return null;
        }
    }
    @GetMapping("/toClassGroupsOne")
    public String toClassGroupsOne(Model model) {
        ClassGroups classGroups = new ClassGroups();
        classGroups.setClass_number("软件工程1班");
        List<ClassGroups>  classGroupsList = classGroupsService.getListByClassNumber(classGroups);
        if(classGroupsList != null){
            model.addAttribute("classGroupsList",classGroupsList);
            return "classgroups/classgroup_one"; //逻辑视图
        }else{
            return null;
        }
    }


//
//    /**
//     * 查询所有用户
//     */
////    @GetMapping("/ulist")
////    public String selectAllUser(Model model){
////        List<User> ulist = userService.selectAllUser();
////        if(ulist!=null){
////            model.addAttribute("ulist",ulist);
////            return "ulist";
////        }else{
////            return null;
////        }
////    }
//
//    //查看用户详情
//    @GetMapping("/selectById/{id}")
//    public String selectById(@PathVariable("id") Integer id,Model model){
//        User user = userService.selectUserById(id);
//        if(user!=null){
//            model.addAttribute("user",user);
//            return "detail";
//        }else{
//            return null;
//        }
//    }
//
//    /**
//     * 删去用户
//     */
//    @RequestMapping("/delUser/{id}")
//    public String delUser(@PathVariable("id") Integer id){
//        int num = userService.delUser(id);
//        if(num>0)
//            return "redirect:/ulist"; //重定向到用户列表请求
//        else
//            return null;
//    }
//
//
//    /**
//     * 去用户修改页面
//     */
//    @GetMapping("/toUpdateUser/{id}")
//    public String toUpdatePage(@PathVariable("id") Integer id,Model model){
//        User user = userService.selectUserById(id);
//        if(user!=null){
//            model.addAttribute("user",user); //将查询出来的信息 传到修改页面
//            return "update"; //逻辑视图
//        } else{
//            return null;
//        }
//    }
//
//    //修改用户
//    @RequestMapping("/updateUser")
//    public String updateUser(User user){
//        int num=userService.updateUser(user);
//        if(num>0)
//            return "redirect:/ulist";
//        else
//            return null;
//    }
//
//
//    //增加用户
//    @RequestMapping("/addUser")
//    public String addUser(User user){
//        int num=userService.addUser(user);
//        if(num>0)
//            return "redirect:/ulist";
//        else
//            return null;
//    }
//
//    //退出功能
//    @RequestMapping("/logout")
//    public String exitSystem(HttpSession session){
//        session.removeAttribute("user");
//        session.invalidate();
//        return "redirect:/index";
//    }
//
//    //查询所有用户
//    @GetMapping("/ulist")
//    public String getList(
//            @RequestParam(defaultValue="1")int pno,
//            @RequestParam(defaultValue="3")int pageSize,
//            User user,Model model){
//        PageHelper.startPage(pno, pageSize); //开始分页
//        List<User> ulist=userService.getListByCon(user);
//        PageInfo<User> page=new PageInfo<User>(ulist);
//        model.addAttribute("ulist",ulist); //将查询出来的数据放入model对象中
//        model.addAttribute("page",page);
//        model.addAttribute("name",user.getName());
//        model.addAttribute("sex",user.getSex());
//        model.addAttribute("pno",pno);
//        return "ulist";
//    }
}
