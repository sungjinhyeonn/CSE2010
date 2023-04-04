

public class Graph {
	private int[] v;
	private int[][] e;
	private int size;
	private int cnt;
	 int temp; //인덱스 저장
	 int temp2; //인덱스 저장
	public Graph() {
		v = null;
		e = null;
		size = 0;
		cnt = 0;
	}

	public Graph(int s) {		
		v = new int[s];
		e = new int[s][s];
		size = s;
		cnt = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insertVertex(int v1) {
		if(cnt >= size ) {
			return;
		}
		v[cnt++] = v1;		
	}

	// v1 -> v2
	public void insertEdge(int v1, int v2) {		
		insertEdgeWithWeight(v1, v2, 1);		
	}

	public void udInsertEdge(int v1, int v2) {		
		insertEdge(v1, v2);
		insertEdge(v2, v1);
	}

	public void insertEdgeWithWeight(int v1, int v2, int w) {
		int idx1 = getIdx(v1);
		int idx2 = getIdx(v2);
		if(idx1 < 0 || idx2 < 0) {
			return;
		}
		e[idx1][idx2] = w;
	}

	public void udInsertEdgeWithWeight(int v1, int v2, int w) {
		insertEdgeWithWeight(v1, v2, w);
		insertEdgeWithWeight(v2, v1, w);
	}

	public void deleteEdge(int v1, int v2) {

		int idx1 = getIdx(v1);
		int idx2 = getIdx(v2);
		if(idx1 < 0 || idx2 < 0) {
			return;
		}

		e[idx1][idx2] = 0;		
	}	

	public void print() {
		System.out.print("  ");
		for(int i=0; i<size; i++) {
			if(v[i] > 10)
				System.out.print(" "+ (char)v[i] + " ");
			else
				System.out.print(v[i] + " ");
		}
		System.out.println();

		for(int i=0; i<size; i++) {

			if(v[i] > 10)
				System.out.print((char)v[i] + " ");
			else
				System.out.print(v[i] + " ");

			for(int j=0; j<size; j++) {
				if(e[i][j] < 99)
					System.out.printf("%2d ", e[i][j]);
				else
					System.out.print(" ∞ ");
			}
			System.out.println();
		}
	}

	public int getIdx(int v1) {
		for(int i=0; i<size; i++) {
			if(v[i] == v1) return i;
		}
		return -1;
	}
	// method for prim algorithm
	public void prim(int startIdx) {
		boolean[] visit = new boolean[size]; //방문하면 true
		int st=startIdx; 
		int mi = 100;
	
		for (int i = 0; i < size-1; i++) {
		   visit[st]=true; //시작지점 true
		   //최소 비용 찾기 
		   for (int j = 0; j < size; j++) {
			 if(e[st][j]!=0 && visit[j]==false){
				 if(e[st][j]<mi){
					mi = e[st][j]; //행에서 최소값 찾기
					temp=j; 
					temp2=j;
				 }
			 }
			 
			 
		   }
		   

		   //다른 노드를 거쳐가는것이 최소 비용인지 확인
		   if(e[temp2][i]<mi && e[temp][i]!=0 && visit[temp]==false) 
			{	 mi=e[temp2][i];

				System.out.println("("+(char)v[i]+", "+(char)v[temp2]+") : "+mi);
				// System.out.println(temp);
				 // System.out.println(i);
			}		 
		   else 
		  	 System.out.println("("+(char)v[st]+", "+(char)v[temp]+") : "+mi);
		  // for(int z=0; z<size; z++)
			 //   System.out.println(visit[z]);
			 st=temp;
		   mi=100;
		}
		
	   }
			
		



	// method for dijkstra algorithm
	public void dijkstra(int startIdx) {
		int[] distance = new int[size];	 //최단 거리를 저장할 변수
		boolean[] check =new boolean[size];

		//distance 값 초기화
		for(int i=0; i<size; ++i){
			distance[i]=Integer.MAX_VALUE;
		}

		distance[startIdx]=0;
		check[startIdx]=true; //시작지점 true 

		//연결노드 distance 갱신
		for(int i=0; i<size; ++i){
				if(!check[i]&&e[startIdx][i]!=Integer.MAX_VALUE) //
				distance[i]=e[startIdx][i];
		}

		for(int j=0; j<size-1; j++)
		{
			//노드가 size 만큼 있을 때 다익스트라를 위해서는 size -1 만큼 반복하기
			int min=Integer.MAX_VALUE;
			int min_index=-1;
			//노드 최소값 찾기
			for(int i=0; i<size; ++i)
				{
					if(!check[i]){
						if(distance[i]<min){
							min=distance[i];
							min_index=i;
						}
					}

				}
				//다른 노드를 거쳐 가는 것이 비용이 더 적은지 확인
			check[min_index]=true;
			for(int i=0; i<size; ++i){
				if(!check[i]&&e[min_index][i]!=Integer.MAX_VALUE){
					if(distance[min_index] + e[min_index][i] < distance[i]){
                        distance[i] = distance[min_index] + e[min_index][i];
				}

			}
		}
		}

		// TODO: your code here
		
		System.out.print("Distance: [");
		for(int i=0; i<size; i++) {
			System.out.print(distance[i]);
			if(i < size-1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
}

