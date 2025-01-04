package org.firstinspires.ftc.teamcode.hardware;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift {

    private DcMotorEx rightSlider, leftSlider;

    public Lift(HardwareMap hardwareMap){
        rightSlider = hardwareMap.get(DcMotorEx.class, "rightSlider");
        leftSlider = hardwareMap.get(DcMotorEx.class, "leftSlider");

        rightSlider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftSlider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightSlider.setDirection(DcMotorSimple.Direction.REVERSE);
        rightSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void teleOp(double slider){
        rightSlider.setPower(slider);
        leftSlider.setPower(slider);
    }

    public void test(double slider, boolean setZero, Telemetry telemetry){
        rightSlider.setPower(slider);
        leftSlider.setPower(slider);

        if (setZero){
            rightSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        telemetry.addLine("rightSlider pos: " + rightSlider.getCurrentPosition());
        telemetry.addLine("leftSlider pos" + leftSlider.getCurrentPosition());
        telemetry.update();
    }

    public class LiftUp implements Action {
        private boolean initialized = false;

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialized) {
                rightSlider.setPower(-0.5);
                leftSlider.setPower(-0.5);
                initialized = true;
            }

            double pos = leftSlider.getCurrentPosition();
            packet.put("liftPos", pos);
            if (pos > -1900.0) {
                return true;
            } else {
                rightSlider.setPower(-0.0025);
                leftSlider.setPower(-0.0025);
                return false;
            }
        }
    }

    public Action liftUp() {
        return new LiftUp();
    }


    public class LiftDown implements Action {
        private boolean initialized = false;

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialized) {
                rightSlider.setPower(+0.25);
                leftSlider.setPower(+0.25);
                initialized = true;
            }

            double pos = leftSlider.getCurrentPosition();
            packet.put("liftPos", pos);
            if (pos < -100.0) {
                return true;
            } else {
                rightSlider.setPower(0);
                leftSlider.setPower(0);
                return false;
            }
        }
    }

    public Action liftDown(){
        return new LiftDown();
    }

}
