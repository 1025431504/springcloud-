package com.couldstart.controller;

import com.couldstart.bean.Depart;
import com.couldstart.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/provider/depart")
public class DepartController {
    @Autowired
    DepartService departService;

    //声明服务发现客户端
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/")
    public Boolean saveHandler(@RequestBody Depart depart){
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteHandler(@PathVariable Integer id){
        return departService.removeDepartById(id);
    };

    @PutMapping("/")
    public Boolean modifyHandler(@RequestBody Depart depart){
        return departService.modifyDepart(depart);
    }

    @GetMapping("/{id}")
    public Depart getHandler(@PathVariable Integer id){
        return departService.getDepartById(id);
    }

    @GetMapping("/")
    public List<Depart> listHandler(){
        return departService.listAllDeparts();
    }

    @GetMapping("/discovery")
    public List<String> discoveryHandler(){
        List<String> services = client.getServices();
        services.forEach(name->{
            //获取当前遍历微服务名称的所有提供者主机
            List<ServiceInstance> instances = client.getInstances(name);
            //遍历所有提供者主机的详细信息
            instances.forEach(instance -> {
                //获取当前提供者的唯一标识 serviceId
                String serviceId = instance.getServiceId();
                String instanceId = instance.getInstanceId();
                //获取当前提供者的主机host
                String host= instance.getHost();

                int port = instance.getPort();

                Map<String, String> metadata = instance.getMetadata();
                System.out.println("serviceId:"+serviceId);
                System.out.println("instanceId:"+instanceId);
                System.out.println("host:"+host);
                System.out.println("port:"+port);
                System.out.println("metadata:"+metadata);
            });
        });
        return null;
    }
}
