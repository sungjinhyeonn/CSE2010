public class SinglyLinkedList {

    private SingleNode head = null;
    private SingleNode tail = null;
    private int size = 0;

    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public SingleNode getTail() {
        return tail;
    }
    
    public boolean isTail(SingleNode node) {
        return node.getNext() == null;
    }
    
    public void addFirst(int element) {
        head = new SingleNode(element, head);
        if(isTail(head))
            tail = head;
        size++;
    }
    
    public void addLast(int element) {
        if(isEmpty())
            addFirst(element);
        else {
            tail.setNext(new SingleNode(element, null));
            tail = tail.getNext();
            size++;
        }
    }
    
    public SingleNode removeFirst() {
        if(isEmpty())
            return null;
            SingleNode answer = head;
        if(isTail(head))
            tail = null;
        head = head.getNext();
        size--;
        return answer;
    }
    
    public SingleNode removeLast() {
        if(isEmpty())
            return null;
        if(isTail(head))
            return removeFirst();
        else{
            SingleNode ptr = head, pre = head;
            while(!isTail(ptr)){
                pre = ptr;
                ptr = ptr.getNext();
            }
            pre.setNext(null);
            size--;
            return ptr;
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder("List: size = " + size + " [");
        SingleNode current = head;
        while(current != null){
            builder.append(current.getElement());
            if(current.getNext() != null)
                builder.append(", ");
            current = current.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    public SingleNode find(int element){
        SingleNode T=this.head;
        while(T!=null){
            if(element==T.getElement()){
                return T; //노드에있는요소와 입력받은 element 같다면 노드를 반환
            }
            else{
                T=T.getNext();
            } //다음 노드로 이동
        }
        return null;
    }

    public SingleNode removeNode(SingleNode node){
      SingleNode prenode=head;
      SingleNode tempnode=head.getNext();

      //Node 삭제
      // 첫번째 노드와  같을 경우
      if(prenode.getElement()==node.getElement()){
        removeFirst(); //노드 삭제
      }
      //두번째 노드부터 마지막 노드와 같을 경우
      else{
          while(tempnode!=null){ //tempnode가 null이 아닐때까지
                if(node.getElement()==tempnode.getElement()){ //노드가 같을 경우
                    if(tempnode.getNext()==null){ //노드가 같으면서 마지막 노드일경우
                        removeLast(); //마지막 노드 삭제
                    }
                    else{
                        prenode.setNext(tempnode.getNext()); //노드가 같으면서 마지막 노드가 아닐경우
                        size--;  //사이즈 감소
                    }
                    break; 
                }    
                else{
                    //노드가 일치하지 않을경우
                    prenode=tempnode;
                    tempnode=tempnode.getNext(); //tempnode에 다음노드 할당

                }
            }
        }
        return null;
    }
    public void reverse(){
        
        SingleNode nextnode=head;
        SingleNode currentnode=null;
        SingleNode prenode=null;
        while(nextnode!=null){
            prenode=currentnode; //prenode를 currentnode 위치로 이동
            currentnode=nextnode; //currentnode를 nextnode 위치로 이동
            nextnode=nextnode.getNext(); //nextnode를 다음 노드로 이동
            currentnode.setNext(prenode); //currentnode의 다음노드를 prenode로
        }
        head=currentnode; //currentnode가 마지막 노드를 가리킬때head는 currentnode
    }
}
