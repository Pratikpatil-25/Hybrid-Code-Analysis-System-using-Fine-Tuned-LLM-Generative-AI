package com.Key.Algorithm;

import java.util.List;


public class Algorithm {

    private final List<String> vex;
    public int index = 0;

    
    public Algorithm(Graph graph) {
        this.vex = graph.getVex();
    }

    
    public EdgeData[] MST_Prim(Graph g, int firstVex) {

                EdgeData[] edges = getEdges(g.getEdgeNum(),vex,g.getEdges());
                int vexNum = g.getVexNum();
                int[] minWeight = new int[vexNum];
                int[] adjVex = new int[vexNum];

                for(int i = 0; i < vexNum; i++) {
                        minWeight[i] = (g.getEdges())[firstVex][i];
            adjVex[i] = firstVex;
        }
                int minEdg;
                int minVex = 0;

                for(int i = 1; i < vexNum; i++) {
            minEdg = Integer.MAX_VALUE;
            for(int j = 0; j < vexNum; j++) {
                if(minWeight[j] != 0 && minWeight[j] < minEdg) {
                                        minEdg = minWeight[j];
                    minVex = j;
                }
            }

                        minWeight[minVex] = 0;
                        for(int j = 0; j < vexNum;j++) {
                if(minWeight[j] != 0 && (g.getEdges())[minVex][j] < minWeight[j] && (g.getEdges())[minVex][j] > 0) {
                    minWeight[j] = (g.getEdges())[minVex][j];
                    adjVex[j] = minVex;
                }
            }
            int pre = adjVex[minVex];
            int end = minVex;

                        edges[index].start = g.getVex().get(pre);
            edges[index].end = g.getVex().get(end);
            index++;
            System.out.println("(" + g.getVex().get(pre) + "," + g.getVex().get(end) + ")");
        }

        return edges;
    }

    
    public EdgeData[] MST_Kruskal(Graph g) {

        int edgeNum = g.getEdgeNum();
                int[] end = new int[g.getVexNum()];
                EdgeData[] rets = new EdgeData[edgeNum];
                EdgeData[] edges = getEdges(edgeNum,vex,g.getEdges());
                sortEdges(edges,edgeNum);

                for(int i = 0;i < edgeNum;i++) {
                        int p1 = getPosition(edges[i].start,vex);
                        int p2 = getPosition(edges[i].end,vex);

                        int m = getEnd(end,p1);
                        int n = getEnd(end,p2);

                        if(m != n) {
                end[m] = n;
                rets[index++] = edges[i];

                System.out.println("(" + rets[index - 1].start + "," + rets[index - 1].end + ")");
            }
        }

        return rets;
    }

    
    public int getEnd(int[] end, int i){
        while(end[i] != 0) {
            i = end[i];
        }
        return i;
    }

    
    public EdgeData[] getEdges(int edgeNum, List<String> vertex, int[][] matrix){
        int index = 0;
        EdgeData[] edges = new EdgeData[edgeNum];

                for(int i = 0;i < vertex.size();i++){
            for(int j = i + 1;j < vertex.size();j++){
                if(matrix[i][j] != 0 && matrix[i][j] != Integer.MAX_VALUE){
                    edges[index++] = new EdgeData(vertex.get(i),vertex.get(j),matrix[i][j]);
                }
            }
        }
        return edges;
    }

    
    public int getPosition(String v, List<String> vertex){
        for(int i = 0;i < vertex.size();i++){
            if(vertex.get(i).equals(v)){
                return i;
            }
        }
        return -1;
    }

    
    public void sortEdges(EdgeData[] edges, int edgeNum){

        for(int i = 0;i < edgeNum - 1;i++){
            for(int j = 0;j < edgeNum - 1-i;j++){

                if(edges[j].weight > edges[j+1].weight){
                    EdgeData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }
}