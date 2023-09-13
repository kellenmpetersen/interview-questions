//  1647. Minimum Deletions to Make Character Frequencies Unique
//  https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique
//  time to solve: ~25m (Sep 12 2023)

class Solution {
    public int minDeletions(String s) {
        /*
        *   Brainstorming
        *   Possibly a HashMap<Character,Integer> to count frequency of each letter
        *   then a Set of Unique Integers representing the counts and as you add
        *   Integers to the Set, if they are already present, remove one from the current
        *   character and see if it fits again, keep removing until it can fit
        *   (up to zero) potential problems in the edge cases since this strategy
        *   will tend to eliminate characters . . . ?
        *   going to implement it now @ 4:45
        */

        HashMap<Character, Integer> charCount = new HashMap<>();
        Set<Integer> counts = new HashSet<>();
        int removed = 0;
        for(int i = 0; i < s.length(); i++){
            int count = charCount.getOrDefault(s.charAt(i),0);
            charCount.put(s.charAt(i),++count);
        }
        for(char c : charCount.keySet()){
            int count = charCount.get(c);
            System.out.println("character & count: "+c+": "+count);
            while(!counts.add(count) && count != 0){
                System.out.println("removed character & count: "+c+": "+count);
                count--;
                removed++;
            }
            charCount.put(c,count);
        }
        return removed;
    }
}