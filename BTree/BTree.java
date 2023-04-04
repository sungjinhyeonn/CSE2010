
public class BTree {

    private int order;
    BTreeNode root;

    public BTreeNode getRoot(){
        return root;
    }
    public BTree(int order){
        this.order=order;
        root=new BTreeNode(order,null);
    }
    public BTreeNode search(BTreeNode x,int key){
        int i=0;
        if(x==null){
            return x;
        }
        for(i=0; i<x.count; i++){
            if(key<x.key[i]){
                break;
            }
            if(key==x.key[i]){
                return x;
            }

        }
        if(x.leaf){
            return null;
        }
        else
            return search(x, key);
        
    }



    public void insert(final int key){
        BTreeNode r=root;
        if(r.count==2*order-1){
            BTreeNode s= new BTreeNode(order,null);
            root=s;
            s.leaf=false;
            s.count=0;
            s.child[0]=r;
            split(s,0,r);
        }
        else
            insertnode(r,key);
    }

    public void insertnode(BTreeNode x,int k){
        if(x.leaf){
            int i=0;
            for(i=x.count-1; i>=0 && k<x.key[i]; i--){
                x.key[i+1]=x.key[i];
            }
            x.key[i+1]=k;
            x.count=x.count+1;
        }
        else{
            int i=0;
            for(i=x.count-1; i>=0 && k<x.key[i];i--){
            }
            ;
            i++;
            BTreeNode tmp=x.child[i];
            if(tmp.count==2*order-1){
                split(x,i,tmp);
                if(k>x.key[i]){
                    i++;
                }
            }
            x.height++;
            insertnode(x.getchild(i),k);
        }
    }
    public void split(BTreeNode x, int pos, BTreeNode y){
        BTreeNode z=new BTreeNode(order,null);
        z.leaf=y.leaf; //z는 y의 정보를 따라가야 합니다.
        z.count=order-1;
        //t-1만큼 z의 key로 할당합니다.
        for(int i=0; i<order-1; i++){
            z.key[i]=y.key[i+order];
        }
        //y가 leaf가 아니므로 서브 트리가 존재합니다. 서브트리를 z에 할당합니다.
        if(!y.leaf){
            for(int i=0; i<order; i++){
                z.child[i]=y.child[i+order];         
            }
        }
        //새로운 공간을 만들어야 하기 때문에 한 칸 씩 뒤로 땡겨줍니다.
        y.count=order-1;
        for(int i=x.count; i>=pos; i--){
            x.child[i+1]=x.child[i];
        }
        x.child[pos+1]=z;
        //x의 key중 뒤에서 부터 한 칸 씩 미뤄줍니다.
        for(int i=x.count-1; i>=pos; i--){
            x.key[i+1]=x.key[i];
        }
        x.key[pos]=y.key[order-1];
        x.count=x.count+1;
       }

    private void remove( BTreeNode x,int key){
        int pos=x.find(key);
        if(pos!=-1){
            if(x.leaf){
                int i=0;
                for(i=0; i<x.count &&  x.key[i]!=key; i++){

                }
                ;
                for(; i<x.count; i++){
                    if(i!=2*order-2){
                        x.key[i]=x.key[i+1];

                    }
                }
                x.count--;
                return;
            }
        }

    }
    public void remove(int key){
        BTreeNode x=search(root, key);
        if(x==null){
            return;
        }
        remove(root,key);
    }


    public void display() {
        display(root);
        System.out.println();
        System.out.print("height="+root.height+" ");
      }
      
      // Display the tree
      private void display(BTreeNode x) {
        assert (x == null);
        for (int i = 0; i < x.count; i++) {
          System.out.print(x.key[i] + " ");
        }
        if (!x.leaf) {
          for (int i = 0; i < x.count + 1; i++) {
            display(x.child[i]);
          }
          
        }
         

      }

     public static void main(String[] args) {
         BTree b = new BTree(4);
         b.insert(8);
         b.insert(9);
         b.insert(10);
         b.insert(11);
         b.insert(15);
         b.remove(15);
        b.display();
       }


}