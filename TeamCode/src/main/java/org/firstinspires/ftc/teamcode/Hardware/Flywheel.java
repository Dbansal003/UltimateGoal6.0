package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Flywheel {

    public DcMotor flywheelMotor;

    public double maxPower=1;

    public void launch()
    {
        flywheelMotor.setPower(maxPower);
    }

    public void noLaunch()
    {
        flywheelMotor.setPower(0);
    }
}
