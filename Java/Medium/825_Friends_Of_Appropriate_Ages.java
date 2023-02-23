class Solution {
    public int numFriendRequests(int[] ages) {
        int request_counter = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int age : ages) {
            count.put(age, count.getOrDefault(age, 0) + 1);
        }
        for (Integer a : count.keySet()) {
            for (Integer b : count.keySet()) {
                if (request(a, b)) {
                    request_counter  += count.get(a) * (count.get(b) - (a == b? 1 : 0));
                }
            }
        }
        return request_counter;
    }

    boolean request(int x, int y) {
        return !(y<=0.5*x+7 || y > x);
    }

} 
