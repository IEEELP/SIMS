package service.impl;

import dao.impl.UserDao;
import dao.intf.IUserDao;
import domain.User;
import service.intf.IUserService;

import java.util.List;

public class UserService implements IUserService {
    IUserDao dao=new UserDao();
    //查询所有用户信息sims=1
    @Override
    public List<User> findAll() throws Exception {
        List<User> result = dao.findAll();
        return result;
    }
}
