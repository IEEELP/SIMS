package service.impl;

import dao.impl.UserDao;
import dao.intf.IUserDao;
import domain.User;
import service.intf.IUserService;

import java.util.List;

public class UserService implements IUserService {
    IUserDao dao=new UserDao();
    //查询所有用户信息
    @Override
    public List<User> findAll() throws Exception {
        List<User> result = dao.findAll();
        return result;
    }
    //用户登录
    @Override
    public void login(User user) {
    }
    //用户注册
    @Override
    public void register(User user) {

    }
}
