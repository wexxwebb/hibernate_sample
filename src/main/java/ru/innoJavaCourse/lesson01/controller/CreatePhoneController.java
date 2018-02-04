package ru.innoJavaCourse.lesson01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innoJavaCourse.lesson01.db.dao.MobilePhoneDao;
import ru.innoJavaCourse.lesson01.db.entities.Certificate;
import ru.innoJavaCourse.lesson01.db.entities.Manufacturer;
import ru.innoJavaCourse.lesson01.db.entities.MobilePhone;


@Controller
public class CreatePhoneController {
    @Autowired
    private MobilePhoneDao mobilePhoneDao;

    @RequestMapping(value = "/createPhone", method = RequestMethod.GET )
    public ModelAndView showdata(){
        ModelAndView modelAndView = new ModelAndView("data");
        MobilePhone phone=new MobilePhone("Siemens C35", 13000, "Тоже ничего так телефон");
        Certificate certificate=new Certificate("134453", phone);
        phone.setCertificate(certificate);
        Manufacturer manufacturer=new Manufacturer("Siemens AG", "Germany");
        phone.setManufacturer(manufacturer);
        mobilePhoneDao.addPhone(phone);
        modelAndView.addObject("phone", mobilePhoneDao.getPhoneByID(2));
        return modelAndView;
    }
}
