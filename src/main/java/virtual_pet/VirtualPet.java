package virtual_pet;
import java.util.Random;
import java.util.Scanner;

public class VirtualPet {
    // Input the instance variable for each pet
    String name;
    int hunger;
    int boredom;
    Random random = new Random();

    // Input the name, hunger, and boredom of pet
    public VirtualPet(String name) {
        this.name = name;
        this.hunger = 50;
        this.boredom = 50;
    }

    // Each time user feeds pet, lower overall hunger by 10
    public void feed() {
        hunger -= 10;
    }

    // Each time user plays with pet, lower overall boredom by 10
    public void play() {
        boredom -= 10;
    }

    // Set up tick count that increases hunger and boredom for each tick
    // Uses random in order to stimulate the pet feeling more "alive"
    public void tick() {
        int randomNumber = random.nextInt(100);
        // As long as each stat is under 50
        if (randomNumber < 50) {
            // Increases both stats by 5
            hunger += 5;
            boredom += 5;
            System.out.println(name + " is feeling a little neglected");
        } else if (hunger > boredom) {
            // Increases hunger by 5
            hunger += 5;
            System.out.println(name + " looks at you and wonders if you have any snacks");
        } else {
            // Increases boredom by 5
            boredom +=5;
            System.out.println(name + " was feeling a little bored");
        }
    }

    // Lists the "stats" of the pet
//    public void status() {
//        System.out.println("Name: " + name);
//        System.out.println("Hunger: " + hunger);
//        System.out.println("Boredom: " + boredom);
//    }

    public String getVisualRepresentation() {
        if (hunger > 75 && boredom > 75) {
            return "😔 Hunger: "+hunger +"  Boredom: "+ boredom;
        } else if (hunger > 75) {
            return "😔 Hunger: "+hunger +"  Boredom: "+ boredom;
        } else if (boredom > 75) {
            return "😔 Hunger: "+hunger +"  Boredom: "+ boredom;
        } else {
            return "😊 Hunger: "+hunger +"  Boredom: "+ boredom;
        }
    }

    public void status() {
        System.out.println("Name: " + name);
        System.out.println(getVisualRepresentation());
    }
}

