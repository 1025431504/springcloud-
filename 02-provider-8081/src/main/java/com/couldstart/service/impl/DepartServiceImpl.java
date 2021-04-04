package com.couldstart.service.impl;

import com.couldstart.bean.Depart;
import com.couldstart.repository.DepartRepository;
import com.couldstart.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    DepartRepository departRepository;

    /**
     * 新增
     * @param depart
     * @return
     */
    @Override
    public boolean saveDepart(Depart depart) {
        Depart obj = departRepository.save(depart);
        return obj!=null?true:false;
    }

    @Override
    public boolean removeDepartById(Integer id) {
        if(departRepository.existsById(id)){
            //若指定id不存在 则会抛出异常
            departRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart obj = departRepository.save(depart);
        return obj!=null?true:false;
    }

    @Override
    public Depart getDepartById(Integer id) {
        if(departRepository.existsById(id)){
           return departRepository.getOne(id);
        }
        return null;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return departRepository.findAll();
    }
}
