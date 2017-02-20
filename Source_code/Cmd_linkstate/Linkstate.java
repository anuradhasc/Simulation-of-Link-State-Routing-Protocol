import java.io.*;
import java.lang.*;
import java.util.*;

public class Linkstate {

	static int sourcenode = 0;
	static int destinationnode = 0;
	static String filename = null;
	static int nodes = 0;

	public static void main(String[] args) {
		System.out.println("CS542 Link State Routing Simulator");
		System.out.println("Select an option from following menu");
		System.out.println("(1) Create a Network Topology");
		System.out.println("(2) Build a Connection Table");
		System.out.println("(3) Shortest Path to Destination Router");
		System.out.println("(4) Modify a Topology");
		System.out.println("(5) Exit");
		
		System.out.println("Enter your option");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		String strLine = null;
		
		
		if(i == 1)
		{
			System.out.println("Enter the network topology filename with .txt extension only:");
			// Take filename from user. File should contain Matrix topology with 1 space in between
			Scanner scanner = new Scanner(System.in);
		    filename = scanner.nextLine();
			System.out.println("Network Topology");
			// Read file
			try{
			FileInputStream fstream = new FileInputStream (filename);
	        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	        while ((strLine = br.readLine()) != null)   {
	        	 System.out.println(strLine);
	        	 nodes= nodes+1;
	        }
	        System.out.print(nodes);
	        br.close();
	        // Return to Main Menu
	        Linkstate lk = new Linkstate();
	        lk.main(args);
			}catch (FileNotFoundException ex)
		    {
			      System.out.println("main: Oops, FileNotFoundException caught");
			}catch(IOException e)
			{
				 System.err.println("Problem with Communication Server");
			     System.exit(1); 
			}
		}
		if(i == 2)
		{
			
				System.out.println("Building a connection table");
				//System.out.println("Printing connection nodes of each node in the network");
				System.out.println("Enter source router");
				Scanner sc1 = new Scanner(System.in);
				sourcenode = sc1.nextInt();
				//for(int k= 1;k <= nodes-1; k++)
				//{
				System.out.println("Router	"+sourcenode+"	Connection Table");
				// call dijkstra's algo with sourcenode
				Dijkstras obj = new Dijkstras();
				int res = obj.callDijkstras(filename, sourcenode);
				//}
				// return to Main Menu
				Linkstate lk1 = new Linkstate();
		        lk1.main(args);
			
		}
		if(i == 3)
		{

				System.out.println("Shortest Path to Destination Router");
				System.out.println("Select a destination router");
				Scanner sc2 = new Scanner(System.in);
				destinationnode = sc2.nextInt();
	
				// call SP class callSP() with sourcenode and destination router
				SP obj1 = new SP();
				int y = obj1.callSP(filename, sourcenode, destinationnode);
				// return to Main Menu
				Linkstate lk2 = new Linkstate();
		        lk2.main(args);
			
		}
		if(i == 4)
		{
			System.out.println("Select a router to take it down");
			Scanner sc3 = new Scanner(System.in);
			int router = sc3.nextInt();
			if(router == sourcenode || router == destinationnode)
			{
				System.out.println("Sorry Cannot find shortest path as either of source or destination nodes down");
				Linkstate lk2 = new Linkstate();
		        lk2.main(args);
				
			}
			// Update connection tables when router down
			
			Routerdown rdobj = new Routerdown();
			rdobj.callRouterdown(filename, sourcenode, router);
				
			// find shortest path when router down
			SP spobj = new SP();
			spobj.callSProuterdown(filename, sourcenode, destinationnode, router);
			
			Linkstate lk2 = new Linkstate();
	        lk2.main(args);
			
		}
		if(i == 5)
		{
			System.out.println("Exit CS542 Project : GoodBye!");
			System.exit(1);
		}
	}
}
