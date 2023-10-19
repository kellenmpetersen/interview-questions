//  LeetCode - 128. Longest Consecutive Sequence
//  https://leetcode.com/problems/longest-consecutive-sequence
//  time spent problem solving: ~15:00 (Oct 19 2023)
//  optimal solution consulted: https://leetcode.com/problems/longest-consecutive-sequence/solutions/4139456/c-c-java-python-javascript-beats-100-3-approaches-explained/
//  concept: NeetCode (9/9) Arrays & Hashing
//  TODO: learn graphs, please for the love of all thats good in this world just memorize
//  how to construct graphs and DFS / BFS

class HashSetSolution {
    public int longestConsecutive(int[] nums) {
        /*  
            brainstorming:
            naive solution would be sorting 
            then running a check to see if two adjacent array slots are consecutive
            tracking current consecutive numbers and storing longest consecutive number chain
            updating longest consecutive number chain if found
            however this would be best case O(n log n) efficency because of comparison sort
            radix sort would be in-place sorting BUT O(d * (n + b)) time complexity
            where d = digits, n = number of elements and b = base of number sytstem being used
            nums[i] digits could be anywhere from -9 to 9 so 19 possiblities and base 10
            in conclusion, not the approach for this problem given the constraints

            simply iterating through the list once, one would not be able to construct a linkedList construction
            of consecutive sequences, consider the sequence 1,3,4,2 since it would construct [1.2] and [3,4] but
            not be able to construct [1,2,3,4] although possibly iterating over the constucted consectuive element
            lists could create the longest possible sequence.

            perhaps building consecutive lists over multiple iterations would yield the best solution? see above
            [1,2],[3,4] after first iteration and then [1.2],[3,4] with pointers at the head and tail of each to track
            combinations?

            still that seems overly complicated and would not be best considering the number of subsequences is
            indetermiable so allocating the correct amount of sublist pointers would have to be done dynamically in List<>
            and would not be very elegent.

            wait . . . what if there was a data structure that would sort the sequence by merit of being put into it?
            something like a tree or a graph? ok, its time to look at the solution because that's probaably it.
            I can't remember what it is for the life of me. The answer would be obvious though, translate the unsorted
            (nums) array into a sorted data structure, then iterate through it to find the longest consectutive sequence.

            post solution peek:
            You CAN use a HashSet. But I thought HashSets were unordered? Now I see though, first iteration through nums to add 
            all the elements to the HashSet, the second iteration to check if consective elements are present in the HashSet.
            Graphs are definitely more efficient but I still need to practice those.
        */

        if(nums.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        int currSequence = 1;
        int longestSequence = 1;

        for(int n : nums){
            currSequence = 1;
            if(!set.contains(n - 1)){
                int x = n;
                while(set.contains(x+1)){
                    currSequence++;
                    x++;
                }
            }
            longestSequence = Math.max(longestSequence, currSequence);
        }

        return longestSequence;
    }
}