package org.firstinspires.ftc.teamcode.opmodes.test.lift;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Lift;
import org.firstinspires.ftc.teamcode.hardware.MecanumDrive;

@TeleOp
public class LiftUpTest extends LinearOpMode {
    Lift lift = null;
    MecanumDrive drive = null;

    @Override
    public void runOpMode(){
        lift = new Lift(hardwareMap);
        drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        Action trajectory = drive.actionBuilder(new Pose2d(0, 0, 0))
                .afterTime(3, lift.liftUp())
                .afterTime(10, lift.liftDown())
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
