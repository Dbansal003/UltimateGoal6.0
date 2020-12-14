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

@Autonomous(name="Remote Auto",group="Autonomous")
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

        //Move forward [to launch line]
        robot.robotMotors.moveForward(1200, 0.6);
        //lift flap, shooter, kicker 3x [shoot hopefully high goal]
        robot.s.upFlap();
        robot.flywheel.launch();
        Thread.sleep(1000);
        for(int i=1; i<=3; i++) {
            robot.s.kick();
            Thread.sleep(1500);
            robot.s.unkick();
            Thread.sleep(500);
        }
        robot.flywheel.noLaunch();
        //Move forward [park]
        robot.robotMotors.moveForward(200, 0.6);


        executor.schedule(new Runnable() {
            @Override
            public void run() {
                robot.robotMotors.setMotorPower(0);
            }
        }, 5, TimeUnit.SECONDS);

    }
}
