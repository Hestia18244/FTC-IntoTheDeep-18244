package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift {

    private DcMotorEx rightSlider, leftSlider;

    public Lift(HardwareMap hardwareMap){
        rightSlider = hardwareMap.get(DcMotorEx.class, "rightSlider");
        leftSlider = hardwareMap.get(DcMotorEx.class, "leftSlider");

        rightSlider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftSlider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightSlider.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void teleOp(double slider){
        rightSlider.setPower(slider);
        leftSlider.setPower(slider);
    }

}
