//---------------------------------------------------------------------
// Simulation.java           by Dale/Joyce/Weems              Chapter 4
// Mizuki Hashimoto
//
// Models a sequence of customers being serviced
// by a number of queues.
//
// Added a function to determine the largest number of customers who were on a queue at the same time. (03/25/2019)
// Added a function to calculate the percentage of idle server time. (03/25/2019)
// Changed package name to put the source codes together into one file. (03/25/2019)
//---------------------------------------------------------------------
package SimulationLab;

public class Simulation 
{
  final int MAXTIME = Integer.MAX_VALUE;
  int max_queues = 0;
                               
  CustomerGenerator custGen;   // a customer generator
  float avgWaitTime = 0.0f;    // average wait time for most recent simulation
  float idleSTProp = 0.0f;     // idle server time proportion
  float idleSTPerc = 0.0f;     // idle server time percent

  public Simulation(int minIAT, int maxIAT, int minST, int maxST)
  {
    custGen = new CustomerGenerator(minIAT, maxIAT, minST, maxST);
  }

  public float getAvgWaitTime()
  {
    return avgWaitTime;
  }

  public void simulate(int numQueues, int numCustomers)
  // Preconditions: numQueues > 0
  //                numCustomers > 0
  //                No time generated during simulation is > MAXTIME
  //
  // Simulates numCustomers customers entering and leaving the
  // a queuing system with numQueues queues
  {
    // the queues
    LinkedGlassQueue<Customer>[] queues = new LinkedGlassQueue[numQueues]; 

    Customer nextCust;      // next customer from generator
    Customer cust;          // holds customer for temporary use
    
    int totWaitTime = 0;    // total wait time
    int custInCount = 0;    // count of customers started so far
    int custOutCount = 0;   // count of customers finished so far
 
    int nextArrTime;        // next arrival time
    int nextDepTime;        // next departure time
    int nextQueue;          // index of queue for next departure
 
    int shortest;           // index of shortest queue
    int shortestSize;       // size of shortest queue
    Customer rearCust;      // customer at rear of shortest queue
    int finishTime;         // calculated finish time for customer being enqueued

    // instantiate the queues
    for (int i = 0; i < numQueues; i++)
      queues[i] = new LinkedGlassQueue<Customer>();
 
    // set customer generator and get first customer
    custGen.reset();
    nextCust = custGen.nextCustomer();
    
    while (custOutCount < numCustomers)  // while still more customers to handle
    { 
      // get next arrival time
      if (custInCount != numCustomers) 
        nextArrTime = nextCust.getArrivalTime();
      else 
        nextArrTime = MAXTIME; 
 
      // get next departure time and set nextQueue
      nextDepTime = MAXTIME;
      nextQueue = -1;
      for (int i = 0; i < numQueues; i++)
        if (queues[i].size() != 0)
        {
          cust = queues[i].peekFront();
          if (cust.getFinishTime() < nextDepTime)
          {
            nextDepTime = cust.getFinishTime();
            nextQueue = i;
          }          
        }

      if (nextArrTime < nextDepTime)
      // handle customer arriving
      {
        // determine shortest queue
        shortest = 0;
        shortestSize = queues[0].size();
        for (int i = 1; i < numQueues; i++)
        {
          if (queues[i].size() < shortestSize)
          {
            shortest = i;
            shortestSize = queues[i].size();
          }
        }

        // determine the largest number of customers who were on a queue at the same time
        max_queues = queues[0].size();
        for (int i = 0; i < numQueues; i++)
        {
          if(max_queues < queues[i].size()){
            max_queues = queues[i].size();
          }
        }

        // determine the finish time
        if (shortestSize == 0)
          finishTime = nextCust.getArrivalTime() + nextCust.getServiceTime();
        else
        {
          rearCust = queues[shortest].peekRear();
          finishTime = rearCust.getFinishTime() + nextCust.getServiceTime();
        }
    
        // set finish time and enqueue customer
        nextCust.setFinishTime(finishTime);
        queues[shortest].enqueue(nextCust);

        custInCount = custInCount + 1;
          
        // if needed, get next customer to enqueue
        if (custInCount < numCustomers)
          nextCust = custGen.nextCustomer();
      }
      else
      // handle customer leaving
      {
          cust = queues[nextQueue].dequeue();
          totWaitTime = totWaitTime + cust.getWaitTime();
          custOutCount = custOutCount + 1;
      }
    }  // end while
      
    avgWaitTime = totWaitTime/(float)numCustomers;

    float avgIAT = (custGen.minIAT + custGen.maxIAT) / 2; // average IAT
    float avgST = (custGen.minST + custGen.maxST) / 2;    // average service time
    // equation of idle server time proportion is different in two cases: single queue, or multiple queue
    if (numQueues == 1){
      idleSTProp = 1 - (avgIAT / avgST);
    } else if (numQueues > 1){
      idleSTProp = 1 - (avgIAT / (numQueues * avgST));
    }
    idleSTPerc = idleSTProp * 100; // multiply 100 to obtain percentage value
  }
  public int getMaxQueues() { return max_queues; }

  public float getIdleSTPerc() { return idleSTPerc; }
}