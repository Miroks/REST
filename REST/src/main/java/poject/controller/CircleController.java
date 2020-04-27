package poject.controller;


import dto.CircleDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import poject.domain.Circle;
import poject.services.ShapeService;

import java.util.List;

@RestController
public class CircleController {

    @Autowired
    ShapeService shapeService;

    @GetMapping(value = "/getAllC")
    public @ResponseBody
    List getAllC() {
        return shapeService.getAllCircle();
    }

    @PostMapping(value = "/addC")
    public void addShapes(@RequestBody CircleDto circle){
        Circle newCircle = new Circle(circle.getRadius());
        shapeService.addC(newCircle);
    }

    @Autowired
    ModelMapper modelMapper;

    private CircleDto convertToDtoC(Circle circle) {
        CircleDto circleDto = modelMapper.map(circle, CircleDto.class);
        return circleDto;
    }

    private Circle convertToEntityC(CircleDto circleDto){
        Circle circle = modelMapper.map(circleDto, Circle.class);
        return circle;
    }
}
