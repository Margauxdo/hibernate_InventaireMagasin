package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.util.SaleCondition;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name="sale_id")
    private int id;
    @OneToMany
    @JoinColumn(name = "article_id")
    @Column(name="sale_article")
    private List<Article> listArticles;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client name;
    private SaleCondition condition;
}
