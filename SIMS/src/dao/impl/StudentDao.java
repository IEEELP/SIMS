package dao.impl;

import dao.intf.IStudentDao;
import domain.Student;

import java.util.List;

public class StudentDao implements IStudentDao {
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findBySno(int sno) {
        return null;
    }

    @Override
    public void deleteById(int sno) {

    }

    @Override
    public void updateById(int id) {

    }

    @Override
    public void insert(Student student) {

    }
}
