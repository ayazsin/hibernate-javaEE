package com.example.hib_03_web.dao;

import com.example.hib_03_web.bean.User;
import com.example.hib_03_web.exception.HbException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDao {

    public UserDao() {
        // TODO Auto-generated constructor stub
    }

    public User save(User obj) throws HbException {
        Session session = HibernateTools.getSessionFactory().openSession();
        session.beginTransaction();
        int id;
        try {
            id = (Integer) session.save(obj);
        } catch (Exception e) {
            throw new HbException ("Cannot insert object: " + obj);
        }
        session.getTransaction().commit();
        session.close();
        return obj;
    }

    public List<User> getAll() throws HbException {
        Session session = HibernateTools.getSessionFactory().openSession();
        session.beginTransaction();

        List<User> users;
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
            criteriaQuery.from(User.class);
            users = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new HbException ("Cannot list");
        }

        session.getTransaction().commit();
        session.close();
        return users;
    }


    public void delete(int id) throws HbException {
        Session session = HibernateTools.getSessionFactory().openSession();
        session.beginTransaction();
        User user=null;
        try {
            user = session.get(User.class, id);
            session.delete(user);
        } catch (Exception e) {
            throw new HbException ("Cannot delete id: " +id);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void update(int id, User obj) throws HbException {
        Session session = HibernateTools.getSessionFactory().openSession();
        session.beginTransaction();

        obj.setId(id);
        try {
            session.update(obj);//No need to update manually as it will be updated automatically on transaction close.
        } catch (Exception e) {
            throw new HbException ("Cannot update id: " +id);
        }
        session.getTransaction().commit();
        session.close();
    }
}
