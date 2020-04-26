package poject.dto;


import dto.CircleDto;
import dto.SquareDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import poject.domain.Circle;
import poject.domain.Square;
import poject.services.ShapeService;

import java.text.ParseException;
import java.util.List;


@RestController
public class ShapeController {

    @Autowired
    ShapeService shapeService;

    @RequestMapping("/")
    public String home(){
        return "**<<>>**";
    }

    @GetMapping(value = "/getAll")
    public @ResponseBody List getAll(){
        return shapeService.getAll();
    }

    @GetMapping(value = "/getAllC")
    public @ResponseBody List getAllC() {
        return shapeService.getAllCircle();
    }

    @GetMapping(value = "/getAllS")
    public @ResponseBody List getAllS() {
        return shapeService.getAllSquare();
    }

    @PostMapping(value = "/addC")
    public void addShapes(@RequestBody CircleDto circle){
        Circle newCircle = new Circle(circle.getRadius());
        shapeService.addC(newCircle);
    }

    @PostMapping(value = "/addS")
    public void addShapes(@RequestBody SquareDto square){
        Square newSquare = new Square(square.getSide());
        shapeService.addS(newSquare);
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

    private SquareDto convertToDtoS(Square square) {
        SquareDto squareDto = modelMapper.map(square, SquareDto.class);
        return squareDto;
    }

    private Square convertToEntityS(SquareDto squareDto){
        Square square = modelMapper.map(squareDto, Square.class);
        return square;
    }

}
