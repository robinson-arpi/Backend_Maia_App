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
@Table(name = "connections", uniqueConstraints = {@UniqueConstraint(columnNames = {"connection_id"})})
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer connectionId;

    @ManyToOne
    @JoinColumn(name = "origin_node")
    private Node originNode;

    @ManyToOne
    @JoinColumn(name = "destination_node")
    private Node destinationNode;

    private String instruction;
}
