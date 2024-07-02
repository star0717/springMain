package com.dw.demo.controller;

import com.dw.demo.model.Game;
import com.dw.demo.service.GameShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameShopController {
    GameShopService gameShopService;

    public GameShopController(GameShopService gameShopService) {
        this.gameShopService = gameShopService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Game>> getAllGames() {
        return new ResponseEntity<>(gameShopService.getAllGames(),
                HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable long id) {
        return new ResponseEntity<>(gameShopService.getGameById(id),
                HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Game> updateGameById(@PathVariable long id,
                               @RequestBody Game game) {
        return new ResponseEntity<>(gameShopService.updateGameById(id, game),
                HttpStatus.OK);
    }

    @GetMapping("/products/maxprice")
    public ResponseEntity<Game> getGameWithMaxPrice() {
        return new ResponseEntity<>(gameShopService.getGameWithMaxPrice(),
                HttpStatus.OK);
    }

    @GetMapping("/products/maxpricetop3")
    public ResponseEntity<List<Game>> getGameWithMaxPriceTop3() {
        return new ResponseEntity<>(gameShopService.getGameWithMaxPriceTop3(),
                HttpStatus.OK);
    }
}





