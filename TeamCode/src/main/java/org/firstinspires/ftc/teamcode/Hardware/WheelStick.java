package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class WheelStick {

    public DcMotor wheelStickMotor;

    public WheelStick(DcMotor w)
    {

        w.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        w.setDirection(DcMotor.Direction.FORWARD);
        w.setPower(0);

        wheelStickMotor=w;
    }

    public void intake() {
        wheelStickMotor.setPower(-1);
    }

    public void noIntake() {
        wheelStickMotor.setPower(0);
    }

    public void reverseIntake() {wheelStickMotor.setPower(1);}
}
