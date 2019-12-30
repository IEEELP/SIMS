package controller;

import domain.Teacher;
import service.impl.TeacherService;
import service.intf.ITeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
    ITeacherService teacherService = new TeacherService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int sims = Integer.parseInt(request.getParameter("sims"));
            //sims为0，遍历教师信息
            if (sims==0){
                try {
                    List<Teacher> result = teacherService.findAll();
                    request.setAttribute("result",result);
                    request.getRequestDispatcher("/pages/tea-list.jsp").forward(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (sims==1){ //sims为1，搜索教师信息
                String keyword = request.getParameter("keyword");
                try {
                    List<Teacher> result = teacherService.findLike(keyword);
                    request.setAttribute("result",result);
                    request.getRequestDispatcher("/pages/tea-list.jsp").forward(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (sims==2){ //sims为2，添加教师信息


            }else if (sims==3){ //删除一条教师信息
                String teacherid = request.getParameter("teacherid");
                try {
                    teacherService.deleteById(Integer.parseInt(teacherid));
                    response.sendRedirect("/TeacherController?sims=0");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
