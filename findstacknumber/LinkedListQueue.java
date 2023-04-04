
public class LinkedListQueue implements Queue {
	
	private SinglyLinkedList queue;

	public LinkedListQueue() {
		queue = new SinglyLinkedList();
		
	}


	@Override
	public int size() {
		if(!queue.isEmpty()){
			return queue.size();  //비어있지 않으면
		}
		else
			return 0;
	}

	@Override
	public boolean isEmpty() {
		if(queue.isEmpty())
		{
			return true; //비어있으면
		}
		else
			return false;
	}

	@Override
	public Integer first() {
		if(!queue.isEmpty())
			return queue.first(); //비어있지않으면
		else
			return null;
	}

	 @Override
	public Integer dequeue(){	
	 	if(!queue.isEmpty()){ //비어있지 않으면
			return queue.removeFirst();  //first는 바뀌지 않기 때문에 
	 	}
	 	else
	 		return null;
	}

	@Override
	public void enqueue(Integer e) { 
		if(!queue.isEmpty()){
			queue.addLast(e);  //first를 바꾸지않고 뒤에 값 넣어주기
	 	}
	 	else{
	 		queue.addFirst(e);
		}
	}
}
