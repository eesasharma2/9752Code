// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.Commands.SmartIntake;
import frc.robot.Commands.SmartOutake;
import frc.robot.Commands.SmartShooter;
import frc.robot.Constants.Constants;
import frc.robot.Subsystems.ArmSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;
import frc.robot.Subsystems.TransferSubsystem;

public class RobotContainer {
  public IntakeSubsystem intake = new IntakeSubsystem();
  public TransferSubsystem transfer = new TransferSubsystem();
  public ShooterSubsystem shooter = new ShooterSubsystem();
  public ArmSubsystem arm = new ArmSubsystem();
  public CommandPS5Controller base1 =  new CommandPS5Controller(0);
  public CommandPS5Controller base2 = new CommandPS5Controller(1);
  
  public RobotContainer() {
    intake.setDefaultCommand(intake.intakeDefault());
    transfer.setDefaultCommand(transfer.transferDefault());
    shooter.setDefaultCommand(shooter.shooterDefault());
    configureBindings();
  }

  

  private void configureBindings() {
    base1.R2().whileTrue(new SmartIntake(intake, transfer, arm));
    base2.R2().whileTrue(new SmartIntake(intake, transfer, arm));
    base2.circle().whileTrue(new SmartShooter(shooter, transfer));
    base2.circle().onTrue(arm.SetArmToPos(Constants.spkPos));
    base2.circle().onFalse(arm.SetArmToPos(Constants.basePos));
    base1.L2().whileTrue(new SmartOutake(intake, transfer, shooter));
    base2.L2().whileTrue(new SmartOutake(intake, transfer, shooter));
    base2.povUp().onTrue(arm.SetArmToPos(Constants.ampPos));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
