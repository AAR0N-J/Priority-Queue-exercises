//--------------------------------------------------------------------
//
//  Laboratory 13                                      Job.java
//
// Definition for the Job heap element class
//
//--------------------------------------------------------------------

class Job implements Comparable<Job>
{
    // Data members
    private int priority,               // Priority for the job
                arrived;                // Arrival time (if used)

    // Constructors
    public Job( )                  // Default constructor
    {
        priority = 0;
        arrived = 0;
    }
    
    public Job( int pty )
    {
        priority = pty;
        arrived = 0;                    
    }
    
    public Job ( int pty, int aTime )
    {
        priority = pty;
        arrived = aTime;
    }
    
    // Class methods
    public int pty ( )
    { return priority; }                // Return the priority
    
    public void setPty ( int newPty )   // Set the priority
    { priority = newPty; }
    
    public int getArrived( )            // Return arrival time
    { return arrived;  }
    
    public void setArrived( int time )  // Set arrival time
    {  arrived = time;  }
    
    //@Override
    public int compareTo(Job j){
        if (this.pty()>j.pty()){
            return 1;
        } else if (this.pty()<j.pty()){
            return -1;
        }
        return 0;
    }

} // class TestData