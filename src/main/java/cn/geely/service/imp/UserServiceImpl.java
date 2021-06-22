package cn.geely.service.imp;

import cn.geely.bean.User;
import cn.geely.dao.UserDao;
import cn.geely.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String login(Integer id, String password) {
        if (StringUtils.isEmpty(id) || StringUtils.hasLength(password)) {
            throw new RuntimeException("参数为空，请检查参数");
        }
        User user = userDao.login(id, password);
        System.out.println(user);
        String res = "";
        if (user == null) {
            res = "用户输入的用户名或者密码不正确";
        } else {
            res = "登录成功";
        }
        return res;
    }

    @Override
    public String insertUser(Integer id, String name, String password) {
        User user=new User(id,name,password);
        try {
            int res = userDao.insertUser(user);
            return "插入成功，影响了" + res;
        } catch (Exception e) {
            log.error("用户插入失败 ： ", e);
            return "插入失败";
        }

    }

    @Override
    public String updateUser(Integer id, String password) {
//        int res = userDao.updateUser(id, password);
//        if (res == 1) {
//            return "修改成功";
//        } else {
//            return "修改失败";
//        }
        return userDao.updateUser(id, password) == 0 ? "修改失败" : "修改成功";
    }

    @Override
    public String deleteUser(Integer id) {
//        int res = userDao.deleteUser(id);
//        if(res==1){
//            return "删除成功,影响了" + res + "行";
//        }
//        else {
//            return "删除失败";
//        }
        return userDao.deleteUser(id) == 0 ? "删除失败" : "删除成功";
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> pageQuery(Integer pageNo, Integer pageSize) {
        return userDao.pagedQuery((pageNo-1)*pageSize,pageSize);
    }

    @Override
    public List<User> pageQuery2(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return userDao.getAllUsers();
    }

    @Override
    public PageInfo<User> queryUserList(int pageNum, int pageSize) {
        //pageNum页码,pageSize条数
        PageHelper.startPage(pageNum,pageSize);
        List<User>list=userDao.getAllUsers();
        return new PageInfo<User>(list);
    }


    //分页查找


}
