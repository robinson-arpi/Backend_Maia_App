package com.maia.maia_app.graph.utils;

import com.maia.maia_app.graph.models.Node;
import com.maia.maia_app.graph.models.Connection;

import java.util.*;



public class Graph {
    private Map<Node, List<Node>> adjacencyList; // Lista de adyacencia para representar el grafo
    private ArrayList<Connection> instructions = new ArrayList<>(); // Mapa para almacenar las instrucciones por nodo
    // Constructor de la clase Graph
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // Método para agregar un nodo al grafo
    public void addNode(Node node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Método para agregar una conexión al grafo
    public void addConnection(Connection connection) {
        Node originNode = connection.getOriginNode();
        Node destinationNode = connection.getDestinationNode();
        instructions.add(connection);
        adjacencyList.get(originNode).add(destinationNode); // Agrega la conexión de A a B
    }

    // Método para encontrar la ruta más corta usando el algoritmo BFS
    public List<Pair<Node, String>> shortestPath(Node start, Node end) {
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> previous = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.equals(end)) {
                break; // Hemos encontrado el nodo de destino, terminamos
            }
            for (Node neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    previous.put(neighbor, current);
                }
            }
        }

        // Reconstruir el camino más corto
        List<Node> path = new ArrayList<>();
        Node current = end;
        while (previous.get(current) != null) {
            path.add(current);
            current = previous.get(current);
        }
        path.add(start);
        Collections.reverse(path);
        List<Pair<Node, String>> pathWithInstructions = new ArrayList<>();

        System.out.println("Camino encontrado:");
        for (int i = 0; i < path.size() - 1; i++) {
            Node currentNode = path.get(i);
            Node nextNode = path.get(i + 1);
            String instruction = findInstruction(currentNode, nextNode);
            pathWithInstructions.add(new Pair<>(currentNode, instruction));

            System.out.println(currentNode.getName() + ": " + instruction);
        }

        return pathWithInstructions;
    }

    // Método para buscar la instrucción entre dos nodos en la lista de conexiones
    private String findInstruction(Node destination, Node origin) {
        for (Connection connection : instructions) {
            if (connection.getOriginNode().equals(origin) && connection.getDestinationNode().equals(destination)) {
                return connection.getInstruction();
            }
        }
        return "Instrucción no encontrada"; // Manejar el caso en que no se encuentre la instrucción
    }

    // Otros métodos que puedas necesitar, como obtener nodos, conexiones, etc.
}

