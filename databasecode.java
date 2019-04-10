////emmployeelogin
// try {
//                //Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
//                Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
//                Statement st = conn.createStatement();
//                st.execute("SELECT * FROM employee");
//                ResultSet results = st.getResultSet();
//                a = employeeUserName.equals(results.getString(4)) && employeePassWord.equals(results.getString(5));
//                detailsCorrect = a && employeeBranch.equals(Integer.toString(results.getInt(3)));
//                st.close();
//                conn.close();
//            } catch (SQLException e) {
//                System.out.println("Something went wrong: " + e.getMessage());
//            }
//
//
//
////new truck
// try {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
//            Statement st = conn.createStatement();
//            st.execute("SELECT * FROM office");
//            ResultSet results = st.getResultSet();
//            while (results.next()) {
//                int branchid = results.getInt(1);
//                branch.getItems().add(Integer.toString(branchid));
//                st.close();
//                conn.close();
//
//
//            }
//        } catch (SQLException s) {
//            System.out.println("Error accessing Database" + s.getMessage());
//        }
//
//
//
//
//
// try {
//                Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
//                Statement st = conn.createStatement();
//                st.execute("INSERT INTO truck(truck_id,max_capacity,curr_office_id)VALUES ('" + truckId.getText() + "','" + capacity.getText() + "','" + branch.getValue() + "')");
//                st.execute("SELECT * FROM office");
//                ResultSet results = st.getResultSet();
//                while (results.next()) {
//                    if (results.getInt(1) == Integer.parseInt(branch.getValue()))
//                        trucklist = results.getString(5) + truckId.getText() + ",";
//                    int officeIdValue = Integer.parseInt(branch.getValue());
//                    st.execute("UPDATE office SET truck_list=('" + trucklist + "')WHERE office_id=('" + officeIdValue + "')");
//                }
//            } catch (SQLException e) {
//                System.out.println("Something went wrong" + e.getMessage());
//            }
//
//
//
//
//
////new consignment
//
//
//
//
//
//
//
////new Branch
//
//try {
//
//               Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
//
//               Statement st = conn.createStatement();
//               st.execute("INSERT INTO office VALUES ('" + branchid + "','*','" + streetname + "','" + cityname + "','*','*','*','*')");
//              // st.execute("INSERT INTO office VALUES (1,'NULL','ehfuef','oiivn','NULL','NULL')");
//               st.close();
//               conn.close();
//               System.out.println("AlpahBeta");
//
//
//           }catch(SQLException e)
//           {
//               System.out.println("Something went wrong: " + e.getMessage());
//           }
//
//
//
//
//
////new Employee
//try {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
//            Statement st = conn.createStatement();
//            st.execute("SELECT * FROM office");
//            ResultSet results = st.getResultSet();
//            while (results.next()) {
//                int branchid = results.getInt(1);
//
//                branch.getItems().add(Integer.toString(branchid));
//            }
//        } catch (SQLException s) {
//            System.out.println("Error accessing Database" + s.getMessage());
//        }
//
//
//
// try {
//                //Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/database1.db");
//                Connection conn = DriverManager.getConnection("jdbc:sqlite:C://Users//Nikhil//Desktop//TransportCompany//database1.db");
//                Statement st = conn.createStatement();
//                st.execute("INSERT INTO  employee VALUES('" + employeeId.getText() + "','" + name.getText() + "','" + branch.getValue() + "','" + userName.getText() + "','" + password.getText() + "')");
//                st.execute("SELECT * FROM office");
//                ResultSet results = st.getResultSet();
//                while (results.next()) {
//                    if (results.getInt(1) == Integer.parseInt(branch.getValue()))
//                        employeelist = results.getString(2) + employeeId.getText() + ",";
//                    // System.out.println(employeelist);
//                    int officeIdValue = Integer.parseInt(branch.getValue());
//                    //st.execute("INSERT INTO office(employee_list)VALUE('"+employeelist+"') WHERE office_id=Integer.parseInt(branch.getValue())");
//                    st.execute("UPDATE office SET employee_list=('" + employeelist + "') WHERE office_id=('" + officeIdValue + "')");
//                }
//            } catch (SQLException e) {
//                System.out.println("Something went wrong" + e.getMessage());
//            }
//
//
//
//
//
//
//









// all trucks


    try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite://Users//Nikhil//Desktop//TransportCompany//database1-2.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM truck");
            ResultSet results = st.getResultSet();
            while (results.next()) {
                System.out.println(results.getInt(1)); //truckid
                System.out.println(results.getInt(3)); //dispatching branchid
                System.out.println(results.getInt(10)); //destination branch
                System.out.println(results.getInt(11)); //curr_occupamcy
                System.out.println(results.getInt(4)); //max_capacity
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }




//consignment
try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite://Users//Nikhil//Desktop//TransportCompany//database1-2.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM consignment");
            ResultSet results = st.getResultSet();
            while (results.next()) {
                System.out.println(results.getInt(1));//consignment_id
                System.out.println(results.getInt(2));//volume
                System.out.println(results.getString(3));//senders name
                System.out.println(results.getInt(11));//arrival time
                System.out.println(results.getInt(12));//departure time
                System.out.println(results.getInt(14));//sending officeid
                System.out.println(results.getInt(15));//recieving officeid

            }
        }catch(SQLException e){
            System.out.println("something went wrong");
        }




// latest
 try{
         Connection conn = DriverManager.getConnection("jdbc:sqlite://Users//Nikhil//Desktop//TransportCompany//database1-2.db");
         Statement st = conn.createStatement();
         st.execute("SELECT * FROM office");
         ResultSet results = st.getResultSet();
         while(results.next()){
             if(branchid==results.getInt(1)){
                 consignementlist=results.getString(6);
             }
         }
     }catch(SQLException e){
         System.out.println("something went wrong");
     }




//complete consignement details
try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite://Users//Nikhil//Desktop//TransportCompany//database1-2.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM consignment");
            ResultSet results = st.getResultSet();
            while (results.next()) {
                System.out.println(results.getInt(1));//consignment_id
                System.out.println(results.getInt(2));//volume
                System.out.println(results.getString(3));//senders name
                System.out.println(results.getString(4));//sender adrress street
                System.out.println(results.getString(5));//sender address city
                System.out.println(results.getString(6));//reciever name
                System.out.println(results.getString(7));//receiver address street
                System.out.println(results.getString(8));//receiver address city
                System.out.println(results.getString(9));//dispatch status
                System.out.println(results.getString(10));//delivery status
                System.out.println(results.getString(11));//arrival time
                System.out.println(results.getString(12));//departure time
                System.out.println(results.getString(13));//delivery time
                System.out.println(results.getInt(14));//sending officeid
                System.out.println(results.getInt(15));//recieving officeid
                System.out.println(results.getString(16));//truck_id

            }
        }catch(SQLException e){
            System.out.println("something went wrong");
        }



//latest 4  
try{
       Connection conn = DriverManager.getConnection("jdbc:sqlite://Users//Nikhil//Desktop//TransportCompany//database1-2.db");
       Statement st = conn.createStatement();
       st.execute("SELECT * FROM manager");
       ResultSet results = st.getResultSet();
       managername=results.getString(1);//managername
   }catch(SQLException e){
       System.out.println("something went wrong");
   }


//


   try{
       Connection conn = DriverManager.getConnection("jdbc:sqlite://Users//Nikhil//Desktop//TransportCompany//database1-2.db");
       Statement st = conn.createStatement();
       st.execute("SELECT * FROM employee");
       ResultSet results = st.getResultSet();
       while(results.next()){
           if(employeeid==results.getInt(1))employeename=results.getString(2);
       }
   }catch(SQLException e){
       System.out.println("something went wrong");
   }
//from truck id


 try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite://Users//Nikhil//Desktop//TransportCompany//database1-2.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM truck");
            ResultSet results = st.getResultSet();
            while (results.next()) {
                if (results.getInt(1) == truckid) {
                    System.out.println(results.getInt(4));//max capacity
                    System.out.println(results.getInt(11));//curroccupancy
                    System.out.println(results.getInt(10));//next officeid
                }
            }
        }catch(SQLException e){
            System.out.println("something went wrong");
        }

//trucks from branchid
  try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite://Users//Nikhil//Desktop//TransportCompany//database1-2.db");
            Statement st = conn.createStatement();
            st.execute("SELECT * FROM office");
            ResultSet results = st.getResultSet();
            while (results.next()) {
                if (results.getInt(1) == branchid) {
                    trucklist = results.getString(5);
                }
            }
        }catch(SQLException e){
            System.out.println("something went wrong");
        }

