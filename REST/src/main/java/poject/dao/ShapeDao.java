package poject.dao;


import org.springframework.stereotype.Repository;
import poject.domain.Circle;
import poject.domain.Shape;
import poject.domain.Square;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class ShapeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Shape> getAll() {
        return entityManager.createQuery("SELECT e FROM Shape e", Shape.class).getResultList();
    }

    @Transactional
    public Shape searchById(Long i){
        return entityManager.createQuery("SELECT e FROM Shape e WHERE e.id=:value",Shape.class).setParameter("value",i).getSingleResult();
    }

    @Transactional
    public Shape deleteById(Long i){
        Shape shape = entityManager.createQuery("SELECT e FROM Shape e WHERE e.id=:value",Shape.class).setParameter("value",i).getSingleResult();
        entityManager.createQuery("DELETE FROM Shape WHERE id=:value").setParameter("value",i).executeUpdate();
        return shape;
    }

    @Transactional
    public Circle addC(Circle circle){
        entityManager.merge(circle);
        return circle;
    }

    @Transactional
    public Square addS(Square square){
        entityManager.merge(square);
        return square;
    }
}
