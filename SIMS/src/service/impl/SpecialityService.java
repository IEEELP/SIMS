package service.impl;

import dao.impl.SpecialityDao;
import dao.intf.ISpecialityDao;
import domain.Speciality;
import service.intf.ISpecialitySercice;

import java.util.List;

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

    @Override
    public List<Speciality> findAll() throws Exception {
        return null;
    }

    @Override
    public Speciality findSpecialityByName(String keyWord) throws Exception {
        return null;
    }

    @Override
    public void addSpeciality(Speciality speciality) throws Exception {

    }

    @Override
    public void deleteById(int id) throws Exception {

    }

    @Override
    public List<Speciality> findLike(String keyword) throws Exception {
        return null;
    }
}
