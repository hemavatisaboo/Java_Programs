/*
 5
 5
 = 1 5
 # 2 4
 # 4 4
 = 5 3
 # 4 2
 
 output:5 2 4 1 3
 */



import java.io.*;
import java.util.*;
public class AmdocsProblemTwo {
    public static void main(String args[] ) throws Exception {

            Scanner in=new Scanner(System.in);
            int n=in.nextInt();
            int c=in.nextInt();
            int zerovalues=n+1;
            HashMap<Integer,List<Integer>> map = new HashMap<>();

            
            List<Integer> list=new ArrayList<Integer>();//(Collections.nCopies(n, 0));
            //Collections.copy(list,pair);
	        
            
			for(int i=1;i<n+1;i++){
				map.put(i, new ArrayList<Integer>());
				for (int j=1;j<n+1; j++) {
				    map.get(i).add(j); 
				}
			}
			
			
            //List<Integer> result = new ArrayList<Integer>(Collections.nCopies(n+1, 0));
            int result[]=new int[n+1];
			String pairvalue;
			int womenvalue,menvalue;
			
                
            for (int i=0;i<c;i++){
            	pairvalue=in.next();
            	womenvalue=in.nextInt();
            	menvalue=in.nextInt();
            	    
            	if (pairvalue.equals("#")){
        			list=map.get(womenvalue);
        			list.remove(new Integer(menvalue));                
					map.put(womenvalue,list);
					
				                
	            }
	            else if (pairvalue.equals("=")){
	            	//result.set(womenvalue,menvalue);
	            	result[womenvalue]=menvalue;
	            	zerovalues--;
	            	map.remove(womenvalue);
	            	/*for(Map.Entry<Integer,Integer> e: map.entrySet())
					{
						list=map.get(e.getKey());
				        list.remove(new Integer(menvalue));
					}*/
				    Iterator mapIterator = map.entrySet().iterator();   					
			        while (mapIterator.hasNext()) { 
			            Map.Entry mapElement = (Map.Entry)mapIterator.next(); 
			            list=map.get(mapElement.getKey());
				        list.remove(new Integer(menvalue));
			            
			        } 
	            	
	            }
	            /*Iterator mapIterator4 = map.entrySet().iterator();   					
			        while (mapIterator4.hasNext()) { 
			            Map.Entry mapElement4 = (Map.Entry)mapIterator4.next(); 
			            System.out.println(mapElement4.getKey());
			            System.out.println(map.get(mapElement4.getKey()));
				        
				    }*/
            
            }
            
            while (zerovalues>1){
            	Iterator mapIterator1 = map.entrySet().iterator(); 
  				while (mapIterator1.hasNext()) { 
		            Map.Entry mapElement1 = (Map.Entry)mapIterator1.next(); 
		          
						list=map.get(mapElement1.getKey());
						if (list.size()==1){
							int value=list.get(0);
							//map.remove(mapElement1.getKey());
							//result.set((int)(mapElement1.getKey()),value);
							result[(int)(mapElement1.getKey())]=value;
							zerovalues--;
				        	Iterator mapIterator2 = map.entrySet().iterator(); 
			  				while (mapIterator2.hasNext()) { 
					            Map.Entry mapElement2 = (Map.Entry)mapIterator2.next(); 
					            list=map.get(mapElement2.getKey());
						        list.remove(new Integer(value));
					            
					        } 
						}
	
			        }
        	}            
        	for(int k=1;k<n+1;k++){
            	System.out.print(result[k]);
            }
 		}           			 
}
            
            
            