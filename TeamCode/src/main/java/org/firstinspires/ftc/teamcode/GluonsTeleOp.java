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
import org.firstinspires.ftc.teamcode.Hardware.wheelStick;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

public class GluonsTeleOp extends LinearOpMode {
    Robot robot = new Robot();
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        int slowModeButtonCD = 0;
        boolean flapUp = false;
        int flapButtonCD = 0;
        boolean released = false;
        int latchButtonCD = 0;
        boolean latched = false;

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


            if (slowModeButtonCD == 0 && gamepad1.back) {
                if (maxPower == 1) {
                    maxPower = .5;
                } else {
                    maxPower = 1;
                }
                slowModeButtonCD = 12;
            }

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

            // WheelStick Control
            if(gamepad1.right_trigger>0.2) {
                robot.wheelStick.intake();
                robot.s.onBuffer();
            }
            else {
                robot.wheelStick.noIntake();
                robot.s.offBuffer();
            }

            // Reverse Intake
            if(gamepad1.left_trigger>0.2) {
                robot.wheelStick.reverseIntake();
            }
            else {
                robot.wheelStick.noIntake();
            }


            // Gamepad 2 - Functions GAMER MOMENTS 2020

            //Flywheel Speed Controls
            if(gamepad2.x)
            {
                maxPower=0.6;
            }
            if(gamepad2.a)
            {
                maxPower=1;
            }

            //FlyWheel Control
            if(gamepad2.left_trigger>0.2) {
                robot.Flywheel.launch();
            }
            else {
                robot.Flywheel.noLaunch();
            }

            //Flap Control
            if(flapButtonCD == 0 && gamepad2.y) {
                if(!flapUp) {
                    robot.s.upFlap();
                    flapUp=true;
                } else {
                    robot.s.downFlap();
                    flapUp=false;
                }
                flapButtonCD=12;
            }

            //Kicker Controls
            if(gamepad2.right_trigger>0.2) {
                robot.s.kick();
            }
            else {
                robot.s.unkick();
            }

            //Release Wheelstick Controls
            if(gamepad2.dpad_left) {
                if(!released) {
                    robot.s.release();
                    released=true;
                }
            }

            //Latch Controls
            if(latchButtonCD == 0 && gamepad2.b) {
                if(!latched) {
                    robot.s.latch();
                    latched=true;
                } else {
                    robot.s.unlatch();
                    latched=false;
                }
                latchButtonCD=12;
            }

            // TELEMETRY STATEMENTS

            telemetry.addData("Gyro Heading", robot.imu.getHeadingDegrees());
//            telemetry.addData("Alpha", h.color.alpha());
//            telemetry.addData("Red  ", h.color.red());
//            telemetry.addData("Green", h.color.green());
//            telemetry.addData("Blue ", h.color.blue());


            telemetry.update();
            // Adds everything to telemetry

            if(slowModeButtonCD>0) {
                slowModeButtonCD--;
            }
            if(flapButtonCD>0) {
                flapButtonCD--;
            }
            if(latchButtonCD>0) {
                latchButtonCD--;
            }

            // Stops phone from queuing too many commands and breaking GAMER MOMENTS 2020
            // 25 ticks/sec
        }

    }
}

