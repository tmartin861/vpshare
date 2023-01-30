package virtual_pet;

import java.util.Scanner;

public class VirtualPetApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        VirtualPetShelter shelter = new VirtualPetShelter();

        while (true) {
            // Welcome the user and present the options they can chose
            System.out.println("Welcome to the Virtual Pet Shelter!");
            System.out.println("1. Admit a pet");
            System.out.println("2. View all pets");
            System.out.println("3. Play with a pet");
            System.out.println("4. Feed all pets");
            System.out.println("5. Adopt a pet");
            System.out.println("6. Quit");

            // Input of user
            int userChoice = input.nextInt();
            input.nextLine();

            // Start with user choosing 1
            // Ask user for name of pet
            if (userChoice == 1) {
                System.out.println("What is the pet's name?");
                String petName = input.nextLine();
                VirtualPet newPet = new VirtualPet(petName);
                // Put pet into shelter
                shelter.admitPet(newPet);
                // Tell the user the pet has been added
                System.out.println(petName + " has been admitted to the shelter.");
                // If user chooses 2, show all the pets they admitted
            } else if (userChoice == 2) {
                for (VirtualPet pet : shelter.pets) {
                    System.out.println(pet.getName() + ": Hunger: " + pet.getHunger() + " Boredom: " + pet.getBoredom());
                }
                // If user chooses 3, ask which pet the user wants to play
            } else if (userChoice == 3) {
                System.out.println("Which pet would you like to play with?");
                String petName = input.nextLine();
                // Compare user input to shelter
                shelter.playWithPet(petName);
                // Tell the user who they played with
                System.out.println("You played with " + petName + ".");
                // If user chooses option 4, feed all pets
            } else if (userChoice == 4) {
                shelter.feedAllPets();
                // Tell the user that all pets were fed
                System.out.println("All pets have been fed!");
                // If user chooses 5, allow the user to adopt a pet
            } else if (userChoice == 5) {
                // Ask the user which pet they would like to adopt
                System.out.println("Which pet would you like to adopt?");
                String petName = input.nextLine();
                // Pulls pet from the adoptPet method
                VirtualPet adoptedPet = shelter.adoptPet(petName);
                // Tells the user the pet has been adopted
                System.out.println(adoptedPet.getName() + " has been adopted!");
                // If user chooses 6, tell bye and quit the program
            } else if (userChoice == 6) {
                System.out.println("Bye!");
                break;
            }
        }
        shelter.tick();
        input.close();
    }
}
