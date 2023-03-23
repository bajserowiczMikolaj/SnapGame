package org.example;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//Rules

// each player geting one card each round by pressing user take turn
// each turn a new card is dealt from the deck
//games end when two cards in the row have the same symbol

public class Snap extends CardGame {

    private boolean GameOn = true;
    Card oldCard;
    Card newCard;
    private int roundCounter = 1;
    Scanner scanner = new Scanner(System.in);

    public Snap(ArrayList<Card> deckOfCards) {
        super(deckOfCards);
    }

    public Snap(String name) {
        super(name);
    }

    @Override
    public void printDeck() {
        super.printDeck();
    }

    public void play() {
        System.out.println("Welcome the the Game!");
        System.out.println("Rules are very simple if you get 2 same cards in the row, you win !");
        System.out.println("press enter and start game now !");
        String enterPress = scanner.nextLine();
        Objects.equals(enterPress, "");
    }

    public void displayCards() {
        if (!(this.oldCard == null)) {
            System.out.println(this.oldCard);
            System.out.println(this.newCard);
        } else {
            System.out.println(this.newCard);
        }
    }

    public Card dealCard() {
        if (newCard != null) {
            oldCard = newCard;
        }
        newCard = deckOfCards.get(0);
        deckOfCards.remove(newCard);
        deckOfCards.add(deckOfCards.size() - 1, newCard);
        return newCard;
    }

    public void turnCheck() {
        roundCounter++;
        if (roundCounter % 2 == 0) {
            System.out.println("player 1");
        } else {
            System.out.println("player 2");
        }
    }

    @Override
    public ArrayList<Card> shuffleDeck() {
        return super.shuffleDeck();
    }

    public void checkWin(Card oldCard, Card newCard) {
        if (oldCard != null || newCard != null) {
            assert oldCard != null;
            if (oldCard.getValue() == newCard.getValue()) {
                System.out.println("Snap!!!!");
                turnCheck();
                System.out.println(" is a winner !!!!");
                GameOn = false;
            }
        }
//        try {
//            Thread.sleep(secondsToSleep * 1000);
//        } catch (InterruptedException ie) {
//            Thread.currentThread().interrupt();
//        }
    }
    public void playGame() {
        populateDeck();
       shuffleDeck();
        dealCard();
        play();
        while (GameOn) {
           // System.out.println(newCard);
            dealCard();
            turnCheck();
            displayCards();
            checkWin(newCard, oldCard);
            System.out.println("Press enter to take another card...");
            Scanner scanner = new Scanner(System.in);
            String newCard = scanner.nextLine();

        }
    }
}
