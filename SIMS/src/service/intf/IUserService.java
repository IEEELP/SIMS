package service.intf;

import domain.User;

import java.util.List;

/*
用户表（user）的业务层接口
 */
public interface IUserService {
    //查询所有用户信息
    List<User> findAll() throws Exception;
    //用户登录
    void login(User user);
    //用户注册
    void register(User user);
}
