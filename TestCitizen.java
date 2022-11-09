import java.util.*;
import java.io.*;
import javax.swing.*;

//Class name
public class TestCitizen
{
    //Driver code
    public static void main(String[] args)
    {
        //Create reader
        try (BufferedReader reader = new BufferedReader(new FileReader("vaccinerecipients.txt"))) {
        
        //Create linkedlist object
        LinkedList <Citizen> citizenList = new LinkedList<>();
        LinkedList <Citizen> completedList = new LinkedList<>();

        //Create stack object
        Stack <Citizen> stCenter1 = new Stack<>();
        Stack <Citizen> stCenter2 = new Stack<>();
        Stack <Citizen> stCenter3 = new Stack<>();
        Stack <Citizen> temp1 = new Stack<>();
        Stack <Citizen> temp2 = new Stack<>();
        Stack <Citizen> temp3 = new Stack<>();

        //Create queue object
        Queue <Citizen> qCenter1 = new LinkedList<>();
        Queue <Citizen> qCenter2 = new LinkedList<>();
        Queue <Citizen> qCenter3 = new LinkedList<>();

        //Declare object name
        Citizen cVac;
        String indate = null;

        //Read data from file 
        while(( indate = reader.readLine()) != null ) {

            StringTokenizer st = new StringTokenizer(indate, ";");
            String name = st.nextToken();
            String ic = st.nextToken();
            String state = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            String category = st.nextToken();
            String dosestatusone = st.nextToken();
            String dosestatustwo = st.nextToken();
            String certificate = st.nextToken();

            //Create object
            cVac = new Citizen(name, ic, state, age, category, dosestatusone, dosestatustwo, certificate);

            //Add data into linkedlist
            citizenList.add(cVac);

    }

    //Close reader
    reader.close();

        //Find citizenList size
        while(!citizenList.isEmpty()) {

            cVac = citizenList.remove();

        if(cVac.getAge() >= 18 && cVac.getAge() <= 30) {

            //Store object into stack
            stCenter1.push(cVac);

        }

        if(cVac.getAge() >= 31 && cVac.getAge() <= 49) {

            //Store object into stack
            stCenter2.push(cVac);

        }

        if(cVac.getAge() >= 50) {

            //Store object into stack
            stCenter3.push(cVac);

        }
    }

    //Declare menu 
   int menu = 0;

   //Do while statement
    do {

        //Instructions
        menu = Integer.parseInt(JOptionPane.showInputDialog("1 - Add new recipients\n2 - Delete existing recipients\n3 - Demostrate vaccination proccess for 1st dose\n4 - Demostrate vaccination proccess for 2nd dose\n5 - Exit menu "));

        //Add new recipients data
        if ( menu == 1) {

            String name = JOptionPane.showInputDialog("Enter recipients name: ");
            String ic = JOptionPane.showInputDialog("Enter recipients ic: ");
            String state = JOptionPane.showInputDialog("Enter recipients state: ");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter recipients age: "));
            String category = JOptionPane.showInputDialog("Enter recipients category: ");
            String dosestatusone = "null";
            String dosestatustwo = "null";
            String certificate = "null";

            //Create object
            cVac = new Citizen(name, ic, state, age, category, dosestatusone, dosestatustwo, certificate);

            if(cVac.getAge() >= 18 && cVac.getAge() <= 30) {
                
                //Store object into stack
                stCenter1.push(cVac);
            }
            if(cVac.getAge() >= 31 && cVac.getAge() <= 49) {

                //Store object into stack
                stCenter2.push(cVac);
            }
            if(cVac.getAge() >= 50) {

                //Store object into stack
                stCenter3.push(cVac);
            }

           
    }

        //Delete existing recipients data
        else if (menu == 2)  {
            
            //Ask user to enter recipients ic number
            String IC = JOptionPane.showInputDialog( "Enter reciepents ic number: ");
            
            //Find size of recipients
            for(int i = 0; i < stCenter1.size(); i++) {

                //Retrieve object from stack
                cVac = stCenter1.get(i);

                //Find reciepents based on ic number
                if(cVac.getIC().equalsIgnoreCase(IC)) {

                    //Remove reciepents data from stack
                    stCenter1.remove(cVac);

                    }
                }
            
            //Find size of reciepents
            for(int i = 0; i < stCenter2.size(); i++) {
                
                //Retrieve object from stack
                cVac = stCenter2.get(i);

                //Find reciepents based on ic number
                if(cVac.getIC().equalsIgnoreCase(IC)) {
                    
                    //Remove reciepents data from stack
                    stCenter2.remove(cVac);

                    }
                }

            //Find size of reciepents
            for(int i = 0; i < stCenter3.size(); i++) {

                //Retrieve object from stack
                cVac = stCenter2.get(i);

                //Find reciepents based on ic number
                if(cVac.getIC().equalsIgnoreCase(IC)) {

                    //Remove reciepents data from stack
                    stCenter3.remove(cVac);

                    }
                }

    
        }

        //Demostrate vaccination process for first dose
        else if (menu == 3) 
        {
            //Create submenu in menu 3
            int submenu = 0;

            //do while statement
            do {

                //Instructions
                submenu = Integer.parseInt(JOptionPane.showInputDialog("1 - Proceed vaccination process for 1st dose\n2 - Display 1st dose reciepents\n3 - Return main menu"));

                //Add reciepents data into temporary stack
                if(submenu == 1) {
                    
                    //if stCenter1 not empty
                    while(!stCenter1.isEmpty()) {

                        //Retrieve object from stack stCenter1
                        cVac = stCenter1.pop();
                        
                        //Find dose status one based on reciepients data input
                        if(cVac.getDosestatusone().equalsIgnoreCase("null")) {
                            
                            //Set new value for dose status one
                            cVac.setDosestatusone("YES");

                            //Add reciepents data into temporary stack
                            temp1.push(cVac);
                        }
                    }
                    
                    //if stCenter2 not empty
                    while(!stCenter2.isEmpty()) {
                        
                        //Retrieve object from stack stCenter2
                        cVac = stCenter2.pop();
                        
                        //Find dose status one based on reciepients data input
                        if(cVac.getDosestatusone().equalsIgnoreCase("null")) {
                            
                            //Set new value for dose status one
                            cVac.setDosestatusone("YES");

                            //Add reciepents data into temporary stack
                            temp2.push(cVac);
                        }
                    }
                    
                    //if stCenter3 not empty
                    while(!stCenter3.isEmpty()) {
                        
                        //Retrieve object from stack stCenter3
                        cVac = stCenter3.pop();
                        
                        //Find dose status one based on reciepients data input
                        if(cVac.getDosestatusone().equalsIgnoreCase("null")) {
                            
                            //Set new value for dose status one
                            cVac.setDosestatusone("YES");

                            //Add reciepents data into temporary stack
                            temp3.push(cVac);
                        }
                    }

                    System.out.print("\n\t\t\t\t\t\t\tProcessing...\n\n");

                }
                
                //Display first dose complete 
                else if (submenu == 2) {

                    System.out.print("\t\t\t\t\t\t\t1ST DOSE COMPLETE :\n\n\n");
                    
                    System.out.print("\t\t\t\t\t\t\tReceipients age 18 until age 30 :\n");

                    //Display format table
                    System.out.print("\t\t\t\t\t\t\t____________________________________________________________________________________________________________________________________\n");
                    System.out.format("\t\t\t\t\t\t\t| %17s | %14s | %16s | %6s | %9s | %15s | %15s | %15s |\n" , "NAME     ", "IC      ", "STATE     ", "AGE ", "CATEGORY", "FIRST DOSE  ", "SECOND DOSE  ", "CERTIFICATE  ");
                    System.out.print("\t\t\t\t\t\t\t|-------------------|----------------|------------------|--------|-----------|-----------------|-----------------|-----------------|\n");

                    //if temp1 not empty
                    while(!temp1.isEmpty()) {
                    
                        //Display reciepents data in temporary stack
                        System.out.print(temp1.peek().toString());
                        System.out.print("\t\t\t\t\t\t\t|-------------------|----------------|------------------|--------|-----------|-----------------|-----------------|-----------------|\n");
                        //Retrieve reciepients data from temporary stack
                        cVac = temp1.pop();    
                        //Add reciepients data to temporary stack             
                        qCenter1.add(cVac);
                    }
                    System.out.print("\n");
                    
                    System.out.print("\t\t\t\t\t\t\tReceipients age 31 until age 49 :\n");

                    //Display format table
                    System.out.print("\t\t\t\t\t\t\t____________________________________________________________________________________________________________________________________\n");
                    System.out.format("\t\t\t\t\t\t\t| %17s | %14s | %16s | %6s | %9s | %15s | %15s | %15s |\n" , "NAME     ", "IC      ", "STATE     ", "AGE ", "CATEGORY", "FIRST DOSE  ", "SECOND DOSE  ", "CERTIFICATE  ");
                    System.out.print("\t\t\t\t\t\t\t|-------------------|----------------|------------------|--------|-----------|-----------------|-----------------|-----------------|\n");

                    //if temp2 not empty
                    while(!temp2.isEmpty()) {

                        //Display reciepents data in temporary stack 
                        System.out.print(temp2.peek().toString());
                        System.out.print("\t\t\t\t\t\t\t|-------------------|----------------|------------------|--------|-----------|-----------------|-----------------|-----------------|\n");
                        //Retrieve reciepients data from temporary stack
                        cVac = temp2.pop();
                        //Add reciepients data to temporary stack
                        qCenter2.add(cVac);
                    }
                    System.out.print("\n");
                    
                    System.out.print("\t\t\t\t\t\t\tReceipients age 50 and more :\n");

                    //Display format table
                    System.out.print("\t\t\t\t\t\t\t____________________________________________________________________________________________________________________________________\n");
                    System.out.format("\t\t\t\t\t\t\t| %17s | %14s | %16s | %6s | %9s | %15s | %15s | %15s |\n" , "NAME     ", "IC      ", "STATE     ", "AGE ", "CATEGORY", "FIRST DOSE  ", "SECOND DOSE  ", "CERTIFICATE  ");
                    System.out.print("\t\t\t\t\t\t\t|-------------------|----------------|------------------|--------|-----------|-----------------|-----------------|-----------------|\n");

                    //if temp2 not empty
                    while(!temp3.isEmpty()) {
                        
                        //Display reciepents data in temporary stack
                        System.out.print(temp3.peek().toString());
                        System.out.print("\t\t\t\t\t\t\t|-------------------|----------------|------------------|--------|-----------|-----------------|-----------------|-----------------|\n");
                        //Retrieve reciepients data from temporary stack
                        cVac = temp3.pop();
                        //Add reciepients data to temporary stack
                        qCenter3.add(cVac);
                    }
                
                }
            
            //Close submenu in menu 3
            } while(submenu != 3);
        
        }
        
        //Demostrate vaccination process for second dose
        else if (menu == 4)
        {
            //Create submenu in menu 4
            int submenu = 0;

            //do while statement
            do{

                //Instructions
                submenu = Integer.parseInt(JOptionPane.showInputDialog("1 - Proceed vaccination process for 2nd dose\n2 - Display 2nd dose reciepents\n3 - Return main menu"));

                //Add reciepents data into completedList and set value for second dose
                if(submenu == 1) {
                
                //if qCenter1 not empty
                while(!qCenter1.isEmpty()) {
                    
                    //Retrieve input data from qCenter1
                    cVac = qCenter1.remove();

                    //Find dose status two based on reciepients data
                    if(cVac.getDosestatustwo().equalsIgnoreCase("null")) {
                       
                        //Set new value for dose status two
                        cVac.setDosestatustwo("YES");

                        //Set new value for certificate
                        cVac.setCertificate("COMPLETED");

                        //Add recipients data into completedList
                        completedList.add(cVac);
                    }
                }
                
                //if stCenter2 not empty
                while(!qCenter2.isEmpty()) {
                
                    //Retrieve input data from qCenter2
                    cVac = qCenter2.remove();

                    //Find dose status two based on reciepients data
                    if(cVac.getDosestatustwo().equalsIgnoreCase("null")) {
                    
                        //Set new value for dose status two
                        cVac.setDosestatustwo("YES");    
                        
                        //Set new value for certificate
                        cVac.setCertificate("COMPLETED");     
                        
                        //Add reciepients data into completedList
                        completedList.add(cVac);
                    }
                }

                //if stCenter3 not empty
                while(!qCenter3.isEmpty()) {
                
                    //Retrieve input data from qCenter3
                    cVac = qCenter3.remove();        
                    
                    //Find dose status two based on reciepients data
                    if(cVac.getDosestatustwo().equalsIgnoreCase("null")) {
                     
                        //Set new value for dose status two
                        cVac.setDosestatustwo("YES");       
                        
                        //Set new value for certificate
                        cVac.setCertificate("COMPLETED");    
                        
                        //Add reciepients data into completedList
                        completedList.add(cVac);
                
                    }          
                }
                System.out.print("\n\t\t\t\t\t\t\tProcessing...\n\n");
            }

            //Display completed dose
            else if (submenu == 2) {
                
                System.out.print("\t\t\t\t\t\t\tCompleted dose recipient: \n");

                //Display format table
                System.out.print("\t\t\t\t\t\t\t____________________________________________________________________________________________________________________________________\n");
                System.out.format("\t\t\t\t\t\t\t| %17s | %14s | %16s | %6s | %9s | %15s | %15s | %15s |\n" , "NAME     ", "IC      ", "STATE     ", "AGE ", "CATEGORY", "FIRST DOSE  ", "SECOND DOSE  ", "CERTIFICATE  ");
                System.out.print("\t\t\t\t\t\t\t|-------------------|----------------|------------------|--------|-----------|-----------------|-----------------|-----------------|\n");
                
                //Find completedList size
                for(int i = 0; i < completedList.size(); i++) {
                
                    //Retrieve input data from completedList
                    cVac = completedList.get(i);
                    
                    //Display reciepients data for completed dose
                    System.out.print(cVac.toString());
                    System.out.print("\t\t\t\t\t\t\t|-------------------|----------------|------------------|--------|-----------|-----------------|-----------------|-----------------|\n");
                }
            }
        
        //Close submenu in menu 4
        }while(submenu != 3);
    
    }

//Close menu
} while (menu != 5);

//To define a block of code to be executed
}
catch(FileNotFoundException fnf) {
    System.out.println("File not found");
}
catch(EOFException eof) {
    System.out.println("End of file error");
}
catch(IOException io) {
    System.out.println("wrong input!!!");
}
finally {
    System.out.println("\n\nSystem end here.Bye!");
    }

}
}
