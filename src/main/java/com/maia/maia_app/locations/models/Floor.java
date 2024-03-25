package com.maia.maia_app.locations.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "floors", uniqueConstraints = {@UniqueConstraint(columnNames = {"floor_id"})})
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "floor_id")
    private Long floorId;

    @Column(name = "floor_number")
    private int floorNumber;

    @ManyToOne
    private Block blockId;
}