package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Robot;

public class WobbleGoal {

    Robot robot=new Robot();
    public DcMotor wobbleGoalMotor;


    public WobbleGoal(DcMotor wo)
    {

        wo.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        wo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        wo.setDirection(DcMotor.Direction.FORWARD);
        wo.setPower(0);

        wobbleGoalMotor=wo;
    }

    public void raise() throws InterruptedException{
        wobbleGoalMotor.setPower(.85);
        Thread.sleep(3000);
        robot.s.unlatch();
        wobbleGoalMotor.setPower(0);
    }

    public void lower() throws InterruptedException{
        wobbleGoalMotor.setPower(-.3);
        Thread.sleep(1000);
        wobbleGoalMotor.setPower(0);
    }
}
