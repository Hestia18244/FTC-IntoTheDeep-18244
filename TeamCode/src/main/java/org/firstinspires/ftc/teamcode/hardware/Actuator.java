package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Actuator {
    private DcMotorEx linearActuator;

    public Actuator(HardwareMap hardwareMap){
        linearActuator = hardwareMap.get(DcMotorEx.class, "linearActuator");

        linearActuator.setDirection(DcMotorSimple.Direction.REVERSE);
        linearActuator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void teleOp(double actuator){
        linearActuator.setPower(actuator);
    }
}
