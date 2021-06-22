package cn.geely.controller;

import cn.geely.bean.User;
import cn.geely.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("用户管理")
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @GetMapping("/login")
    public String login(Integer id, String password) {
        //Integer idInt = Integer.parseInt(id);
        return userService.login(id, password);
    }

    @ApiOperation(value = "添加用户")
    @GetMapping("/user")
    public String insertUser(Integer id, String name, String password) {
        return userService.insertUser(id, name, password);
    }
//
    @ApiOperation(value = "修改用户信息")
    @PostMapping("/user")
    public String updateUser(Integer id, String password) {
        return userService.updateUser(id, password);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/user")
    public String deleteUser(@RequestParam(name = "用户id") Integer id) {
        return userService.deleteUser(id);
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/user/id")
    public User getUser(@RequestParam(value = "idddd", required = true) Integer id) {
        //Integer idInt = Integer.parseInt(id);
        return userService.getUser(id);
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/user/users")
    public List<User> pagedQuery(Integer pageNo, Integer pageSize) {
        //return userService.pageQuery(pageNo,pageSize);
        return userService.pageQuery2(pageNo, pageSize);
    }


    @ApiOperation(value = "获取用户信息3")
    @GetMapping("/queryStudentList")
    public PageInfo<User> queryUserList(int pageNum, int pageSize) {

        return userService.queryUserList(pageNum, pageSize);
    }


}
