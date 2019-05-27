package no.frode.cruddemo.controller;

import no.frode.cruddemo.entity.Product;
import no.frode.cruddemo.service.ProductService;
import no.frode.cruddemo.service.SlowMovieService;
import no.frode.cruddemo.service.SlowMovieServiceWithCustomCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name="Movies", value = "movies")
public class MovieController {

    @Autowired
    SlowMovieService slowMovieService;

    @Autowired
    SlowMovieServiceWithCustomCache slowMovieServiceWithCustomCache;

    @GetMapping(value = "/{director}")
    String getMovieByDirector(@PathVariable(name = "director") String director) {
        //return slowMovieService.findMoveByDirector(director);
        return slowMovieServiceWithCustomCache.findMoveByDirector(director);
    }
}
