package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="article_id")
    protected int id;
    @Column (name="article_description")
    protected String description;
    @Column (name="article_price")
    protected float price;
    @Column (name="article_quantity")
    protected int quantity;
    @Column (name="article_dateRenewalStock")
    protected LocalDate dateRenewalStock;



}

