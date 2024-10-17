// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ChargeShoot extends SequentialCommandGroup {
  private ShooterSubsystem m_shooterSub;
  private VictorSPX m_shooter;
  private VictorSPX m_compressor;  
  
  /** Creates a new ChargeShoot. */
  public ChargeShoot(ShooterSubsystem shootSub, VictorSPX shooter, VictorSPX charger) {
    m_shooterSub = shootSub;
    m_shooter = shooter;
    m_compressor = charger;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new Charge(m_shooterSub, m_compressor),
    new Shoot(m_shooterSub, m_shooter));
  }
}
