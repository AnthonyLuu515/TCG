import java.util.*;

public class CardBinder {
    private PriorityQueue<Card> priorityQueue;
    private Map <String,Card> hashmap;

    public CardBinder() {
        priorityQueue = new PriorityQueue<>();
        hashmap = new HashMap<>();
    }

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

    public void print() {
        System.out.println("Cards in Binder.");
        for (Card value : hashmap.values()) {
            System.out.println(value.toString());
        }
    }

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