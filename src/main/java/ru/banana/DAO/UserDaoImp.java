package ru.banana.DAO;

import org.springframework.stereotype.Repository;
import ru.banana.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> index() {
        return em.createQuery("select p from User p", User.class)
                .getResultList();
    }

    @Override
    public User show(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        em.merge(updatedUser);
    }

    @Override
    public void delete(int id) {
        em.remove(show(id));
    }
}
