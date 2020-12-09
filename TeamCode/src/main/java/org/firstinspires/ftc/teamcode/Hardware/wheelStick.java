package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class wheelStick {

    public DcMotor wheelStickMotor;


    public wheelStick(DcMotor f)
    {

        f.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        f.setDirection(DcMotor.Direction.FORWARD);
        f.setPower(0);

        wheelStickMotor=f;
    }

    public void intake() {
        wheelStickMotor.setPower(-1);
    }

    public void noIntake() {
        wheelStickMotor.setPower(0);
    }

    public void reverseIntake() {wheelStickMotor.setPower(1);}
}
