package dao.impl;

import dao.intf.IStudentDao;
import domain.Dormitory;
import domain.Speciality;
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
                    student.getSpeciality().getId(),student.getDormitory().getId(),student.getSno(),id};
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

    //查询一条学生信息，并且包含该学生所对应的寝室信息和专业信息。
    @Override
    public Student findStudentWithAll(int id) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        Object[] param={id};
        //查询学生信息
        Student student = queryRunner.query("select * from student where id=?", new BeanHandler<Student>(Student.class), param);
        Object[] p={student.getId()};
        //查询跟该学生信息有关联的寝室信息
        Dormitory dormitory = queryRunner.query(
                "select * from dormitory where id=(select dormitoryid from student where id=?)", new BeanHandler<Dormitory>(Dormitory.class),p);
        //查询跟该学生有关联的专业信息
        Speciality speciality = queryRunner.query(
                "select * from speciality where id=(select specialityid from student where id=?)", new BeanHandler<Speciality>(Speciality.class), p);
        //将关联信息全部分装为Student对象
        student.setDormitory(dormitory);
        student.setSpeciality(speciality);
        return student;
    }

}
