package org.example;

import org.example.entity.Client;
import org.example.repository.*;

public class Main {
    public static void main(String[] args) {

        RepositoryClient repositoryClient = new RepositoryClient();

        Client client = Client.builder().id(1).name("henry").email("henry@gdkld.com").build();
        //repositoryClient.createClient(client);
        //System.out.println(repositoryClient.findClientById(1));
        //repositoryClient.findClientById(client.getId());
        //repositoryClient.updateClient(client);
        //repositoryClient.deleteClient(client);


        RepositoryElectronicArticle repositoryElectronicArticle = new RepositoryElectronicArticle();

        RepositoryFoodArticle repositoryFoodArticle = new RepositoryFoodArticle();

        RepositoryModeArticle repositoryModeArticle = new RepositoryModeArticle();

        RepositorySale repositorySale = new RepositorySale();
        }
    }
