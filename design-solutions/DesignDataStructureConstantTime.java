// https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/

/* 
Java program to design a data structure that support operations in Theta(n) time
a) Insert
b) Delete
c) Search
d) getRandom 
*/

import java.util.*;
  
class MyDS
{
   ArrayList<Integer> arr;
  
   // A hash where keys are array elements and vlaues are
   // indexes in arr[]
   HashMap<Integer, Integer>  hash;
  
   public MyDS()
   {
       arr = new ArrayList<Integer>();
       hash = new HashMap<Integer, Integer>();
   }
  
   // A Theta(1) function to add an element to MyDS data structure
   void add(int x)
   {
      if (hash.get(x) != null)
          return;
  
      int s = arr.size();
      arr.add(x);
  
      hash.put(x, s);
   }
  
   // A Theta(1) function to remove an element from MyDS data structure
   void remove(int x)
   {
       Integer index = hash.get(x);
       if (index == null)
          return;
  
       hash.remove(x);
  
       // Swap element with last element so that remove from
       // arr[] can be done in O(1) time
       int size = arr.size();
       Integer last = arr.get(size-1);
       Collections.swap(arr, index,  size-1);
  
       // Remove last element (This is O(1))
       arr.remove(size-1);
  
       // Update hash table for new index of last element
       hash.put(last, index);
    }
  
    // Returns a random element from MyDS
    int getRandom()
    {
       // Find a random index from 0 to size - 1
       Random rand = new Random();
       int index = rand.nextInt(arr.size());
  
       return arr.get(index);
    }
  
    // Returns index of element if element is present, otherwise null
    Integer search(int x)
    {
       return hash.get(x);
    }
}
  