package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private final RomiController intakeMotor = new RomiController(4);
    private final RomiController liftMotor = new RomiController(3);
   
    public void m_intake(double speed){
      intakeMotor.set(speed);
   }
    public void m_lift(double speed){
       liftMotor.set(speed);
    }
 
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}
