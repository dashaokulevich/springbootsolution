package com.example.springboot.springbootsolution.dao;

import com.example.springboot.springbootsolution.model.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void editUser(User user, Long id) {
        User person = entityManager.find(User.class, id);
        if (person != null) {
            person.setFirstName(user.getFirstName());
            person.setLastName(user.getLastName());
            person.setEmail(user.getEmail());
            entityManager.merge(person);
        }
    }
}