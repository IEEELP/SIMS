package dao.impl;

import dao.intf.IStudentDao;
import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDao implements IStudentDao {
    /**
     * 查询所有学生信息
     * @return
     * @throws SQLException
     */
    @Override
    public List<Student> findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Student> result = queryRunner.query("select * from student",
                           new BeanListHandler<Student>(Student.class));
        return result;
    }

    /**
     * 根据学号查询学生信息
     * @param sno
     * @return
     * @throws SQLException
     */
    @Override
    public Student findBySno(int sno) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Object[] param = {sno};
        Connection connection = JDBCUtils.getDataSource().getConnection();
        Student result = queryRunner.query(connection, "select * from student where sno =?", new BeanHandler<Student>(Student.class), param);
        connection.close();
        return result;
    }

    /**
     * 根据学号删除学生信息
     * @param sno
     * @throws SQLException
     */
    @Override
    public void deleteById(int sno) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {sno};
        queryRunner.update("delete from student where sno =?", param);
    }

    /**
     * 根据id更新学生信息
     * @param id
     * @param student
     * @throws SQLException
     */
    @Override
    public void updateById(int id,Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {student.getName(),student.getSex(),student.getBirthday(),
                    student.getSpeciality().getId(),student.getDomitory().getId(),student.getSno(),id};
        queryRunner.update(
                "update student set name=?,sex=?,birthday=?,specialityid=?,domitoryid=?,sno=? where id=?",param);
    }

    /**
     * 插入一条学生信息
     * @param student
     * @throws SQLException
     */
    @Override
    public void insert(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {student.getName(),student.getSex(),student.getBirthday(),
                                student.getSno()};
        queryRunner.update(
                "insert into student(name,sex,birthday,sno) values(?,?,?,?)", param);
    }

}
