///////////////////////////////////////////////////////////////////////////////////////////////////////////Date: 10/13/2020
//Author: Nicholas LeBlanc
//Purpose: Find the amount of change owed and in what denomination for any given purchase
/////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.lang.reflect.Array;
 
class Main {
 public static void main(String[] args) {
  
   Scanner scan = new Scanner(System.in);
   System.out.println("What is the cost of the item?");
  
   double cost;
   cost = scan.nextDouble(); //copies input value to variable cost

   System.out.println("How much money was given?");

   double pay;
   pay = scan.nextDouble(); //copies input value to variable cost
 
   int CostCents = (int)(cost * 100); //converts cost in dollars to cost in cents
   cost = (double)(CostCents / 100.00); //insures cost only goes to the hundreds place

   int PayCents = (int)(pay * 100);
   pay = (double)(PayCents / 100.00);
  
   int change = PayCents - CostCents;
   double TotalChange = (double)(change / 100.00); //changes change into a dollar amount

   String[] Pdenom = {"hundreds", "fifties", "tens", "fives", "ones", "quarters", "dimes", "nickels", "pennies"}; //plural form of each denomination
   String[] Sdenom = {"hundred", "fifty", "ten", "five", "one", "quarter", "dime", "nickel", "penny"}; //singular form of each denomination

   int[] owed = {0, 0, 0, 0, 0, 0, 0, 0, 0}; //stores denominations owed
   int[] conver = {10000, 5000, 1000, 500, 100, 25, 10, 5, 1}; //denomination in pennies

   for(int i = 0; i < owed.length; i++){ //calculates denominations owed
     int amountowed = change / conver[i];
     change = change % conver[i];
     Array.set(owed, i, amountowed);
   }
  
   System.out.println("Change due is $" + TotalChange );
 
   System.out.println("Denominations: ");
   
   for(int i = 0; i < owed.length; i++){ //outputs denominations owed
   if(owed[i] > 0) //removes denomination from list if it is not needed
     if(owed[i] > 1) //determines the plurality of the denomination
     System.out.println(owed[i] + " " + Pdenom[i]);
     else
     System.out.println(owed[i] + " " + Sdenom[i]);
   }
 
 }
}