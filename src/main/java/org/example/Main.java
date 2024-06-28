package org.example;

import org.example.repository.*;

public class Main {
    public static void main(String[] args) {

        RepositoryClient repositoryClient = new RepositoryClient();

        RepositoryElectronicArticle repositoryElectronicArticle = new RepositoryElectronicArticle();

        RepositoryFoodArticle repositoryFoodArticle = new RepositoryFoodArticle();

        RepositoryModeArticle repositoryModeArticle = new RepositoryModeArticle();

        RepositorySale repositorySale = new RepositorySale();
        }
    }
