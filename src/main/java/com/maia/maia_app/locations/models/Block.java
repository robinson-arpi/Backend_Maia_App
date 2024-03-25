package com.maia.maia_app.locations.models;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blocks", uniqueConstraints = {@UniqueConstraint(columnNames = {"block_id"})})
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id")
    private Long blockId;

    @Column(name = "name")
    private String name;
}