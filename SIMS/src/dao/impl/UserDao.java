package dao.impl;

import dao.intf.IUserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;
import java.util.List;

public class UserDao implements IUserDao {
    //查询所有用户信息
    @Override
    public List<User> findAll() throws Exception{
        QueryRunner queryRunner=new QueryRunner();
        List<User> result = queryRunner.query("select * from user", JDBCUtils.getDataSource(), new BeanListHandler<User>(User.class));
        return result;
    }
    //根据用户名删除用户信息
    @Override
    public void deleteByUsername(String username) throws Exception {
        QueryRunner queryRunner=new QueryRunner();
        Object[] param={username};
        queryRunner.update("delete from user where username=?",param);
    }
    //根据用户名用户修改密码
    @Override
    public void updateByUsername(String username,String password) throws Exception {
        QueryRunner queryRunner=new QueryRunner();
        Object[] param={username,password};
        queryRunner.update("update user set password=？where username=?",param);
    }
    //根据用户名查询单个用户信息
    @Override
    public User findUserByUsername(String username) {
        return null;
    }
    //插入一条用户数据
    @Override
    public void insert(User user) {

    }
}
