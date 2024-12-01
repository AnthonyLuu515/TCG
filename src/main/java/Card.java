public class Card implements Comparable<Card> {
    String name;
    String rarity;
    int value;

    public Card(String name, String rarity, int value) {
        this.name = name;
        this.rarity = rarity;
        this.value = value;
    }

    public static void insertionSort(Card[] cardArray, String compareBy) {
        int n = cardArray.length;
        for (int i = 1; i < n; ++i) {
            Card key = cardArray[i];
            int j = i - 1;

            // Move elements of cardArray[0..i-1], that are
            // greater than key, to one position ahead
            // of their current position
            while (j >= 0 && cardArray[j].compareBy(compareBy, key) > 0) {
                cardArray[j + 1] = cardArray[j];
                j--;
            }
            cardArray[j + 1] = key;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", rarity='" + rarity + '\'' +
                ", value=" + value +
                '}'
                ;
    }

    public int compareRarity(Card other) {
        // Prioritize by rarity (higher rarity first)
        int rarityComparison = compareRarity(this.rarity, other.rarity);
        if (rarityComparison != 0) {
            return rarityComparison;
        } else {
            // If rarities are the same, prioritize by value (higher value first)
            return Integer.compare(other.value, this.value);
        }
    }

    private int compareRarity(String rarity1, String rarity2) {
        int rarity1Value = getRarityValue(rarity1);
        int rarity2Value = getRarityValue(rarity2);
        return Integer.compare(rarity2Value, rarity1Value); // Higher rarity value first
    }

    private int getRarityValue(String rarity) {
        switch (rarity.toUpperCase()) {
            case "ULTRA RARE":
                return 4;
            case "RARE":
                return 3;
            case "UNCOMMON":
                return 2;
            case "COMMON":
                return 1;
            default:
                throw new IllegalArgumentException("Invalid rarity: " + rarity);
        }
    }

    public int compareName(Card other) {
        return name.compareTo(other.getName());
    }

    public int comparePrice(Card other) {
        return Integer.compare(other.getValue(), value );
    }

    public int compareBy(String compareBy, Card other){
        switch (compareBy.toUpperCase()) {
            case "NAME":
                return compareName(other);
            case "VALUE":
                return comparePrice(other);
            case "RARITY":
                return compareRarity(other);
            default:
                throw new IllegalArgumentException("INVALID OPTION");
        }

    }

    @Override
    public int compareTo(Card o) {
        return compareBy("RARITY", o);
    }
}
