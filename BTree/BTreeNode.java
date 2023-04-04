


 public class BTreeNode {
          int t; //최소 key의 수
         int count; // key의 수
         int [] key; //  key는 2/M -1 개부터 M-1
        int c; //자식 수 // 2/M~ M
        BTreeNode [] child;//numkey+1; 
        boolean leaf;
        BTreeNode parent;
        int height;


         public BTreeNode(){}

         public BTreeNode(int t,BTreeNode parent){
             this.t=t;
             this.parent=parent;
             key=new int[2*t-1];
             child=new BTreeNode[2*t];
            leaf=true;
             count=0;     //key의 수    
             c=0;
            height=-1;
         }
         public int getvalue(int index){
             return key[index];
        }
         public BTreeNode getchild(int index){
             return child[index];
         }

         public int find(int key){
            for(int i=0; i<this.count; i++){
                if(this.key[i]==key){
                    return i;
                }
            }
            return -1;
         }
    
 }
