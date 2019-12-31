package service.intf;

import domain.Student;

import java.util.List;

public interface IStudentService {
    /**
     * 获取所有学生信息
     * @return
     * @throws Exception
     */
    List<Student> findAll() throws Exception;

    /**
     * 根据学生关键字搜索学生信息
     * @return
     * @throws Exception
     */
    Student findStudentByName(String keyWord) throws Exception;

    /**
     * 添加学生信息
     * @param student
     * @throws Exception
     */
    void addStudent(Student student) throws Exception;

    /**
     * 根据学生ID删除学生信息
     * @param id
     * @throws Exception
     */
    void deleteById(int id) throws Exception;

    /**
     * 模糊查询
     * @return
     * @throws Exception
     */
    List<Student> findLike(String keyword) throws Exception;

    /**
     * 详情
     * @param id
     * @return
     * @throws Exception
     */
    Student findDetail(int id) throws Exception;

    /**
     * 根据学生sno查询学生信息
     * @return
     * @throws Exception
     */
    Student findStudentBySno(int sno) throws Exception;
}
