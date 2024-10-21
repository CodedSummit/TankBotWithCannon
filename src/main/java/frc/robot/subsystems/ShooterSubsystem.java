// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  public final VictorSPX m_shooter = new VictorSPX(4);
  public final VictorSPX m_compressor = new VictorSPX(3);

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    release();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  protected void charge(){
    System.out.println("Charge.execute");
    m_compressor.set(VictorSPXControlMode.PercentOutput, 1.0);
    try{
      Thread.sleep(Constants.compressionTime);}
    catch (Exception e){};
    m_compressor.set(VictorSPXControlMode.PercentOutput, 0.0);
  }

  public void shoot(){
    charge();
    release();
  }

  public void release(){
    m_shooter.set(VictorSPXControlMode.PercentOutput, 1.0);
    try{
      Thread.sleep(Constants.shootTime);}
    catch (Exception e){};
    m_shooter.set(VictorSPXControlMode.PercentOutput, 0.0);
  }
  }


