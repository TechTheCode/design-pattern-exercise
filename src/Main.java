import design_patterns.builder_example.*;
import design_patterns.factory_example.*;


// imports for the different tasks
import static best_practices.YearDescriber.describeYear;
import design_patterns.adapter_exercise.Pensioner;
import design_patterns.adapter_exercise.PensionerAdapter;
import animal_factory.AnimalFactory;
import design_patterns.singleton_exercise.GuessTheNumber;
import strategy_pattern_exercise.CaeserCipher;
import strategy_pattern_exercise.CipherStrategy;
import strategy_pattern_exercise.Encoder;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //GuessTheNumber guessingGame = getInstance();
        //guessingGame.playGame();

        //describeYear();

        //Pensioner me = new Pensioner("Kevin Pham", 22);
        //Pensioner oldDude = new Pensioner("Some Fossil", 1000);
        //PensionerAdapter adapter = new PensionerAdapter(me);
        //PensionerAdapter adapter1 = new PensionerAdapter(oldDude);
        //System.out.println(adapter);
        //System.out.println(adapter1);

        //Animal animal1 = AnimalFactory.getAnimal("dog");
        //System.out.println(animal1.makeSound());

        //Animal animal2 = AnimalFactory.getAnimal("cat");
        //System.out.println(animal2.makeSound());

       // GuessTheNumber game = new GuessTheNumber(new Random(), new Scanner(System.in));
        //game.playGame();
        //Shape myShape = ShapeFactory.createShape("Triangle");
        //myShape.draw();

        CipherStrategy caesarCipher=new CaeserCipher();
        String caeserEncoded = Encoder.encodeMessage(caesarCipher, "a b c 1 2 3");
        System.out.println("Caeser Cipher Encoded: " + caeserEncoded);

    }
}