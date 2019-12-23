package service.intf;

import domain.User;

import java.util.List;

/*
用户表（user）的业务层接口
 */
public interface IUserService {
    //查询所有用户信息
    List<User> findAll() throws Exception;
}
