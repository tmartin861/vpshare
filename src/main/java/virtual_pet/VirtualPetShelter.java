package virtual_pet;

import java.util.ArrayList;

public class VirtualPetShelter {
    ArrayList<VirtualPet> pets = new ArrayList<>();

    public void admitPet(VirtualPet pet) {
        pets.add(pet);
    }

    public VirtualPet getPetByName(String name) {
        for (VirtualPet pet : pets) {
            if (pet.getName().equals(name)) {
                return pet;
            }
        }
        return null;
    }

    public RoboticPet getRoboticPetByName(String name) {
        VirtualPet pet = getPetByName(name);
        if (pet instanceof RoboticPet) {
            return (RoboticPet) pet;
        } else {
            return null;
        }
    }

    public OrganicPet getOrganicPetByName(String name) {
        VirtualPet pet = getPetByName(name);
        if (pet instanceof OrganicPet) {
            return (OrganicPet) pet;
        } else {
            return null;
        }
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
