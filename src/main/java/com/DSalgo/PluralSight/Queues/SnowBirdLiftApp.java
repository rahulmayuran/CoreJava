package com.DSalgo.PluralSight.Queues;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SnowBirdLiftApp {

    QueueDataStructure<SnowyLift> birdQueuelifter = new QueueDataStructure<>();

    public static void main(String[] args)
    {
        SnowBirdLiftApp snowBirdlifter = new SnowBirdLiftApp();
        snowBirdlifter.runlift();
    }


    //This method calls all other methods
    private void runlift()
    {
        //Print the lift size
        log.info(String.valueOf(birdQueuelifter.size()));

        loadLift();

        //Print the lift size
        log.info(String.valueOf(birdQueuelifter.size()));

        //Does the lift contain the skiers Rahul and Bala
        log.info(birdQueuelifter.contains(new SnowyLift("Rahul","Bala")));

        //Who's at the 2nd position - It is 0 based index
        log.info("2nd Lift has "+ birdQueuelifter.access(1).listLiftRaiders());

        unloadLift();

        //If the lift is unloaded again, there should be an error, as there is no one in lift
        try {
            unloadLift();
        } catch (IllegalArgumentException e) {
            log.info("The lift is already empty, Whom you're trying to unload "+e.getMessage());
        }
    }

    private void loadLift()
    {
        //The list of skiers to get into the lift
        SnowyLift skier1 = new SnowyLift("Prasad","Rajesh");
        SnowyLift skier2 = new SnowyLift("Shashank","Ravi");
        SnowyLift skier3 = new SnowyLift("Pammi","Deepika");
        SnowyLift skier4 = new SnowyLift("Rahul","Bala");
        SnowyLift skier5 = new SnowyLift("Dhanus","Baskar");

        //Load them into the lift
        birdQueuelifter.enQueue(skier1);
        birdQueuelifter.enQueue(skier2);
        birdQueuelifter.enQueue(skier3);
        birdQueuelifter.enQueue(skier4);
        birdQueuelifter.enQueue(skier5);
    }

    private void unloadLift()
    {
        SnowyLift lift = birdQueuelifter.deQueue();

        //Should be Prasad and Rajesh
        log.info(lift.listLiftRaiders());

        lift = birdQueuelifter.deQueue();

        //Should be Pammi and Deepika
        log.info(lift.listLiftRaiders());

        lift = birdQueuelifter.deQueue();

        //Should be Shashank and Ravi
        log.info(lift.listLiftRaiders());

        lift = birdQueuelifter.deQueue();

        //Should be Rahul and Bala
        log.info(lift.listLiftRaiders());

        lift = birdQueuelifter.deQueue();

        //Should be Dhanus and Baskar
        log.info(lift.listLiftRaiders());
    }

    //Creating the generics with two strings, a parameterized constructor
    //Hashcode and equals methods.
    class SnowyLift
    {
        private String nameOfFirstSkier;
        private String nameOfSecondSkier;

        public SnowyLift(String seat1, String seat2){
            this.nameOfFirstSkier = seat1;
            this.nameOfSecondSkier = seat2;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
                return true;
            if(o==null)
                return false;
            if(getClass() != o.getClass())
                return false;
            SnowyLift other = (SnowyLift) o;
            if(!getOuterType().equals(other.getOuterType()))
                return false;
            if(nameOfFirstSkier == null)
            {
                if(other.nameOfFirstSkier!=null)
                    return false;
            }
            else if(!nameOfFirstSkier.equals(other.nameOfFirstSkier))
                return false;

            if(nameOfSecondSkier == null)
            {
                if(other.nameOfSecondSkier!=null)
                    return false;
            }
            else if(!nameOfSecondSkier.equals(other.nameOfSecondSkier))
                return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            int result =1;
            final int prime = 31;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((nameOfFirstSkier == null) ? 0 : nameOfFirstSkier.hashCode());
            result = prime * result + ((nameOfSecondSkier == null) ? 0 : nameOfSecondSkier.hashCode());
            return result;
        }

        public String listLiftRaiders()
        {
            return this.nameOfFirstSkier +" "+ this.nameOfSecondSkier;
        }

        public SnowBirdLiftApp getOuterType()
        {
            return SnowBirdLiftApp.this;
        }
    }
}
