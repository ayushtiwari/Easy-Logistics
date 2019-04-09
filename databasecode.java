//emmployeelogin
 try {
                //Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
                Statement st = conn.createStatement();
                st.execute("SELECT * FROM employee");
                ResultSet results = st.getResultSet();
                a = employeeUserName.equals(results.getString(4)) && employeePassWord.equals(results.getString(5));
                detailsCorrect = a && employeeBranch.equals(Integer.toString(results.getInt(3)));
                st.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }



//new truck
 try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM office");
            ResultSet results = st.getResultSet();
            while (results.next()) {
                int branchid = results.getInt(1);
                branch.getItems().add(Integer.toString(branchid));
                st.close();
                conn.close();


            }
        } catch (SQLException s) {
            System.out.println("Error accessing Database" + s.getMessage());
        }





 try {
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
                Statement st = conn.createStatement();
                st.execute("INSERT INTO truck(truck_id,max_capacity,curr_office_id)VALUES ('" + truckId.getText() + "','" + capacity.getText() + "','" + branch.getValue() + "')");
                st.execute("SELECT * FROM office");
                ResultSet results = st.getResultSet();
                while (results.next()) {
                    if (results.getInt(1) == Integer.parseInt(branch.getValue()))
                        trucklist = results.getString(5) + truckId.getText() + ",";
                    int officeIdValue = Integer.parseInt(branch.getValue());
                    st.execute("UPDATE office SET truck_list=('" + trucklist + "')WHERE office_id=('" + officeIdValue + "')");
                }
            } catch (SQLException e) {
                System.out.println("Something went wrong" + e.getMessage());
            }





//new consignment
 int truckid=12;
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
            Statement st = conn.createStatement();
            st.execute("INSERT INTO consignment('"+consignment.getText()+"','"+volume.getText()+"','"+senderName
        .getText()+"','"+senderStreetName.getText()+"','"+senderCity.getText()+"','"+receiverName
        .getText()+"','"+receiverStreetName.getText()+"','"+receiverCity+"','NOT DISPATCHED','NOT DELIVERED','NULL','NULL','NULL','"+currentOfficeId.getText()+"','"+nextOffice.getText()+"','"+truckid+"')");
        st.close();
        conn.close();
        }catch(SQLException e){
            System.out.println("Something went wrong" + e.getMessage());
        }






//new Branch

try {

               // Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
               Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
               Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
               //Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");

               Statement st = conn.createStatement();
               st.execute("INSERT INTO office VALUES ('" + branchid + "','*','" + streetname + "','" + cityname + "','*','*','*','*')");
              // st.execute("INSERT INTO office VALUES (1,'NULL','ehfuef','oiivn','NULL','NULL')");
               st.close();
               conn.close();
               System.out.println("AlpahBeta");


           }catch(SQLException e)
           {
               System.out.println("Something went wrong: " + e.getMessage());
           }





//new Employee 
try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM office");
            ResultSet results = st.getResultSet();
            while (results.next()) {
                int branchid = results.getInt(1);

                branch.getItems().add(Integer.toString(branchid));
            }
        } catch (SQLException s) {
            System.out.println("Error accessing Database" + s.getMessage());
        }



 try {
                //Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
                Statement st = conn.createStatement();
                st.execute("INSERT INTO  employee VALUES('" + employeeId.getText() + "','" + name.getText() + "','" + branch.getValue() + "','" + userName.getText() + "','" + password.getText() + "')");
                st.execute("SELECT * FROM office");
                ResultSet results = st.getResultSet();
                while (results.next()) {
                    if (results.getInt(1) == Integer.parseInt(branch.getValue()))
                        employeelist = results.getString(2) + employeeId.getText() + ",";
                    // System.out.println(employeelist);
                    int officeIdValue = Integer.parseInt(branch.getValue());
                    //st.execute("INSERT INTO office(employee_list)VALUE('"+employeelist+"') WHERE office_id=Integer.parseInt(branch.getValue())");
                    st.execute("UPDATE office SET employee_list=('" + employeelist + "') WHERE office_id=('" + officeIdValue + "')");
                }
            } catch (SQLException e) {
                System.out.println("Something went wrong" + e.getMessage());
            }


///new2


 try{
          Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
          Statement st=conn.createStatement();
          st.execute("SELECT * FROM office");
          ResultSet results=st.getResultSet();
          while(results.next())
          {
              if(results.getInt(1)==branchid)
              {
                  trucklist=results.getString(5);
                  
                  
              }
          }
           results.close();
           st.close();
          conn.close();
          st.execute("SELECT * FROM truck");
          ResultSet results1=st.getResultSet();
          while(results1.next())
          {
               if(results1.getString(1) belong to trucklist and results1.getString(4)>0)
               {
                    newtrucklist=results1.getString(1);    
                
               }
          }
          
          
   
          
         
      }catch(SQLException e)
      {
          System.out.println("Something went wrong"+e.getMessage());
      }


//new1

 Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TrasportCompany/database1.db");
    Statement st=conn.createStatement();
    st.execute("SELECT * FROM employee");
    ResultSet results = st.getResultSet();
    while(results.next()){
        if(results.getString(4)==username)
            {
                results.getString(1);
            }
        
            }

//latest
 try{
           Connection conn=DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TrasportCompany/database1.db");
           Statement st=conn.createStatement();
           st.execute("SELECT * FROM office");
           ResultSet results=st.getResultSet();
           while(results.next()){
           System.out.println(results.getString(3));//street name
           System.out.println(results.getString(4));//city name
           System.out.println(results.getString(2));//employeelist
           for(i=0;i<strlen(employeelist);i++)
        {
        if(employeelist[i]=",")count++;
        System.out.println(count)//no of employees

        }
        }
        }catch(SQLException e){
         System.out.println("something went wrong");
        }



//latest 1
try{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TrasportCompany/database1.db");
        Statement st=conn.createStatement;
        st.execute("SELECT * FROM office");
        ResultSet results = st.getResultSet();
 while(results.next()){
  if(branchid==results.getString(1))
        consignmentlist=results.getString(6);
 }
        st.execute("SELECT * FROM consignment");
        ResultSet results1=st.getResultSet();
        while(results1.next()){
            if(results1.getInt(1) belongs to consignmentlist){
                System.out.println(results1.getInt(1));  //consignemntidd
        System.out.println(results1.getText(3));  //sendername
        System.out.println(results1.getText(9));  //dispatch status
        System.out.println(results1.getText(10));  //deliverystatus
        System.out.println(results1.getText(14));//sendingofficeid
        System.out.println(results1.getText(15)); //receivingofficeid
        System.out.println(results1,getText(5));//seder city
        System.out.println(results1.getText(8);//receiver city

        }
        }


        }catch(SQLException e){
        System.out.println("Something went wrong: " + e.getMessage());  
        }
