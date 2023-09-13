package org.firstinspires.ftc.teamcode;

//import com.acmerobotics.roadrunner.mecanum.MecanumDrive;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous(name = "LineTwiceAuto", group = "Autonomous")
public class AutoRR extends LinearOpMode {

    private SampleMecanumDrive drive;



        @Override
        public void runOpMode() {
            // Initialize the drive system
            drive = new SampleMecanumDrive(hardwareMap);

            // Wait for the start button to be pressed
            waitForStart();

            // Define start pose and target position
            Pose2d startPose = new Pose2d(0, 0, 0);
            Pose2d targetPose = new Pose2d(24, 0, 0); // First movement: Move forward 24 inches


            //you can define another motor movement, as well as servo here.

            // Define and follow a trajectory to the target position
            drive.followTrajectory(drive.trajectoryBuilder(startPose)
                    .lineTo(targetPose.vec())
                    .build()
            );

            //you can stop the movement here, once it reaches the target position

            // Pause briefly before returning to the starting position
            sleep(1000);

            // Define and follow a trajectory to return to the starting position
            drive.followTrajectory(
                    drive.trajectoryBuilder(targetPose)
                            .lineTo(startPose.vec())
                            .build()
            );

            // Pause briefly before the second movement
            sleep(1000);

            // Define a new target position for the second movement
            targetPose = new Pose2d(24, 24, 0); // Second movement: Move diagonally

            // Define and follow a trajectory for the second movement
            drive.followTrajectory(
                    drive.trajectoryBuilder(startPose)
                            .lineTo(targetPose.vec())
                            .build()
            );

            // Update telemetry or provide feedback
            telemetry.addData("Status", "Autonomous complete");
            telemetry.update();

            // End the OpMode
            while (opModeIsActive()) {
                // Keep the OpMode active but idle
                idle();
            }

        }
}