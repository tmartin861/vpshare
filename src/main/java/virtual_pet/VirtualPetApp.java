package virtual_pet;

import java.util.Scanner;

public class VirtualPetApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Ask user to name pet
        System.out.println("What would you like to name your pet? ");
        String petName = input.nextLine();
        VirtualPet myPet = new VirtualPet(petName);

        // Create loop for actions with pet
        while (true) {
            myPet.status();
            // Ask user for action to take
            System.out.println("What would you like to do with your pet?");
            // Feed pet
            System.out.println("1. Feed your pet");
            // Play with pet
            System.out.println("2. Play with your pet");
            // Do nothing (creates tick)
            System.out.println("3. Do nothing");
            System.out.print("> ");
            int choice = input.nextInt();


            if (choice == 1) {
                // If user selects 1, feed the pet
                myPet.feed();
            } else if (choice == 2) {
                // If user selects 2, play with pet
                myPet.play();
            } else {
                // If user selects 3, increase the tick count
                myPet.tick();
            }
        }
    }
}
