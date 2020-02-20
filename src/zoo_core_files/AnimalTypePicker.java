package zoo_core_files;
import java.util.Scanner;
public class AnimalTypePicker {
  static Scanner UserInputScanner = new Scanner(System.in);
  public static void main(String[] args) {
    BASE_Animals Animals = new BASE_Animals();
    System.out.println("choose an animal from the following list (type the number to the right of the animal you would like to select):");
    for (int i=0; i<Animals.TypesOfAnimals.length; i++) {
      System.out.println("#" + (i+1) + ": " + Animals.TypesOfAnimals[i]);
      //------------
    }
    boolean hasSelected = false;
    String ChosenAnimal = null;//is null a reserved keyword?? should check sometime
    boolean AnimalWasChosenByItsNumber;
    do {
      ChosenAnimal = UserInputScanner.nextLine();
      try {
        int ChosenAnimalByNumber = Integer.parseInt(ChosenAnimal);
        AnimalWasChosenByItsNumber = true;
      }
      catch (NumberFormatException ChosenAnimal_NFE) {
        AnimalWasChosenByItsNumber = false;
      }
      try {
        if (AnimalWasChosenByItsNumber == false) {
          for(int i=0; i<Animals.TypesOfAnimals.length; i++) {
            if (ChosenAnimal.equalsIgnoreCase(Animals.TypesOfAnimals[i])) {
              ChosenAnimal = Animals.TypesOfAnimals[i];
              hasSelected = true;
              break;/////////////////////////////////////////////////
            }
          }
        }
        else if (AnimalWasChosenByItsNumber == true) {
        	ChosenAnimal = Animals.TypesOfAnimals[ChosenAnimalByNumber];
        	hasSelected = true;
        	break;
        }
      }
      catch (Exception AnimalIdentificationLoopException) {
        System.out.println("Unfortunately, an error of type \"" + AnimalIdentificationLoopException + "\" has occurred in location \"AnimalIdentificationLoop\".");
      }
    } while (hasSelected == false); //part of a do-while loop
    System.out.println("You selected a(n) " + ChosenAnimal + ". Is this correct? (y/n)");
    String UserInput = UserInputScanner.nextLine();
  }
}
class BASE_Animals {
  public String[] TypesOfAnimals = {"lion","tiger","wolf","rabbit","bear","turtle"};
}
