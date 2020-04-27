package poject.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poject.dao.ShapeDao;
import poject.domain.Circle;
import poject.domain.Shape;
import poject.domain.Square;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShapeService {

    @Autowired
    ShapeDao shapeDao;


    public List<Shape> getAll() {
        return shapeDao.getAll();
    }

    public List<Shape> getAllCircle() {
        return shapeDao.getAll().stream()
                .filter(b -> "Circle".equals(b.getType())).collect(Collectors.toList());
    }

    public List<Shape> getAllSquare() {
        return shapeDao.getAll().stream()
                .filter(b -> "Square".equals(b.getType())).collect(Collectors.toList());
    }

    public Shape searchById(Long i){
        return shapeDao.searchById(i);
    }

    public Shape deleteById(Long i){
        //Shape shape = shapeDao.searchById(i);
        return shapeDao.deleteById(i);
        //return shape;
    }

    public void addC(Circle circle) {
        shapeDao.addC(circle);
    }

    public void addS(Square square) {
        shapeDao.addS(square);
    }
}
