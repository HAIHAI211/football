package com.highschool.football.controller;

import com.highschool.football.dao.PersonRepository;
import com.highschool.football.entity.CommonReponse;
import com.highschool.football.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    /*
    * 查询全部人员
    * */
    @GetMapping(value="/find/all")
    private List<Person> personList(){
        return personRepository.findAll();
    }

    /*
    * 查询一个人员
    * by id
    * */
    @GetMapping(value = "/find/one/{id}")
    public CommonReponse<Person> personFindOne(@PathVariable("id") Integer id){
        Optional<Person> optional = personRepository.findById(id);
        // return new CommonReponse<Person>(true, optional.get());
         return new CommonReponse<Person>(optional.isPresent(),optional.isPresent()? optional.get() : null);
    }

    /*
    * 添加一个人员
    * */
    @PostMapping(value = "/add")
    public Person personAdd(@RequestParam("name") String name,
                             @RequestParam("age") Integer age){
        Person person=new Person();
        person.setName(name);
        person.setAge(age);

        return personRepository.save(person);
    }

    /*
    * 删除一个人员
    * by id
    * */
    @PostMapping(value = "/delete/{id}")
    public void personDelete(@PathVariable("id") Integer id){
        personRepository.deleteById(id);
    }

    /*
    * 更新一个人员
    * by params
    * */
//    @PostMapping(value = "/update/{id}")
//    public Person personUpdate(@PathVariable("id") Integer id,
//                               @RequestParam("name") String name,
//                               @RequestParam("age") Integer age){
//        Person person=new Person();
//        person.setId(id);
//        person.setName(name);
//        person.setAge(age);
//        return personRepository.save(person);
//    }

    /*
    * 更新一个人员
    * by entity
    * */
    @PostMapping(value = "/update/{id}")
    public Person personUpdate(@PathVariable("id") Integer id,@RequestBody Person person){
        person.setId(id);
        return personRepository.save(person);
    }


}
