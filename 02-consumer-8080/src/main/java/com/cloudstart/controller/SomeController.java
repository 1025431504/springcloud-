package com.cloudstart.controller;

import com.cloudstart.bean.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/depart")
public class SomeController {
    @Autowired
    private RestTemplate restTemplate;

    //直连提供者
    // private static final String SERVICE_PROVIDER = "http://localhost:8081";
    //要使用微服务名称来从eureka server查找提供者
    private static final String SERVICE_PROVIDER = "http://cloudstart-provider-depart";
    @PostMapping("/")
    public boolean saveHandler(@RequestBody Depart depart){
        String url = SERVICE_PROVIDER+"/provider/depart/";
        return restTemplate.postForObject(url,depart,Boolean.class);
    }

    @DeleteMapping("/{id}")
    public void deleteHandler(@PathVariable Integer id){
        String url = SERVICE_PROVIDER+"/provider/depart/"+id;
        restTemplate.delete(url);
    }

    @PutMapping("/")
    public void updateHandler(@RequestBody Depart depart){
        String url = SERVICE_PROVIDER+"/provider/depart/";
        restTemplate.put(url,depart);
    }

    @GetMapping("/{id}")
    public Depart getByIdHandler(@PathVariable Integer id){
        String url = SERVICE_PROVIDER+"/provider/depart/"+id;
        return restTemplate.getForObject(url,Depart.class);
    }

    @GetMapping("/")
    public List<Depart> listHandler(){
        String url = SERVICE_PROVIDER+"/provider/depart/";
        return  restTemplate.getForObject(url,List.class);
    }
}
