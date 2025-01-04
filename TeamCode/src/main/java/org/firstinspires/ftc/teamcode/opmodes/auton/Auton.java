package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.MecanumDrive;

@Autonomous
public class Auton extends LinearOpMode{

    MecanumDrive mecanumDrive = null;
    Pose2d initalPose = null;
    Action trajectory = null;

    @Override
    public void runOpMode(){

        initalPose = new Pose2d(-36, -61, Math.toRadians(90));
        mecanumDrive = new MecanumDrive(hardwareMap, initalPose);
        trajectory = mecanumDrive.actionBuilder(initalPose)
                .strafeToSplineHeading(new Vector2d(-56, -54), Math.toRadians(45))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-48, -34.5), Math.toRadians(90))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-56, -54), Math.toRadians(45))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-58, -34.5), Math.toRadians(90))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-56, -54), Math.toRadians(45))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-55, -25), Math.toRadians(180))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-56, -54), Math.toRadians(45))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-27, 0), Math.toRadians(0))
                .build();

        waitForStart();

        if (isStopRequested()) return;

        Actions.runBlocking(
                new SequentialAction(
                        trajectory
                )
        );

    }

}
