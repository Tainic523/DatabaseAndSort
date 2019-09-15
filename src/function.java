import java.util.HashSet;
public class function {
    class Node{
        private  int id;
        private double x;
        private  double y;
        private  double energy;
        public int getId() {
            return id;
        }
    }
    public int f(HashSet<Node> V, HashSet<Node> M,int[][]p){
        int sum=0;
        for (Node v: V) {
            if (!M.contains(v))
                sum+=max(v,M,p);
        }
        return sum;

    }
    private int max(Node v, HashSet<Node> M, int[][] p) {
        int max=Integer.MIN_VALUE;
        for (Node m:M){
            if(p[v.getId()][m.getId()]>max)
                max=p[v.getId()][m.getId()];
        }
        return max;
    }

}
