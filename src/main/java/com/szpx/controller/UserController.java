package com.szpx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szpx.entity.User;
import com.szpx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.VariableElement;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lishihui
 * @date 2022/8/1 14:59
 */

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 去系统首页
     */
//    @RequestMapping("/index")
//    public String toIndex(){
//        return "index";
//    }

    /**
     * 登录功能
     */
    @PostMapping("/login")
    public String login(User user, HttpSession session,Model model){
        User user1 = userService.login(user);
        if(user1!=null){ //登录成功-将用户信息保存到session并且去后台首页
            session.setAttribute("user",user1);
            return "redirect:/main"; //将请求重定向到/main的url-此时是请求url不是逻辑视图
        }else { //登录失败-去登录页面-重新登录
            model.addAttribute("msg","用户名或密码不正确!");
            return "index";
        }
    }


    /**
     * 查询所有用户
     */
//    @GetMapping("/ulist")
//    public String selectAllUser(Model model){
//        List<User> ulist = userService.selectAllUser();
//        if(ulist!=null){
//            model.addAttribute("ulist",ulist);
//            return "ulist";
//        }else{
//            return null;
//        }
//    }

    //查看用户详情
    @GetMapping("/selectById/{id}")
    public String selectById(@PathVariable("id") Integer id,Model model){
        User user = userService.selectUserById(id);
        if(user!=null){
            model.addAttribute("user",user);
            return "detail";
        }else{
            return null;
        }
    }

    /**
     * 删去用户
     */
    @RequestMapping("/delUser/{id}")
    public String delUser(@PathVariable("id") Integer id){
        int num = userService.delUser(id);
        if(num>0)
            return "redirect:/ulist"; //重定向到用户列表请求
        else
            return null;
    }


    /**
     * 去用户修改页面
     */
    @GetMapping("/toUpdateUser/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id,Model model){
        User user = userService.selectUserById(id);
        if(user!=null){
            model.addAttribute("user",user); //将查询出来的信息 传到修改页面
            return "update"; //逻辑视图
        } else{
            return null;
        }
    }

    //修改用户
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        int num=userService.updateUser(user);
        if(num>0)
            return "redirect:/ulist";
        else
            return null;
    }


    //增加用户
    @RequestMapping("/addUser")
    public String addUser(User user){
        int num=userService.addUser(user);
        if(num>0)
            return "redirect:/ulist";
        else
            return null;
    }

    //退出功能
    @RequestMapping("/logout")
    public String exitSystem(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/index";
    }

    //查询所有用户
    @GetMapping("/ulist")
    public String getList(
            @RequestParam(defaultValue="1")int pno,
            @RequestParam(defaultValue="3")int pageSize,
            User user,Model model){
        PageHelper.startPage(pno, pageSize); //开始分页
        List<User> ulist=userService.getListByCon(user);
        PageInfo<User> page=new PageInfo<User>(ulist);
        model.addAttribute("ulist",ulist); //将查询出来的数据放入model对象中
        model.addAttribute("page",page);
        model.addAttribute("name",user.getName());
        model.addAttribute("sex",user.getSex());
        model.addAttribute("pno",pno);
        return "ulist";
    }

    @GetMapping("/model")
    public String model(Model model) {
        return "model"; //逻辑视图
    }
}
