package com.couldstart.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity //使用自动建表
//HttpMessageConverter jackson—》 实现json与对象的转换
//JPA的默认是hibernate 而hibernate默认对于对象的查询是基于延迟加载
//Depart depart = service.findById(5) 这里的depart 实际上是javasist动态代理对象
//String name = depart.getName() 时才会执行sql语句查询
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","fieldHandler"})
public class Depart {

    //标识当前属性为自动建表的主键
    @Id
    //自动递增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
