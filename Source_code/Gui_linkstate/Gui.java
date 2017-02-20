import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;

public class Gui {
	private Frame mainFrame;
	private Label msgLabel;
	private Label headerLabel;
	private Panel controlPanel;
	private CheckboxGroup cbg = new CheckboxGroup();
	private Checkbox cb1 = new Checkbox("1. Create a Network Topology", cbg, false);
	private Checkbox cb2 = new Checkbox("2. Build a Connection Table", cbg, false);
	private Checkbox cb3 = new Checkbox("3. Shortest Path to Destination Router", cbg, false);
	private Checkbox cb4 = new Checkbox("4. Modify a topology", cbg, false);
	private Checkbox cb5 = new Checkbox("5. Exit", cbg, false);

	private Button exitbutton;
	String filename;
	int source;
	int destination;
	int router;
	public Gui()
	{
		prepareGui();
	}
	
	public static void main(String[] args)
	{
		Gui Guiobj = new Gui();
		//Guiobj.callFrame();
	}

	private void prepareGui(){
		mainFrame = new Frame("CS542 Link State Routing Protocol Simulator");
		mainFrame.setSize(400, 400);
		BorderLayout layout = new BorderLayout();
	    layout.setHgap(5);
	    layout.setVgap(5);
		mainFrame.setLayout(layout);
		mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });  
		msgLabel = new Label();
	    msgLabel.setAlignment(Label.CENTER);
	    msgLabel.setText("Welcome to CS542 Link State Routing Protocol");
	    msgLabel.setForeground(Color.BLUE);
	    
	    exitbutton = new Button("Exit");
	    exitbutton.setForeground(Color.BLUE);
	    exitbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
   	        	 mainFrame.dispose();

			}
        	 
         });
	    
	    cb1.setForeground(Color.BLUE);
	    cb2.setForeground(Color.BLUE);
	    cb3.setForeground(Color.BLUE);
	    cb4.setForeground(Color.BLUE);
	    cb5.setForeground(Color.BLUE);
	    
	    controlPanel = new Panel();
	    controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
	    mainFrame.add(msgLabel,BorderLayout.BEFORE_FIRST_LINE);
	   // mainFrame.add(headerLabel, BorderLayout.LINE_START);
	    mainFrame.add(controlPanel, BorderLayout.CENTER );
	    mainFrame.add(exitbutton, BorderLayout.SOUTH);

	    cb1.addItemListener(new ItemListener(){
	    	public void itemStateChanged(ItemEvent e) {   
	    		Frame Connectionframe = new Frame("CS542 Link State Routing Protocol Simulator");
	    		
	            Connectionframe.setLayout(new BorderLayout());
	    		Connectionframe.setSize(700, 700);
	    		
	    		Label lb1 = new Label("Enter input filename:Network Topology");
	    		lb1.setForeground(Color.BLUE);
	    		
	    		TextField tf1 = new TextField(10);
	    		tf1.setEditable(true);
	    		tf1.setForeground(Color.RED);
	    		
	    	    JTextArea ta1 = new JTextArea();
	    	    ta1.setEditable(false);
	    	     
	    	    Button b = new Button("Return to Main Menu");
	    	     b.setSize(2, 4);
		         b.setForeground(Color.BLUE);
		         b.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
		   	        	 Connectionframe.dispose();

					}
		        	 
		         });	
		         
		         Panel p1 = new Panel();
		         p1.setLayout(new FlowLayout());
		         p1.add(lb1);
		         p1.add(tf1);
		         
		         Panel p2 = new Panel();
		         p2.setLayout(new FlowLayout());
		         p2.add(ta1);
		         
		         Panel p3 = new Panel();
		         p3.setLayout(new FlowLayout());
		         p3.add(b);
		         
	    	    Connectionframe.add(p1, BorderLayout.NORTH);
	    		Connectionframe.add(p2, BorderLayout.CENTER);
	    		Connectionframe.add(p3, BorderLayout.SOUTH);
	    	
	    		Connectionframe.setVisible(true);
	    		
	    		Connectionframe.addWindowListener(new WindowAdapter() {
	   	         public void windowClosing(WindowEvent windowEvent){
	   	        	 Connectionframe.dispose();
	   	         }        
	   	      });  
	    	    tf1.addActionListener(new ActionListener(){
	    	    	@Override
					public void actionPerformed(ActionEvent arg0) {
						
	    	    		filename = tf1.getText();
	    	    		String strLine = null;
	    	    		try{
	    	    			FileInputStream fstream = new FileInputStream (filename);
	    	    	        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	    	    	        while ((strLine = br.readLine()) != null)   {
	    	    	        	 ta1.append(strLine+"\n");
	    	    	        	 ta1.setForeground(Color.BLUE);
	    	    	        }
	    	    	       
	    	    	        br.close();
	    	    	     
	    	    			}catch(IOException ioe)
	    	    			{
	    	    				 System.err.println("Problem with Communication Server");
	    	    			     System.exit(1); 
	    	    			}

					}
	    	    	
	    	    });            
	         }
	    });
	    cb2.addItemListener(new ItemListener(){
	    	public void itemStateChanged(ItemEvent e) {     
	    		Frame Connectionframe1 = new Frame("CS542 Link State Routing Protocol Simulator");
	    		Connectionframe1.setLayout(new BorderLayout());
	    		Connectionframe1.setSize(700, 700);
	    		
	            Label lb2 = new Label("Enter Source Router");
	            lb2.setForeground(Color.BLUE);
	            
	            TextField tf2 = new TextField(10);
	            tf2.setForeground(Color.RED);
	      
	            Button b = new Button("Return to Main Menu");
	             b.setSize(2, 5);
		         b.setForeground(Color.BLUE);
		         b.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
		   	        	 Connectionframe1.dispose();

					}
		        	 
		         });
	           	            
	            Connectionframe1.setVisible(true);
	            Connectionframe1.addWindowListener(new WindowAdapter() {
		   	         public void windowClosing(WindowEvent windowEvent){
		   	        	 Connectionframe1.dispose();
		   	         }        
		   	      });  
	            
	            tf2.addActionListener(new ActionListener(){
	    	    	@Override
					public void actionPerformed(ActionEvent arg0) {
						
	    	    		source = Integer.parseInt(tf2.getText());
	    	    		Gui_Dijkstras obj = new Gui_Dijkstras();
	    				int res = obj.callDijkstras(filename, source);

					}
	    	    	
	    	    });   
	          
	            Panel p1 = new Panel();
	            p1.setLayout(new FlowLayout());
	            p1.add(lb2);
	            
	            Panel p2 = new Panel();
	            p2.setLayout(new FlowLayout());
	            p2.add(tf2);
	            
	            Panel p3 = new Panel();
	            p3.setLayout(new FlowLayout());
	            p3.add(b);
	            
	            Connectionframe1.add(p1, BorderLayout.NORTH);
	    		Connectionframe1.add(p2, BorderLayout.CENTER);
	    		Connectionframe1.add(p3, BorderLayout.SOUTH);
	         }
	    });
	    cb3.addItemListener(new ItemListener(){
	    	public void itemStateChanged(ItemEvent e) {
	    		Frame Connectionframe2 = new Frame("CS542 Link State Routing Protocol Simulator");
	    		Connectionframe2.setLayout(new BorderLayout());
	    		Connectionframe2.setSize(700, 700);
	    		headerLabel = new Label();
	            headerLabel.setText("Shortest Path to Destination Router");
	            
	            Label lb3 = new Label("Enter Destination Router");
	            lb3.setForeground(Color.BLUE);
	            
	            TextField tf3 = new TextField(10);
	            tf3.setForeground(Color.RED);
	            
	            Button b = new Button("Return to Main Menu");
	             b.setSize(2, 5);
		         b.setForeground(Color.BLUE);
		         b.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
		   	        	 Connectionframe2.dispose();

					}
		        	 
		         });
		         
		         Connectionframe2.setVisible(true);
		            Connectionframe2.addWindowListener(new WindowAdapter() {
			   	         public void windowClosing(WindowEvent windowEvent){
			   	        	 Connectionframe2.dispose();
			   	         }        
			   	      });  
		            
		            tf3.addActionListener(new ActionListener(){
		    	    	@Override
						public void actionPerformed(ActionEvent arg0) {
							
		    	    		destination = Integer.parseInt(tf3.getText());
		    	    		Gui_SP obj1 = new Gui_SP();
		    				int y = obj1.callSP(filename, source, destination);

						}
		    	    	
		    	    });   
		            

		            Panel p1 = new Panel();
		            p1.setLayout(new FlowLayout());
		            p1.add(lb3);
		            
		            Panel p2 = new Panel();
		            p2.setLayout(new FlowLayout());
		            p2.add(tf3);
		            
		            Panel p3 = new Panel();
		            p3.setLayout(new FlowLayout());
		            p3.add(b);
		            
		            Connectionframe2.add(p1, BorderLayout.NORTH);
		    		Connectionframe2.add(p2, BorderLayout.CENTER);
		    		Connectionframe2.add(p3, BorderLayout.SOUTH);
		            
	         }
	    });
	    cb4.addItemListener(new ItemListener(){
	    	public void itemStateChanged(ItemEvent e) {   
	    		Frame Connectionframe3 = new Frame("CS542 Link State Routing Protocol Simulator");
	    		Connectionframe3.setLayout(new BorderLayout());
	    		Connectionframe3.setSize(700, 700);
	    		
	    		 Label lb3 = new Label("Enter Router to be taken down");
		         lb3.setForeground(Color.BLUE);
		            
		         TextField tf3 = new TextField(10);
		         tf3.setForeground(Color.RED);
		         
		         
		         Button b = new Button("Return to Main Menu");
	             b.setSize(2, 5);
		         b.setForeground(Color.BLUE);
		         b.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
		   	        	 Connectionframe3.dispose();

					}
		        	 
		         });
		         Connectionframe3.setVisible(true);
		         tf3.addActionListener(new ActionListener(){
		    	    	@Override
						public void actionPerformed(ActionEvent arg0) {
							
		    	    		router = Integer.parseInt(tf3.getText());
		    	    		
		    	    		Routerdown rdobj = new Routerdown();
		    				rdobj.callRouterdown(filename, source, router);
		    				
		    	    		Gui_SP obj1 = new Gui_SP();
		    				int y = obj1.callSProuterdown(filename, source, destination, router);

						}
		    	    	
		    	    });   
		            
		         	Panel p1 = new Panel();
		            p1.setLayout(new FlowLayout());
		            p1.add(lb3);
		            
		            Panel p2 = new Panel();
		            p2.setLayout(new FlowLayout());
		            p2.add(tf3);
		            
		            Panel p3 = new Panel();
		            p3.setLayout(new FlowLayout());
		            p3.add(b);
		            
		            Connectionframe3.add(p1, BorderLayout.NORTH);
		    		Connectionframe3.add(p2, BorderLayout.CENTER);
		    		Connectionframe3.add(p3, BorderLayout.SOUTH);
	            
	         }
	    });
	    cb5.addItemListener(new ItemListener(){
	    	public void itemStateChanged(ItemEvent e) {             
	            System.exit(1);
	         }
	    });
 
	    controlPanel.add(cb1);
	    controlPanel.add(cb2);
	    controlPanel.add(cb3);
	    controlPanel.add(cb4);
	    controlPanel.add(cb5);
	    
	    mainFrame.setVisible(true);
	    	
	}
	
	
	private void callFrame() {
		// TODO Auto-generated method stub
		
	}
}
