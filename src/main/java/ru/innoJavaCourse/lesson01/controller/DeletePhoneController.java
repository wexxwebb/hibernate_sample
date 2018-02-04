package ru.innoJavaCourse.lesson01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innoJavaCourse.lesson01.db.dao.MobilePhoneDao;
import ru.innoJavaCourse.lesson01.db.entities.MobilePhone;

@Controller
public class DeletePhoneController {
    @Autowired
    private MobilePhoneDao mobilePhoneDao;

    @RequestMapping(value = "/deletePhone", method = RequestMethod.GET )
    public ModelAndView showdata(){
        ModelAndView modelAndView = new ModelAndView("data");
        mobilePhoneDao.deletePhoneById(2);
        MobilePhone phone=mobilePhoneDao.getPhoneByID(2);
        modelAndView.addObject("phone", mobilePhoneDao.getPhoneByID(2));
        return modelAndView;
    }
}
