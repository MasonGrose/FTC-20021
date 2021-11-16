package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "AutoMove", group = "")
public class AutoMove extends LinearOpMode {

  private DcMotor backLeft;
  private DcMotor frontLeft;
  private DcMotor backRight;
  private DcMotor frontRight;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    backLeft = hardwareMap.dcMotor.get("backLeft");
    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    backRight = hardwareMap.dcMotor.get("backRight");
    frontRight = hardwareMap.dcMotor.get("frontRight");

    // Put initialization blocks here.
    waitForStart();
    frontLeft.setPower(-1);
    frontRight.setPower(1);
    backLeft.setPower(1);
    backRight.setPower(1);
    sleep(1500);
  }
}
