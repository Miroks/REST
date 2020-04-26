package poject.dao;


import com.sun.prism.PixelFormat;
import org.springframework.stereotype.Repository;
import poject.domain.Circle;
import poject.domain.DataTable;
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
    public List<DataTable> getAll() {
        return entityManager.createQuery("select e from DataTable e", DataTable.class).getResultList();
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
