package poject.controller;


import dto.CircleDto;
import dto.SquareDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import poject.domain.Circle;
import poject.domain.Shape;
import poject.domain.Square;
import poject.services.ShapeService;

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

    @GetMapping(value = "/searchById/{id}")
    public @ResponseBody Shape searchById(@PathVariable("id") Long id){
        return shapeService.searchById(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        shapeService.deleteById(id);
    }
}
