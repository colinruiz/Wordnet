import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShortestCommonAncestor {
    // private Digraph copy;
    private final Digraph G;
    // keeps track of the root of the graph if any
    private int root;
    // private BreadthFirstDirectedPaths first;
    // private BreadthFirstDirectedPaths second;

    // constructor takes a rooted DAG as argument
    public ShortestCommonAncestor(Digraph G) {
        if (G == null) {
            throw new IllegalArgumentException();
        }

        this.G = new Digraph(G);
        if (!isRootedDAG(this.G)) {
            throw new IllegalArgumentException();
        }
        // System.out.println(this.root);


        // this.copy = new Digraph(G);


    }

    // helper method to see if the Digraph is rooted
    private boolean isRootedDAG(Digraph graph) {
        DirectedCycle directedCycle = new DirectedCycle(graph);

        if (directedCycle.hasCycle()) {
            return false;
        }
        int rootcount = 0;

        for (int i = 0; i < graph.V(); i++) {

            if (G.outdegree(i) == 0) {
                rootcount++;
                this.root = i;
                if (rootcount > 1) {
                    return false;
                }
            }
            // if (G.outdegree(i) > 0) {
            //     if (!first.hasPathTo(root)) {
            //         return false;
            //     }
            // }

        }
        if (rootcount == 0) {
            return false;
        }
        Digraph reverse = graph.reverse();
        BreadthFirstDirectedPaths first = new BreadthFirstDirectedPaths(reverse, this.root);

        for (int i = 0; i < graph.V(); i++) {

            if (G.outdegree(i) > 0) {
                if (!first.hasPathTo(i)) {
                    return false;
                }
            }
        }

        return true;

    }

    // private methods for the lengths
    private int lengths(BreadthFirstDirectedPaths first, BreadthFirstDirectedPaths second) {
        int minimumLength = Integer.MAX_VALUE;
        // int l;
        for (int i = 0; i < this.G.V(); i++) {
            if (first.hasPathTo(i) && second.hasPathTo(i)) {
                int length = first.distTo(i) + second.distTo(i);
                if (length < minimumLength) {
                    minimumLength = length;
                }
            }
        }

        if (minimumLength == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return minimumLength;
        }
    }

    // helper method for the shoretest common ancestor
    private int shortestcommonanc(BreadthFirstDirectedPaths first,
                                  BreadthFirstDirectedPaths second) {
        int minimumLength = Integer.MAX_VALUE;
        int sca = -1;
        int length;
        for (int i = 0; i < this.G.V(); i++) {
            if (first.hasPathTo(i) && second.hasPathTo(i)) {
                length = first.distTo(i) + second.distTo(i);
                if (length < minimumLength) {
                    minimumLength = length;
                    sca = i;
                }
            }
        }
        if (minimumLength == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return sca;
        }
    }


    // length of shortest ancestral path between v and w
    public int length(int v, int w) {
        if (v < 0 || v > this.G.V()) {
            throw new IllegalArgumentException();
        }
        if (w < 0 || w > this.G.V()) {
            throw new IllegalArgumentException();
        }
        // if (v == null || w == null){
        //     throw new IllegalArgumentException();
        // }
        BreadthFirstDirectedPaths first = new BreadthFirstDirectedPaths(this.G, v);
        BreadthFirstDirectedPaths second = new BreadthFirstDirectedPaths(this.G, w);
        return lengths(first, second);
    }

    // a shortest common ancestor of vertices v and w
    public int ancestor(int v, int w) {
        if (v < 0 || v > this.G.V()) {
            throw new IllegalArgumentException();
        }
        if (w < 0 || w > this.G.V()) {
            throw new IllegalArgumentException();
        }
        BreadthFirstDirectedPaths first = new BreadthFirstDirectedPaths(this.G, v);
        BreadthFirstDirectedPaths second = new BreadthFirstDirectedPaths(this.G, w);
        return shortestcommonanc(first, second);


    }

    // private helper method for throwing exceptions
    private void throwexceptions(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        if (subsetA == null || subsetB == null) {
            throw new IllegalArgumentException();
        }
        int nodecountA = 0;
        int nodecountB = 0;
        for (Integer node : subsetA) {
            nodecountA++;
            if (node == null) {
                throw new IllegalArgumentException();
            }
        }
        if (nodecountA == 0) {
            throw new IllegalArgumentException();
        }
        for (Integer node : subsetB) {
            nodecountB++;
            if (node == null) {
                throw new IllegalArgumentException();
            }
        }
        if (nodecountB == 0) {
            throw new IllegalArgumentException();
        }
    }

    // length of shortest ancestral path of vertex subsets A and B
    public int lengthSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        throwexceptions(subsetA, subsetB);
        BreadthFirstDirectedPaths first = new BreadthFirstDirectedPaths(this.G, subsetA);
        BreadthFirstDirectedPaths second = new BreadthFirstDirectedPaths(this.G, subsetB);

        return lengths(first, second);

    }

    // a shortest common ancestor of vertex subsets A and B
    public int ancestorSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        // if (subsetA == null || subsetB == null) {
        //     throw new IllegalArgumentException();
        // }
        throwexceptions(subsetA, subsetB);
        BreadthFirstDirectedPaths first = new BreadthFirstDirectedPaths(this.G, subsetA);
        BreadthFirstDirectedPaths second = new BreadthFirstDirectedPaths(this.G, subsetB);
        // int nodecountA = 0;
        // int nodecountB = 0;
        // int minimumLength = Integer.MAX_VALUE;
        // int l;
        // int sca = -1;
        // for (Integer node : subsetA) {
        //     nodecountA++;
        //     if (node == null) {
        //         throw new IllegalArgumentException();
        //     }
        //
        //
        // }
        // if (nodecountA == 0) {
        //     throw new IllegalArgumentException();
        // }
        // for (Integer node : subsetB) {
        //     nodecountB++;
        //     if (node == null) {
        //         throw new IllegalArgumentException();
        //     }
        // }
        // if (nodecountB == 0) {
        //     throw new IllegalArgumentException();
        // }
        return shortestcommonanc(first, second);
    }

    // unit testing (required)
    public static void main(String[] args) {
        In digraph = new In(args[0]);
        Digraph G = new Digraph(digraph);
        ShortestCommonAncestor sca = new ShortestCommonAncestor(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length = sca.length(v, w);
            int ancestor = sca.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }


    }

}
