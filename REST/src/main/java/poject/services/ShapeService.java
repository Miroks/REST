package poject.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poject.dao.ShapeDao;
import poject.domain.Circle;
import poject.domain.DataTable;
import poject.domain.Square;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShapeService {

    @Autowired
    ShapeDao shapeDao;


    public List<DataTable> getAll() {
        return shapeDao.getAll();
    }

    public List<DataTable> getAllCircle() {
        return shapeDao.getAll().stream()
                .filter(b -> "Circle".equals(b.getType())).collect(Collectors.toList());
    }

    public List<DataTable> getAllSquare() {
        return shapeDao.getAll().stream()
                .filter(b -> "Square".equals(b.getType())).collect(Collectors.toList());
    }

    public void addC(Circle circle) {
        shapeDao.addC(circle);
    }

    public void addS(Square square) {
        shapeDao.addS(square);
    }
}
