import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CardBinderTest {

    @Test
    public void testAdd() {
        // ARRANGE
        CardBinder binder = new CardBinder();

        // ACT
        binder.add("charmander", "rare", 1);


        // ASSERT
        binder.print();
    }

    @Test
    public void testRemove(){
        // ARRANGE
        CardBinder binder = new CardBinder();
        binder.add("Derek","uncommon",3);
        binder.add("David","common",1);
        binder.add("Panda","ultra rare",100);
        //Act
        binder.remove("David");
        //Assert
        Assertions.assertNull(binder.getFromHashmap("David"));
    }

    @Test
    public void testRarestName(){
        //Arrange
        CardBinder binder = new CardBinder();
        binder.add("Turtlemon","rare",5);
        binder.add("dogmon","ultra rare",7);
        binder.add("catdogmon","common",1);

        //ACt
        Card rarest = binder.pullRarestCard();

        //Assert
        Assertions.assertEquals("dogmon", rarest.getName());
    }
    @Test
    public void testSort(){
        // Arange
        CardBinder binder = new CardBinder();
        binder.add("bulbasaura","common",3);
        binder.add( "venasaur","rare",40);
        binder.add("pikachu","uncommon",11);
        // ACt

        Card[] testSomething = binder.sort("RARITY");

        // Assert

        Assertions.assertEquals("venasaur",testSomething[0].getName());

    }

}

