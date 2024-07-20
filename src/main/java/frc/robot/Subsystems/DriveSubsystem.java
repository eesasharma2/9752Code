// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  public final TalonFX FLdrive = new TalonFX(0,"static");
  public final TalonFX FRdrive = new TalonFX(0,"static");
  public final TalonFX BLdrive = new TalonFX(0,"static");
  public final TalonFX BRdrive = new TalonFX(0,"static");
  public DriveSubsystem() {}

  public Command driveDefault(){
    return run(
      () -> {
        FLdrive.set(0);
        FRdrive.set(0);
        BLdrive.set(0);
        BRdrive.set(0);
      });
  }
public void setDrive(double speed){
  FRdrive.set(speed);
  FLdrive.set(speed);
  BRdrive.set(speed);
  BLdrive.set(speed);
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
