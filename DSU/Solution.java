
import java.util.*;

class DisjointSetUnion {

    private List<Integer> rank = new ArrayList<>();
    private List<Integer> size = new ArrayList<>();
    private List<Integer> parent = new ArrayList<>();

    public DisjointSetUnion(int n) {
        rank = new ArrayList<>(n);
        parent = new ArrayList<>(n);
        size = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }

    }

    public int findPar(int x) {
        if (parent.get(x) == x) {
            return x;
        }
        parent.add(x, parent.get(x));
        return parent.get(x);
    }

    public void unionByRank(int u, int v) {
        int ultPar_u = findPar(u);
        int ultPar_v = findPar(v);

        if (ultPar_u == ultPar_v) {
            return;
        } else if (rank.get(ultPar_u) < rank.get(ultPar_v)) {
            parent.set(ultPar_u, ultPar_v);
        } else if (rank.get(ultPar_u) > rank.get(ultPar_v)) {
            parent.set(ultPar_v, ultPar_u);
        } else {
            parent.set(ultPar_v, ultPar_u);
            rank.set(ultPar_u, rank.get(ultPar_u) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ultPar_u = findPar(u);
        int ultPar_v = findPar(v);

        if (ultPar_u == ultPar_v) {
            return;
        } else if (size.get(ultPar_u) < size.get(ultPar_v)) {
            parent.set(ultPar_u, ultPar_v);
            size.set(ultPar_v, size.get(ultPar_v) + size.get(ultPar_u));
        } else {
            parent.set(ultPar_v, ultPar_u);
            size.set(ultPar_u, size.get(ultPar_u) + size.get(ultPar_v));
        }
    }

}

class Solution {

    public static void main(String[] args) {
        // int n = 7;
        // DisjointSetUnion ds = new DisjointSetUnion(n);
        // ds.unionByRank(1, 2);
        // ds.unionByRank(2, 3);
        // ds.unionByRank(4, 5);

        // // does 1 and 7 are the part of same component
        // System.out.println(ds.findPar(1) == ds.findPar(7));
        // ds.unionByRank(6, 7);
        int n = 7;
        DisjointSetUnion ds = new DisjointSetUnion(n);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);

        // does 1 and 7 are the part of same component
        System.out.println(ds.findPar(1) == ds.findPar(7));
        ds.unionBySize(6, 7);

    }
}
