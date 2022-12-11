// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.DriveTime;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lift;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.LiftCommand;
import frc.robot.commands.IntakeCommand;
//import frc.robot.commands.AutonomousDistance;
//import frc.robot.commands.AutonomousTime;
//import edu.wpi.first.wpilibj2.command.button.Button;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
 // private final Intake cnt_Intake = new Intake();
  private final Intake intake = new Intake();
  private final Lift lift = new Lift();


  private final Joystick m_controller = new Joystick(0);
  // Create SmartDashboard chooser for autonomous routines
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() { 
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
    m_drivetrain.setDefaultCommand(getArcadeDriveCommand());
    intake.setDefaultCommand(new IntakeCommand(intake, 0));
    lift.setDefaultCommand(new LiftCommand(lift, 0));

    // if 7 and 6 doesnt work switch to 3 and 1

    final JoystickButton intakeButton = new JoystickButton(m_controller, 7);
    final JoystickButton intakeButtonReverse = new JoystickButton(m_controller, 6);
    final JoystickButton liftButtonReverse =  new JoystickButton(m_controller, 2);
    final JoystickButton liftButton =  new JoystickButton(m_controller, 4);
   
    intakeButton.whileHeld(new IntakeCommand(intake, -0.75));
    intakeButtonReverse.whileHeld(new IntakeCommand(intake, 0.75));
    liftButton.whileHeld(new LiftCommand(lift,-0.80));
    liftButtonReverse.whileHeld(new LiftCommand(lift,0.80));

    SmartDashboard.putData(m_chooser);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      new DriveTime(0.80, 3, m_drivetrain)); 
      //return m_chooser.getSelected();


  }
  

  /**
   * Use this to pass the teleop command to the main {@link Robot} class.
   *
   * @return the command to run in teleop
   */
  public Command getArcadeDriveCommand() {
    return new ArcadeDrive(
        m_drivetrain, () -> -m_controller.getRawAxis(1), () -> m_controller.getRawAxis(2));
       //m_drivetrain, () -> m_controller.getPOV(2), () -> m_controller.getRawAxis(1));
      
  }
}
