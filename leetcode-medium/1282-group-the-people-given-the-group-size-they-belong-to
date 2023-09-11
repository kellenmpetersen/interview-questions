//  LeetCode - 1282. Group the People Given the Group Size They Belong To
//  https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
//  time problem solving: 36:22 (Sep 11 2023)
//  solution consulted:
//  https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/solutions/4028895/98-55-greedy-hash-table/
//  TODO:   need to think outside the box about what to use for HashMap key, value pairs
//          learn more about greedy algorithms

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> groups = new ArrayList<>();
        HashMap<Integer,List<Integer>> sizeCount = new HashMap<>();

        for(int i = 0; i < groupSizes.length; i++){
            int size = groupSizes[i];
            sizeCount.putIfAbsent(size, new ArrayList<>());
            sizeCount.get(size).add(i);

            if(sizeCount.get(size).size() == size){
                groups.add(new ArrayList<>(sizeCount.get(size)));
                sizeCount.get(size).clear();
            }
        }
        
        return groups;
    }
}

class IncorrectSolution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        /*  psuedocode:
        *   create arrayList to return: groups
        *   create an array to track groupSize for each array in the list: groupsSize
        *   iterate through the groupSizes array using i
        *       check if groupSize of i = 1 
        *           add it to the groups list as an ArrayList
        *           assign groupSize
        *       if groupSize of i > 1
        *           find if there is a groupsSize of the right amount that does not contains 
        *           add it to the groups list
        *       (9 min in)
        *        Wait a second ... maybe we could iterate through the groupSizes array first with a hashmap
        *        and figure out the size of each group then create list of appropriate length and fill it with
        *        corresponding i's! That sounds like it would be more efficient & eligent than my first brute force method.
        *        . . . Ok I'm going to start coding.
        */
        List<List<Integer>> groups = new ArrayList<>();
        HashMap<Integer,Integer> sizeCount = new HashMap<Integer,Integer>(groupSizes.length);
        for(int i : groupSizes){
            sizeCount.put(i,i);
        }
        for(Integer i : sizeCount.keySet()){
            List<Integer> group = new ArrayList<>();
            for(int j = 0; j < i; j++){
                group.add(i);
            }
            groups.add(group);
        }
        return groups;
    }
}