package org.example.IHM;


import org.example.entity.Client;
import org.example.repository.RepositoryClient;

import java.util.List;
import java.util.Scanner;

public class IHMClient {

    private Scanner sc;
    private RepositoryClient repositoryClient;


    public IHMClient() {
        sc = new Scanner(System.in);
        repositoryClient = new RepositoryClient();

    }
        public void start() {
        String entry;
        while (true) {
            System.out.println("--- Client Menu---");
            System.out.println("1/ Create client");
            System.out.println("2/ Show all clients/");
            System.out.println("3/ Show a client by his id/");
            System.out.println("4/ Update client");
            System.out.println("5/ Delete client");
            System.out.println("6/ Exit");
            entry = sc.nextLine();
            switch (entry) {
                case "1" -> createClient();
                case "2" -> showAllClient();
                case "3" -> showClientById();
                case "4" -> updateClient();
                 case "5" -> deleteClient();
                default -> {
                    System.out.println("Invalid entry");
                    return;
                }
            }

             }


        }
    private void createClient(){
        System.out.println("--Create Client---");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();

        Client client = Client.builder()
                .name(name)
                .email(email)
                .build();
        client = repositoryClient.createClient(client);
        System.out.println("client: " +client);
    }
    private void showAllClient( ){
        System.out.println("--Show All Clients---");
        List<Client> clients = repositoryClient.findAllClients();
        clients.forEach(System.out::println);
    }
    private void showClientById(){
        try {
            System.out.println("--Show Client by Id---");
            System.out.println("Id: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println(repositoryClient.findClientById(id));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    private void updateClient(){
        System.out.println("--Update Client---");
        System.out.println("id: ");
        int id = Integer.parseInt(sc.nextLine());

        Client client = repositoryClient.findClientById(id);
        System.out.println("nom actuel : "+client.getName());
        System.out.println("veuillez entrer le nouveau nom :");
        String name = sc.nextLine();
        client.setName(name);
        System.out.println("email actuel : "+client.getEmail());
        System.out.println("veuillez entrer le nouveau email :");
        String email = sc.nextLine();
        client.setEmail(email);

        client = repositoryClient.updateClient(client);
        System.out.println("new client: "+client.getName());

    }
    private void deleteClient(){
        System.out.println("--Delete Client---");
        System.out.println("Id: ");
        int id = Integer.parseInt(sc.nextLine());
        Client client = repositoryClient.findClientById(id);
        repositoryClient.deleteClient(client);
        }



}