package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {
    @Test
    public void feedShouldReduceHungerBy10() {
        VirtualPet pet = new VirtualPet("TestPet");
        int initialHunger = pet.getHunger();
        pet.feed();
        int finalHunger = pet.getHunger();
        assertEquals(initialHunger - 10, finalHunger);
    }

    @Test
    public void playShouldReduceBoredomBy10() {
        VirtualPet pet = new VirtualPet("TestPet");
        int initialBoredom = pet.getBoredom();
        pet.play();
        int finalBoredom = pet.getBoredom();
        assertEquals(initialBoredom - 10, finalBoredom);
    }

    @Test
    public void getVisualRepresentation() {
        VirtualPet pet = new VirtualPet("TestPet");
        pet.hunger = 80;
        pet.boredom = 80;
        String visualRepresentation = pet.getVisualRepresentation();
        assertEquals("😔 Hunger: 80  Boredom: 80", visualRepresentation);
    }
}
