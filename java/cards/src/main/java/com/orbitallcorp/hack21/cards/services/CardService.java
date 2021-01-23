package com.orbitallcorp.hack21.cards.services;


import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @PostMapping
    public Card save(Card card){
        return cardRepository.save((card));
    }

    @GetMapping
    public List<Card> findAll() {

        List<Card> cards = new ArrayList<Card>();
        for (Card card : (List<Card>) cardRepository.findAll()) {
            cards.add(card);
        }

    @GetMapping("/{id}")
    public List<Card> findById() {

        List<Card> id = new ArrayList<Card>();
        for (Card card : (List<Card>) cardRepository.findById(id)) {
            cards.add(card);
        }


    @PutMapping("/{id}")
    public Card updateCard(Card id) {
        return cardRepository.save((card));
    }


    @DeleteMapping("/{id}")
    public void delCard(Card id) {
            cardRepository.delete(id.get(Card));
    }

}