// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private final TalonFX intakemotor = new TalonFX(15, "static");

  public IntakeSubsystem() {

  }

  public Command intakeDefault(){
    return run(
    () -> {
      intakemotor.set(0);
    });
  }




  @Override
  public void periodic() {
     //This method will be called once per scheduler run
  }

  

  public void setIntake(double speed) {
    intakemotor.set(speed);
  }
}
