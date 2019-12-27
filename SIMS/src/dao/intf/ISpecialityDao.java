package dao.intf;

import domain.Speciality;

import java.sql.SQLException;
import java.util.List;

/**
 * 学生专业的Dao层接口
 */
public interface ISpecialityDao {
    /**
     * 查询所有专业
     * @return
     * @throws SQLException
     */
    List<Speciality> findAll() throws SQLException;

    /**
     * 根据专业 ID查询专业信息
     * @return
     * @throws SQLException
     */
    Speciality findById(int id) throws SQLException;

    /**
     * 根据专业 ID删除专业
     * @param id
     * @throws SQLException
     */
    void deleteById(int id) throws SQLException;

    /**
     * 根据专业id,更新专业信息
     * @param id
     * @param speciality
     * @throws SQLException
     */
    void updateById(int id,Speciality speciality) throws SQLException;

    /**
     * 插入一条专业信息
     * @param speciality
     * @throws SQLException
     */
    void insert(Speciality speciality) throws SQLException;
}