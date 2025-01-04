package org.firstinspires.ftc.teamcode.opmodes.test.lift;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Lift;

@TeleOp
public class LiftTest extends LinearOpMode {
    Lift lift = null;

    @Override
    public void runOpMode(){
        lift = new Lift(hardwareMap);

        waitForStart();

        while (opModeIsActive()){
            lift.test(gamepad1.left_stick_y, gamepad1.dpad_left, telemetry);
        }
    }
}
