import java.util.*;

class Employee 
{
    public static int Counter;
    
    static
    {
        Counter = 0;
    }
    
    public int Eno;
    public String Ename;
    public int Eage;
    public String Eadd;
    public int Esal;
    
    public Employee(String b, int c, String d, int e)
    {
        Counter++;
        Eno = Counter;
        
        Ename = b;
        Eage = c;
        Eadd = d;
        Esal = e;
    }
    
    public void DisplayInformation ()
    {
        System.out.printf("%-5d %-10s %-5d %-10s %-5d\n",Eno,Ename,Eage,Eadd,Esal);
        
    }   
}

class MarvellousDBMS
{  
    public LinkedList<Employee> lobj;
    
    public MarvellousDBMS()
    {
        System.out.println("Marvellous DBMS Started");
        lobj = new LinkedList<Employee>();
    }
    
    public void ReassignIDs()
    {
        int i = 1;

        for(Employee eref : lobj)
        {
            eref.Eno = i;
            i++;
        }

        Employee.Counter = lobj.size();
    }
    
    public void InsertIntoTable(String name, int age, String add, int sal)
    {
        Employee eobj = new Employee(name,age,add,sal);
        lobj.addLast(eobj);               
    }
    
    public void SelectStar()
    {
        System.out.printf("%-5s %-10s %-5s %-10s%-5s\n","Eno","Name","Age","Address","Salary");
        System.out.println("------------------------------------------------");

        for(Employee eref : lobj)
        {
            eref.DisplayInformation();
        }
    }    
    
    public void SelectSpecific(int id)
    {
        for(Employee eref : lobj)
        {
            if(eref.Eno == id)
            {
                System.out.printf("%-5s %-10s %-5s %-10s %-5s","Eno","Name","Age","Addres","Salary");
                
                System.out.println("\n------------------------------------------------");
                
                eref.DisplayInformation();              
            }
        }
    }
    
    public void SelectSpecific(String str)
    {
        for(Employee eref : lobj)
        {
            if(eref.Ename.equals(str))
            {
                System.out.printf("%-5s %-10s %-5s %-10s %-5s","Eno","Name","Age","Address","Salary");
                
                System.out.println("\n------------------------------------------------");
                
                eref.DisplayInformation();              
            }
        }
    }
    
    public void DeleteData(int id)
    {
        boolean bRet = false;

        Iterator<Employee> iobj = lobj.iterator();

        while(iobj.hasNext())
        {
            Employee eref = iobj.next();

            if(eref.Eno == id)
            {
                iobj.remove();   
                bRet = true;
                break;
            }
        }

        if(bRet == false)
        {
            System.out.println("Unable to Remove Element As Element is not there Database");
        }
        else
        {
            ReassignIDs();
            System.out.println("Record deleted Successfully");
        }
    }
    
    public void DeleteData(String str)
    {
        boolean bRet = false;

        Iterator<Employee> iobj = lobj.iterator();

        while(iobj.hasNext())
        {
            Employee eref = iobj.next();

            if(eref.Ename.equals(str))
            {
                iobj.remove();   
                bRet = true;
                break;
            }
        }

        if(bRet == false)
        {
            System.out.println("Unable to Remove Element As Element is not there Database");
        }
        else
        {
            ReassignIDs();
            System.out.println("Record deleted Successfully");
        }
    }            
    
    public void UpdateName(int iNo, String str)
    {
        boolean bRet = false;
        
        for(Employee eref : lobj)
        {
            if(eref .Eno == iNo)
            {
                eref.Ename = str;
                bRet = true;
                break;
            }
        }
        
        if(bRet == true)
        {
            System.out.println("Name Update Successfully");
        }
        else
        {
            System.out.println("Record Not Found");
        }
    }
    
    public void AggregateCount()
    {
        System.out.println("Total Number Of Records "+lobj.size());
    }    
    
    public void AggregateSum()
    {
        int iSum = 0;
        
        for(Employee eref : lobj)
        {
            iSum = iSum + eref.Esal;
        }
        System.out.println("Total Salary Of All Employee  : "+iSum);
    }
    
    public void AggregateAvg()
    {
        int iSum = 0;
        double dno = 0.0;
        
        for(Employee eref : lobj)
        {
            iSum = iSum + eref.Esal;
        }
        
        dno = (double) iSum / lobj.size();
        
        System.out.println("Avarage Salary of Employees : "+dno);
    }
    
    public void AggregateMax()
    {
        if(lobj.size() == 0)
        {
            System.out.println("DataBase is Empty");
            return;
        }
        
        int imax = lobj.getFirst().Esal;
        
        for(Employee eref : lobj)
        {
            if(eref.Esal > imax)
            {
                imax = eref.Esal;
            }
        }
        System.out.println("Maximum Salary Of Employee : "+imax);    
    }
    
    public void AggregateMin()
    {
        if(lobj.size() == 0)
        {
            System.out.println("DataBase is Empty");
            return;
        }
        
        int imin = lobj.getFirst().Esal;
        
        for(Employee eref : lobj)
        {
            if(eref.Esal < imin)
            {
                imin = eref.Esal;
            }
        }
        System.out.println("Minimum Salary Of Employee : "+imin);    
    }
    
    public void UpdateRecord(int iNo, String Add)
    {
        boolean bRet = false;
        
        for(Employee eref : lobj)
        {
            if(eref.Eno == iNo)
            {
                eref.Eadd = Add;
                bRet = true;
                break;
            }
        }
        
        if(bRet == false)
        {
            System.out.println("Record Not Found");
        }
        
        else
        {
            System.out.println("Address Updated Successfully");
        }
    }    
}

class CDMS
{
    public static void main(String A[])
    {
        
        MarvellousDBMS mobj = new MarvellousDBMS();
        Scanner sobj = new Scanner(System.in);
        
        int option = 0;
        
        System.out.println("Welcome To Harsh DBMS");
                
        while(true)
        {
            System.out.println("----------------------------");
            System.out.println("1 : Insert Record");
            System.out.println("2 : Display All Record");
            System.out.println("3 : Select Record By Id");
            System.out.println("4: Select Record By Name");
            System.out.println("5: Delete Record By Id");
            System.out.println("6: Delete Record By Name");
            System.out.println("7 : Update Address");
            System.out.println("8 : Update Name");
             System.out.println("9 : Aggregate Count");
            System.out.println("10 : Aggregate Sum");
            System.out.println("11 : Aggregate Avg");
            System.out.println("12 : Aggregate Max");
            System.out.println("13 : Aggregate Min");
            System.out.println("14 : Exit");
            System.out.println("-----------------------------");
            
            System.out.println("Enter Your Choice : ");
            option =  sobj.nextInt();
            
            if(option == 1)
            {
                System.out.println("Enter Name : ");
                sobj.nextLine();              
                String name = sobj.nextLine();

                System.out.println("Enter Age : ");
                int age = sobj.nextInt();

                System.out.println("Enter Address : ");
                sobj.nextLine();              
                String add = sobj.nextLine();

                System.out.println("Enter Salary : ");
                int sal = sobj.nextInt();

                mobj.InsertIntoTable(name, age, add, sal);
                System.out.println("Record Insert Successfully");               
            }
            
            else if(option == 2)
            {
                mobj.SelectStar();
            }
            
            else if(option == 3)
            {
                System.out.println("Enter Employee ID : ");
                int id = sobj.nextInt();
                
                mobj.SelectSpecific(id);
            }
            
            else if(option == 4)
            {
                System.out.println("Enter Employee Name : ");
                sobj.nextLine();              
                String name = sobj.nextLine();
                
                mobj.SelectSpecific(name);
            }
            
            else if(option == 5)
            {
                System.out.println("Enter Employee ID : ");
                int id = sobj.nextInt();
                
                mobj.DeleteData(id);                
            }
            
            else if(option == 6)
            {
                System.out.println("Enter Employee Name : ");
                sobj.nextLine();
                String name = sobj.nextLine();
                
                mobj.DeleteData(name);
            }
            
            else if(option == 7)
            {
                System.out.println("Enter Employee ID : ");
                int id = sobj.nextInt();
                
                System.out.println("Enter New Address : ");
                sobj.nextLine();              
                String add = sobj.nextLine();
                
                mobj.UpdateRecord(id, add);
            }
            
            else if(option == 8)
            {
                System.out.println("Enter Employee ID : ");
                int id = sobj.nextInt();
                
                System.out.println("Enter New Name : ");
                sobj.nextLine();
                String Name = sobj.nextLine();
                
                mobj.UpdateName(id, Name);
            }
            
            else if(option == 9)
            {
                mobj.AggregateCount();
            }
            
            else if(option == 10)
            {
                mobj.AggregateSum();
            }
            
            else if(option == 11)
            {
                mobj.AggregateAvg();
            }
            
            else if(option == 12)
            {
                mobj.AggregateMax();
            }
            
            else if(option == 13)
            {
                mobj.AggregateMin();
            }
            
            else if(option == 14)
            {
                System.out.println("Thank You For Using Harsh DBMS");
                break;
            }
            
            else
            {
                System.out.println("Invalid Choice");
            }
        }                       
    }
}
