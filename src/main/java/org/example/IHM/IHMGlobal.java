package org.example.IHM;

import org.example.util.SessionfactorySingleton;

import java.util.Scanner;

public class IHMGlobal {
    private Scanner sc = new Scanner(System.in);
    private IHMArticle ihmArticle;
    private IHMClient ihmClient;
    private IHMSale ihmSale;
    public IHMGlobal() {
        ihmArticle = new IHMArticle();
        ihmClient = new IHMClient();
        ihmSale = new IHMSale();
        sc = new Scanner(System.in);
    }
    public void start() {
        String entry;
        while (true) {
            System.out.println("---Main Menu---");
            System.out.println("1.Article");
            System.out.println("2.Client");
            System.out.println("3.Sales");
            System.out.println("4.Exit");
            entry = sc.nextLine();
            switch (entry) {
                case "1"-> ihmArticle.start();
                case "2"-> ihmClient.start();
               // case "3" -> ihmSale.start();
                case "4"-> System.exit(0);
                default -> System.out.println("Invalid option");


            }


        }
    }

}
