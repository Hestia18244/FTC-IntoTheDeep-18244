package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    private DcMotorEx arm;

    public Arm(HardwareMap hardwareMap){
        arm = hardwareMap.get(DcMotorEx.class, "arm");
    }

    public void teleOp(double armPower){
        arm.setPower(armPower - .05);
    }

}
