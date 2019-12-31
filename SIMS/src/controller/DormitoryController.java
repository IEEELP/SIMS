package controller;

import domain.Course;
import domain.Dormitory;
import domain.Speciality;
import domain.Student;
import service.impl.DormitoryService;
import service.impl.SpecialityService;
import service.intf.IDormitoryService;
import service.intf.ISpecialitySercice;
import utils.StringDateTransformUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DormitoryController")
public class DormitoryController extends HttpServlet {
   IDormitoryService dormitoryService = new DormitoryService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sims = Integer.parseInt(request.getParameter("sims"));
        //sims为0，遍历宿舍信息
        if (sims==0){
            try {
                List<Dormitory> result = dormitoryService.findAll();
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/dor-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==1){ //sims为1，搜索宿舍信息
            String keyword = request.getParameter("keyword");
            try {
                List<Dormitory> result = dormitoryService.findLike(keyword);
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/dor-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==2){ //sims为2，添加宿舍信息
            String dno = request.getParameter("dno");
            String type = request.getParameter("type");
            try {
                //查询数据库中是否存在当前宿舍信息
                Dormitory result = dormitoryService.findByDno(Integer.parseInt(dno));
                if (result==null){
                    Dormitory dormitory = new Dormitory();
                    dormitory.setDno(Integer.parseInt(dno));
                    dormitory.setType(Integer.parseInt(type));
                    dormitoryService.addDormitory(dormitory);
                    response.sendRedirect("/DormitoryController?sims=0");
                }else {
                    request.setAttribute("massage","当前宿舍信息已经存在，请重新输入");
                    request.getRequestDispatcher("/pages/fail.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==3){ //删除一条宿舍信息
            String dormitoryid = request.getParameter("dormitoryid");
            try {
                dormitoryService.deleteById(Integer.parseInt(dormitoryid));
                response.sendRedirect("/DormitoryController?sims=0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==4){ //宿舍详情信息
            String dormitoryid = request.getParameter("dormitoryid");
            try {
                Dormitory result = dormitoryService.findDetail(Integer.parseInt(dormitoryid));
                request.setAttribute("dor",result);
                request.getRequestDispatcher("/pages/dor-detail.jsp").forward(request,response);
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