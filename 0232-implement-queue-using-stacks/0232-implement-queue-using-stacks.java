class MyQueue {
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    public void push(int x) {
        inputStack.push(x);
    }
    
    public int pop() {
        if(outputStack.isEmpty()){
            transfer();
        }

        return outputStack.pop();
    }
    
    public int peek() {
        if(outputStack.isEmpty() && !inputStack.isEmpty()){
           transfer();
        }
        return outputStack.peek();
    }
    
    public boolean empty() {
        return outputStack.isEmpty() && inputStack.isEmpty();
    }

    private void transfer(){
        int len = inputStack.size();
            for(int i = 0;i < len;i++){
                outputStack.push(inputStack.pop());
            }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */