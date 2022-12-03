package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class IntakeCommand extends CommandBase {
    private final Intake thing;
    private double motorSpeed;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public IntakeCommand(Intake subsystem, double speed) {
      thing = subsystem;
      motorSpeed = speed;
     
      addRequirements(subsystem);
    }


    @Override
    public void initialize() {}


    @Override
    public void execute() {
        thing.m_intake(motorSpeed);
    }

    @Override
    public void end(boolean interrupted) {

    }


    @Override
    public boolean isFinished() {
      return false;
    } 


}