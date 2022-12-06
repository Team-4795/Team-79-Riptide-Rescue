// Copyright (c) FIRST and other WPILib contributors.
 // Open Source Software; you can modify and/or share it under the terms of
 // the WPILib BSD license file in the root directory of this project.
 package frc.robot.subsystems;
 import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
 /** Add your docs here. */
 public class RomiController extends PWMSparkMax {
    public RomiController(int channel) {
       super(channel);
    }
    @Override
    public void set(double speed) {
      if (speed > 0) {
         super.set(speed-.17);
      } else if (speed < 0) {
         super.set(speed+.17);
      } else {
         super.set(speed);
      }
    }
 }