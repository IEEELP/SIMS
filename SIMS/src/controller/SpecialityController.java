package controller;

import domain.Dormitory;
import domain.Speciality;
import domain.Student;
import service.impl.SpecialityService;
import service.intf.ISpecialitySercice;
import utils.StringDateTransformUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SpecialityController")
public class SpecialityController extends HttpServlet {
    ISpecialitySercice specialitySercice = new SpecialityService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sims = Integer.parseInt(request.getParameter("sims"));
        //sims为0，遍历专业信息
        if (sims==0){
            try {
                List<Speciality> result = specialitySercice.findAll();
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/spe-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //sims为1，搜索专业信息
        }else if (sims==1){
            String keyword = request.getParameter("keyword");
            try {
                List<Speciality> result = specialitySercice.findLike(keyword);
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/spe-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==2){ //sims为2，添加专业信息
            String name = request.getParameter("name");
            String faculty = request.getParameter("faculty");
            String type = request.getParameter("type");
            Speciality speciality = new Speciality();
            speciality.setName(name);
            speciality.setFaculty(faculty);
            speciality.setType(Integer.parseInt(type));
            try {
                //添加一条专业信息
                specialitySercice.addSpeciality(speciality);
                response.sendRedirect("/SpecialityController?sims=0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==3){ //删除一条专业信息
            String specialityid = request.getParameter("specialityid");
            try {
                specialitySercice.deleteById(Integer.parseInt(specialityid));
                response.sendRedirect("/SpecialityController?sims=0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==4){ //专业详情信息
            String specialityid = request.getParameter("specialityid");
            try {
                Speciality result = specialitySercice.findDetail(Integer.parseInt(specialityid));
                request.setAttribute("spe",result);
                request.getRequestDispatcher("/pages/spe-detail.jsp").forward(request,response);
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
