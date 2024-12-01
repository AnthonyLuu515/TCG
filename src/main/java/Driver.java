public class Driver {
    public static void main(String[] args) {
        CardBinder binder = new CardBinder();
        binder.add("charmander","common",10);
        binder.add("charmeleon","uncommon",20);
        binder.add("charizard","rare",30);
        binder.add("blastoise","rare",28);
        binder.add("dragonite","ultra rare",27);
        binder.add("blastoise","rare",28);

        //binder.print();
        //binder.remove("charmeleon");
        binder.print();
        binder.sort("NAME");
        binder.sort("VALUE");
        binder.sort("RARITY");

    }
}