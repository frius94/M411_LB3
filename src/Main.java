import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BeerAdmin beerAdmin = new BeerAdmin();
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("----------MENU----------\n1) loadBeerStyles()\n2) printBeerStyles()\n3) printBeerStyles(String search)\n4) getBeerListForStyle(int idStyle)\n5) printBeerList()\n6) printBeer(String id)\nx) Exit");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    beerAdmin.loadBeerStyles();
                    break;
                case "2":
                    beerAdmin.printBeerStyles();
                    break;
                case "3":
                    beerAdmin.printBeerStyles(BeerAdmin.getInput("Search name: "));
                    break;
                case "4":
                    beerAdmin.getBeerListForStyle(Integer.parseInt(BeerAdmin.getInput("Style-ID: ")));
                    break;
                case "5":
                    beerAdmin.printBeerList();
                    break;
                case "6":
                    beerAdmin.printBeer(BeerAdmin.getInput("Search ID: "));
                    break;
                case "x":
                    System.out.println("Thank you for using my program. Bye.");
                    break;
                default:
                    System.out.println("Please choice a valid option.");
                    break;
            }
        } while (!choice.equals("x"));
    }
}
