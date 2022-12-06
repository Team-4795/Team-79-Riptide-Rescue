// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  // TO-DO Create two PWMTalonSRX motor controllers
  private final RomiController m_leftMotor = new RomiController(6);
  private final RomiController m_rightMotor = new RomiController(5);

  // TO-DO Set up the differential drive controller
  private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    //m_leftMotor.setInverted(true);

    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
     if(zaxisRotate<0) m_diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
     if(zaxisRotate>0) m_diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);


    //m_diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
    //TO-DO Call the arcade drive method
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
