package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class wheelStick {

    public DcMotor wheelStick;

    public void intake() {
        wheelStick.setPower(1);
    }

    public void noIntake() {
        wheelStick.setPower(0);
    }

    public void reverseIntake() {wheelStick.setPower(-1);}
}
