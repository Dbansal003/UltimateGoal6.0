package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Flywheel {

    public DcMotor flywheelMotor;

    public Flywheel(DcMotor flyWheel)
    {
        flyWheel.setPower(0);
        flyWheel.setDirection(DcMotor.Direction.FORWARD);
        flyWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        flywheelMotor=flyWheel;
    }

    public double maxPower=-1;

    public void launch()
    {
        flywheelMotor.setPower(maxPower);
    }

    public void noLaunch() { flywheelMotor.setPower(0); }
}
