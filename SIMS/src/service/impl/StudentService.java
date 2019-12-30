package service.impl;

import dao.impl.StudentDao;
import dao.intf.IStudentDao;
import domain.Student;
import service.intf.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentDao studentDao = new StudentDao();
    /**
     * 获取所有学生信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findAll() throws Exception {
        List<Student> result = studentDao.findAll();
        return result;
    }

    /**
     * 根据学生关键字查询学生信息
     * @param keyWord
     * @return
     * @throws Exception
     */
    @Override
    public Student findStudentByName(String keyWord) throws Exception {
        return null;
    }

    /**
     * 添加一条学生信息
     * @param student
     * @throws Exception
     */
    @Override
    public void addStudent(Student student) throws Exception {

    }

    /**
     * 根据学生ID删除学生信息
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteById(int id) throws Exception {
        studentDao.deleteById(id);
    }

    @Override
    public List<Student> findLike(String keyword) throws Exception{
        List<Student> result = studentDao.findLike("%"+keyword+"%");
        return result;
    }
}
