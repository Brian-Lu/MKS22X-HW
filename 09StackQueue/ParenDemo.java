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
	MyStack<String> stack = new MyStack<String>();
	for(int i = 0; i < s.length(); i++) {
	    if(s.substring(i).equals("[") || s.substring(i).equals("(") || s.substring(i).equals("{")) {
		stack.push(s.substring(i));
	    }
	    if(s.substring(i).equals("}")) {
		if(!(stack.peek().equals("{"))){
		    return false;
		}
		else{
		    stack.pop();
		}
	    }
	    if(s.substring(i).equals("]")) {
		if(!(stack.peek().equals("["))){
		    return false;
		}
		else{
		    stack.pop();
		}
	    }
	    if(s.substring(i).equals(")")) {
		if(!(stack.peek().equals("("))){
		    return false;
		}
		else{
		    stack.pop();
		}
	    }
	}
	return (stack.size() == 0);
    }
}
