package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Servos {


    private Servo flap;             // Hub 3 Servo Slot 3
    private Servo kick;             // Hub 3 Servo Slot 2
    private Servo latch;
    private CRServo buffer;

    private final double FLAP_UP = 0.45;
    private final double FLAP_DOWN = 0;

    private final double KICK_IN = 0.3;
    private final double KICK_OUT = 0.04;

    private final double LATCH_ON = 1;
    private final double LATCH_OFF = 0.55;

    public Servos(Servo f, Servo k, Servo l, CRServo b)
    {
        //servo hardware moments
//        r.setDirection(Servo.Direction.FORWARD);
        f.setDirection(Servo.Direction.FORWARD);
        k.setDirection(Servo.Direction.FORWARD);
        l.setDirection(Servo.Direction.FORWARD);
        b.setDirection(CRServo.Direction.REVERSE);

        flap=f;
        kick=k;
        latch = l;
        buffer=b;

        latch.setPosition(LATCH_ON);
    }

    public void downFlap() {
        flap.setPosition(FLAP_DOWN);
    }

    public void upFlap() {
        flap.setPosition(FLAP_UP);
    }

    public void unkick() {
        kick.setPosition(KICK_IN);
    }

    public void kick() {
        kick.setPosition(KICK_OUT);
    }

    public void latch() {latch.setPosition(LATCH_ON);}

    public void unlatch() {latch.setPosition(LATCH_OFF);}

    public void onBuffer() {buffer.setPower(1);}

    public void offBuffer() {buffer.setPower(0);}

}
