package controller;

import domain.User;
import service.impl.UserService;
import service.intf.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService=new UserService();
        int sims =Integer.parseInt(request.getParameter("sims"));
        //if-start
        if (sims==0){//用户登录

        }else if (sims==1){//用户注册

        }else if (sims==2){//用户查询

        }else if (sims==3){//用户授权

        }
        //if-end
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
