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
       super.set(125.0*speed/232.0 + 57.0/232.0);
    }
 }