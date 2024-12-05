import java.util.*;

public class CardBinder {
    private PriorityQueue<Card> priorityQueue;
    private Map <String,Card> hashmap;

    public CardBinder() {
        priorityQueue = new PriorityQueue<>();
        hashmap = new HashMap<>();
    }

    /**
     * Methods for the map and priority queue
     *
     */
    public void add(String name, String rarity, int value) {
        Card card = new Card(name, rarity, value);
        priorityQueue.add(card);
        hashmap.put(name, card);
    }

    public void remove(String name) {
        Card card = hashmap.get(name);
        priorityQueue.remove(card);
        hashmap.remove(name);
    }

    public Card getFromHashmap(String name){
        return hashmap.get(name);
    }

    public Card pullRarestCard() {
        return priorityQueue.poll();
    }
    /**
     * for loop to take values of card and map and outputting tostring
     */
    public void print() {
        System.out.println("Cards in Binder.");
        for (Card value : hashmap.values()) {
            System.out.println(value.toString());
        }
    }

    /**
     * Take the values out of the map and put it into a array to be sorted with the insertion sort
     *
     */
    public Card[] sort(String compareBy) {
        Card[] cardArray = hashmap.values().toArray(new Card[hashmap.size()]);

        Card.insertionSort(cardArray, compareBy);

        System.out.println("Sorted Binder.");

        for (Card card : cardArray) {
            System.out.println(card);
        }
        return cardArray;
    }
}