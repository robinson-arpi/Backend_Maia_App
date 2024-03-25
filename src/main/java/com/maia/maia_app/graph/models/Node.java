package com.maia.maia_app.graph.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nodes",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"node_id"}),
                @UniqueConstraint(columnNames = {"name"})})
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "node_id")
    private Integer nodeId;

    @Column(name = "name")
    private String name;
}
