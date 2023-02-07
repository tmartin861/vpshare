package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class VirtualPetShelterTest {
    VirtualPetShelter shelter = new VirtualPetShelter();

    @Test
    public void shouldAdmitPet() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("Pet1");
        shelter.admitPet(pet);
        assertEquals(1, shelter.pets.size());
        assertEquals(pet, shelter.pets.get(0));
    }

    @Test
    public void shouldGetPetByName() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet pet1 = new VirtualPet("Pet1");
        VirtualPet pet2 = new VirtualPet("Pet2");
        shelter.admitPet(pet1);
        shelter.admitPet(pet2);
        assertEquals(pet1, shelter.getPetByName("Pet1"));
        assertEquals(pet2, shelter.getPetByName("Pet2"));
        assertNull(shelter.getPetByName("Pet3"));
    }

    @Test
    public void shouldWalkPet() {
        VirtualPet pet = new VirtualPet("Pet");
        pet.walk();
        assertEquals(45, pet.getBoredom());
        assertEquals(55, pet.getHunger());
    }

    @Test
    public void shouldAddRoboticPetToShelter() {
        RoboticPet robotPet = new RoboticCat("RoboCat");
        shelter.admitPet(robotPet);

        assertEquals(1, shelter.pets.size());
        assertEquals("RoboCat", shelter.pets.get(0).getName());
    }


}