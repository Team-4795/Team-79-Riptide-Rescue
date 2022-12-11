package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase{
   
    private final PWMVictorSPX liftMotor = new PWMVictorSPX(2);
   
  
    public void m_lift(double speed){
       liftMotor.set(speed);
    }
 
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}
