package service.impl;

import dao.impl.SpecialityDao;
import dao.intf.ISpecialityDao;
import domain.Speciality;
import service.intf.ISpecialitySercice;

public class SpecialityService implements ISpecialitySercice {
    ISpecialityDao specialityDao = new SpecialityDao();

    /**
     * 根据专业名称查询专业信息
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Speciality findSpecilityByName(String name) throws Exception {
        Speciality result = specialityDao.findByName(name);
        return result;
    }
}
