package com.corejava.Enum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CrewMember {

    private FlightPositions position;
    /*
     * This is composition as we are using a class inside a class. with has-a
     * relationship, where the CrewMember has a position in a flight
     */

    public CrewMember(FlightPositions position) {
        this.position = position;
        /*
         * The parameterized constructor and 'this' pointer is essential here because, it
         * has to change as per positions defined in enum
         */
    }

    public static void main(String[] args) {

        CrewMember alex = new CrewMember(FlightPositions.CoPilot);
        //Now, He got promotion
        alex.setPosition(FlightPositions.Pilot);
        alex.setPosition(FlightPositions.AirMarshal);
        log.info("alex's position after promotions = " + alex);

        CrewMember latika = new CrewMember(FlightPositions.FlightAttendant);
        //After rigorous training, she got promotion
        latika.setPosition(FlightPositions.AirHostress);
        log.info("latika's position = " + latika);
    }

    public void setPosition(FlightPositions position) {
        this.position = position;
        //This is needed to change the position for any demotions and promotions
    }


}
