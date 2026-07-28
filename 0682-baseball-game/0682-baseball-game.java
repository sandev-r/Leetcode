class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String s: operations){
            if(s.equals("C")){
                stack.pop();
            }
            else if(s.equals("D")){
                stack.push(stack.peek() * 2);
            }
            else if(s.equals("+")){
                int first = stack.pop();
                int second = 0;
                if(!stack.isEmpty()){
                    second = stack.peek();
                }
                stack.push(first);
                stack.push(first + second);
            }
            else{
                int val = Integer.parseInt(s);
                stack.push(val);
            }
        }

        int sum = 0;
        for(int v : stack){
            sum+=v;
        }

        return sum;
    }
}