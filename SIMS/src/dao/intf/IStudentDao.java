package dao.intf;

import domain.Student;

import java.util.List;

public interface IStudentDao {
    //查找所有学生记录
        List<Student> findAll();
    //根据sno查找一个学生记录
        Student findBySno(int sno);
    //根据id删除一条学生记录
        void deleteById(int sno);
    //根据学生id修改该学生信息
        void  updateById(int id);
    //添加一条学生信息（主键字段自增长不写）
        void insert(Student student);
}
