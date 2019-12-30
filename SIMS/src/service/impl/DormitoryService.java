package service.impl;

import dao.impl.DormitoryDao;
import dao.intf.IDormitoryDao;
import domain.Dormitory;
import service.intf.IDormitoryService;

import java.util.List;

public class DormitoryService implements IDormitoryService {
    IDormitoryDao dormitoryDao = new DormitoryDao();

    /**
     * 根据dno查询宿舍信息
     * @param dno
     * @return
     * @throws Exception
     */
    @Override
    public Dormitory findByDno(int dno) throws Exception {
        Dormitory result = dormitoryDao.findByDno(dno);
        return result;
    }

    @Override
    public List<Dormitory> findAll() throws Exception {
        return null;
    }

    @Override
    public Dormitory findDormitoryByName(String keyWord) throws Exception {
        return null;
    }

    @Override
    public void addDormitory(Dormitory dormitory) throws Exception {

    }

    @Override
    public void deleteById(int id) throws Exception {

    }

    @Override
    public List<Dormitory> findLike(String keyword) throws Exception {
        return null;
    }
}
