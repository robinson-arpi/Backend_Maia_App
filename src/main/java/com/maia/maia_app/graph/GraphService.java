package com.maia.maia_app.graph;

import com.maia.maia_app.graph.Controllers.ConnectionRepository;
import com.maia.maia_app.graph.Controllers.NodeRepository;
import com.maia.maia_app.graph.models.Connection;
import com.maia.maia_app.graph.models.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GraphService {
    @Autowired
    private NodeRepository nodeRepository;
    @Autowired
    private ConnectionRepository connectionRepository;

    public List<Node> getNodes() {
        return nodeRepository.findAll();
    }

    public List<Connection> getConnections() {
        return connectionRepository.findAll();
    }

    public Optional<Node> getNodeById(int id){
       return nodeRepository.findById(id);

    }

}



