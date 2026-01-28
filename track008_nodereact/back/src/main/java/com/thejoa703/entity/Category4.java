package com.thejoa703.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORY4")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Category4 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat4_seq")
    @SequenceGenerator(name = "cat4_seq", sequenceName = "CATEGORY4_SEQ", allocationSize = 1)
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(nullable = false, length = 100)
    private String categoryName;

    // 해당 카테고리에 속한 레시피들 (필요 시)
    @Builder.Default
    @OneToMany(mappedBy = "category")
    private List<Recipe4> recipes = new ArrayList<>();
}