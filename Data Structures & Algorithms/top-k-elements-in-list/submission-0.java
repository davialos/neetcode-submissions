class Solution {
    public int[] topKFrequent(int[] nums, int k) {

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
