/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

public class GluonsTeleOp extends LinearOpMode {
    Robot robot = new Robot();
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        //boolean rakeIsLowered = false; GAMER MOMENTS 2020
        //int rakeButtonCD = 0; GAMER MOMENTS 2020
        //int lockButtonCD = 0; GAMER MOMENTS 2020
        int liftHeight = 0;
        final double STONE_INCHES = 5;
        final double FOUNDATION_INCHES = 2.25;
        int slowModeButtonCD = 0;
        //boolean bArmIsClosed = false;
        boolean fArmIsDown = false;
        boolean isLocked = false;
        int fArmButtonCD = 0;
        int  cArmButtonCD = 0;
        boolean cArmIsClosed = true;
        int capCD = 0;
        boolean capIsDown = false;
        int flipArmButtonCD = 0;
        int kickButtonCD = 0;
        boolean kicked = false;
        boolean flipIsOut = false;

        robot.robotMotors.turnOffEncoders();
        waitForStart();

        while (opModeIsActive()) {


            robot.imu.loop();

            // DRIVE ====================================================                                                              Wheel vectors GAMER MOMENTS 2020
            //                                                                                                                      135 degrees  45 degrees GAMER MOMENTS 2020
            double maxPower = 1;
            double forward = Math.abs(gamepad1.left_stick_y) > 0.2 ? -gamepad1.left_stick_y : 0;
            double clockwise = Math.abs(gamepad1.right_stick_x) > 0.2 ? -gamepad1.right_stick_x : 0;                                  // 45 degrees   135 degrees GAMER MOMENTS 2020
            double right = Math.abs(gamepad1.left_stick_x) > 0.2 ? gamepad1.left_stick_x : 0;
            //Math for drive relative to theta
            clockwise *= -1;

            double fr = forward - clockwise + right;  //+
            double br = forward - clockwise - right;  //-
            double fl = forward + clockwise - right;  //-
            double bl = forward + clockwise + right;  //+

            fl = Range.scale(fl, -1, 1, -maxPower, maxPower);
            fr = Range.scale(fr, -1, 1, -maxPower, maxPower);
            bl = Range.scale(bl, -1, 1, -maxPower, maxPower);
            br = Range.scale(br, -1, 1, -maxPower, maxPower);
            robot.robotMotors.setMotorPower(fl, fr, bl, br);
//
//
//            // BUTTONS ================================================== GAMER MOMENTS 2020
//
//            // Gamepad 1 - Driver + Intake + Foundation Arms GAMER MOMENTS 2020
//            if (slowModeButtonCD == 0 && gamepad1.back) {
//                if (maxPower == 1) {
//                    maxPower = .5;
//                } else {
//                    maxPower = 1;
//                }
//                slowModeButtonCD = 12;
//            }

//
//            final double x = Math.pow(gamepad1.left_stick_x*-1, 3.0);
//            final double y = Math.pow(gamepad1.left_stick_y *-1, 3.0);
//            final double rotation = Math.pow(gamepad1.right_stick_x*1, 3.0)/1.5; //changed from negative to 1
//            final double direction = Math.atan2(x, y) + robot.imu.getHeading();
//            final double speed = Math.min(1.0, Math.sqrt(x * x + y * y));
//
//            final double frontLeft = 1 * speed * Math.sin(direction + Math.PI / 4.0) + rotation;
//            final double frontRight = 1 * speed * Math.cos(direction + Math.PI / 4.0) - rotation;
//            final double backLeft = 1 * speed * Math.cos(direction + Math.PI / 4.0) + rotation;
//            final double backRight = 1 * speed * Math.sin(direction + Math.PI / 4.0) - rotation;
//
//            robot.robotMotors.setMotorPower(frontLeft, frontRight, backLeft, backRight);




            // Gamepad 2 - Functions GAMER MOMENTS 2020





            //Claw GAMER MOMENTS 2020
//            //Horizontal Linear Slide
//            if(gamepad2.dpad_right)
//            {
//                h.horizontal.setPower(1);
//            }
//            else if(gamepad2.dpad_left)
//            {
//                h.horizontal.setPower(-1);
//            }
//            else
//            {
//                h.horizontal.setPower(0);
//            }
//            //Flip
//            if(flipArmButtonCD == 0 && gamepad2.b) {
//                if (!flipIsOut) {
//                    h.flip.setPosition(1);
//                    flipIsOut = true;
//                } else {
//                    h.flip.setPosition(0);
//                    flipIsOut = false;
//                }
//                flipArmButtonCD = 12;
//            }


//            // Butterfly arms
//            if(bArmButtonCD == 0 && gamepad2.a) {
//                if (!bArmIsClosed) {
//                    h.bArmLeft.setPosition(.55);
//                    h.bArmRight.setPosition(1);
//                    bArmIsClosed = true;
//                } else {
//                    h.bArmLeft.setPosition(0);
//                    h.bArmRight.setPosition(.5);
//                    bArmIsClosed = false;
//                }
//                bArmButtonCD = 12;
//            }
//
//            // "Rake"
//            if (rakeButtonCD == 0 && gamepad2.x)
//            {
//                if (rakeIsLowered) {
//                    // Raise it.
//                    h.rake.setPosition(0.5);
//                    rakeIsLowered = false;
//                } else {
//                    // Drop it.
//                    if (gamepad2.dpad_down) {
//                        h.rake.setPosition(0);
//                    } else {
//                        h.rake.setPosition(.29);
//                    }
//                    rakeIsLowered = true;
//                }
//                rakeButtonCD = 12;
//            }
//
//            // Flip thingamabob
//            // CONTROL: Press the left or right triggers to make the arm rotate. The speed of the arm depends on how much you press.
//            if (gamepad2.right_trigger > .2) {
//                h.flip.setPower(-1 * Range.scale(gamepad2.right_trigger, 0, 1, 0, 0.5));
//            } else if (gamepad2.left_trigger > .2) {
//                h.flip.setPower(Range.scale(gamepad2.left_trigger, 0, 1, 0, 0.5));
//            } else {
//                h.flip.setPower(0);
//            }

            // h.flip.setPosition(Range.clip((h.flip.getPosition() - 0.25 * leftPow + 0.25 * rightPow), 0, 0.8));    // Position not final

            // Lift
            // CONTROL: Press the left or right bumper to elevate the arm.


            //Lock
            // CONTROL: Press 'B' to either lock or unlock.
//            if (lockButtonCD == 0 && gamepad2.b) {
//                if (!isLocked) {
//                    // Unlocked and locking.
//                    h.lock.setPower(-0.5);
//                    isLocked = true;
//                } else {
//                    // Locked and unlocking.
//                    h.lock.setPower(0.5);
//                    Thread.sleep(600);
//                    h.lock.setPower(0);
//                    isLocked = false;
//                }
//                lockButtonCD = 12;
//            }

            // Probably should go in Autonomous somewhere
//            if (gamepad1.left_bumper) {
//                h.flip.setPosition(0.8);
//                h.lock.setPosition(0.3);
//                Thread.sleep(2000);
//                h.lift.setPower(1);
//                Thread.sleep(2000);
//                h.flip.setPosition(0);
//                Thread.sleep(5000);
//                h.flip.setPosition(0.8);
//                h.lift.setPower(0.5);
//            }

            // TELEMETRY STATEMENTS

            telemetry.addData("Gyro Heading", robot.imu.getHeadingDegrees());
//            telemetry.addData("Position of Servo", h.foundationArmR.getPosition());
//            telemetry.addData("Position of Servo", h.foundationArmL.getPosition());
//            telemetry.addData("Alpha", h.color.alpha());
//            telemetry.addData("Red  ", h.color.red());
//            telemetry.addData("Green", h.color.green());
//            telemetry.addData("Blue ", h.color.blue());


            telemetry.update();
            // Adds everything to telemetry


            // Stops phone from queuing too many commands and breaking GAMER MOMENTS 2020
            // 25 ticks/sec
        }

    }
}

