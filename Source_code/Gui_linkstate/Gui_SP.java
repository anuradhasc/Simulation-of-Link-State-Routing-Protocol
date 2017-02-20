import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Gui_SP extends Frame {

	public static void main(String[] args){
		
	}
	public int callSP(String filename, int sourcenode, int destinationnode){
		int initial_source = sourcenode;
		int destination = destinationnode;
		int index = 1;
		int[] Path = new int[10000];
		ShortestPath spobj = new ShortestPath();
		//int new_source = spobj.callDijkstras(filename, initial_source, destination);
		int new_source = 0;
		int min_cost = 0;
		int[] result =  spobj.callDijkstras(filename, initial_source, destination);
		new_source = result[0];
		min_cost = result[1];
		Path[0]= initial_source;
		Path[1]= new_source;
		while(new_source != destination)
		{
			 //System.out.print(new_source);
			 result =  spobj.callDijkstras(filename, new_source, destination);
				new_source = result[0];
			//	min_cost = result[1];
				 index = index + 1;
				 Path[index]= new_source;

		}
		index++;
		Path[index] = destination;
		
		Frame ResultConnectiontable = new Frame();    
    	ResultConnectiontable.setLayout(new BorderLayout());
    	ResultConnectiontable.setSize(500, 500);
    	
    	TextArea ta = new TextArea();
    	ta.setForeground(Color.BLUE);
    	
    	Label lb3 = new Label("Shortest Path from	" + initial_source+"	to	"+destination+"	is	");
        lb3.setForeground(Color.BLUE); 
        
        Button b = new Button("Return to Main Menu");
        b.setForeground(Color.BLUE);
        b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
  	        	 ResultConnectiontable.dispose();

			}
       	 
        });
        
        
		//System.out.println("Shortest Path	from	" + initial_source + "	to	" + destination + "	is	");
        
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        p1.add(lb3);
        
        Panel p2 = new Panel();
        p2.setLayout(new FlowLayout());
        p2.add(ta);
        
        Panel p3 = new Panel();
        p3.setLayout(new FlowLayout());
        p3.add(b);
        
        ResultConnectiontable.add(p1, BorderLayout.NORTH);
		ResultConnectiontable.add(p2, BorderLayout.CENTER);
		ResultConnectiontable.add(p3, BorderLayout.SOUTH);
    	
    	ResultConnectiontable.addWindowListener(new WindowAdapter() {
   	         public void windowClosing(WindowEvent windowEvent){
   	        	 ResultConnectiontable.dispose();
   	         }        
   	      });  
    	
    	ResultConnectiontable.addWindowListener(new WindowAdapter() {
   	         public void windowClosing(WindowEvent windowEvent){
   	        	 ResultConnectiontable.dispose();
   	         }        
   	      });  
        
		for(int i = 0; i<index; i++)
		//System.out.print(Path[i] + "	");
		//System.out.println();
			ta.append(Path[i]+" ");
		ta.append("\n"+"Min cost is  "+ min_cost);
		ta.setEditable(false);
		ResultConnectiontable.setVisible(true);
		
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
		//int new_source = initial_source;
		//Path[0]= initial_source;
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
		
		Frame ResultConnectiontable = new Frame();    
    	ResultConnectiontable.setLayout(new BorderLayout());
    	ResultConnectiontable.setSize(500, 500);
    	
    	TextArea ta = new TextArea();
    	ta.setForeground(Color.BLUE);
    	
    	Label lb3 = new Label("Shortest Path after removing down router from	" + initial_source+"	to	"+destination+"	is	");
        lb3.setForeground(Color.BLUE); 
        
        Button b = new Button("Return to Main Menu");
        b.setForeground(Color.BLUE);
        b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
  	        	 ResultConnectiontable.dispose();

			}
       	 
        });
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        p1.add(lb3);
        
        Panel p2 = new Panel();
        p2.setLayout(new FlowLayout());
        p2.add(ta);
        
        Panel p3 = new Panel();
        p3.setLayout(new FlowLayout());
        p3.add(b);
        
        ResultConnectiontable.add(p1, BorderLayout.NORTH);
		ResultConnectiontable.add(p2, BorderLayout.CENTER);
		ResultConnectiontable.add(p3, BorderLayout.SOUTH);
    	
    	ResultConnectiontable.addWindowListener(new WindowAdapter() {
   	         public void windowClosing(WindowEvent windowEvent){
   	        	 ResultConnectiontable.dispose();
   	         }        
   	      });  
    	
		//System.out.println("Shortest Path after removing down node from	" + initial_source + "	to	" + destination + "	is	");
		for(int i = 0; i<index; i++)
		{
			
			ta.append(Path[i]+" ");

		}
		ta.append("\n"+"Min cost is:"+min_cost);
		//System.out.println();
		ResultConnectiontable.setVisible(true);

		return 1;
		
	}
}
