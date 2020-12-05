package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class wheelStick {

    public DcMotor wheelStickMotor;


    public wheelStick(DcMotor WheelStick)
    {

        WheelStick.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        WheelStick.setDirection(DcMotor.Direction.FORWARD);
        WheelStick.setPower(0);

        wheelStickMotor=WheelStick;
    }

    public void intake() {
        wheelStickMotor.setPower(-1);
    }

    public void noIntake() {
        wheelStickMotor.setPower(0);
    }

    public void reverseIntake() {wheelStickMotor.setPower(1);}
}
