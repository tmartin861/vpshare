package virtual_pet;

import java.util.Scanner;

public class VirtualPetApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        VirtualPetShelter shelter = new VirtualPetShelter();

        while (true) {
            System.out.println("Welcome to the Virtual Pet Shelter!");
            System.out.println("1. Admit a pet");
            System.out.println("2. View all pets");
            System.out.println("3. Play with a pet");
            System.out.println("4. Feed all pets");
            System.out.println("5. Adopt a pet");
            System.out.println("6. Walk a pet");
            System.out.println("7. Perform maintenance on a pet");
            System.out.println("8. Clean a pet");
            System.out.println("9. Quit");

            int userChoice = input.nextInt();
            input.nextLine();

            if (userChoice == 1) {
                System.out.println("What type of pet would you like to admit? (Organic Dog, Organic Cat, Robotic Dog, Robotic Cat)");
                String petType = input.nextLine();
                System.out.println("What is the pet's name?");
                String petName = input.nextLine();

                VirtualPet newPet;
                if (petType.equalsIgnoreCase("Organic Dog")) {
                    newPet = new OrganicDog(petName);
                } else if (petType.equalsIgnoreCase("Organic Cat")) {
                    newPet = new OrganicCat(petName);
                } else if (petType.equalsIgnoreCase("Robotic Dog")) {
                    newPet = new RoboticDog(petName);
                } else if (petType.equalsIgnoreCase("Robotic Cat")) {
                    newPet = new RoboticCat(petName);
                } else {
                    System.out.println("Invalid pet type");
                    continue;
                }
                shelter.admitPet(newPet);
                System.out.println(petName + " has been admitted to the shelter.");
            } else if (userChoice == 2) {
                for (VirtualPet pet : shelter.pets) {
                    System.out.println(pet.getName() + " " + pet.getVisualRepresentation());
                }
            } else if (userChoice == 3) {
                System.out.println("Which pet would you like to play with?");
                String petName = input.nextLine();
                shelter.playWithPet(petName);
                System.out.println("You played with " + petName + ".");
            } else if (userChoice == 4) {
                shelter.feedAllPets();
                System.out.println("All pets have been fed!");
            } else if (userChoice == 5) {
                System.out.println("Which pet would you like to adopt?");
                String petName = input.nextLine();
                VirtualPet adoptedPet = shelter.adoptPet(petName);
                System.out.println(adoptedPet.getName() + " has been adopted!");
            } else if (userChoice == 6) {
                System.out.println("Which pet would you like to walk?");
                String petName = input.nextLine();
                VirtualPet petToWalk = shelter.getPetByName(petName);
                if (petToWalk == null) {
                    System.out.println("Pet not found");
                    continue;
                }
                petToWalk.walk();
                System.out.println("You walked " + petName + ".");
            } else if (userChoice == 7) {
                System.out.println("Which pet would you like to perform maintenance on?");
                String petName = input.nextLine();
                RoboticPet petToMaintenance = shelter.getRoboticPetByName(petName);
                if (petToMaintenance == null) {
                    System.out.println("Pet not found or not a robotic pet");
                    continue;
                }
                petToMaintenance.performMaintenance();
                System.out.println("Maintenance performed on " + petName + ".");
            } else if (userChoice == 8) {
                System.out.println("Which pet would you like to clean?");
                String petName = input.nextLine();
                OrganicPet petToClean = shelter.getOrganicPetByName(petName);
                if (petToClean == null) {
                    System.out.println("Pet not found or not an organic pet");
                    continue;
                }
                petToClean.clean();
                System.out.println("Cage/litter box cleaned for " + petName + ".");
            } else if (userChoice == 9) {
                System.out.println("Bye!");
                break;
            }
            shelter.tick();
        }
        input.close();
    }
}
