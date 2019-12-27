package service.impl;

import dao.impl.UserDao;
import dao.intf.IUserDao;
import domain.User;
import service.intf.IUserService;

import java.util.List;

public class UserService implements IUserService {
    IUserDao dao=new UserDao();

    /**查询所有用户信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<User> findAll() throws Exception {
        List<User> result = dao.findAll();
        return result;
    }

    /**用户登录
     *
     * @param user
     * @return
     */
    @Override
    public Boolean login(User user) throws Exception {
        User userByUsername = dao.findUserByUsername(user.getUsername());
        String password = userByUsername.getPassword();
        if (password==null||password==""){
            return false;
        }
        if (password.equals(user.getPassword())){
            return true;
        }else{
            return false;
        }
    }

    /**用户注册
     *
     * @param user
     */
    @Override
    public Boolean register(User user) throws Exception {
        User userByUsername =null;
        userByUsername = dao.findUserByUsername(user.getUsername());
        //用户不存在
        if (userByUsername==null){
            int insert = dao.insert(user);
            if (insert==1){
                return true;
            }
            return false;
        }
        return false;
    }
}
