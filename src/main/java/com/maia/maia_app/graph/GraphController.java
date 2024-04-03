package com.maia.maia_app.graph;

import com.maia.maia_app.graph.Controllers.ConnectionRepository;
import com.maia.maia_app.graph.Controllers.NodeRepository;
import com.maia.maia_app.graph.models.Connection;
import com.maia.maia_app.graph.models.Node;
import com.maia.maia_app.graph.utils.Graph;
import com.maia.maia_app.graph.utils.Pair;
import com.maia.maia_app.schedule.ScheduleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/graph")
public class GraphController {

    private Graph graph;

    @Autowired
    private GraphService graphService;

    public GraphController(GraphService graphService) {
        try {
            this.graphService = graphService;
            // Inicializar el grafo con los datos de la base de datos
            List<Node> nodes = graphService.getNodes();
            List<Connection> connections = graphService.getConnections();

            if (!nodes.isEmpty() && !connections.isEmpty()) {
                this.graph = new Graph();
                for (Node node : nodes) {
                    graph.addNode(node);
                }
                for (Connection connection : connections) {
                    graph.addConnection(connection);
                }
            }
        } catch (Exception e) {
            // Manejar la excepción
            e.printStackTrace();
            this.graph = null; // Asignar null al grafo si hay un problema
        }
    }


    @GetMapping("/nodes")
    public ResponseEntity<Map<String, List<Node>>> getNodes() {
        List<Node> nodes = graphService.getNodes();

        if (nodes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Map<String, List<Node>> response = new HashMap<>();
        response.put("nodes", nodes);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/connections")
    public ResponseEntity<Map<String, List<Connection>>> getConnections() {
        List<Connection> connections = graphService.getConnections();

        if (connections.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Map<String, List<Connection>> response = new HashMap<>();
        response.put("connections", connections);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/shortestPath/{startId}/{endId}")
    public ResponseEntity<List<Pair<Node, String>>> shortestPath(@PathVariable int startId, @PathVariable int endId) {
        if (graph == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Node> aux1Opt =graphService.getNodeById(startId);
        Optional<Node> aux2Opt =graphService.getNodeById(endId);

        if (aux1Opt.isPresent() && aux2Opt.isPresent()) {
            Node aux1 = aux1Opt.get();
            Node aux2 = aux2Opt.get();
            List<Pair<Node, String>> path = graph.shortestPath(aux1, aux2);
            // Utiliza la lista de nodos path según sea necesario
            if (path.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(path, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}