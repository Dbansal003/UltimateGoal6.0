package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Flywheel {

    public DcMotorSimple flywheelMotor;

    public void launch()
    {
        flywheelMotor.setPower(1);
    }

    public void stop()
    {
        flywheelMotor.setPower(0);
    }
}
