import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BeerAdmin beerAdmin = new BeerAdmin();
        beerAdmin.loadBeerStyles();
        beerAdmin.printBeerStyles();
        beerAdmin.printBeerList();
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("----------MENU----------\n1) Print all beer information\n2) Search for a beer with name\n3) Search for a beer with ID\nx) Exit");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    beerAdmin.printBeerStyles();
                    break;
                case "2":
                    beerAdmin.printBeerStyles((BeerAdmin.getInput("Search name: ")));
                    break;
                case "3":
                    beerAdmin.printBeer(BeerAdmin.getInput("Search ID: "));
                    break;
                case "x":
                    System.out.println("Thank you for using my program. Bye.");
                    System.exit(0);
                default:
                    System.out.println("Please choice a valid option.");
                    break;
            }
        } while (!choice.equals("x"));
    }
}
