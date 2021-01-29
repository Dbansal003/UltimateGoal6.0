package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import java.lang.Runnable;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Autonomous(name="Normal Auto",group="Autonomous")
public class remoteAuto extends LinearOpMode{
    private Robot robot=new Robot();

    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        waitForStart();


        final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.schedule(new Runnable() {
            @Override
            public void run() {

            }
        }, 29, TimeUnit.SECONDS);

        //Move forward to shooting position
        robot.robotMotors.moveForward(2100, 0.6);
        robot.wobbleGoal.lower();
        //Shoot three times
        robot.s.upFlap();
        robot.flywheel.launch();
        Thread.sleep(3000);
        robot.s.kick();
        Thread.sleep(1500);
        robot.s.unkick();
        Thread.sleep(1500);
        robot.robotMotors.moveForward(700,-0.6);
        robot.robotMotors.turn(4,'r');
        for(int i=1; i<=3; i++) {
            robot.s.kick();
            Thread.sleep(1500);
            robot.s.unkick();
            Thread.sleep(1500);
        }
        robot.flywheel.noLaunch();
        //Park on launch line
        robot.robotMotors.moveForward(1500, 0.6);
        robot.wheelStick.intake();
        Thread.sleep(1000);
        robot.wheelStick.noIntake();
        robot.s.downFlap();


        executor.schedule(new Runnable() {
            @Override
            public void run() {
                robot.robotMotors.setMotorPower(0);
            }
        }, 5, TimeUnit.SECONDS);

    }
}
