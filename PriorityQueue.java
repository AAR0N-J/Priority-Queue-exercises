/**    An interface for the ADT priority queue.        
 * @author Frank M. Carrano    
 * @version 3.0 
 */ 

public class PriorityQueue <T extends Comparable<? super T>> 
{    
    MaxHeap<T> data;
    
    public PriorityQueue(){
        data = new MaxHeap<T>();
    }
    /** Adds a new entry to this priority queue.        
     * @param newEntry  an object 
     */    
    public void add(T newEntry)
    {
        data.add(newEntry);
    }
    
    /** Removes and returns the item with the highest priority.        
     * @return either the object with the highest priority or, if the                
     * priority queue is empty before the operation, null 
     */    
    public T remove()
    {
        return data.removeMax();
    }
    
    /** Retrieves the item with the highest priority.        
     * @return either the object with the highest priority or, if the                
     * priority queue is empty, null 
     */    
    public T peek()
    {
        return data.getMax();
    }
    
    /** Detects whether this priority queue is empty.        
     * @return true if the priority queue is empty, or false otherwise 
     */    
    public boolean isEmpty()
    {
        return data.isEmpty();
    }
     
    /** Gets the size of this priority queue.        
     * @return the number of entries currently in the priority queue 
     */    
    public int getSize()
    {
        return data.getSize();
    }
    
    /** Removes all entries from this priority queue */    
    public void clear()
    {
        data.clear();
    }
    
    public static void main(String [] args){
        System.out.println("\f");
        PriorityQueue<String> pq = new PriorityQueue<String>();
        
        pq.add("Zeno");pq.add("Xerxes");pq.add("Aristotle");pq.add("Athena");
        pq.add("Gina");pq.add("Horatio");
        
        while(!pq.isEmpty())
        System.out.println("removing " + pq.remove());
    }
} // end PriorityQueueInterface 