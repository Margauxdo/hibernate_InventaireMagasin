package org.example.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Data
@Builder
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "food_article")
public class FoodArticle extends Article {

    private LocalDate expirationDate;
}
