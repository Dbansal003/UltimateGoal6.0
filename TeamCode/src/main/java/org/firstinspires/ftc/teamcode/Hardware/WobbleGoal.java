package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Robot;

public class WobbleGoal {

    public DcMotor wobbleGoalMotor;


    public WobbleGoal(DcMotor wo)
    {

        wo.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        wo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        wo.setDirection(DcMotor.Direction.FORWARD);
        wo.setPower(0);

        wobbleGoalMotor=wo;
    }

    public void raise() {
        wobbleGoalMotor.setPower(1);
    }

    public void noRaise()
    {
        wobbleGoalMotor.setPower(0);
    }

    public void lower() throws InterruptedException{
        wobbleGoalMotor.setPower(-.3);
        Thread.sleep(300);
        wobbleGoalMotor.setPower(0);
    }
}
