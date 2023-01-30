package virtual_pet;

import java.util.ArrayList;

public class VirtualPetShelter {
    ArrayList<VirtualPet> pets = new ArrayList<>();

    public void admitPet(VirtualPet pet) {
        pets.add(pet);
    }

    public void feedAllPets() {
        for (VirtualPet pet : pets) {
            pet.feed();
        }
    }

    public void playWithPet(String petName) {
        for (VirtualPet pet : pets) {
            if (pet.getName().equals(petName)) {
                pet.play();
                return;
            }
        }
    }

    public VirtualPet adoptPet(String petName) {
        for (VirtualPet pet : pets) {
            if (pet.getName().equals(petName)) {
                pets.remove(pet);
                return pet;
            }
        }
        return null;
    }

    public void tick() {
        for (VirtualPet pet : pets) {
            pet.tick();
        }
    }
}
