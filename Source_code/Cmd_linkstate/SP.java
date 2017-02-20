
public class SP {

	public static void main(String[] args){
		
	}
	public int callSP(String filename, int sourcenode, int destinationnode){
		int initial_source = sourcenode;
		int destination = destinationnode;
		int index = 1;
		int c = 2;
		int[] Path = new int[10000];
		ShortestPath spobj = new ShortestPath();
		int new_source = 0;
		int min_cost = 0;

		int[] result =  spobj.callDijkstras(filename, initial_source, destination);
		new_source = result[0];
		// System.out.print(result[0]);

		min_cost = result[1];
		// System.out.print(result[1]);

		Path[0]= initial_source;
		Path[1]= new_source;
		while(new_source != destination)
		{
			 //System.out.print(new_source);
			// new_source = spobj.callDijkstras(filename, new_source, destination);
			 result =  spobj.callDijkstras(filename, new_source, destination);
			 System.out.print(result[0]);
			new_source = result[0];
		//	min_cost = result[1];
			 //c = c+1;
			 index = index + 1;
			 Path[index]= new_source;

		}
		index++;
		Path[index] = destination;
		System.out.println("Shortest Path	from	" + initial_source + "	to	" + destination + "	is	");
		for(int i = 0; i<index; i++)
		System.out.print(Path[i] + "	");
		System.out.println();
		System.out.println("Minimum cost is  "+ min_cost);
		return 1;
		
	}
	
	public int callSProuterdown(String filename, int sourcenode, int destinationnode, int rdown){
		int initial_source = sourcenode;
		int destination = destinationnode;
		int index = 1;
		int[] Path = new int[10000];
		Routerdownpath rdobj = new Routerdownpath();
		int new_source = initial_source;
		Path[0]= initial_source;
	    boolean flag = true;
	    //int new_source = 0;
		int min_cost = 0;

		int[] result = {0};
		while(new_source != destination)
		{
			{
			 result = rdobj.callSPRouterdown(filename, new_source, destination, rdown);
			 new_source = result[0];
			 if(flag)
			 {
				 min_cost = result[1];
			 }
			 Path[index]= new_source;
			 index = index + 1;

			}
		}
	
		Path[index] = destination;
		System.out.println("Shortest Path after removing down node from	" + initial_source + "	to	" + destination + "	is	");
		for(int i = 0; i<index; i++)
		{
			//if(i != rdown)
			System.out.print(Path[i] + "	");
		}
		System.out.println();
		
		System.out.println("Minimum Cost  "+min_cost);
		return 1;
		
	}
}
