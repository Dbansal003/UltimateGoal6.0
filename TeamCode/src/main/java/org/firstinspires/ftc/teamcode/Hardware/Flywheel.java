package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Flywheel {

    public DcMotor flywheelMotor;

    public void launch()
    {
        flywheelMotor.setPower(1);
    }

    public void noLaunch()
    {
        flywheelMotor.setPower(0);
    }
}
