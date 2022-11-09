public class Citizen 
{
    String Name;
    String IC;
    String State;
    int Age;
    String Category = null; //initially set value to null
    String Dosestatusone = null; //initially set value to null
    String Dosestatustwo = null; //initially set value to null
    String Certificate = null; //initially set value to null
    
    //Constructor with parameter
    public Citizen(String name, String ic, String state, int age, String category, String dosestatusone, String dosestatustwo, String certificate)
    {
        Name = name;
        IC = ic;
        State = state;
        Age = age;
        Category = category;
        Dosestatusone = dosestatusone;
        Dosestatustwo = dosestatustwo;
        Certificate = certificate;
    }

    //Setter @ Mutator methods
    public void setName(String name) 
    {
    Name = name;
    }
   
    public void setIC(String ic) 
    {
    IC = ic;
    }

    public void setState(String state) 
    {
    State = state;
    }

    public void setAge(int age) 
    {
    Age = age;
    }

    public void setCategory(String category) 
    {
    Category = category;
    }

    public void setDosestatusone(String dosestatusone) 
    {
    Dosestatusone = dosestatusone;
    }

    public void setDosestatustwo(String dosestatustwo) 
    {
    Dosestatustwo = dosestatustwo;
    }

    public void setCertificate(String certificate) 
    {
    Certificate = certificate;
    }


    //Getter @ Accessor methods
    public String getName() 
    {
    return Name;
    }

    public String getIC()
    {
    return IC;
    }

    public String getState() 
    {
    return State;
    }

    public int getAge() 
    {
    return Age;
    }

    public String getCategory() 
    {
    return Category;
    }   

    public String getDosestatusone() 
    {
    return Dosestatusone;
    }

    public String getDosestatustwo() 
    {
    return Dosestatustwo;
    }

    public String getCertificate() 
    {
    return Certificate;
    }

    //Display methods
    public String toString() 
    {   
    return (String.format("\t\t\t\t\t\t\t| %17s | %13s | %16s | %6s | %9s | %15s | %15s | %15s |\n", Name, IC, State, Age + "  ", Category, Dosestatusone + "     ", Dosestatustwo + "     ", Certificate + " "));
    }
}
