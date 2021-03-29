package com.couldstart.service;

import com.couldstart.bean.Depart;

import java.util.List;

public interface DepartService {

    boolean saveDepart(Depart depart);

    boolean removeDepartById(Integer id);

    boolean modifyDepart(Depart depart);

    Depart getDepartById(Integer id);

    List<Depart> listAllDeparts();
}
