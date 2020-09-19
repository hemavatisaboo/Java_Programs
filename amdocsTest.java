/*
 Input:4
 DBCC 0 2
 CDAB 2 1
 CAAD 1 2
 CDDA 2 0
 Output:BDAA
*/

import java.io.*;
import java.util.*;
public class amdocsTest 
{
	static List<String> chars=new ArrayList<String>();
    public static void main(String args[] ) throws Exception
    {

    	//Write code here
        Scanner in=new Scanner(System.in);
        int n;
        n=in.nextInt();
        List<Integer> bulls=new ArrayList<Integer>();
        List<Integer> cows=new ArrayList<Integer>();
        List<String> str=new ArrayList<String>();
        
        for(int i=0;i<n;i++)
        {
            str.add(in.next());     
            bulls.add(in.nextInt());
            cows.add(in.nextInt());
        }
        /*for(int i=0;i<n;i++)
        {
            System.out.println(str.get(i)+"\t"+bulls.get(i)+"\t"+cows.get(i));
    	}*/
    	if (Collections.max(bulls)==n)
    	{
    		System.out.println(str.get(bulls.indexOf(n)));
    	}
    	else
    	{
           	
        	allLexicographic("ABCD");
        	System.out.println("Chars Array Size is: "+chars.size());
        	if (Collections.min(bulls)==0)
        	{
        		char first,second,third,fourth;
        		int ind=bulls.indexOf(0);
    		    first=str.get(ind).charAt(0);
    		    if (first=='A'){
    		    	chars.subList(0, 64).clear();
    		    	//System.out.println("New Chars Array Size is: "+chars.size());
    		    	}
    		    else if (first=='B'){
    		     	chars.subList(64, 128).clear();
    		     	//System.out.println("New Chars Array Size is: "+chars.size());
    		     	}
    		    else if (first=='C'){
    		     	chars.subList(128, 192).clear();
    		     	//System.out.println("New Chars Array Size is: "+chars.size());
    		     	}
    		    else if (first=='D'){
    		    	chars.subList(192, 256).clear();
    		    	//System.out.println("New Chars Array Size is: "+chars.size());
    		    	}
    		    second=str.get(ind).charAt(1);
    		    third=str.get(ind).charAt(2);
    		    fourth=str.get(ind).charAt(3);
    		    for (int k=0;k<chars.size();k++)
    		    {
    		    	if (chars.get(k).indexOf(second)==1 || chars.get(k).indexOf(third)==2 || chars.get(k).indexOf(fourth)==3)
    		    	{
    		    		chars.remove(k);
    		    		k--;
    		    	}
    		    
    		    
    		  	}
    		 }
    		 for(int k=0;k<chars.size();k++)
    		 {
    		 	int l=0;
		    
		    		for (l=0;l<n;l++)
		    		{
		    			int count=0;
		    			int count1=0;
		    
		    			int total=bulls.get(l)+cows.get(l);
		    			String charword=new String(chars.get(k));
		    			//StringBuilder strword=new StringBuilder(str.get(l));
		    			
		    			
		    			for (int p=0;p<4;p++)
		    			{
		    				 if (chars.get(k).charAt(p)==str.get(l).charAt(p))
		    				 {
		    				 	count++;
		    				 }
		    				 int index=charword.indexOf(str.get(l).charAt(p));
		    				 if (index!=-1)
		    				 {
		    				 	charword = charword.substring(0,index)+'X'+charword.substring(index+1);
		    				 	//charword.setCharAt(charword.indexOf(strword.charAt(p)),'X');
   		    				 	count1++;
		    				 }
		    			}
		    			if (count!=bulls.get(l) || count1!=total)
		    			{
		    				chars.remove(k);
		    				k--;
		    				break;
		    			}
		    		
		    		}
		    		
    		    }
    		    			
        		    
        	}		   
        		    
    	//System.out.println("New Chars Array Size is: "+chars.size());
    	System.out.println("The string is: "+chars.get(0));
    	
    }
    public static void allLexicographicRecur(String str, char[] data, int last, int index)  
	{ 
    	int length = str.length(); 

    	for (int i = 0; i < length; i++)  
    	{ 

        	data[index] = str.charAt(i); 
        	if (index == last) 
        	{
            	//System.out.println(new String(data)); 
            	chars.add(new String(data));
        	}
        	else
            	allLexicographicRecur(str, data, last,index + 1); 
    	} 
	} 

	public static void allLexicographic(String str)  
	{ 
    	int length = str.length(); 
    	char[] data = new char[length + 1]; 
    	char[] temp = str.toCharArray(); 

    	Arrays.sort(temp); 
    	str = new String(temp); 

    	allLexicographicRecur(str, data, length - 1, 0); 
	} 

}
     

	        
	        	
        
        
        
        