// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.RobotMap;
import org.usfirst.frc812.BB9.subsystems.DrivelineSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc812.BB9.Robot;

/**
 *
 */
public class AutonomousCommand extends Command {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public AutonomousCommand() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);
	}
        
//           else if(Robot.controlBoxSubsystem.isSet(1)) {		//Right on 3-way switch
//           	System.out.println("Starting on right");
//           	//Program to deliver gear if we start on right side
//           }
//           else if(Robot.controlBoxSubsystem.isSet(2)) {		//Middle on 3-way switch
//           	System.out.println("Starting in middle");
//           	//Program to deliver gear if we start in middle
//           }
//           else if(Robot.controlBoxSubsystem.isSet(3)) {		//Left on 3-way switch
//           	System.out.println("Starting on left");
//           	//Program to deliver gear if we start on left side
//           }
//           
//       	RobotMap.dtProductionRobotDrive.drive(0, 0);
//       	RobotMap.dtProductionRobotDrive.setExpiration(0.1);
//       	RobotMap.gyro.reset();
//       	DrivelineSubsystem.leftEnc.reset();
     //  	DrivelineSubsystem.rightEnc.reset();     
    // Called just before this Command runs the first time
	protected void initialize() {
		Robot.controlBoxSubsystem.readBits();
		System.out.println("Auto: initialize");
		Robot.controlBoxSubsystem.printBits();
		
		// time out in 3 seconds, making isFinished() return true
		this.setTimeout(3);
		// Robot.drivelineSubsystem.rightEnc.reset();
		// DrivelineSubsystem.leftEnc.reset();
		// How long is it to drive in autonomous?
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.controlBoxSubsystem.isSet(7)) { // Drive forward
			// Program to drive forward 5 feet
			// Stops when isFinished() returns true
			System.out.println("Driving Forward autonomously");
			RobotMap.dtProductionRobotDrive.drive(0.5, 0);
		}
	}

	// double angle;
	// Robot.controlBoxSubsystem.readBits();
	// if(Robot.controlBoxSubsystem.isSet(4)) { //Normal
	// RobotMap.dtProductionRobotDrive.drive(1.00,
	// Robot.gyroSubsystem.calcCurve()); // straight
	// }
	//
	// else if(Robot.controlBoxSubsystem.isSet(5)) { //Moats
	// RobotMap.dtProductionRobotDrive.drive(1.00,
	// Robot.gyroSubsystem.calcCurve()); // straight
	// }
	// else if(Robot.controlBoxSubsystem.isSet(6)) { //Cheval
	// RobotMap.dtProductionRobotDrive.drive(1.00,
	// Robot.gyroSubsystem.calcCurve()); // straight
	// }
	// else{
	// RobotMap.dtProductionRobotDrive.drive(1.00,
	// Robot.gyroSubsystem.calcCurve()); // straight
	// }
	// // Robot.gyroSubsystem.showPosition();
	// } THIS IS FOR GYRO, CHANGE TO INPUT METHOD OF CHOICE

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut() || Robot.drivelineSubsystem.rightCounter.get() > 1000;
	}

	// Called once after isFinished returns true
	protected void end() {
		RobotMap.dtProductionRobotDrive.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}