package com.couldstart.controller;

import com.couldstart.bean.Depart;
import com.couldstart.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider/depart")
public class DepartController {
    @Autowired
    DepartService departService;

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
}
