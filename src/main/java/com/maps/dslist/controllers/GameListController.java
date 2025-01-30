package com.maps.dslist.controllers;

import com.maps.dslist.dto.GameListDTO;
import com.maps.dslist.dto.GameMinDTO;
import com.maps.dslist.services.GameListService;
import com.maps.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping
    public GameListDTO insert(@RequestBody GameListDTO dto) {
        return gameListService.insert(dto);
    }

    @PutMapping("/{id}")
    public GameListDTO update(@PathVariable Long id, @RequestBody GameListDTO dto) {
        return gameListService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gameListService.delete(id);
    }


}
