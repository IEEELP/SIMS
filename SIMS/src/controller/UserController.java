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
        if (sims==1){
            try {
                List<User> result = userService.findAll();
                request.setAttribute("result",result);
                request.getRequestDispatcher("").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==2){

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
