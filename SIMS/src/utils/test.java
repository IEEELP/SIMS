package utils;

import dao.impl.StudentDao;
import dao.intf.IStudentDao;
import domain.Student;
import org.junit.Test;

import java.sql.SQLException;

public class test {
    @Test
    public void findStudentWithAllTTest(){

        try {
            IStudentDao studentDao=new StudentDao();
            Student studentWithAll = studentDao.findStudentWithAll(1);
            System.out.println(studentWithAll);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
