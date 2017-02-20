import java.util.*;
import java.lang.*;
import java.io.*;

public class Dijkstras {

	String strLine = null;
	int lines = 0;
	int no_of_nodes;
	  int vertex;
      List<Integer>[] adj;
	public static void main(String[] args) {
		
	}
	
	public int callDijkstras(String filename, int sourcenode)
	{
		
		// Reading the topology file to get distances
		try{
		FileInputStream fstream = new FileInputStream (filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        LineNumberReader reader  = new LineNumberReader(new FileReader(filename));
        while((reader.readLine()) != null)  
        {
        	lines++;
        }
        no_of_nodes = lines - 1;
        
        // Least cost path from S to node m;
        int[] D = new int[no_of_nodes+1]; 
        // Set of nodes in the network
		List<Integer> Nodes = new ArrayList<Integer>(); 
		// Source node
		int source = sourcenode;		
		// Set of nodes so far incorporated
		List<Integer> M = new ArrayList<Integer>();
		// link cost from node i to node j
		int[][] d = new int[no_of_nodes+1][no_of_nodes+1]; 
        int index = 0;
        // Array containing next hops for each node
        int[] Nexthop = new int[no_of_nodes+1];
        
        Nexthop[source] = source;
        
        int n = (no_of_nodes*no_of_nodes) + 1;
        String[] tokens = new String[n];
        while ((strLine = br.readLine()) != null)   {
        	 tokens = strLine.split(" ");
        	 for(int i = 1; i<=no_of_nodes; i++)
        	 {
        		 d[index][i] = Integer.parseInt(tokens[i]);
        	 }
    		 index = index + 1;
        }

        reader.close();
        br.close();
        
        //Initialization of set Nodes
        for(int i=1; i<=no_of_nodes; i++)
        {
        Nodes.add(i);
        }
        
        //Intialization of set M
        M.add(source);
        // Removing source from Nodes
        Iterator<Integer> iter1 = Nodes.listIterator();
        while (iter1.hasNext()) {
            Integer a = iter1.next();
            if(a == source)
            {
            	iter1.remove();
            }    
        }
        
        //Find D[m] distance from source to node m
        for(int k=1; k<=no_of_nodes; k++)
        {
        	if(d[source][k]>0)
        	{
        		D[k] = d[source][k];
        	}
        	else
        	{
        		D[k] = Integer.MAX_VALUE;
        	}
        }
    	int firstloop = 1;

       while(!(Nodes.isEmpty()))
        {
        //Find Minimum of D[m]
        int min = Integer.MAX_VALUE;
        int Min_node = 0;
        for(Integer x: Nodes)
        {
        	if(D[x]<min)
        	{
        		min = D[x];
        		Min_node = x;
        	}
        }
   
        // adding node to M
        M.add(Min_node);
        
        if(firstloop == 1)
        {
        	Nexthop[Min_node] = Min_node;
        }
        
        //for final loop: exit condition
        if(M.size() == no_of_nodes)
        {
        	
            //System.out.println("CONNECTION TABLE FOR" + source);
    		System.out.println("Destination Router		Nexthop");
    		System.out.println("=======================================");
    		for(int i=1; i<=no_of_nodes; i++)
    		{
    			System.out.print(i+"				"+ Nexthop[i]);
    			System.out.println();
    		}
    		return 1;
        }
        
        // Remove nodes from Nodes set which are added to M set
        Iterator<Integer> iter = Nodes.listIterator();
        while (iter.hasNext()) {
            Integer a = iter.next();
            if(a == Min_node)
            {
            	iter.remove();
            }    
        }
      
        //Update least costs
        for( Integer m: Nodes)
        {
        	if(d[Min_node][m] == -1)
        	{
        		d[Min_node][m] = Integer.MAX_VALUE;
        		D[m] = min(D[m], d[Min_node][m]);
            	if(D[m] == d[Min_node][m])
            	{
            		if(D[Min_node] == d[sourcenode][Min_node])
            		{
            		Nexthop[m] = Min_node;
            		}
            		else
            		{
            			Nexthop[m] = Nexthop[Min_node];
            		}
            	}
            	else{
            		if(D[m] == d[source][m])
            		{
            		Nexthop[m] = m;
            		}
            		else{
            			Nexthop[m] = Nexthop[m];
            		}

            	}
        	}
        	else{
        		D[m] = min(D[m], D[Min_node]+d[Min_node][m]);
        		if(D[m] == (D[Min_node]+d[Min_node][m]))
            	{
        			if(D[Min_node] == d[sourcenode][Min_node])
            		{
            		Nexthop[m] = Min_node;
            		}
            		else
            		{
            			Nexthop[m] = Nexthop[Min_node];
            		}

            	}
            	else{
            		if(D[m] == d[source][m])
            		{
            		Nexthop[m] = m;
            		}
            		else{
            			Nexthop[m] = Nexthop[m]; // if D[m] is Updated value
            		}
            	}
        	}
         }
        firstloop = firstloop + 1;
		}
       
		}catch(IOException e)
		{
			 System.err.println("Problem with Communication Server");
		     System.exit(1); 
		}
		return 1;
	}

	public int min(int i, int j) {
		// TODO Auto-generated method stub
		if( i <= j)
			return i;
		else
			return j;
	}
}
