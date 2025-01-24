package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacemantDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
@Tag(name = "Lists", description = "Endpoints for managing Lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;


    // GET Find ALL
    @GetMapping
    @Operation(summary = "Finds All Lists",
            description = "Finds All Lists",
            tags = {"Lists"})
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }


    //GET by ID
    @GetMapping(value = "/{listId}/games")
    @Operation(summary = "Finds list by id",
            description = "Finds list by id",
            tags = {"Lists"})
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    // POST replace on list via Body
    @PostMapping (value = "/{listId}/replacement")
    @Operation(summary = "Replaces a game on list",
            description = "Replaces a game on list",
            tags = {"Lists"})
    public void move(@PathVariable Long listId, @RequestBody ReplacemantDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
