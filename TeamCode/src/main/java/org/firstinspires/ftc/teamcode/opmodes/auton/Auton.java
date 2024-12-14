package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.MecanumDrive;

@Autonomous (name = "TempBlueAuton", group = "blue")
public class Auton extends LinearOpMode {

    private MecanumDrive mecanumDrive = null;

    @Override
    public void runOpMode(){

        mecanumDrive = new MecanumDrive(hardwareMap, new Pose2d(36, 60, Math.toRadians(180)));

        waitForStart();

        //Push preloaded thing into the basket area
        mecanumDrive.cartesianAuton(0, -1, 0);
        sleep(2000);

        // Stop for a second
        mecanumDrive.cartesianAuton(0, 0, 0);
        sleep(1000);

        // Move right for a second
        mecanumDrive.cartesianAuton(0, 1, 0);
        sleep(1000);

        // Stop for a second
        mecanumDrive.cartesianAuton(0,0,0);
        sleep(1000);

        // Move forward for 4 seconds
        mecanumDrive.cartesianAuton(1, 0, 0);
        sleep(4000);

        // Move left for 1 second
        mecanumDrive.cartesianAuton(0, -1, 0);
        sleep(1000);

        //Move backward to push the blocks in
        mecanumDrive.cartesianAuton(-1, 0, 0);
        sleep(2500);

        // Stop for a second
        mecanumDrive.cartesianAuton(0, 0, 0);
        sleep(1000);

        // Move forward to get back to the ascent zone
        mecanumDrive.cartesianAuton(1, 0, 0);
        sleep(2500);

        //turn towards the ascent zone
        mecanumDrive.cartesianAuton(0, 0, 1);
        sleep(1000);

        //Move towards ascent zone
        mecanumDrive.cartesianAuton(0, 1, 0);
        sleep(1500);

        //Raise slider to touch the ascent zone
        mecanumDrive.otherMechanisms(0.1, 0, 0, 0, false, false);


    }
}
