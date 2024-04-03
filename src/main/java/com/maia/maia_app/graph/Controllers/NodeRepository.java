package com.maia.maia_app.graph.Controllers;

import com.maia.maia_app.graph.models.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<Node, Integer> {
}


