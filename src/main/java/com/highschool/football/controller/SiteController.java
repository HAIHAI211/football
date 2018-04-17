package com.highschool.football.controller;

import com.highschool.football.dao.SiteRepository;
import com.highschool.football.entity.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/site")
public class SiteController {
    @Autowired
    SiteRepository siteRepository;

    /*
    * 查询全部场馆
    * */
    @GetMapping(value="/find")
    private List<Site> siteList(){
        return siteRepository.findAll();
    }

}
