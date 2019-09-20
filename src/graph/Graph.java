package graph;

import java.util.LinkedList;
import java.util.Queue;

//邻接矩阵
public class Graph {

    //实现图的深度遍历

    private static void depthFirstSearch(boolean[] isVisited,int  i,int [][]edges) {
        //首先访问该结点，在控制台打印出来
        System.out.print(i+"  ");
        //置该结点为已访问
        isVisited[i]=true;
        for (int j=0;j<edges.length;j++){
            if (edges[i][j]!=0 && !isVisited[j]){
                depthFirstSearch(isVisited,j,edges);
            }
        }
    }

    /**
     * 具体算法表述如下：
     *
     * 1.访问初始结点v，并标记结点v为已访问。
     * 2.查找结点v的第一个邻接结点w。
     * 3.若w存在，则继续执行4，否则算法结束。
     * 4.若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）。
     * 5.查找结点v的w邻接结点的下一个邻接结点，转到步骤3。
     * @param edges
     */
    //对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
    public static void depthFirstSearch(int start,int [][]edges) {
        boolean[] isVisited = new boolean[edges.length];
        depthFirstSearch(isVisited,start,edges);

    }

    //得到第一个邻接结点的下标
    public static int getFirstNeighbor(int index,int [][]edges) {
        for(int j=0;j<edges.length;j++) {
            if (edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来取得下一个邻接结点
    public static int getNextNeighbor(int v1,int v2,int [][]edges) {
        for (int j=v2+1;j<edges.length;j++) {
            if (edges[v1][j]>0) {
                return j;
            }
        }
        return -1;
    }

    /** 广度优先遍历
     * 1.访问初始结点v并标记结点v为已访问。
     * 2.结点v入队列
     * 3.当队列非空时，继续执行，否则算法结束。
     * 4.出队列，取得队头结点u。
     * 5.查找结点u的第一个邻接结点w。
     * 6.若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
     *      1). 若结点w尚未被访问，则访问结点w并标记为已访问。
     *      2). 结点w入队列
     *      3). 查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。
     * @param start 起始点
     * @param edges 邻接矩阵
     * @return
     */
    public  static String BFS(int start,int [][]edges) {
        if (start>edges.length-1) {
            System.out.print("输入节点不在该图内");
            return null;
        }
        int numOfNodes=edges.length;
        boolean[]visited=new boolean[numOfNodes];
        StringBuilder resultBuilder=new StringBuilder();
        Queue<Integer>queue=new LinkedList<>();
        // 访问起始点
        queue.offer(start);
        visited[start]=true;
        while (!queue.isEmpty()) {
            int current=queue.poll();
            resultBuilder.append(current).append(",");
            for(int i=0;i<edges.length;i++) // 找到当前节点的所有邻接节点然后入队
            {
                if((edges[current][i]!=0)&&!visited[i])
                {
                    queue.offer(i);
                    visited[i]=true;
                }
            }

        }
        return resultBuilder.length()>0?resultBuilder.substring(0,resultBuilder.length()-1):null;
}


    public static void main(String[] args) {
        int graph[][] = new int[5][5]; // 2---0---3
        for (int i=1;i<=3;i++){      //       |  /
                                    //        1
                                    //        |
            graph[0][i]=1;          //        4
            graph[i][0]=1;
        }
        for (int i=2;i<=3;i++){
            graph[1][i] = 1;
            graph[i][1] =1;
        }
        graph[1][4] =1;
        graph[4][1] =1;

        graph[1][2] =0;
        graph[2][1] =0;
        depthFirstSearch(0,graph); // 深度
        System.out.println("");
        System.out.println(BFS(0,graph)); // 广度
    }
}

