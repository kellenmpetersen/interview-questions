//  LeetCode - 347. Top K Frequent Elements
//  https://leetcode.com/problems/top-k-frequent-elements
//  time to problem solve: ~50:00 (Oct 17 2023)
//  optimal solution consulted: https://leetcode.com/problems/top-k-frequent-elements/solutions/3550088/python-java-c-simple-solution-easy-to-understand/
//  concept: NeetCode (5/9) Arrays & Hashing
//  TODO: study priority queues / heaps / bucket sort

class OptimalSolution {
    public int[] topKFrequent(int[] nums, int k) {
        //1) map number to frequency
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        // 2) create a heap to maintain invarient of most frequent element at top
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(int num : map.keySet()){
            heap.offer(num);
        }
        int[] kElements = new int[k];
        for(int i = 0; i < k; i++){
            kElements[i] = heap.poll();
        }
        return kElements;
    }
}