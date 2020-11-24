package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Servos {


    private Servo flap;             // Hub 3 Servo Slot 3
    private Servo kick;             // Hub 3 Servo Slot 2
    private Servo release;          // Hub 3 Servo Slot 4
    private Servo latch;

    private final double FLAP_UP = 1;
    private final double FLAP_DOWN = 0;

    private final double KICK_IN = 1;
    private final double KICK_OUT = 0;

    private final double FLIP_IN = 0;
    private final double FLIP_OUT = 1;

    private final double RELEASED = 1;

    private final double LATCH_ON = 1;
    private final double LATCH_OFF = 0;

    public Servos(Servo f, Servo cl, Servo ca, Servo k)
    {
        //servo hardware moments
        cl.setDirection(Servo.Direction.FORWARD);
        f.setDirection(Servo.Direction.FORWARD);
        k.setDirection(Servo.Direction.FORWARD);
        ca.setDirection(Servo.Direction.FORWARD);

        flap=f;
        kick=cl;
        release = ca;
        latch = k;
    }

    public void downFlap() {
        flap.setPosition(FLAP_DOWN);
    }

    public void upFlap() {
        flap.setPosition(FLAP_UP);
    }

    public void kick() {
        kick.setPosition(KICK_IN);
    }

    public void unkick() {
        kick.setPosition(KICK_OUT);
    }

    public void release() {release.setPosition(RELEASED); }

    public void latch() {latch.setPosition(LATCH_ON);}

    public void unlatch() {latch.setPosition(LATCH_OFF);}

}
