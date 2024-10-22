	package com_patiente_details;
	import java.util.*; 
	public class Patient_Factory 
	{
	 
		public static int generateOTP()
		{
			Random random = new Random();
			int otp = random.nextInt(1000,9999);
			return otp;
		}
		public static void displayOptions()
		{
		 System.out.println("Select a below Option...");
		 System.out.println("1.Enroll a patint");
		 System.out.println("2.Discharge the patient");
		 System.out.println("3.Update the patient Details");
		 System.out.println("4.Display all Patient Details");
		 System.out.println("5.Exit");
		}
		public static Patient enrollPatient()
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Patient Name");
			String name = sc.next();			
			System.out.println("Enter the Patient Age");
             int age = sc.nextInt();
			System.out.println("Enter the Patient Disease");
			String disease = sc.next();
			System.out.println("Enter the Patient Status");
			String status = sc.next();
			return new Patient(name,age,disease,status);
		}
		public static void displayAllPatient(Patient p)
		{
//			Patient p = new Patient();
			System.out.println(p.getPatient_name() + " " + p.getPatient_age() + " "+ p.getDisease() + " " + p.getStatus());
		}
		public static void updateStatus(List<Patient> patientList,String name,String newStatus)
		{
		  boolean condn = false;
		  for(Patient patient : patientList)
		  {
			  if(patient.getPatient_name().equalsIgnoreCase(name))
			  {
				  patient.setStatus(newStatus);
				  condn=true;
			  }
		  }
		  if(condn==true)
		  {
			  System.out.println("Patient status update successfully ************");
		  }
		  else
		  {
			 System.out.println("patient Not Found");
		  }
		}
		public static void removePatient(List<Patient> patientList,String name)
	{
		boolean condn = false;
		Iterator<Patient> itr = patientList.iterator();
		while(itr.hasNext())
		{
			Patient patient = itr.next();
			if(patient.getPatient_name().equalsIgnoreCase(name))
			{
				itr.remove();
				condn=true;
			}
		}
		if(condn==true)
		{
			System.out.println(("Patient remove successfully"));
		}
		else
		{
			System.out.println("Patient not found");
		}
	}
	}