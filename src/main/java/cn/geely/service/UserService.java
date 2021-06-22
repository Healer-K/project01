package cn.geely.service;

import cn.geely.bean.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    String login(Integer id,String password);
    String insertUser(Integer id, String name, String password);
    String updateUser(Integer id,String password);
    String deleteUser(Integer id);
    User getUser(Integer id);
    List<User> pageQuery(Integer pageNo, Integer pageSize);

    List<User> pageQuery2(Integer pageNo, Integer pageSize);

    PageInfo<User> queryUserList(int pageNum, int pageSize);

}
