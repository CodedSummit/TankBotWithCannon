// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;

public class Charge extends Command {
  private ShooterSubsystem m_shooterSub;
  private VictorSPX m_charger;
  /** Creates a new Charge. */
  public Charge(ShooterSubsystem shooterSubsystem, VictorSPX charger) {
    m_shooterSub = shooterSubsystem;
    m_charger = charger;
    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_charger.set(VictorSPXControlMode.PercentOutput, 1.0);
    new WaitCommand(Constants.compressionTime);
    m_charger.set(VictorSPXControlMode.PercentOutput, 0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
