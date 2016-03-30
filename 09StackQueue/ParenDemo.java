public class ParenDemo{
    public static void main(String[]args){
        String input = "()()(([[]]))";
        if(args.length > 0){
            input = args[0];
            System.out.println(isMatching(input));
        }else{
            System.out.println(isMatching(input));
            System.out.println("Usage:");
            System.out.println("java ParenDemo \"text\"");
        }

    }
    public static boolean isMatching(String s) {
        MyStack<Character> stack = new MyStack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(a == '{' || a == '[' || a == '(') {
                stack.push(a);
            }
            if(a == '}') {
                if(stack.isEmpty() || (stack.peek() != '{')){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            if(a == ']') {
                if(stack.isEmpty() || (stack.peek() != '[')){
                        return false;
                    }
                    else{
                        stack.pop();
                    }
            }
            if(a == ')') {
                if(stack.isEmpty() || (stack.peek() != '(')){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
    }
}



