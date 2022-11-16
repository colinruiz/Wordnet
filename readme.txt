Programming Assignment 6: WordNet

/* *****************************************************************************
 *  Please take a moment now to fill out the mid-semester survey:
 *  https://forms.gle/diTbj5r4o4xXbJm89
 *
 *  If you're working with a partner, please do this separately.
 *
 *  Type your initials below to confirm that you've completed the survey.
 **************************************************************************** */



/* *****************************************************************************
 *  Describe concisely the data structure(s) you used to store the
 *  information in synsets.txt. Why did you make this choice?
 **************************************************************************** */

I used two HashMap's to store the information in synsets.txt. The first one was
to set the synset id to the whole string of nouns. The second was to store each
noun to the synset id's it corresponded to. I decided to use two and
especially the second one to avoid for duplicate nouns in one HashMap.


/* *****************************************************************************
 *  Describe concisely the data structure(s) you used to store the
 *  information in hypernyms.txt. Why did you make this choice?
 **************************************************************************** */

The data structure I used to store the information in hypernyms.txt was a Digraph.
I split the text file into two parts. One being the synset id. The second being
the hypernym id which would be the synset or synsets id/s that link to the first
id read in. Then I would just add edges into the digraph with this correspondance.

/* *****************************************************************************
 *  Describe concisely the algorithm you use in the constructor of
 *  ShortestCommonAncestor to check if the digraph is a rooted DAG.
 *  What is the order of growth of the worst-case running times of
 *  your algorithm? Express your answer as a function of the
 *  number of vertices V and the number of edges E in the digraph.
 *  (Do not use other parameters.) Use Big Theta notation to simplify
 *  your answer.
 **************************************************************************** */

Description:
I use a private helper method in my constructor that does this calculation.
The first thing I check for is if the digraph passed in is a cycle. If it is
I return false. Next, I go through every vertex in the graph and check if
there is only one root. After this, I reverse the graph and run a
BreadthFirstDirectedPath on the reverse graph on the root node. Finally, I check
if all the other vertex's have a path to the root node.



Order of growth of running time:
O(E + V)


/* *****************************************************************************
 *  Describe concisely your algorithm to compute the shortest common ancestor
 *  in ShortestCommonAncestor. For each method, give the order of growth of
 *  the best- and worst-case running times. Express your answers as functions
 *  of the number of vertices V and the number of edges E in the digraph.
 *  (Do not use other parameters.) Use Big Theta notation to simplify your
 *  answers.
 *
 *  If you use hashing, assume the uniform hashing assumption so that put()
 *  and get() take constant time per operation.
 *
 *  Be careful! If you use a BreadthFirstDirectedPaths object, don't forget
 *  to count the time needed to initialize the marked[], edgeTo[], and
 *  distTo[] arrays.
 **************************************************************************** */

Description:
The way I computed the shortest common ancestor is to first run a
BreadthFirstDirectedSearch on either the integers or integer subsets that I had.
After this I would traverse through every vertex in the graph and would see if
the BreadthFirstDirectedSearch's had a path from that vertex that I was checking
to the one I was traversing through. If both of them did, I would get the distance
from that vertex to the one's I ran BreadthFirstDirectedSearch on. Through this
traversal of every node, I would track a running total to see if the new
distances were less than the old ones. If they were I would change the minimum
length and the vertex that held that minimum length or the shortest common
ancestor in this case.


                                 running time
method                  best case            worst case
--------------------------------------------------------
length()                O(E+V)                  O(E+V)

ancestor()              O(E+V)                  O(E+V)

lengthSubset()          O(E+V)                  O(E+V)

ancestorSubset()        O(E+V)                  O(E+V)



/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */

The limitations for this program was that pruning was very difficult for finding
the shortest common ancestor. So I just relied on the BreadthFirstDirectedSearch
API to run the graph's features. This could've caused memory issues for bigger
graphs.

/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **************************************************************************** */

Daruis(Shortest Common Ancestor constructor and subset methods), Professor Han
(Wordnet constructor, choosing data types)

/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */
The constructor and choosing the data types for wordnet was pretty difficult.
However, after choosing the data types, the constructor was pretty straightforward.


/* *****************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */
N/A



/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */
I enjoyed this assignment.
