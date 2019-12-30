package controller;

import dao.impl.DormitoryDao;
import dao.intf.IDormitoryDao;
import domain.Dormitory;
import domain.Speciality;
import domain.Student;
import service.impl.DormitoryService;
import service.impl.SpecialityService;
import service.impl.StudentService;
import service.intf.IDormitoryService;
import service.intf.ISpecialitySercice;
import service.intf.IStudentService;
import utils.StringDateTransformUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    IStudentService studentService = new StudentService();
    IDormitoryService dormitoryService = new DormitoryService();
    ISpecialitySercice specialitySercice = new SpecialityService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sims = Integer.parseInt(request.getParameter("sims"));
        //sims为0，遍历学生信息
        if (sims==0){
            try {
                List<Student> result = studentService.findAll();
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/stu-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==1){ //sims为1，搜索学生信息
            String keyword = request.getParameter("keyword");
            try {
                List<Student> result = studentService.findLike(keyword);
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/stu-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if (sims==2){ //sims为2，添加学生信息
            String sno = request.getParameter("sno");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String birth = request.getParameter("birth");
            String spe = request.getParameter("spe");
            String dor = request.getParameter("dor");
            Student student = new Student();
            student.setSno(Integer.parseInt(sno));
            student.setName(name);
            student.setSex(Integer.parseInt(sex));
            student.setBirthday(new StringDateTransformUtils().StringToDate(birth));
            try {
                if (dor!=""&&dor!=null) {
                    //根据宿舍dno查询宿舍信息
                    Dormitory dormitory = dormitoryService.findByDno(Integer.parseInt(dor));
                    if (dormitory!=null){
                        student.setDormitoryid(dormitory.getId());
                    }
                }
                //根据专业名称查询专业信息
                Speciality specility = specialitySercice.findSpecilityByName(spe);
                student.setSpecialityid(specility.getId());
                studentService.addStudent(student);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==3){ //删除一条教师信息
            String studentid = request.getParameter("studentid");
            try {
                studentService.deleteById(Integer.parseInt(studentid));
                response.sendRedirect("/StudentController?sims=0");
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
