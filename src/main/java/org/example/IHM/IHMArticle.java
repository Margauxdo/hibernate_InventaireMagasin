package org.example.IHM;

import org.example.entity.*;
import org.example.repository.RepositoryElectronicArticle;
import org.example.repository.RepositoryFoodArticle;
import org.example.repository.RepositoryModeArticle;
import org.example.util.Category;
import org.example.util.SaleCondition;
import org.example.util.SessionfactorySingleton;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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

    public void start() {
        String entry;
        while (true) {
            System.out.println("---Article Menu --- ");
            System.out.println("1/Category Electronic");
            System.out.println("2/ Category Food");
            System.out.println("3/ Category Mode");
            System.out.println("4/Exit");
            entry = sc.nextLine();
            switch (entry) {
                case "1" -> menuElectronic();
                case "2" -> menuFood();
                case "3" -> menuMode();
                default -> {
                    System.out.println("Wrong entry");
                    return;
                }
            }
        }
    }

    public void menuElectronic() {
        String entry;
        while (true) {
            System.out.print("---Electronic Menu --- ");
            System.out.println("1/Create Article");
            System.out.println("2/Show all Article");
            System.out.println("3/show all Article by id");
            System.out.println("4/Update Article");
            System.out.println("5/Delete Article");
            entry = sc.nextLine();
            switch (entry) {
                case "1" -> createArticleElectronic();
                case "2" -> showAllArticleElectronic();
                case "3" -> showArticleElectronicById();
                case "4" -> updateArticleElectronic();
                case "5" -> deleteArticleElectronic();
                default -> {
                    System.out.println("Wrong entry");
                    return;
                }
            }
        }
    }

    public void menuFood() {
        String entry;
        while (true) {
            System.out.println("---Food Menu --- ");
            System.out.println("1/Create Article");
            System.out.println("2/Show all Article");
            System.out.println("3/show all Article by id");
            System.out.println("4/Update Article");
            System.out.println("5/Delete Article");
            entry = sc.nextLine();
            switch (entry) {
                case "1" -> createArticleFood();
                case "2" -> showAllArticleFood();
                case "3" -> showArticleFoodById();
                case "4" -> updateArticleFood();
                case "5" -> deleteArticleFood();
                default -> {
                    System.out.println("Wrong entry");
                    return;
                }
            }
        }
    }

    public void menuMode() {
        String entry;
        while (true) {
            System.out.println("---Mode Menu --- ");
            System.out.println("1/Create Article");
            System.out.println("2/Show all Article");
            System.out.println("3/show all Article by id");
            System.out.println("4/Update Article");
            System.out.println("5/Delete Article");
            entry = sc.nextLine();
            switch (entry) {
                case "1" -> createArticleMode();
                case "2" -> showAllArticleMode();
                case "3" -> showArticleModeById();
                case "4" -> updateArticleMode();
                case "5" -> deleteArticleMode();
                default -> {
                    System.out.println("Wrong entry");
                    return;
                }
            }
        }
    }

    private void createArticleElectronic() {
        System.out.println("--Create Electronic Article---");
        System.out.println("article description: ");
        String description = sc.nextLine();
        System.out.println("Price : ");
        float price = sc.nextInt();
        System.out.println("quantity : ");
        int quantity = sc.nextInt();
        System.out.println("Date renewal stock: ");
        LocalDate dateRenewalStock = LocalDate.now();

        ElectronicArticle electronicArticle = ElectronicArticle.builder()
                .description(description)
                .price(price)
                .quantity(quantity)
                .dateRenewalStock(dateRenewalStock)
                .batteryLife(LocalTime.now())
                .build();
        electronicArticle = repositoryElectronicArticle.createElectronic(electronicArticle);
        System.out.println("electronicArticle created: " + electronicArticle);
    }

    private void showAllArticleElectronic() {
        System.out.println("--Show All article---");
        List<ElectronicArticle> electronicArticleList = repositoryElectronicArticle.findAllElectronicArticle();
        electronicArticleList.forEach(System.out::println);
    }

    private void showArticleElectronicById() {
        try {
            System.out.println("--Show Electronic articles by Id---");
            System.out.println("Id: ");
            int id = Integer.parseInt(sc.nextLine());
            ElectronicArticle electronicArticle = repositoryElectronicArticle.findElectronicArticleById(id);

            System.out.println(repositoryElectronicArticle.findElectronicArticleById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void updateArticleElectronic() {
        System.out.println("--Update Electronic---");
        System.out.println("id: ");

        int id = Integer.parseInt(sc.nextLine());

        ElectronicArticle electronicArticle = repositoryElectronicArticle.findElectronicArticleById(id);
        System.out.println("article description : " + electronicArticle.getDescription());
        System.out.println("new description: ");
        String newdescription = sc.nextLine();

        System.out.println("price : " + electronicArticle.getDescription());
        int newPrice = sc.nextInt();
        System.out.println("quantity : " + electronicArticle.getDescription());
        int newQuantity = sc.nextInt();
        System.out.println("date renewal stock : " + electronicArticle.getDescription());
        LocalDate dateRenewalStock = LocalDate.now();


        electronicArticle = repositoryElectronicArticle.updateElectronicArticle(electronicArticle);
        System.out.println("new article: " + electronicArticle);


    }

    private void deleteArticleElectronic() {
        System.out.println("--Delete Electronic article---");
        System.out.println("Id: ");
        int id = Integer.parseInt(sc.nextLine());
        ElectronicArticle electronicArticle = repositoryElectronicArticle.findElectronicArticleById(id);
        repositoryElectronicArticle.deleteElectronicArticle(electronicArticle);
    }




    private void createArticleFood() {
        System.out.println("--Create Food Article---");
        System.out.println("article description: ");
        String description = sc.nextLine();
        System.out.println("Price : ");
        float price = sc.nextInt();
        System.out.println("quantity : ");
        int quantity = sc.nextInt();
        System.out.println("Date renewal stock: ");
        LocalDate dateRenewalStock = LocalDate.now();
        System.out.println("expiration date: ");
        LocalDate expirationDate = LocalDate.now();

        repositoryFoodArticle.createFood(FoodArticle.builder().build());

        FoodArticle foodArticle = FoodArticle.builder()
                .description(description)
                .price(price)
                .quantity(quantity)
                .dateRenewalStock(dateRenewalStock)
                .expirationDate(LocalDate.now())
                .build();
        foodArticle = repositoryFoodArticle.createFood(foodArticle);
        System.out.println("foodArticle created: " + foodArticle);
    }

    private void showAllArticleFood() {
        System.out.println("--Show All article---");
        List<FoodArticle> foodArticleList = repositoryFoodArticle.findAllFoodArticle();
        foodArticleList.forEach(System.out::println);
    }
    private void showArticleFoodById () {
        try {
            System.out.println("--Show Food articles by Id---");
            System.out.println("Id: ");
            int id = Integer.parseInt(sc.nextLine());
            FoodArticle foodArticle = repositoryFoodArticle.findFoodArticleById(id);

            System.out.println(repositoryFoodArticle.findFoodArticleById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateArticleFood () {
            System.out.println("--Update Food---");
            System.out.println("id: ");

            int id = Integer.parseInt(sc.nextLine());

            FoodArticle foodArticle = repositoryFoodArticle.findFoodArticleById(id);
            System.out.println("article description : " + foodArticle.getDescription());
            System.out.println("new description: ");
            String newdescription = sc.nextLine();

            System.out.println("price : " + foodArticle.getDescription());
            int newPrice = sc.nextInt();
            System.out.println("quantity : " + foodArticle.getDescription());
            int newQuantity = sc.nextInt();
            System.out.println("date renewal stock : " + foodArticle.getDescription());
            LocalDate expirationDate = LocalDate.now();


            foodArticle = repositoryFoodArticle.updateFoodArticle(foodArticle);
            System.out.println("new article: " + foodArticle);
        }

    private void deleteArticleFood () {
        System.out.println("--Delete Food article---");
        System.out.println("Id: ");
        int id = Integer.parseInt(sc.nextLine());
        FoodArticle foodArticle = repositoryFoodArticle.findFoodArticleById(id);
        repositoryFoodArticle.deleteFoodArticle(foodArticle);
    }

    private void createArticleMode () {
        System.out.println("--Create Food Article---");
        System.out.println("article description: ");
        String description = sc.nextLine();
        System.out.println("Price : ");
        float price = sc.nextInt();
        System.out.println("quantity : ");
        int quantity = sc.nextInt();
        System.out.println("Date renewal stock: ");
        LocalDate dateRenewalStock = LocalDate.now();
        System.out.println("category: ");
        String category = sc.nextLine();
        System.out.println("weight: ");
        int weight = sc.nextInt();

        repositoryModeArticle.createMode(ModeArticle.builder().build());

        ModeArticle modeArticle = ModeArticle.builder()
                .description(description)
                .price(price)
                .quantity(quantity)
                .dateRenewalStock(dateRenewalStock)
                .category(Category.MAN)
                .category(Category.WOMAN)
                .category(Category.CHILDREN)
                .weight(weight)
                .build();
        modeArticle = repositoryModeArticle.createMode(modeArticle);
        System.out.println("modearticle created: " + modeArticle);
    }
    private void showAllArticleMode () {
        System.out.println("--Show All article---");
        List<ModeArticle> modeArticleList = repositoryModeArticle.findAllModeArticle();
        modeArticleList.forEach(System.out::println);
    }
    private void showArticleModeById () {
        try {
            System.out.println("--Show Mode articles by Id---");
            System.out.println("Id: ");
            int id = Integer.parseInt(sc.nextLine());
            ModeArticle modeArticle = repositoryModeArticle.findModeArticleById(id);

            System.out.println(repositoryModeArticle.findModeArticleById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    private void updateArticleMode () {
        System.out.println("--Update Mode---");
        System.out.println("id: ");

        int id = Integer.parseInt(sc.nextLine());

        ModeArticle modeArticle = repositoryModeArticle.findModeArticleById(id);
        System.out.println("article description : " + modeArticle.getDescription());
        System.out.println("new description: ");
        String newdescription = sc.nextLine();

        System.out.println("price : " + modeArticle.getDescription());
        int newPrice = sc.nextInt();
        System.out.println("quantity : " + modeArticle.getDescription());
        int newQuantity = sc.nextInt();
        System.out.println("Category: " + modeArticle.getCategory());
        Category category = Category.valueOf(sc.nextLine());
        System.out.println("weight: " + modeArticle.getDescription());
        int newWeight = sc.nextInt();


        modeArticle = repositoryModeArticle.updateModeArticle(modeArticle);
        System.out.println("new article: " + modeArticle);

    }

    private void deleteArticleMode () {
        System.out.println("--Delete Mode article---");
        System.out.println("Id: ");
        int id = Integer.parseInt(sc.nextLine());
        ModeArticle modeArticle = repositoryModeArticle.findModeArticleById(id);
        repositoryModeArticle.deleteModeArticle(modeArticle);
    }
    }

