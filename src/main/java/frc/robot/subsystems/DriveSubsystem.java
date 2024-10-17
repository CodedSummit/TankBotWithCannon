// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    private DifferentialDrive m_robotDrive;

  private final VictorSPX m_leftMotor = new VictorSPX(1);
  private final VictorSPX m_rightMotor = new VictorSPX(2);
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    SendableRegistry.addChild(m_robotDrive, m_leftMotor);
    SendableRegistry.addChild(m_robotDrive, m_rightMotor);

    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_rightMotor.setInverted(true);

    m_robotDrive = new DifferentialDrive(
      (p) -> {m_leftMotor.set(VictorSPXControlMode.PercentOutput, p);}, 
      (p) -> {m_rightMotor.set(VictorSPXControlMode.PercentOutput, p);}
    );
  }
  
public void Drive(double left, double right) {
    System.out.println("Drive Values " + left +" " + right);
    m_robotDrive.tankDrive(left, right);
  }
}