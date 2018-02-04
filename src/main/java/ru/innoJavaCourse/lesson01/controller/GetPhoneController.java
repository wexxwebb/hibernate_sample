package ru.innoJavaCourse.lesson01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetPhoneController {

    @Autowired
    private ru.innoJavaCourse.lesson01.db.dao.MobilePhoneDao mobilePhoneDao;

    @RequestMapping(value = "/getPhone", method = RequestMethod.GET )
    public ModelAndView showdata(){
        ModelAndView modelAndView=new ModelAndView("data");
        modelAndView.addObject("phone", mobilePhoneDao.getPhoneByID(102));
        return modelAndView;
    }
}
