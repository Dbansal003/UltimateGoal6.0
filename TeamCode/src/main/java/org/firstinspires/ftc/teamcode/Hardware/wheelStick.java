package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class wheelStick {

    public DcMotor wheelStick;

    public wheelStick(DcMotor wheelStick)
    {
        wheelStick.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        wheelStick.setDirection(DcMotor.Direction.FORWARD);

        wheelStick=wheelStick;
    }

    public void intake() {
        wheelStick.setPower(1);
    }

//    public void noIntake() {
//        wheelStick.setDirection(DcMotor.Direction.FORWARD);
//        wheelStick.setPower(0);
//    }

    public void reverseIntake() {wheelStick.setPower(-1);}
}
