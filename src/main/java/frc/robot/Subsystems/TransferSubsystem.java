// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TransferSubsystem extends SubsystemBase {
  /** Creates a new TransferSubsystem. */
  private final TalonFX transfermotor = new TalonFX(20);
  
  public TransferSubsystem() {}

  public Command transferDefault(){
    return run(
    () -> {
      transfermotor.set(0);
    });
  }

  public Command transfer(){
    return run(
      () -> {
        transfermotor.set(1);
      });
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setTransfer(double speed) {
    transfermotor.set(speed);
  }
}
