package ru.banana.DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.banana.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<User> index() {
        return em.createQuery("select p from User p", User.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        em.persist(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        em.merge(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        em.remove(show(id));
    }
}
