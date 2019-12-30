package service.impl;

import dao.impl.DormitoryDao;
import dao.intf.IDormitoryDao;
import domain.Dormitory;
import service.intf.IDormitoryService;

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
}
