package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Lights {
    private RevBlinkinLedDriver lights;
    private boolean isFirstLoop;

    public Lights(HardwareMap hardwareMap){
        lights = hardwareMap.get(RevBlinkinLedDriver.class,"lights");
        lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.VIOLET);

        isFirstLoop = true;
    }

    public void teleOp(ElapsedTime timer, double forward, double strafe, double turn){
        if (isFirstLoop && (forward != 0 || strafe != 0 || turn != 0)){
            // Reset the timer and add telemetry to show this
            timer.reset();
            this.isFirstLoop = false;
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLUE_VIOLET);
        }

        // If the timer reaches 60 seconds and is less than 90 seconds, switch to the next pattern
        else if (timer.seconds()>=60 && timer.seconds()<90){
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.GREEN);
        }

        // If the timer reaches 90 seconds, signal that it is now end game
        else if (timer.seconds()>=90 && timer.seconds()<105){
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.RED);
        }

        else if (timer.seconds()>=105){
            lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.SHOT_RED);
        }
    }
}
