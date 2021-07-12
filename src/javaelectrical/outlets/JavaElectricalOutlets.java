
package javaelectrical.outlets;

import java.util.InputMismatchException;
import java.util.Scanner;


public class JavaElectricalOutlets {

    // https://open.kattis.com/problems/electricaloutlets
    // simple java program
    
    public static void main(String[] args) {
        
        
        Scanner input =new Scanner(System.in);
        
        
        int testCases=EnterInteger(input);
        
        int[][] myInputs= new int[testCases][];
        
        
        for (int i = 0; i < myInputs.length; i++) {
            myInputs[i]=GetLineIntegers(input);
        }
        
        int[] results=GetMaximumNumberOfAppliancesArray(myInputs);
        
        PrintIntArray(results);
        
        
    }// end main()
    
    private static int[] GetMaximumNumberOfAppliancesArray(int[][] inputs)
    {
        int[] ans =new int[inputs.length];
        
        for (int i = 0; i < inputs.length; i++) {
            ans[i]=GetMaximumNumberOfAppliances(inputs[i]);
        }
        return ans;
    }
    
    private static int GetMaximumNumberOfAppliances(int[] array)
    {
        int res=0;
        for (int i = 1; i < array.length-1; i++) {
            res=res+(array[i]-1);
        }
        res=res+array[array.length-1];
        return res;
    }
    
    private static int[] GetLineIntegers(Scanner in)
    {
        try{
        String s=GetLineString(in);
        String[] a=ConvertString2StringArray(s);
        int[] b=ConverStringArray2IntegerArrray(a);
        
        if (!CheckArrayLevel1(b) || !CheckArrayLevel2(b)) 
            throw new InputMismatchException("Non-valid integers line");
        return b;
        }catch(Exception e)
        {
            //System.out.println(e.toString());
            return GetLineIntegers(in);
        }
    }
    
    private static int[] ConverStringArray2IntegerArrray(String[] array)
    {
        int[] res=new   int[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i]=Integer.parseInt(array[i]);
        }
        return res;
    }
    
    private static String[] ConvertString2StringArray(String str)
    {
        String[] a= str.split(" ");
        return a;
    }
    
    private static String GetLineString(Scanner in)
    {
        String str=in.nextLine();
        return str;
    }
    
    private static boolean CheckArrayLevel1(int[] array)
    {
        if (array==null || array.length<=1) 
            return false;
        
        int number1=array[0];
        int number2=array.length-1;
        if(number1!=number2)
            return false;
        
        else return true;
    }
    
    private static boolean CheckArrayLevel2(int[] array)
    {
        int first=array[0];
        if(first<1 ||first>10)
            return false;
        
        for (int i = 1; i < array.length; i++) {
            if(array[i]<2|| array[i]>10)
                return false;
        }
        return true;
    }
    
    private static int EnterInteger(Scanner in)
    {
        int res=0;
        try{
            res=in.nextInt();
            if(res<1 || res>20)
                throw new InputMismatchException();
            in.nextLine();
            return res;
        }
        catch(Exception e)
        {
            in.nextLine();
            System.out.println(e.toString());
            return EnterInteger(in);
        }
    }  
    private static void PrintIntArray(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
}
