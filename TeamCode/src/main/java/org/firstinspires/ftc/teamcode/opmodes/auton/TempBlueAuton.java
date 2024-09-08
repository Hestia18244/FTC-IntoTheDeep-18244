package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.MecanumDrive;

@Autonomous (name = "TempBlueAuton", group = "blue")
public class TempBlueAuton extends LinearOpMode {

    private MecanumDrive mecanumDrive = null;

    @Override
    public void runOpMode(){

        mecanumDrive = new MecanumDrive(hardwareMap, new Pose2d(36, 60, Math.toRadians(180)));

        waitForStart();

        mecanumDrive.robotCentricDrive(.5,0, 0);
        sleep(1000);
        mecanumDrive.robotCentricDrive(0, -0.5, 0);
        sleep(500);
        mecanumDrive.robotCentricDrive(-.5, 0, 0);
        sleep(1000);
    }
}
