package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Mecanum Drive", group="teleop")
public class MecanumDrive extends LinearOpMode {
    private DcMotor backLeft;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor frontRight;
    private DcMotor liftBack;
    private Servo duckServo;
    private DcMotor liftFront;
    @Override
    public void runOpMode(){
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        liftBack = hardwareMap.dcMotor.get("liftBack");
        liftFront = hardwareMap.dcMotor.get("liftFront");
        duckServo = hardwareMap.get(Servo.class, "duckServo");

        waitForStart();
        while (opModeIsActive()) {
            double horizontal = 0.7 * gamepad1.left_stick_x;
            double vertical = -0.7 * gamepad1.left_stick_y;
            double turn = -0.7 * gamepad1.right_stick_x;
            double liftSet1 = 0.7 * gamepad2.left_stick_x;
            double liftSet2 = 0.3 * gamepad2.right_stick_x;

            if(gamepad2.a){
                duckServo.setPosition(-1);
            }
            if(gamepad2.b){
                duckServo.setPosition(0.5);
            }

            liftBack.setPower(liftSet1);
            liftFront.setPower(liftSet2);
            backLeft.setPower(vertical + turn - horizontal);
            frontLeft.setPower(vertical + turn + horizontal);
            backRight.setPower(vertical - turn + horizontal);
            frontRight.setPower(vertical - turn - horizontal);

            telemetry.update();
        }
    }
}
