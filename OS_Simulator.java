//--------------------------------------------------------------------
//
//  Some priority queue exercises
//
//--------------------------------------------------------------------

// Simulates an operating system's use of a priority queue to regulate
// access to a system resource (printer, disk, etc.).

import java.io.*;
import java.util.Random;
import java.util.Scanner;

class OS_Simulator
{
    public static void main ( String args[ ])
    {
        System.out.println("\f");
        PriorityQueue<Job> taskPQ = new PriorityQueue<Job>( );  // Priority queue of tasks
        Job task;                      // Task
        int simLength,                      // Length of simulation (minutes)
            minute,                         // Current minute
            timeArrived,                    // Time task arrived
            numPtyLevels,                   // Number of priority levels
            pLevel,                         // Priority level of the task
            numArrivals = 0,                // Number of new tasks arriving
            maxWait0 = 0,                   // Longest wait for priority 0
            maxWait1 = 0,                   // Longest wait for priority 1
            j;                              // Loop counter

        Random rand                  // Initialize random number generator
            = new Random(System.currentTimeMillis());   // seed is clocktime
                                                        // to reduce sequence
                                                        // repetition
        Scanner keyboard = new Scanner(System.in);
        //-----------------------------------------------------------------
        // Read in the number of priority levels

        System.out.println( );
        // System.out.print("Enter the number of priority levels : ");
        numPtyLevels = 2;//  just do two priorities, 0 and 1

        System.out.print("Enter the length of time to run the simulator : ");
        simLength = keyboard.nextInt();

        System.out.println( );
        System.out.println("                           Priority Arrived Waited");

        for ( minute = 0 ; minute < simLength ; minute++ )
        {
            // Part A) Process any tasks in Queue
            // Dequeue the first task in the queue (if any) and
            //  print info about the task dequeued (priority, arrival time, and wait time)


            if (taskPQ.getSize() != 0){
                Job done = taskPQ.remove();
                int waitTime = minute-done.getArrived();
                System.out.println("                               "+done.pty() + ", " + done.getArrived() + ", " + waitTime);
                if (done.pty() == 1 && waitTime>maxWait1){
                    maxWait1 = waitTime;
                } else if(done.pty() == 0 && waitTime>maxWait0) {
                    maxWait0 = waitTime;
                }
            }

            // Part B) Add tasks to Queue
            // Determine the number of new tasks
            int k = rand.nextInt(4);
            int p = rand.nextInt(2);
            // Create new tasks (set arrival time and priority) and add them to the queue.
            for(int i = 0; i< k; i++){
                task = new Job(p);
                task.setArrived(minute);
                taskPQ.add(task);
                System.out.println("At " + minute + " enqueued : " + "\t"
                                   + task.pty());
            }
        }

        // Output longestWait for each priority
        System.out.println("Longest wait for priority 0: " + maxWait0);
        System.out.println("Longest wait for priority 1: " + maxWait1);

    } // main

} // class

/*

Enter the length of time to run the simulator : 10

                           Priority Arrived Waited
At 0 enqueued : 	1
At 0 enqueued : 	1
At 0 enqueued : 	1
                               1, 0, 1
At 1 enqueued : 	1
At 1 enqueued : 	1
At 1 enqueued : 	1
                               1, 0, 2
At 2 enqueued : 	1
At 2 enqueued : 	1
At 2 enqueued : 	1
                               1, 1, 2
At 3 enqueued : 	0
At 3 enqueued : 	0
                               1, 2, 2
At 4 enqueued : 	1
At 4 enqueued : 	1
                               1, 0, 5
                               1, 4, 2
At 6 enqueued : 	1
At 6 enqueued : 	1
At 6 enqueued : 	1
                               1, 1, 6
At 7 enqueued : 	1
                               1, 6, 2
At 8 enqueued : 	0
At 8 enqueued : 	0
                               1, 7, 2
At 9 enqueued : 	0
At 9 enqueued : 	0
Longest wait for priority 0: 0
Longest wait for priority 1: 6
*/
