package org.example.IHM;

import org.example.repository.RepositoryElectronicArticle;
import org.example.repository.RepositoryFoodArticle;
import org.example.repository.RepositoryModeArticle;
import org.example.util.SessionfactorySingleton;

import java.util.Scanner;

public class IHMArticle {
    private Scanner sc;
    private RepositoryModeArticle repositoryModeArticle;
    private RepositoryFoodArticle repositoryFoodArticle;
    private RepositoryElectronicArticle repositoryElectronicArticle;

    public IHMArticle() {
        sc = new Scanner(System.in);
        repositoryModeArticle = new RepositoryModeArticle();
        repositoryFoodArticle = new RepositoryFoodArticle();
        repositoryElectronicArticle = new RepositoryElectronicArticle();

    }
    public void start(){
        String entry;
        while(true){
            System.out.print("---Article Menu --- ");
            System.out.println("1/Category");
            System.out.println("2/");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }


}
