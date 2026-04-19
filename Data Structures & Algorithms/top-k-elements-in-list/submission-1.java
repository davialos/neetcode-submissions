class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> f = new HashMap<>();
        for(int n : nums){
            f.put(n, f.getOrDefault(n,0) +1);
        }

        List<List<Integer>> rl  = new ArrayList<>();
        for(int i = 0; i<= nums.length;  i++){
            rl.add(i,new ArrayList<>());
        }
        for(Map.Entry<Integer,Integer> e : f.entrySet()){
            rl.get(e.getValue()).add(e.getKey());
        }

        List<Integer> res = new ArrayList<>();
        for(int i = nums.length; i>= 0 && res.size()< k ; i--){
            for(int n : rl.get(i)){
                res.add(n);
                if(res.size() == k) break;
            }
        }

        int[] ia = new int[k];
        for(int  i = 0; i < k ; i ++){
            ia[i] = res.get(i);
        }
        return ia;
        
    }

    public int[] topKFrequentAppraoch1(int[] nums, int k) {

        Map<Integer,Integer> f = new HashMap<>();
        for(int n : nums){
            f.put(n, f.getOrDefault(n,0) +1);
        }
        //min-head 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for(Map.Entry<Integer,Integer> e : f.entrySet()){
            int[] a = {e.getValue(), e.getKey()};
            pq.offer(a);
            if(pq.size()> k){
                pq.poll();
            }
        }

        int[] a = new int[k];
        for(int i =0; i< k; i++){
            a[i] = pq.poll()[1];
        }
        return a;
    }
}
