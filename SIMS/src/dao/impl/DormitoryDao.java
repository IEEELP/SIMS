package dao.impl;

import dao.intf.IDormitoryDao;
import domain.Dormitory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class DormitoryDao implements IDormitoryDao {
    @Override
    public List<Dormitory> findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Dormitory> result = queryRunner.query("select * from dormitory", new BeanListHandler<Dormitory>(Dormitory.class));
        return result;
    }

    @Override
    public Dormitory findByDno(int dno) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {dno};
        Dormitory result = queryRunner.query("select * from dormitory where dno=?", new BeanHandler<>(Dormitory.class), param);
        return result;
    }

    @Override
    public void deleteById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {id};
        queryRunner.update("delete from dormitory where id=?",param);
    }

    @Override
    public void updateById(int id, Dormitory dormitory) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {dormitory.getDno(),dormitory.getType(),id};
        queryRunner.update("update dormitory set dno=?,type=? where id=?",param);
    }

    @Override
    public void inset(Dormitory dormitory) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {dormitory.getDno(),dormitory.getType()};
        queryRunner.update("insert into dormitory(dno,type) values(?,?)",param);
    }
}
