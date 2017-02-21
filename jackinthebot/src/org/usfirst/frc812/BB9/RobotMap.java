// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc812.BB9;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainRtFront;
    public static SpeedController driveTrainRtBack;
    public static SpeedController driveTrainLftFront;
    public static SpeedController driveTrainLftBack;
    public static SpeedController dtRight2;
    public static SpeedController dtRight1;
    public static SpeedController dtLeft2;
    public static SpeedController dtLeft1;
    public static SpeedController gathererMotor;
    public static RobotDrive dtProtoRobotDrive;
    public static RobotDrive dtProductionRobotDrive;
    public static Compressor compressor;
    public static Solenoid leftSolenoid;
    public static Solenoid rightSolenoid;
    //public static DoubleSolenoid shifter;
    public static DoubleSolenoid shifter;
    public static DoubleSolenoid shootRight;
    public static DoubleSolenoid ballGatherer;
    public static Servo cameraHorizontal;
    public static Servo cameraVertical;
    public static AnalogGyro gyro; 
    public static Joystick controlBox;
   // public static DigitalInput grabberSensor;
    public static DigitalInput climberSensor;
    	
    
    //ultrasonic sensor
    public static AnalogInput ultraSensor;
    public static AnalogInput analogPot;
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	/*
        driveTrainRtFront = new Talon(0);
        LiveWindow.addActuator("Drive Train", "RtFront", (Talon) driveTrainRtFront);
        
        driveTrainRtBack = new Talon(1);
        LiveWindow.addActuator("Drive Train", "RtBack", (Talon) driveTrainRtBack);
        
        driveTrainLftFront = new Talon(2);
        LiveWindow.addActuator("Drive Train", "LftFront", (Talon) driveTrainLftFront);
        
        driveTrainLftBack = new Talon(3);
        LiveWindow.addActuator("Drive Train", "LftBack", (Talon) driveTrainLftBack);
  
        dtProtoRobotDrive = new RobotDrive(driveTrainLftFront, driveTrainLftBack,
              driveTrainRtFront, driveTrainRtBack);
                      // if we want to reverse the understanding of the motors, something like the following
        // is advised for each of the motors.
        //   driveTrainRobotDrive41.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false); 

        
        dtProtoRobotDrive.setSafetyEnabled(true);
        dtProtoRobotDrive.setExpiration(0.1);
        dtProtoRobotDrive.setSensitivity(0.5);
        dtProtoRobotDrive.setMaxOutput(1.0);


		*/
    	
    	
        // Production robot uses CAN bus Talon SRX speed controllers
    	dtLeft1 = new CANTalon(2);
    	dtLeft2 = new CANTalon(3);
        dtRight1 = new CANTalon(4);
        dtRight2 = new CANTalon(5);
        dtLeft1.setInverted(true);
        dtLeft2.setInverted(true);
        dtRight1.setInverted(true);
        dtRight2.setInverted(true);

        
        // front left, rear left, front right, rear right
        dtProductionRobotDrive = new RobotDrive(dtLeft1, dtLeft2, 
        		dtRight1, dtRight2);

        dtProductionRobotDrive.setSafetyEnabled(true);
        dtProductionRobotDrive.setExpiration(0.1);
        dtProductionRobotDrive.setSensitivity(0.5);
        dtProductionRobotDrive.setMaxOutput(1.0);
        
        gathererMotor = new CANTalon(6);        


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
      compressor = new Compressor(8);
      shifter = new DoubleSolenoid(0,0,1);
      shootRight = new DoubleSolenoid(8,1,3);
      ballGatherer = new DoubleSolenoid(8,4,5);
      gyro = new AnalogGyro(0);
      controlBox = new Joystick(2);
      
      //ultrasonic sensor
      ultraSensor = new AnalogInput(1);
      analogPot = new AnalogInput(2);
      
      cameraHorizontal = new Servo(9);
      cameraVertical = new Servo(8);
      
      //grabberSensor = new DigitalInput(5);
      
      // climbing limit switches
      climberSensor = new DigitalInput(9);
      
    }
}
