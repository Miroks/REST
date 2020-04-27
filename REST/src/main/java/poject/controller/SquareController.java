package poject.controller;


import dto.SquareDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import poject.domain.Square;
import poject.services.ShapeService;

import java.util.List;

@RestController
public class SquareController {

    @Autowired
    ShapeService shapeService;

    @GetMapping(value = "/getAllS")
    public @ResponseBody
    List getAllS() {
        return shapeService.getAllSquare();
    }

    @PostMapping(value = "/addS")
    public void addShapes(@RequestBody SquareDto square){
        Square newSquare = new Square(square.getSide());
        shapeService.addS(newSquare);
    }

    @Autowired
    ModelMapper modelMapper;

    private SquareDto convertToDtoS(Square square) {
        SquareDto squareDto = modelMapper.map(square, SquareDto.class);
        return squareDto;
    }

    private Square convertToEntityS(SquareDto squareDto){
        Square square = modelMapper.map(squareDto, Square.class);
        return square;
    }
}
