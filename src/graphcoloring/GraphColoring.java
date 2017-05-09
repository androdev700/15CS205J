/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoloring;

/**
 *
 * @author andro
 */
import java.util.*;
import java.util.LinkedList;

// This class represents an undirected graph using adjacency list
class GraphColoring {

    private final int V;   // No. of vertices
    private final LinkedList<Integer> adj[]; //Adjacency List

    //Constructor
    GraphColoring(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); //Graph is undirected
    }

    // Assigns colors (starting from 0) to all vertices and
    // prints the assignment of colors
    void greedyColoring() {
        int result[] = new int[V];

        // Assign the first color to first vertex
        result[0] = 0;

        // Initialize remaining V-1 vertices as unassigned
        for (int u = 1; u < V; u++) {
            result[u] = -1;  // no color is assigned to u
        }
        // A temporary array to store the available colors. True
        // value of available[cr] would mean that the color cr is
        // assigned to one of its adjacent vertices
        boolean available[] = new boolean[V];
        for (int cr = 0; cr < V; cr++) {
            available[cr] = false;
        }

        // Assign colors to remaining V-1 vertices
        for (int u = 1; u < V; u++) {
            // Process all adjacent vertices and flag their colors
            // as unavailable
            Iterator<Integer> it = adj[u].iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (result[i] != -1) {
                    available[result[i]] = true;
                }
            }

            // Find the first available color
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr] == false) {
                    break;
                }
            }

            result[u] = cr; // Assign the found color

            // Reset the values back to false for the next iteration
            it = adj[u].iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (result[i] != -1) {
                    available[result[i]] = false;
                }
            }
        }

        // print the result
        for (int u = 0; u < V; u++) {
            System.out.println("Vertex " + u + " --->  Color "
                    + result[u]);
        }
    }

    // Driver method
    public static void main(String args[]) {
        GraphColoring g1 = new GraphColoring(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();

        System.out.println();
        GraphColoring g2 = new GraphColoring(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        System.out.println("Coloring of graph 2 ");
        g2.greedyColoring();
    }
}
