package com.example.roadrunnertesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class RoadRunnerTesting {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.toRadians(180), Math.toRadians(180), 16)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-36, -61, Math.toRadians(90)))
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
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
