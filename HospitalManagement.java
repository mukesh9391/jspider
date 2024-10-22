package com_patiente_details;
import java.util.*;
public class HospitalManagement 
{
public static void main(String[] args) 
{
	System.out.println("Welcome to Hospital Mangament Application🛏️🛏️🛏️🛏");
	System.out.println("Please Login to the Application");
	System.out.println("Enter your mobile number📱📱");
	Scanner sc = new Scanner(System.in);
	long mobileNumber = sc.nextLong();
	if ((mobileNumber>999999999l && mobileNumber<99999999999l) &&
			(mobileNumber>6000000000l||mobileNumber>7000000000l||mobileNumber>8000000000l||mobileNumber>9000000000l))
	{
		Random random = new Random();
		int otp = Patient_Factory.generateOTP();
		System.out.println("Your OTP is : " + otp);
		System.out.println("Enter the OTP");
		int inputOTP = sc.nextInt();
		if(inputOTP==otp)
		{
			System.out.println("Login successfull.....👍👍");
			List<Patient> patientList = new ArrayList();
			boolean condn = true;
			while(condn)
			{
				Patient_Factory.displayOptions();
				 int option = sc.nextInt();
				switch(option)
				{
				case 1 : {
					Patient patient = Patient_Factory.enrollPatient();
					patientList.add(patient);
					System.out.println("Patient enrollment successfull👍👍");
				} break;
				case 2 : {
					if(patientList.isEmpty())
					{
						System.out.println("*NO DATA FOUND");
					}
					else
					{
						System.out.println("Enter the patient name");
						String patientName = sc.next();
						Patient_Factory.removePatient(patientList, patientName);
					}
				} break;
				case 3 : {
					if(patientList.isEmpty())
					{
						System.out.println("*NO DATA FOUND");
					}
					else
					{
						System.out.println("Enter the patient name");
						String patientName = sc.next();
						System.out.println("Enter the newpatient status");
						String newStatus = sc.next();
						Patient_Factory.updateStatus(patientList, patientName, newStatus);
					}
				} break;
				case 4 : {
					System.out.format("%-10s %-5s %-10s %-10s","NAME","AGE","DISEASE","STATUS");
					System.out.println();
					System.out.println("--------------------------------------------------------------------------");
					for(Patient p : patientList)
					{
						System.out.format("%-10s %-5s %-10s %-10s",p.getPatient_name(),p.getPatient_age(),p.getPatient_age(),p.getStatus());
//						Patient_Factory.displayAllPatient(p);
					}
					
				} break;
				case 5 : {
					condn  = false;
					System.out.println("Logout Successfull\nVisit Again");
				} break;
				default : {System.out.println("Invalid Option\nTry Again Later");}
				}
			}
		}
		else
		{
			System.out.println("Invalid OTP❌❌ \nplease try again later");
		}	
	}
	else
	{
		System.out.println("Invalid mobile Number");
	}
}
}
