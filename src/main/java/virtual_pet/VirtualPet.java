package virtual_pet;

import java.util.Random;

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
            boredom += 5;
            System.out.println(name + " was feeling a little bored");
        }
    }


    public String getVisualRepresentation() {
        if (hunger > 75 && boredom > 75) {
            // This is show the inputs of the pet when the hunger and boredom in under 75
            return "😔 Hunger: " + hunger + "  Boredom: " + boredom;
            // If only the hunger is below 75
        } else if (hunger > 75) {
            return "😔 Hunger: " + hunger + "  Boredom: " + boredom;
            // If only the boredom is below 75
        } else if (boredom > 75) {
            return "😔 Hunger: " + hunger + "  Boredom: " + boredom;
            // If both are both 75
        } else {
            return "😊 Hunger: " + hunger + "  Boredom: " + boredom;
        }
    }

    public String getName() {
        return this.name;
    }


    public int getHunger() {
        return this.hunger;
    }

    public int getBoredom() {
        return this.boredom;
    }

    public void walk() {
        // Decrease boredom by 10 and increase hunger by 5
        boredom -= 10;
        hunger += 5;
    }
}

interface Maintenance {
    void performMaintenance();
}

class OrganicPet extends VirtualPet {
    int cageCleanliness;

    public OrganicPet(String name) {
        super(name);
        this.cageCleanliness = 50;
    }

    public void walk() {
        this.boredom -= 10;
        this.cageCleanliness -= 10;
    }


    public void clean() {
        cageCleanliness = 100;
    }
}

class OrganicDog extends OrganicPet {
    public OrganicDog(String name) {
        super(name);
    }
}

class OrganicCat extends OrganicPet {
    public OrganicCat(String name) {
        super(name);
    }
}

class RoboticPet extends VirtualPet implements Maintenance {
    int oilLevel;
    int maintenanceLevel;

    public RoboticPet(String name) {
        super(name);
        this.oilLevel = 50;
        this.maintenanceLevel = 50;
    }

    @Override
    public void performMaintenance() {
        this.maintenanceLevel = 50;
    }

    public void walk() {
        this.boredom -= 10;
        this.oilLevel -= 10;
        this.maintenanceLevel -= 10;
    }
}

class RoboticDog extends RoboticPet {
    public RoboticDog(String name) {
        super(name);
    }
}

class RoboticCat extends RoboticPet {
    public RoboticCat(String name) {
        super(name);
    }
}
