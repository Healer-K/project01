package cn.geely.dao;

import cn.geely.bean.User;
import org.apache.ibatis.annotations.Mapper;
import sun.security.util.Password;

import java.util.List;

@Mapper
public interface UserDao {
    User login(Integer id,String password);
    int insertUser(User user);
    int updateUser(Integer id,String password);
    int deleteUser(Integer id);
    User getUser(Integer id);
    List<User> pagedQuery(Integer pageNo, Integer pageSize);
    List<User> getAllUsers();
}

