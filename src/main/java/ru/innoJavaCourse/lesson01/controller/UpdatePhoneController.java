package ru.innoJavaCourse.lesson01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innoJavaCourse.lesson01.db.dao.MobilePhoneDao;
import ru.innoJavaCourse.lesson01.db.entities.MobilePhone;

@Controller
public class UpdatePhoneController {
    @Autowired
    private MobilePhoneDao mobilePhoneDao;

    @RequestMapping(value = "/updatePhone", method = RequestMethod.GET )
    public ModelAndView showdata(){
        ModelAndView modelAndView = new ModelAndView("data");
        MobilePhone phone=mobilePhoneDao.getPhoneByID(2);
        phone.setModel("Iphone X");
        mobilePhoneDao.updatePhone(phone);
        modelAndView.addObject("phone", mobilePhoneDao.getPhoneByID(2));
        return modelAndView;
    }
}
