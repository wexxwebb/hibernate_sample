package ru.innoJavaCourse.lesson01.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innoJavaCourse.lesson01.db.entities.MobilePhone;

@Repository
public class MobilePhoneDao {

    @Autowired
    private SessionFactory factory;

    public MobilePhone getPhoneByID(long id){
        Session session=factory.openSession();
        session.beginTransaction();
        MobilePhone phone=(MobilePhone) session.get(MobilePhone.class, id);
        session.getTransaction().commit();
        session.close();
        return phone;
    }

    public void addPhone (MobilePhone phone){
        Session session=factory.openSession();
        session.beginTransaction();
        session.save(phone);
        session.getTransaction().commit();
        session.close();
    }

    public void updatePhone (MobilePhone phone){
        Session session=factory.openSession();
        session.beginTransaction();
        session.update(phone);
        session.getTransaction().commit();
        session.close();
    }

    public void deletePhoneById (long id){
        Session session=factory.openSession();
        session.beginTransaction();
        MobilePhone phone=session.get(MobilePhone.class, id);
        session.delete(phone);
        session.getTransaction().commit();
        session.close();
    }
}
