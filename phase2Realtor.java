///////////////////////////////////////////////////////// 
//Riley Faszewski
// 5/3/2017 
//Final Database 
///////////////////////////////////////////////////////////

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class phase2Realtor extends JFrame{
   private JTabbedPane tabbedPane; 
   private JPanel agent = new JPanel(); 
   private JPanel Buyer = new JPanel();

   // Agent Tab
   protected JLabel agentMLSNumLabel = new JLabel("MLSNum: ");
   protected JTextField agentMLSNumTextBox = new JTextField("",20);
   protected JLabel agentIDLabel = new JLabel("Property ID:");
   protected JTextField agentIDTextBox = new JTextField("",30);
   protected JLabel agentAddressLabel = new JLabel("Address:");
   protected JTextField agentAddressTextBox = new JTextField("",30);
   protected JLabel agentCityLabel = new JLabel("City:");
   protected JTextField agentCityTextBox = new JTextField("",30);
   protected JLabel agentStateLabel = new JLabel("State:");
   protected JTextField agentStateTextBox = new JTextField("",30);
   protected JLabel agentLotLabel = new JLabel("Lot Size:");
   protected JTextField agentLotTextBox = new JTextField("",30);
   protected JLabel agentYearLabel = new JLabel("Year Built:");
   protected JTextField agentYearTextBox = new JTextField("",30);
   protected JLabel agentStyleLabel = new JLabel("Architecture Style:");
   protected JTextField agentStyleTextBox = new JTextField("",30);
   protected JLabel agentRoofLabel = new JLabel("Roof Type:");
   protected JTextField agentRoofTextBox = new JTextField("",30);
   protected JLabel agentHeatLabel = new JLabel("Heat Type:");
   protected JTextField agentHeatTextBox = new JTextField("",30);
   protected JLabel agentPriceLabel = new JLabel("Price:");
   protected JTextField agentPriceTextBox = new JTextField("",30);
   protected JLabel agentsqftLabel = new JLabel("Property Square Footage:");
   protected JTextField agentsqftTextBox = new JTextField("",30);
   protected JLabel agentBedroomsLabel = new JLabel("Property Bedrooms:");
   protected JTextField agentBedroomsTextBox = new JTextField("",30);
   protected JLabel agentBathroomsLabel = new JLabel("Property Bathrooms:");
   protected JTextField agentBathroomsTextBox = new JTextField("",30);
   protected JLabel agentZipLabel = new JLabel("Property Zip:");
   protected JTextField agentZipTextBox  = new JTextField("",30);
   protected JLabel agentStoriesLabel = new JLabel("Property Stories:");
   protected JTextField agentStoriesTextBox  = new JTextField("",30);
   protected JLabel agentStatusLabel = new JLabel("Property Status:");
   protected JTextField agentStatusTextBox  = new JTextField("",30);
   protected JLabel agentSellLabel = new JLabel("Sell Date:");
   protected JTextField agentSellTextBox  = new JTextField("",30);
   protected JLabel agentMarketLabel = new JLabel("Market Date:");
   protected JTextField agentMarketTextBox  = new JTextField("",30);
   protected JLabel agentLandLabel = new JLabel("Land(0 = No and 1 = Yes):");
   protected JTextField agentLandTextBox  = new JTextField("",30);
   
   protected JLabel agentOutputLabel = new JLabel("Output:");
   protected JTextArea agentOutputTextArea  = new JTextArea(4,7);

   // Buyer Tab
   protected JLabel buyersqftLabel = new JLabel("Property Square Footage:");
   protected JTextField buyersqftTextBox = new JTextField("",30);
   protected JLabel buyerBedroomsLabel = new JLabel("Property Bedrooms:");
   protected JTextField buyerBedroomsTextBox = new JTextField("",30);
   protected JLabel buyerBathroomsLabel = new JLabel("Property Bathrooms:");
   protected JTextField buyerBathroomsTextBox = new JTextField("",30);
   protected JLabel buyerZipLabel = new JLabel("Property Zip:");
   protected JTextField buyerZipTextBox = new JTextField("",30);
   protected JLabel buyerStoriesLabel = new JLabel("Property Stories:");
   protected JTextField buyerStoriesTextBox  = new JTextField("",30);
   protected JLabel buyerOutputLabel = new JLabel("Output:");
   protected JTextArea buyerOutputTextArea  = new JTextArea(4,7);


   public phase2Realtor(){
   // Set JFrame layout
         setTitle("REAPS");
         setSize(1100,400);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   		setResizable(false);
   // Create and design top JPanel
         JPanel topPanel = new JPanel();
         topPanel.setLayout(new BorderLayout());
         getContentPane().add(topPanel);  
         
         agent();
         buyer();
         
         tabbedPane = new JTabbedPane();
         //tabbedPane.addTab("Buyer", Buyer);
         tabbedPane.addTab("Agent", agent); 
         tabbedPane.addTab("Buyer", Buyer);
         topPanel.add(tabbedPane, BorderLayout.CENTER);   
   } // end phase2Realtor()

   public void initializeDB(){
      String url = "jdbc:mysql://localhost/realestate";
      String username = "root";
      String password = "cs304";
		
		System.out.println("Connecting database...");

      try (Connection conn = DriverManager.getConnection(url, username, password)) {
         System.out.println("Database connected!");
         Statement stmt = conn.createStatement();
         final ResultSet rs;
         
      } 
      catch (SQLException e) {
         throw new IllegalStateException("Cannot connect the database!", e);
      }

	} // end initializeDB 

   public void agent(){
      //initializeDB();

      // Label(s) and Textfield(s)
      JPanel information = new JPanel();
      information.setLayout(new GridLayout(14,1));
      
      information.add(agentMLSNumLabel);
      information.add(agentMLSNumTextBox);
      information.add(agentIDLabel);
      information.add(agentIDTextBox);
      information.add(agentAddressLabel);
      information.add(agentAddressTextBox);
      information.add(agentCityLabel);
      information.add(agentCityTextBox);
      information.add(agentStateLabel);
      information.add(agentStateTextBox);
      information.add(agentZipLabel);
      information.add(agentZipTextBox);
      information.add(agentsqftLabel);
      information.add(agentsqftTextBox);
      information.add(agentLotLabel);
      information.add(agentLotTextBox);
      information.add(agentYearLabel);
      information.add(agentYearTextBox);
      information.add(agentStoriesLabel);
      information.add(agentStoriesTextBox);
      information.add(agentStyleLabel);
      information.add(agentStyleTextBox);
      information.add(agentBedroomsLabel);
      information.add(agentBedroomsTextBox);
      information.add(agentBathroomsLabel);
      information.add(agentBathroomsTextBox);
      information.add(agentHeatLabel);
      information.add(agentHeatTextBox);
      information.add(agentRoofLabel);
      information.add(agentRoofTextBox);
      information.add(agentPriceLabel);
      information.add(agentPriceTextBox);
      information.add(agentStatusLabel);
      information.add(agentStatusTextBox);
      information.add(agentSellLabel);
      information.add(agentSellTextBox);
      information.add(agentMarketLabel);
      information.add(agentMarketTextBox);
      information.add(agentLandLabel);
      information.add(agentLandTextBox);

      
      
      
      

      
      // Button(s)
      JPanel buttons = new JPanel();
      JButton jbtSearch = new JButton("Search");
      JButton jbtUpdate = new JButton("Update");
      JButton jbtInsert = new JButton("Insert");
      JButton jbtDelete = new JButton("Delete");
      JButton jbtClear = new JButton("Clear");
      buttons.add(jbtSearch);
      buttons.add(jbtUpdate);
      buttons.add(jbtInsert);
      buttons.add(jbtDelete);
      buttons.add(jbtClear);
      
      //Output
      JPanel output = new JPanel();
      output.add(agentOutputLabel);
      output.add(agentOutputTextArea);

      // Add Panel(s)
      agent.add(information);
      agent.add(buttons);
      agent.add(output);

      jbtSearch.addActionListener( new ActionListener(){
         public void actionPerformed(ActionEvent e){
            String sqlMLSNum = agentMLSNumTextBox.getText();
            String sqlIDNum = agentIDTextBox.getText();
            String sqlAddressNum = agentAddressTextBox.getText();
            String sqlCityNum = agentCityTextBox.getText();
            String sqlStateNum = agentStateTextBox.getText();
            String sqlLotNum = agentLotTextBox.getText();
            String sqlYearNum = agentYearTextBox.getText();
            String sqlStyleNum = agentStyleTextBox.getText();
            String sqlHeatNum = agentHeatTextBox.getText();
            String sqlRoofNum = agentRoofTextBox.getText();
            String sqlPriceNum = agentPriceTextBox.getText();
            String sqlSqft = agentsqftTextBox.getText();
            String sqlBeds = agentBedroomsTextBox.getText();
            String sqlBaths = agentBathroomsTextBox.getText();
            String sqlZip = agentZipTextBox.getText();
            String sqlStories = agentStoriesTextBox.getText();
            String sqlStatus = agentStatusTextBox.getText();
            String sqlSell = agentSellTextBox.getText();
            String sqlMarket = agentMarketTextBox.getText();
            String sqlLand = agentLandTextBox.getText();
            String url = "jdbc:mysql://localhost/realestate";
            String username = "root";
            String password = "cs304";
            
            System.out.println("Connecting database...");

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
               System.out.println("Database connected!");
               Statement stmt = conn.createStatement();
               ResultSet rset;
               String sql = "SELECT * FROM property WHERE sqFeet = '" + sqlSqft + "' OR bedrooms = '" + sqlBeds
               + "' OR baths = '" + sqlBaths + "' OR zip = '" + sqlZip + "' OR stories = '" + sqlStories + "';"; 
               rset = stmt.executeQuery(sql);
                
               if (rset.next()) {            
                        
                  int propSqft = rset.getInt(7);
                  String sqft = String.valueOf(propSqft);
                  int propBeds = rset.getInt(12);
                  String beds = String.valueOf(propBeds);
                  double propBaths = rset.getDouble(13);
                  String baths = String.valueOf(propBaths);
                  int propZip = rset.getInt(6);
                  String zip = String.valueOf(propZip);
                  int propStories = rset.getInt(10);
                  String stories = String.valueOf(propStories);
                  String output = rset.getString(1) + " " + rset.getString(2)+ " " + rset.getString(3)+ " " + rset.getString(4)+ " "
                  + rset.getString(5) + "\n " + rset.getString(6) + " " + rset.getString(7) + " " + rset.getString(8)+ " " + rset.getString(9)
                  + " " + rset.getString(10) + " " + rset.getString(11) + "\n " + rset.getString(12)+ " " + rset.getString(13)+ " "
                   + rset.getString(14)+ " " + rset.getString(15);
                  System.out.println(sqft);



                  agentBedroomsTextBox.setText(beds);
                  agentBathroomsTextBox.setText(baths);
                  agentZipTextBox.setText(zip);
                  agentsqftTextBox.setText(sqft);
                  agentStoriesTextBox.setText(stories);
                  agentOutputTextArea.setText(output);
               } else {
                  // Display result in a dialog box
                  System.out.println("Can't Display");
                 }
            }
            catch (SQLException ex) {
               ex.printStackTrace();
            }
            
           // conn.close();
               
         }
      }); // end  ActionListener

      jbtClear.addActionListener( new ActionListener(){
         public void actionPerformed(ActionEvent e){
            agentsqftTextBox.setText("");
            agentMLSNumTextBox.setText("");
            agentIDTextBox.setText("");
            agentAddressTextBox.setText("");
            agentLotTextBox.setText("");
            agentHeatTextBox.setText("");
            agentStatusTextBox.setText("");
            agentYearTextBox.setText("");
            agentStyleTextBox.setText("");
            agentPriceTextBox.setText("");
            agentSellTextBox.setText("");
            agentMarketTextBox.setText("");
            agentLandTextBox.setText("");
            agentStateTextBox.setText("");
            agentCityTextBox.setText("");
            agentBedroomsTextBox.setText("");
            agentBathroomsTextBox.setText("");
            agentZipTextBox.setText("");
            agentStoriesTextBox.setText("");
            agentOutputTextArea.setText("");

         }
      }); // end jbtClear ActionListener
      jbtInsert.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            
            String sqlMLSNum = agentMLSNumTextBox.getText();
            String sqlIDNum = agentIDTextBox.getText();
            String sqlAddressNum = agentAddressTextBox.getText();
            String sqlCityNum = agentCityTextBox.getText();
            String sqlStateNum = agentStateTextBox.getText();
            String sqlLotNum = agentLotTextBox.getText();
            String sqlYearNum = agentYearTextBox.getText();
            String sqlStyleNum = agentStyleTextBox.getText();
            String sqlHeatNum = agentHeatTextBox.getText();
            String sqlRoofNum = agentRoofTextBox.getText();
            String sqlPriceNum = agentPriceTextBox.getText();
            String sqlSqft = agentsqftTextBox.getText();
            String sqlBeds = agentBedroomsTextBox.getText();
            String sqlBaths = agentBathroomsTextBox.getText();
            String sqlZip = agentZipTextBox.getText();
            String sqlStories = agentStoriesTextBox.getText();
            String sqlStatus = agentStatusTextBox.getText();
            String sqlSell = agentSellTextBox.getText();
            String sqlMarket = agentMarketTextBox.getText();
            String sqlLand = agentLandTextBox.getText();
            String url = "jdbc:mysql://localhost/realestate";
            String username = "root";
            String password = "cs304";
            
            System.out.println("Connecting database...");

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
               System.out.println("Database connected!");
               Statement stmt = conn.createStatement();
               int rset;
               String sql = "INSERT INTO property VALUES('" + sqlMLSNum + "', '" + sqlIDNum
               + "', '" + sqlAddressNum + "', '" + sqlCityNum + "', '" + sqlStateNum + "', '" + sqlZip +"', '" + sqlSqft +
               "', '" + sqlLotNum + "', '" + sqlYearNum + "', '" + sqlStories + "', '" + sqlStyleNum + "', '" + sqlBeds
                +"', '" + sqlBaths + "', '" + sqlHeatNum + "', '" + sqlRoofNum + "', '" + sqlPriceNum + "', '"
                + sqlStatus + "', '" + sqlSell + "', '" + sqlMarket + "', '" + sqlLand +"');";
               
               rset = stmt.executeUpdate(sql);
               System.out.println("propSqft"); 
           
            }
            catch (SQLException ex) {
               ex.printStackTrace();
            }
            
           // conn.close();
           }  
         
       });
       
       jbtDelete.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            
            String sqlMLSNum = agentMLSNumTextBox.getText();
            String sqlIDNum = agentIDTextBox.getText();
            String sqlAddressNum = agentAddressTextBox.getText();
            String sqlCityNum = agentCityTextBox.getText();
            String sqlStateNum = agentStateTextBox.getText();
            String sqlLotNum = agentLotTextBox.getText();
            String sqlYearNum = agentYearTextBox.getText();
            String sqlStyleNum = agentStyleTextBox.getText();
            String sqlHeatNum = agentHeatTextBox.getText();
            String sqlRoofNum = agentRoofTextBox.getText();
            String sqlPriceNum = agentPriceTextBox.getText();
            String sqlSqft = agentsqftTextBox.getText();
            String sqlBeds = agentBedroomsTextBox.getText();
            String sqlBaths = agentBathroomsTextBox.getText();
            String sqlZip = agentZipTextBox.getText();
            String sqlStories = agentStoriesTextBox.getText();
            String sqlStatus = agentStatusTextBox.getText();
            String sqlSell = agentSellTextBox.getText();
            String sqlMarket = agentMarketTextBox.getText();
            String sqlLand = agentLandTextBox.getText();
            String url = "jdbc:mysql://localhost/realestate";
            String username = "root";
            String password = "cs304";
            
            System.out.println("Connecting database...");

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
               System.out.println("Database connected!");
               Statement stmt = conn.createStatement();
               int rset;
               String sql = "DELETE FROM property WHERE MLSNum = '" + sqlMLSNum+"'";
               
               rset = stmt.executeUpdate(sql);
               System.out.println("propSqft"); 
              
            }
            catch (SQLException ex) {
               ex.printStackTrace();
            }
            
           // conn.close();
           }  
         
       });
       
        jbtUpdate.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            
            String sqlMLSNum = agentMLSNumTextBox.getText();
            String sqlIDNum = agentIDTextBox.getText();
            String sqlAddressNum = agentAddressTextBox.getText();
            String sqlCityNum = agentCityTextBox.getText();
            String sqlStateNum = agentStateTextBox.getText();
            String sqlLotNum = agentLotTextBox.getText();
            String sqlYearNum = agentYearTextBox.getText();
            String sqlStyleNum = agentStyleTextBox.getText();
            String sqlHeatNum = agentHeatTextBox.getText();
            String sqlRoofNum = agentRoofTextBox.getText();
            String sqlPriceNum = agentPriceTextBox.getText();
            String sqlSqft = agentsqftTextBox.getText();
            String sqlBeds = agentBedroomsTextBox.getText();
            String sqlBaths = agentBathroomsTextBox.getText();
            String sqlZip = agentZipTextBox.getText();
            String sqlStories = agentStoriesTextBox.getText();
            String sqlStatus = agentStatusTextBox.getText();
            String sqlSell = agentSellTextBox.getText();
            String sqlMarket = agentMarketTextBox.getText();
            String sqlLand = agentLandTextBox.getText();
            String url = "jdbc:mysql://localhost/realestate";
            String username = "root";
            String password = "cs304";
            
            System.out.println("Connecting database...");

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
               System.out.println("Database connected!");
               Statement stmt = conn.createStatement();
               int rset;
               String sql = "UPDATE property SET address = '" + sqlAddressNum + "', city = '" + sqlCityNum + "', state = '" + sqlStateNum + "', zip ='" + sqlZip +"', sqFeet = '" + sqlSqft +
               "', lotSize = '" + sqlLotNum + "', yearBuilt = '" + sqlYearNum + "', stories= '" + sqlStories + "', archStyle = '" + sqlStyleNum + "', bedrooms = '" + sqlBeds+
                "', baths = '" + sqlBaths + "', heatType = '" + sqlHeatNum + "', roofType = '" + sqlRoofNum + "', price = '" + sqlPriceNum + "', status = '"+
                 sqlStatus + "', sellDate = '" + sqlSell + "', marketDate = '" + sqlMarket + "', land = '" + sqlLand +"' WHERE MLSNum = '"+
                 sqlMLSNum + "' ;";
               
               rset = stmt.executeUpdate(sql);
               System.out.println("propSqft"); 
              
            }
            catch (SQLException ex) {
               ex.printStackTrace();
            }
            
           // conn.close();
           }  
         
       });

   } // end agent  

   public void buyer(){

      // Label(s) and Textfield(s)
      JPanel infoBuyer = new JPanel();
      infoBuyer.setLayout(new GridLayout(10,1));
      
      infoBuyer.add(buyersqftLabel);
      infoBuyer.add(buyersqftTextBox);
      infoBuyer.add(buyerBedroomsLabel);
      infoBuyer.add(buyerBedroomsTextBox);
      infoBuyer.add(buyerBathroomsLabel);
      infoBuyer.add(buyerBathroomsTextBox);
      infoBuyer.add(buyerZipLabel);
      infoBuyer.add(buyerZipTextBox);
      infoBuyer.add(buyerOutputLabel);
      infoBuyer.add(buyerOutputTextArea);
      
      // Button(s)
      JPanel buttons = new JPanel();
      JButton jbtSearch = new JButton("Search");
      JButton jbtClear = new JButton("Clear");

      buttons.add(jbtSearch);
      buttons.add(jbtClear);

      // Add Panel(s)
      Buyer.add(infoBuyer);
      Buyer.add(buttons);
      
      jbtSearch.addActionListener( new ActionListener(){
         public void actionPerformed(ActionEvent e){
            String sqlSqft = buyersqftTextBox.getText();
            String sqlBeds = buyerBedroomsTextBox.getText();
            String sqlBaths = buyerBathroomsTextBox.getText();
            String sqlZip = buyerZipTextBox.getText();
            String sqlStories = buyerStoriesTextBox.getText();
            String url = "jdbc:mysql://localhost/realestate";
            String username = "root";
            String password = "cs304";
            
            System.out.println("Connecting database...");

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
               System.out.println("Database connected!");
               Statement stmt = conn.createStatement();
               ResultSet rset;
               String sql = "SELECT * FROM property WHERE sqFeet = '" + sqlSqft + "' OR bedrooms = '" + sqlBeds
               + "' OR baths = '" + sqlBaths + "' OR zip = '" + sqlZip + "' OR stories = '" + sqlStories +"'"; 
               rset = stmt.executeQuery(sql);

               if (rset.next()) {            
                        
                  int propSqft = rset.getInt(7);
                  String sqft = String.valueOf(propSqft);
                  int propBeds = rset.getInt(12);
                  String beds = String.valueOf(propBeds);
                  double propBaths = rset.getDouble(13);
                  String baths = String.valueOf(propBaths);
                  int propZip = rset.getInt(6);
                  String zip = String.valueOf(propZip);
                  int propStories = rset.getInt(10);
                  String stories = String.valueOf(propStories);
                  String output = rset.getString(1) + " " + rset.getString(2)+ " " + rset.getString(3)+ " " + rset.getString(4)+ " "
                  + rset.getString(5) + " " + rset.getString(6) + " \n" + rset.getString(7) + " " + rset.getString(8)+ " " + rset.getString(9)
                  + " " + rset.getString(10) + " " + rset.getString(11) + " \n" + rset.getString(12)+ " " + rset.getString(13)+ " "
                   + rset.getString(14)+ " " + rset.getString(15);
                  System.out.println(output);



                  buyerBedroomsTextBox.setText(beds);
                  buyerBathroomsTextBox.setText(baths);
                  buyerZipTextBox.setText(zip);
                  buyersqftTextBox.setText(sqft);
                  buyerStoriesTextBox.setText(stories);
                  buyerOutputTextArea.setText(output);
               } else {
                  // Display result in a dialog box
                  System.out.println("NO");
                 }
            }
            catch (SQLException ex) {
               ex.printStackTrace();
            }
            
           // conn.close();
               
         }
      }); // end jbtSearch ActionListner

      jbtClear.addActionListener( new ActionListener(){
         public void actionPerformed(ActionEvent e){
            buyersqftTextBox.setText("");
            buyerBedroomsTextBox.setText("");
            buyerBathroomsTextBox.setText("");
            buyerZipTextBox.setText("");
            buyerOutputTextArea.setText("");
         }
      });
   } // end createBuyer

   public static void main(String[] args) throws SQLException, ClassNotFoundException {
   
		phase2Realtor frame = new phase2Realtor();   
      frame.setVisible(true);
	}// end main	 
}   


