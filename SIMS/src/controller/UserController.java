package controller;

import domain.User;
import service.impl.UserService;
import service.intf.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserService();
        int sims = Integer.parseInt(request.getParameter("sims"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        HttpSession session = request.getSession();
        String drawCode = session.getAttribute("drawCode").toString();
        Boolean flag = drawCode.equalsIgnoreCase(code);
        //if-start
        if (sims == 0) { //用户登录
            if (flag){
                try {
                    Boolean  login = userService.login(user);
                    if (login) {
                        //登陆成功，重定向
                        response.sendRedirect("/pages/main.jsp");
                    } else {
                        //登录失败,跳转到登陆页面
                        request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                //验证码错误
                request.setAttribute("codeError", "验证码错误");
                request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
            }
        } else if (sims == 1) {//用户注策
            if (flag) {
                try {
                    Boolean register = userService.register(user);
                    if (register) {
                        response.sendRedirect("/pages/login.jsp");
                    } else {
                        response.setContentType("text/html;charset=utf-8");
                        request.setAttribute("registerFail", "注册失败");
                        request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                //验证码错误
                request.setAttribute("codeError", "验证码错误");
                request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
            }
        } else if (sims == 2) {//用户查询

        } else if (sims == 3) {//用户授权

        }
        //if-end
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
