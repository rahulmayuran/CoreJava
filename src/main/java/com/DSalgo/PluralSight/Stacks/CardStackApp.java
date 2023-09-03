package com.DSalgo.PluralSight.Stacks;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/*This class goes along with the DS_Stack class
* It is an implementation of the Stack operations with an example of Deck of Cards
*
* There are 5 methods declared here that correlates with the
* 5 stack operation done in DS_Stack class
*
* 1. stackCards() - push
* 2. unStackCards() - pop
* 3. deckSize() - size
* 4. containsCard("Any String representation of a card") - contains
* 5. goToCard("Any String representation of a card") - access
* */
@Slf4j
public class CardStackApp {

    StackDataStructure<String> stack = new StackDataStructure<>();

    public static void main(String[] args) {
        CardStackApp cards = new CardStackApp();

        cards.stackCards();

        cards.unstackCards();

        //Restack Cards
        cards.stackCards();

        log.info("Total Cards in the deck -> ");
        cards.deckSize();

        log.info("Does the deck have Ace of Spades? -> ");
        cards.containsCard("Ace of Spades");
        log.info("Does the deck have a Joker? -> ");
        cards.containsCard("Joker");

        Scanner scan = new Scanner(System.in);

            log.info("Enter the card to access");
            String cardToAccess = scan.nextLine();
            cards.goToCard(cardToAccess);

        log.info("Remaining Cards in the deck -> ");
        cards.deckSize();
    }

    private void stackCards() {
        //Stack the spade suit
        stack.push("Ace of Spades");
        stack.push("2 of Spades");
        stack.push("3 of Spades");
        stack.push("4 of Spades");
        stack.push("5 of Spades");
        stack.push("6 of Spades");
        stack.push("7 of Spades");
        stack.push("8 of Spades");
        stack.push("9 of Spades");
        stack.push("10 of Spades");
        stack.push("Jack of Spades");
        stack.push("Queen of Spades");
        stack.push("King of Spades");

        //Stack the diamond suit
        stack.push("Ace of Diamonds");
        stack.push("2 of Diamonds");
        stack.push("3 of Diamonds");
        stack.push("4 of Diamonds");
        stack.push("5 of Diamonds");
        stack.push("6 of Diamonds");
        stack.push("7 of Diamonds");
        stack.push("8 of Diamonds");
        stack.push("9 of Diamonds");
        stack.push("10 of Diamonds");
        stack.push("Jack of Diamonds");
        stack.push("Queen of Diamonds");
        stack.push("King of Diamonds");

        //Stack the heart suit
        stack.push("Ace of Hearts");
        stack.push("2 of Hearts");
        stack.push("3 of Hearts");
        stack.push("4 of Hearts");
        stack.push("5 of Hearts");
        stack.push("6 of Hearts");
        stack.push("7 of Hearts");
        stack.push("8 of Hearts");
        stack.push("9 of Hearts");
        stack.push("10 of Hearts");
        stack.push("Jack of Hearts");
        stack.push("Queen of Hearts");
        stack.push("King of Hearts");

        //Stack the club suit
        stack.push("Ace of Clubs");
        stack.push("2 of Clubs");
        stack.push("3 of Clubs");
        stack.push("4 of Clubs");
        stack.push("5 of Clubs");
        stack.push("6 of Clubs");
        stack.push("7 of Clubs");
        stack.push("8 of Clubs");
        stack.push("9 of Clubs");
        stack.push("10 of Clubs");
        stack.push("Jack of Clubs");
        stack.push("Queen of Clubs");
        stack.push("King of Clubs");
    }

    private void unstackCards() {

        //Pull out the cards from the stack and print them
        while (!stack.size().isEmpty())
        {
            log.info(stack.pop());
        }
    }

    private void deckSize() {
        log.info(stack.size());
    }

    private void containsCard(String cardToCheck) {
        log.info(stack.contains(cardToCheck));
    }

    private void goToCard(String cardToAccess) {
        log.info(stack.access(cardToAccess));
    }

}
