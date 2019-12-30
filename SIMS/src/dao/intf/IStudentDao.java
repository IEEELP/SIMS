package dao.intf;

import domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDao {
        //查找所有学生记录
        List<Student> findAll() throws SQLException;
        //根据sno查找一个学生记录
        Student findBySno(int sno) throws SQLException;
        //根据id删除一条学生记录
        void deleteById(int id) throws SQLException;
        //根据学生id修改该学生信息
        void  updateById(int id,Student student) throws SQLException;
        //添加一条学生信息（主键字段自增长不写）
        void insert(Student student) throws SQLException;
        //查询一条学生信息，并且包含该学生所对应的寝室信息和专业信息。
        Student findStudentWithAll(int id) throws SQLException;
        //模糊查询
        List<Student> findLike(String keyword) throws Exception;
        //查询一条学生信息，附带关联的宿舍信息和专业信息
        Student findDetail(int id) throws Exception;
}
