package frc.robot.commands;

import frc.robot.subsystems.Lift;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class LiftCommand extends CommandBase {
    private final Lift thing2;
    private double motorSpeed;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public LiftCommand(Lift subsystem, double speed) {
      thing2 = subsystem;
      motorSpeed = speed;
      // add execute here? wtf what kinda magic is this java?     
      addRequirements(subsystem);
    }


    @Override
    public void initialize() {}


    @Override
    public void execute() {
        thing2.m_lift(motorSpeed);
    }

    @Override
    public void end(boolean interrupted) {

    }


    @Override
    public boolean isFinished() {
      return false;
    } 


}