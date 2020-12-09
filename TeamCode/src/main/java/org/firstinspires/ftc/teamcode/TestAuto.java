package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.lang.Runnable;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Autonomous.DriveTrain;

@Autonomous(name="TestAuto",group="Autonomous")
public class TestAuto extends LinearOpMode{

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;

    public void runOpMode() throws InterruptedException {
        DriveTrain robot=new DriveTrain(frontLeft,frontRight,backLeft,backRight);
    }
}
