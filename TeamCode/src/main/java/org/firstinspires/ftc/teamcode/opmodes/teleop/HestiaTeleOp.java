package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Actuator;
import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Claw;
import org.firstinspires.ftc.teamcode.hardware.Lift;
import org.firstinspires.ftc.teamcode.hardware.Lights;
import org.firstinspires.ftc.teamcode.hardware.MecanumDrive;


@TeleOp (name = "HestiaTeleOp", group = "TeleOp")
public class HestiaTeleOp extends LinearOpMode {

    // Declares a new MecanumDrive object and sets it to null to avoid hardwaremapping right now
    private MecanumDrive mecanumDrive = null;
    private Actuator actuator = null;
    private Claw claw = null;
    private Arm arm = null;
    private Lift lift = null;
    private Lights lights = null;

    // Variables used to take input from joysticks
    private double forward;
    private double strafe;
    private double turn;

    // Boolean used to determine if the robot is in field centric mode or robot centric mode
    private boolean isRobotCentric = false;

    private ElapsedTime timer = null;

    @Override
    public void runOpMode(){

        // Calling the constructor creates a new object and hardwareMaps our motors and servos
        // We give it a heading because the default roadrunner file asks for a heading, but this heading won't be used
        mecanumDrive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        actuator = new Actuator(hardwareMap);
        claw = new Claw(hardwareMap);
        arm = new Arm(hardwareMap);
        lift = new Lift(hardwareMap);
        lights = new Lights(hardwareMap);
        timer = new ElapsedTime();

        waitForStart();
        // Loop this
        while (opModeIsActive()){

            // Sets our variables from earlier to their respective joysticks
            forward = -gamepad1.left_stick_y;
            strafe = -gamepad1.left_stick_x;
            turn = -.75*gamepad1.right_stick_x;

            // Helps to toggle whether or not the robot is in robot centric or field centric mode
            if (gamepad1.ps && !isRobotCentric){
                isRobotCentric = true;
            } else if (gamepad1.back && isRobotCentric){
                isRobotCentric = false;
            }

            // Based off of which drive mode we are in, we use the appropriate function to drive
            if (isRobotCentric){
                mecanumDrive.robotCentricDrive(forward, strafe, turn);
                telemetry.addLine("We are in robot centric mode");
            } else {
                // The final parameter here is used as a button to determine whether the IMU needs to be reset or not
                mecanumDrive.cartesianDrive(forward, strafe, turn, gamepad1.dpad_up);
                telemetry.addLine("We are in field centric mode");
            }

            lift.teleOp(.75 * (gamepad1.right_trigger - gamepad1.left_trigger));
            arm.teleOp(gamepad2.left_stick_y);
            actuator.teleOp(gamepad2.right_stick_y);
            claw.teleOp(gamepad2.right_trigger, gamepad2.left_trigger);

            lights.teleOp(timer, forward, strafe, turn);

            telemetry.update();
        }
    }

}
