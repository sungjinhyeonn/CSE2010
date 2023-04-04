
public class StackNumberTest {
	
	public boolean findStackNumber(String inputStr, String outputStr) {
		
		Queue rightQueue = new LinkedListQueue();
		Queue leftQueue = new LinkedListQueue();
		Stack mainStack = new LinkedListStack();
		Queue leftQueue1=new LinkedListQueue(); //새로운 leftQueue를 생성

		//문자열을 정수로 바꾸고 leftQueue1에 enqueue
		for(char c: outputStr.toCharArray()){
			leftQueue1.enqueue(Integer.valueOf(Integer.parseInt(c+"")));
		}
		//문자열을 정수로 바꾸고 rightQueue에 enqueue
		for(char c : inputStr.toCharArray()){
			rightQueue.enqueue(Integer.valueOf(Integer.parseInt(c+"")));
		}

		Integer tmp1;
		Integer tmp2;
		Integer tmp3;


		for(int i=0; i<9999; i++){ //rightQueue와 mainstack이 비어있을때까지 반복하기위해 범위를 9999로 설정
									//while문을 사용하면 한번 더 비교해야하기 때문에 for 문 사용
			tmp1=rightQueue.first(); 
			tmp2=mainStack.top();
			tmp3=leftQueue1.first();
			
			//비교는 leftQueue1과 하고 값은 leftQueue에 넣기
			if(tmp1==tmp3) 
			{
				leftQueue.enqueue(tmp1); //leftQueue에 값 넣기
				rightQueue.dequeue(); //rightQueue의 first 제거
				leftQueue1.dequeue(); //leftQueue1 first 제거
			}
			else if(tmp2==tmp3)
			{
				leftQueue.enqueue(tmp2); //leftQueue에 값 넣기
				mainStack.pop(); //mainstack top 제거
				leftQueue1.dequeue(); // leftQueue1 first 제거
			}
			//first의 값이 전부 다르다면
			else
			{
				mainStack.push(tmp1); //스택에 값 넣기
				rightQueue.dequeue(); ////rightQueue의 first 제거
			}
		}

		//비교했을 때 전부 맞으면 leftQueue1은 비어있다
		if(leftQueue1.isEmpty()){
			return true;
		}
		else{
			return false;
		}

	}
	
	public void stackDriver(Stack stack, String str) {
		Integer tmp;
		for(char c : str.toCharArray()) {
			if(c == '-') {
				tmp = stack.pop();
				System.out.print("Pop(): ");
				if(tmp != null)
					System.out.println(tmp.toString());
				else
					System.out.println("null");
			}
			else if(c == 't') {
				tmp = stack.top();
				System.out.print("Top(): ");
				if(tmp != null)
					System.out.println(tmp.toString());
				else
					System.out.println("null");
			}
			else if(c == 's') {
				System.out.println("Size(): " + stack.size());
			}
			else if(c == 'e') {
				System.out.println("isEmpty(): " + (stack.isEmpty()?"true":"false"));
			}	
			else {
				System.out.println("Push(" + c + ")");
				stack.push(Integer.valueOf(Integer.parseInt(c+"")));
			}
		}
	}
	
	public void queueDriver(Queue queue, String str) {
		Integer tmp;
		for(char c : str.toCharArray()) {
			if(c == '-') {
				tmp = queue.dequeue();
				System.out.print("Dequeue(): ");
				if(tmp != null)
					System.out.println(tmp.toString());
				else
					System.out.println("null");
			}
			else if(c == 'f') {
				tmp = queue.first();
				System.out.print("First(): ");
				if(tmp != null)
					System.out.println(tmp.toString());
				else
					System.out.println("null");
			}
			else if(c == 's') {
				System.out.println("Size(): " + queue.size());
			}
			else if(c == 'e') {
				System.out.println("isEmpty(): " + (queue.isEmpty()?"true":"false"));
			}
			else {
				System.out.println("enqueue(" + c + ")");
				queue.enqueue(Integer.valueOf(Integer.parseInt(c+"")));
			}
		}
	}
	
	public static void main(String [] args) {
		StackNumberTest snt = new StackNumberTest();
		
		/* Stack operation test */
		Stack testStack = new LinkedListStack();
		System.out.println("Stack operation test");
		snt.stackDriver(testStack, "53s-e-e-79t4s-68-");
		
		/* Queue operation test */
		 Queue testQueue = new LinkedListQueue();
		 System.out.println("\nQueue operation test");
		 snt.queueDriver(testQueue, "53-7-f--e97s35-");
		
		 /* findStackNumber method test */		
		 System.out.println("\nfindStackNumber test");
		 System.out.println("find test 1: " + (snt.findStackNumber("123456789", "346785921")?"OK":"Failed"));
		 System.out.println("find test 2: " + (snt.findStackNumber("123456789", "567483219")?"OK":"Failed"));
		 System.out.println("not find test 1: " + (snt.findStackNumber("123456789", "348567291")?"Failed":"OK"));
		 System.out.println("not find test 2: " + (snt.findStackNumber("123456789", "185674932")?"Failed":"OK"));	
	}
}
