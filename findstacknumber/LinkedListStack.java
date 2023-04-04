
public class LinkedListStack implements Stack {
	
	private SinglyLinkedList stack;
	
	public LinkedListStack() {
		stack = new SinglyLinkedList();
	}

	@Override
	public int size() {
		if(!stack.isEmpty()) //스택이 비어있지않으면
			return stack.size();
		else{ //스택이 비어있으면
			return 0;
		}
	}

	@Override
	public boolean isEmpty() {
		if(stack.isEmpty()) 
		{
			return true; //스택이 비어있으면 true 반환
		}
		else
			return false; //스택이 비어있지 않으면 false 반환
	}

	@Override
	public Integer top() {
		if(!stack.isEmpty()){
			return stack.first();  //addFirst를 하면 나중에 들어오는 값이 first이기 떄문에 top은 first를 리턴
		}
		else{
			return null;
		}
	}

	@Override
	public Integer pop() {
		if(!stack.isEmpty()){
			return stack.removeFirst();  //addFirst를 하면 나중에 들어오는 값이 first이기 떄문에 pop은 first를 제거
		}
		else
			return null;
	}

	@Override
	public void push(Integer e) {
		stack.addFirst(e);
	}
}
