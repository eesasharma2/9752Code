// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Constants.ShooterPIDConstants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private final CANSparkFlex shootermotor_1 = new CANSparkFlex(20, MotorType.kBrushless);
  private final CANSparkFlex shootermotor_2 = new CANSparkFlex(21, MotorType.kBrushless);

  //TalonFXConfiguration shooterConfigs = new TalonFXConfiguration();
  
  Slot0Configs slot0Configs = new Slot0Configs();
  MotionMagicConfigs motionMagicConfigs = new MotionMagicConfigs();
  MotionMagicVoltage request = new MotionMagicVoltage(0).withSlot(0);
  private final Servo exampleServo = new Servo(9);

  public boolean shooterRPMreached = false;


  public ShooterSubsystem() {
    slot0Configs.kP = ShooterPIDConstants.kP; 
    slot0Configs.kI = ShooterPIDConstants.kI; 
    slot0Configs.kD = ShooterPIDConstants.kD;

    motionMagicConfigs.MotionMagicCruiseVelocity = 80;
    motionMagicConfigs.MotionMagicAcceleration = 100;
    motionMagicConfigs.MotionMagicJerk = 1600;
  }

  public void setShooterRPM1(double setRPM) {
    shooterRPMreached = false;
    shootermotor_1.set(setRPM);
    shooterRPMreached = true;
  }
  public void setShooterRPM2(double setRPM) {
    shooterRPMreached = false;
    shootermotor_2.set(setRPM);
    shooterRPMreached = true;
  }

  public Command shooterDefault(){
    return run(
    () -> {
      shootermotor_1.set(0);
      shootermotor_2.set(0);
      exampleServo.set(0);
    });
  }

  public void servoPosition(double position) {
    exampleServo.set(position);
  }

    public Command servoPostion() {
    return run(
      () -> {
        exampleServo.set(.45);
      }
    );
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //public void setShooter(double speed) {
   // shootermotor_1.set(speed);
    //shootermotor_2.set(speed*0.9);
 // }

}

