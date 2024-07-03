package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@Builder
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "electronic_article")
public class ElectronicArticle extends Article {

    private LocalTime batteryLife;
}
