package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.util.Category;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mode_article")
public class ModeArticle extends Article{

    private Category category;
    private int weight;
}
