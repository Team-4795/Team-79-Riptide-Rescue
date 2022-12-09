package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private final PWMVictorSPX intakeMotor = new PWMVictorSPX(3);
   
    public void m_intake(double speed){
      intakeMotor.set(speed);
   }
    
 
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}
