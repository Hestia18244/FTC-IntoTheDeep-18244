package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private Servo claw;

    public Claw(HardwareMap hardwareMap){
        claw = hardwareMap.get(Servo.class, "claw");
    }

    public void teleOp(double right, double left){
        if (right > .25){
            claw.setPosition(.40);
        } else if (left > .25){
            claw.setPosition(.60);
        } else {
            claw.setPosition(.5);
        }
    }
}
