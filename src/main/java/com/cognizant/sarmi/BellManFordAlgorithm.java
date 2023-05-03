package com.cognizant.sarmi;

import java.util.*;

public class BellManFordAlgorithm {

    static class Edge {
        int src, dest, weight;
        Edge() {
            src = dest = weight = 0;
        }
    }

    static int V, E;
    static Edge[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
            edges[i].src = sc.nextInt();
            edges[i].dest = sc.nextInt();
            edges[i].weight = sc.nextInt();
        }

        int source = sc.nextInt();
        sc.close();

        bellmanFord(source);
    }

    static void bellmanFord(int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 1; i <= V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i].src;
            int v = edges[i].dest;
            int w = edges[i].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                //return;
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }
}
