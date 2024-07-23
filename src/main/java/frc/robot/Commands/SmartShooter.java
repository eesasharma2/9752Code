
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.ShooterSubsystem;
import frc.robot.Subsystems.TransferSubsystem;

public class SmartShooter extends Command {
  /** Creates a new SmartTransfer. */
  ShooterSubsystem shooter;
  TransferSubsystem transfer;
  //ShooterSubsystem exampleServo;
  //public CommandPS5Controller base1 =  new CommandPS5Controller(0);
  private final Timer timer;
  public SmartShooter(ShooterSubsystem s, TransferSubsystem t) {
    shooter = s;
    transfer = t;
    timer = new Timer();
    addRequirements(shooter, transfer);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.setShooter(1);
    if(timer.get() > .4) {
      shooter.servoPosition(0.35);
    }
    if(timer.get() > .7){
      transfer.setTransfer(1);
      }
    else {
      transfer.setTransfer(0);
    }
  }



public void periodic() {

}
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
