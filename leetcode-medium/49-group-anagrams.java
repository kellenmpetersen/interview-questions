//  LeetCode - 49. Group Anagrams
//  https://leetcode.com/problems/group-anagrams/
//  time to solve: 38:04 (Oct 16 2023)
//  optimal solution consulted: https://leetcode.com/problems/group-anagrams/solutions/3687735/beats-100-c-java-python-beginner-friendly/
//  concept: NeetCode (4/9) Arrays & Hashing

class OptimalSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if(!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }
}

class MySolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //create a hashmap of the list of anagrams
        List<List<String>> anagramList = new ArrayList<>();
        String[] sorted = new String[strs.length];
        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            sorted[i] = s;
        }
        //map of sorted, unsorted strings
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0; i < sorted.length; i++){
            List<String> list = map.getOrDefault(sorted[i], new ArrayList<String>());
            list.add(strs[i]);
            map.put(sorted[i],list);
        }
        for(String n : map.keySet()){
            anagramList.add(map.get(n));
        }
        return anagramList;
    }
}