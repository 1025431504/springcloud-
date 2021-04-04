package com.couldstart.repository;

import com.couldstart.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

//第一个泛型 当前repository所操作对象的类型
//第二个泛型 当前repository所操作对象的id类型
public interface DepartRepository extends JpaRepository<Depart,Integer> {
}
