package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.SampleMecanumDrive;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(49, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36.00, -67.79, Math.toRadians(90.00)))
                                .splineTo(new Vector2d(-35.82, -43.38), Math.toRadians(89.59))
                                .splineTo(new Vector2d(-34.42, -26.34), Math.toRadians(89.60))
                                .splineTo(new Vector2d(-39.51, -12.82), Math.toRadians(170.29))
                                .splineToLinearHeading(new Pose2d(-55.32, -13.00, Math.toRadians(180.00)), Math.toRadians(180.00))
                                .splineToConstantHeading(new Vector2d(-6.67, -12.64), Math.toRadians(2.37))
                                .setReversed(true)
                                .splineTo(new Vector2d(27.75, -12.64), Math.toRadians(4.59))
                                .splineTo(new Vector2d(58.48, -11.59), Math.toRadians(1.78))
                                .build()
                );



        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}