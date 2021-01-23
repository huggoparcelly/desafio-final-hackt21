package com.orbitallcorp.hack21.cards.controllers;


import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.repositories.CardRepository;
import com.orbitallcorp.hack21.cards.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> Save(@RequestBody Card card) {
        Card savedCard = cardService.save((card));

        return new ResponseEntity(savedCard, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Card>> findAll(){
        List<Card> cards = cardService.findAll();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Card>> findByID(){
        List<Card> cards = cardService.findById();
        return ResponseEntity.ok(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@RequestBody Card card){
        return cardService.save((card));
    }

    @DeleteMapping("/{id}")
    public void delCard(@RequestBody Card card){
        cardService.delete(card);
    }
}
