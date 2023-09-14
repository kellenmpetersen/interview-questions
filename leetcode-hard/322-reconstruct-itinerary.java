//  LeetCode - 332. Reconstruct Itinerary
//  https://leetcode.com/problems/reconstruct-itinerary
//  time problem solving: ~7m (Sep 14 2023)
//  solution consulted:
//  https://leetcode.com/problems/reconstruct-itinerary/solutions/4041944/95-76-dfs-recursive-iterative/
//  TODO:   review graphs + algorithms
//          learn backtracking
//          learn built-in LinkedList, PriorityQueue data structures

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        /*
        *   brainstorming:
        *       today's problem is a graph problem and since I haven't reviewed graphs since I studied them almost
        *       a year ago, I'm going to spend less time than usual trying to figure out the solution on my own.
        *       ----
        *       the problem breaks down into creating a graph and optimizing it.
        *       this could be one step/loop, but brute force method would use at least two. 
        *       (also maybe its not possible to do in one?)
        *       I forget if one should use a form of Dijkstra’s for shortest path 
        *       or Prim’s for minimum spanning tree (MST). Either way, I have to review those and
        *       how to construct a proper graph in the first place.
        *       Brainstorming/Problem-Solving done: ~7m
        *   solution:
        *       -   It's DFS because of course it is. :| I'm still amazed how veristile that algorithm is. OK, lets look
        *       at implementation.
        *       -   I've heard of backtracking but never used it. TODO: look into backtracking.
        */
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        LinkedList<String> stack = new LinkedList<>();
        stack.add("JFK");
        LinkedList<String> itinerary = new LinkedList<>();

        while(!stack.isEmpty()) {
            while(graph.getOrDefault(stack.peekLast(), new PriorityQueue<>()).size() > 0) {
                stack.add(graph.get(stack.peekLast()).poll());
            }
            itinerary.addFirst(stack.pollLast());
        }

        return itinerary;
    }
}