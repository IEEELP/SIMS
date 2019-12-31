package controller;

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
            String specialityid = request.getParameter("specialityid");
            String dormitoryid = request.getParameter("dormitoryid");
            try {
                Student student = new Student();
                if(sno!=null&&name!=null&&sex!=null&&birth!=null&&specialityid!=null&&dormitoryid!=null){
                    student.setSno(Integer.parseInt(sno));
                    student.setName(name);
                    student.setSex(Integer.parseInt(sex));
                    student.setBirthday(new StringDateTransformUtils().StringToDate(birth));
                    student.setSpecialityid(Integer.parseInt(specialityid));
                    student.setDormitoryid(Integer.parseInt(dormitoryid));
                    //查询数据库中是否存在当前学生信息
                    Student result = studentService.findStudentBySno(Integer.parseInt(sno));
                    if (result==null){
                        studentService.addStudent(student);
                        request.getRequestDispatcher("/StudentController?sims=0").forward(request,response);
                    }else{
                        request.setAttribute("massage","当前学生已经存在，请重新输入！");
                        request.getRequestDispatcher("/pages/fail.jsp").forward(request,response);
                    }
                }else{
                    request.setAttribute("massage","学生信息不完整，请重新输入！");
                    request.getRequestDispatcher("/pages/fail.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==3){ //删除一条学生信息
            String studentid = request.getParameter("studentid");
            try {
                studentService.deleteById(Integer.parseInt(studentid));
                response.sendRedirect("/StudentController?sims=0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==4){ //详情
            String studentid = request.getParameter("studentid");
            Student result = null;
            try {
                result = studentService.findDetail(Integer.parseInt(studentid));
                request.setAttribute("student",result);
                request.getRequestDispatcher("/pages/stu-detail.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==5){ //查询宿舍和专业信息
            try {
                List<Speciality> specialities = specialitySercice.findAll();
                List<Dormitory> dormitories = dormitoryService.findAll();
                request.setAttribute("spe",specialities);
                request.setAttribute("dor",dormitories);
                request.getRequestDispatcher("/pages/stu-add.jsp").forward(request,response);
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
