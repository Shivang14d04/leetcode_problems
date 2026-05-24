class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        boolean asc = true;
        boolean des = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (first + i) % n) {
                asc = false;
            }
            if (nums[i] != (first - i + n) % n) {
                des = false;
            }
        }

        if (!asc && !des) {
            return -1;
        }
        int start = asc ? first : n + first; 
        int target = 0; 

        if (start == target) {
            return 0;
        }

        int[] temp = new int[2 * n];
        Arrays.fill(temp, -1);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        temp[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int id = queue.poll();
            int d = temp[id];
            int c = id / n;
            int s = id % n;

            int next1, next2;
            if (c == 0) {
                next1 = ((s + 1) % n);          
                next2 = n + ((s - 1 + n) % n);   
            } else {
                next1 = n + ((s - 1 + n) % n);   
                next2 = ((s + 1) % n);           
            }

            if (temp[next1] == -1) {
                temp[next1] = d + 1;
                if (next1 == target) {
                    return d + 1;
                }
                queue.add(next1);
            }

            if (temp[next2] == -1) {
                temp[next2] = d + 1;
                if (next2 == target) {
                    return d + 1;
                }
                queue.add(next2);
            }
        }

        return -1;
    }
}