package dao.intf;
/*
用户表（user）的持久化层接口
 */
import domain.User;

import java.util.List;

public interface IUserDao {
    //查询所有用户信息
    List<User> findAll() throws Exception;
    //删除用户信息
    void deleteByUsername(String username)throws Exception;
    //修改用户密码
    void updateByUsername(String username,String password)throws Exception;
}
