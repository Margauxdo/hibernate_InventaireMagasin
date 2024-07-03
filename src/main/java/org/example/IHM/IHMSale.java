package org.example.IHM;

import org.example.entity.Article;
import org.example.entity.Client;
import org.example.entity.ElectronicArticle;
import org.example.entity.Sale;
import org.example.repository.*;
import org.example.util.SaleCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

public class IHMSale {
    private Scanner sc;
    private RepositoryClient repositoryClient;
    private RepositorySale repositorySale;


    public IHMSale(){
        sc = new Scanner(System.in);
        repositoryClient = new RepositoryClient();
        repositorySale = new RepositorySale();


    }
    public void start() {
        String entry;
        while (true) {
            System.out.println("--- Sale Menu---");
            System.out.println("1/ Create sale");
            System.out.println("2/ Show all sale/");
            System.out.println("3/ Show one sale by his id/");
            System.out.println("4/ Update sale");
            System.out.println("5/ Delete sale");
            System.out.println("6/ Exit");
            entry = sc.nextLine();
            switch (entry) {
                case "1" -> createSale();
                case "2" -> showAllSale();
                case "3" -> showSaleById();
                case "4" -> updateSale();
                case "5" -> deleteSale();
                default -> {
                    System.out.println("Invalid entry");
                    return;
                }
            }

        }


    }
    private void createSale(){
        System.out.println("--Create Sale---");
        System.out.println("Client ID: ");
        int clientId = Integer.parseInt(sc.nextLine());
        Client client = repositoryClient.findClientById(clientId);
        System.out.println("Condition of sale (INPROGRESS, FINISHED, CANCELLED): ");
        SaleCondition condition = SaleCondition.valueOf(sc.nextLine().toUpperCase());
        System.out.println("Sale articles: ");
        List<Article> articleList = new ArrayList<>();

       Sale sale = Sale.builder()
               .name(client)
               .condition(condition)
                .listArticles(articleList)
                .build();
        sale = repositorySale.createSale(sale);
        System.out.println("sale created: " +sale);
    }
    private void showAllSale( ){
        System.out.println("--Show All Sale---");
        List<Sale> sales = repositorySale.findAllSale();
        sales.forEach(sale -> {
            System.out.println("Sale ID: " + sale.getId());
            System.out.println("Client: "+ (sale.getName() != null ? sale.getName() : ""));
            System.out.println("Condition: "+ sale.getCondition());
            System.out.println("ListArticles: "+ sale.getListArticles());
        });
    }
    private void showSaleById(){
        try {
            System.out.println("--Show Sale by Id---");
            System.out.println("Id: ");
            int id = Integer.parseInt(sc.nextLine());
            Sale sale = repositorySale.findSaleById(id);

            System.out.println(repositorySale.findSaleById(id));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    private void updateSale() {
        System.out.println("--Update Sale---");
        System.out.println("id: ");

            int id = Integer.parseInt(sc.nextLine());

            Sale sale = repositorySale.findSaleById(id);

            if (sale != null){
                System.out.println("Client Id: "+sale.getName().getId());
                System.out.println("new client ID: ");
                int newClientId = Integer.parseInt(sc.nextLine());
                Client newClient = repositoryClient.findClientById(newClientId);

                System.out.println("condition : " + sale.getCondition());
                System.out.println("New Condition (INPROGRESS, FINISHED, CANCELLED): ");
                SaleCondition newCondition = SaleCondition.valueOf(sc.nextLine().toUpperCase());

                sale.setName(newClient);
                sale.setCondition(newCondition);
                sale=repositorySale.updateSale(sale);
                System.out.println("Updates sale: "+sale);
            }else {
                System.out.println("Sale not found");
            }

        }

    private void deleteSale(){
        System.out.println("--Delete Sale---");
        System.out.println("Id: ");
        int id = Integer.parseInt(sc.nextLine());
        Sale sale = repositorySale.findSaleById(id);
        repositorySale.deleteSale(sale);
    }
}
