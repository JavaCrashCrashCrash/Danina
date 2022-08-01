package com.doma.danina.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Writing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Column(length = 50)
    private String title;
    @Column(length = 5000)
    private String body;
    @Column(length = 20)
    private String name;
}
