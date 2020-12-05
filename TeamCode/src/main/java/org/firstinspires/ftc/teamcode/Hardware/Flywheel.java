package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Flywheel {

    public DcMotor flywheelMotor;

    public Flywheel(DcMotor f)
    {
        f.setPower(0);
        f.setDirection(DcMotor.Direction.FORWARD);
        f.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        flywheelMotor=f;
    }

    public double maxPower=-1;

    public void launch()
    {
        flywheelMotor.setPower(maxPower);
    }

    public void noLaunch() { flywheelMotor.setPower(0); }
}
