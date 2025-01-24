package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
@Tag(name = "Games", description = "Endpoints for managing Games")
public class GameController {

    @Autowired
    private GameService gameService;

    // GET findAll
    @GetMapping
    @Operation(summary = "Finds All Games",
            description = "Finds All Games",
            tags = {"Games"})
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    // GET findById
    @GetMapping(value = "/{id}")
    @Operation(summary = "Finds games by Id",
            description = "Finds games by Id",
            tags = {"Games"})
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }

}
