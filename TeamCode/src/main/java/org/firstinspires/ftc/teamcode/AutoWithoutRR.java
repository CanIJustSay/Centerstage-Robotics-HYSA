
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto", group=" ")
public class AutoWithoutRR extends LinearOpMode{

    /**
     * class must extend "LinearOpMode" in order to apply telemetry
     * also to apply other classes such as "gamepad" and hardwaremap
     **/

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;

    public void runOpMode() throws InterruptedException{
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        //oriented facing the back of the bot
        leftFront  = hardwareMap.get(DcMotor.class, "left_drive");
        rightBack = hardwareMap.get(DcMotor.class, "right_drive");
        leftBack  = hardwareMap.get(DcMotor.class, "left_drive");
        rightFront = hardwareMap.get(DcMotor.class, "right_drive");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();


        /**
         * find the tpr for the motors
         * convert that to inches or something of the sort? useful??
         * set up roadrunner and opencv
         * hopefully the "sleep" function is highly accurate..
         * measure trackwidth of bot -- important for roadrunner
         */

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            if(leftFront.isBusy()){
                telemetry.addData("Testing the boolean",true);
            }
            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
