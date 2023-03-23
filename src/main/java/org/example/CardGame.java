package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {

    String name;

    // constructor
    public CardGame(String name) {
        this.name = name;

    }

    public CardGame(ArrayList<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public ArrayList<Card> deckOfCards = new ArrayList<>();

//    public ArrayList<Card> getDeckOfCards() {
//        return deckOfCards;
//    }

    //just to check how my deck looks like
    public void printDeck() {
        for (Card card : deckOfCards) {
            System.out.println(card.toString());
        }
    }
    // Takes the card from the top of the deck and returns it.

    public Card dealCard(){
        Card chosenCard = deckOfCards.get(0);
        deckOfCards.remove(chosenCard);
        deckOfCards.add(deckOfCards.size()-1, chosenCard);
        return chosenCard;
    }

    //Sorts the deck in number order (e.g. 2222333344445555 etc) and stores the new shuffled deck back into
    //the deckOfCards attribute.
    //comparator method works --->
    public ArrayList<Card> sortDeckInNumberOrder(){
        deckOfCards.sort(Comparator.comparing(Card::getValue));
        return deckOfCards;
    }
    //Sorts the deck into suits (2,3,4,5,6,7,8,9,10,J,Q,K,A of hearts, then 2,3,4,5,6,7,8,9,10,J,Q,K,A of clubs etc.)
    //and stores the new shuffled deck back into the deckOfCards attribute
    public ArrayList<Card> sortDeckIntoSuits(){
        deckOfCards.sort(Comparator.comparing(Card::getSuit));
        return deckOfCards;
    }

    //Shuffles the deck into a random order and stores the new shuffled deck back into the deckOfCards attribute.
    public ArrayList<Card> shuffleDeck(){
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }

    //creating the deck of card -> probobly beter option than loop avalible
    public void populateDeck(){
        for (int i = 0; i < 4; i++) {
            for (int a = 0; a < 13; a++) {
                Card card = new Card(CardUtill.suits[i], CardUtill.symbol[a], CardUtill.value[a]);
                deckOfCards.add(card);
            }
        }
    }
}


//   // call the static method
//        // using double colon operator
//        list.forEach(class::someFunction);