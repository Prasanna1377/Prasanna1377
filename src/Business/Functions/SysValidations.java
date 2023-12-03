/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Functions;

/**
 *
 * @author aayush
 */
import Business.NetworkHelp;
import Business.Enterprises.Enterprise;
import Business.Networks.Network;
import Business.Organizations.*;
import Business.Organizations.Org;
import Business.userAccount.Users;

import java.util.Calendar;
import java.util.Date;

public class SysValidations {
        public static boolean StringValidation(String name)
    {
        return true;
    }
    
    public static int ageCalculation(Date dateOfBirth)
    {
       try
       {     
        Calendar dob = Calendar.getInstance();
        dob.setTime(dateOfBirth);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR))
        age--;
        return age;
       }
       catch(Exception e)
       {
        return 0;   
       }
    }
    
    
    public static HelperOrg getHelperOrganizations(NetworkHelp environment, Users users)
    {
        HelperOrg helperOrg = null;
        try
        {
        for(Network network : environment.getNetworkList())
        {
         if(network.equals(users.getNetwork()))
         {
          for(Enterprise enterprise : network.getEnterprisesDirectory().getEnterprisesList())
          {
            if(enterprise.getEnterprisesType().equals(Enterprise.EnterprisesType.University))
            {
            for(Org org : enterprise.getOrganizationsDirectory().getOrganizationsList())
            {
             if(org instanceof HelperOrg)
             {
              helperOrg = (HelperOrg) org;
             }
            }
            }
          }
         }
        }
        }
        catch(NullPointerException npe)
        {
          npe.printStackTrace();
         return null;
        }
        return helperOrg;
    }
    
    public static HelperOrg getHelperOrganizationsInNw(NetworkHelp environment, Network nw)
    {
        HelperOrg helperOrg = null;
        try
        {
        for(Network network : environment.getNetworkList())
        {
         if(network.equals(nw))
         {
          for(Enterprise enterprise : network.getEnterprisesDirectory().getEnterprisesList())
          {
            if(enterprise.getEnterprisesType().equals(Enterprise.EnterprisesType.University))
            {
            for(Org org : enterprise.getOrganizationsDirectory().getOrganizationsList())
            {
             if(org instanceof HelperOrg)
             {
              helperOrg = (HelperOrg) org;
             }
            }
            }
          }
         }
        }
        }
        catch(NullPointerException npe)
        {
          npe.printStackTrace();
         return null;
        }
        return helperOrg;
    }
    
//      public static SponsorOrg getSponsorOrganizations(NetworkHelp environment, Users users)
//    {
//        SponsorOrg sponsorOrganizations = null;
//        
//        for(Network Network : environment.getNetworkList())
//        {
//         if(Network.equals(users.getNetwork()))
//         {
//          for(Enterprise enterprise : Network.getEnterprisesDirectory().getEnterprisesList())
//          {
//            if(enterprise.getEnterprisesType().equals(Enterprise.EnterprisesType.Charity))
//            {
//            for(Org org : enterprise.getOrganizationsDirectory().getOrganizationsList())
//            {
//             if(org instanceof SponsorOrg)
//             {
//              sponsorOrganizations = (SponsorOrg) org;
//             }
//            }
//            }
//          }
//         }
//        }
//        return sponsorOrganizations;
//    }
//      
//       public static TransportationOrg getTransportationOrganizations(NetworkHelp environment, Users users)
//    {
//        TransportationOrg transportationOrganizations = null;
//        
//        for(Network Network : environment.getNetworkList())
//        {
//         if(Network.equals(users.getNetwork()))
//         {
//          for(Enterprise enterprise : Network.getEnterprisesDirectory().getEnterprisesList())
//          {
//            if(enterprise.getEnterprisesType().equals(Enterprise.EnterprisesType.University))
//            {
//            for(Org org : enterprise.getOrganizationsDirectory().getOrganizationsList())
//            {
//             if(org instanceof TransportationOrg)
//             {
//              transportationOrganizations = (TransportationOrg) org;
//             }
//            }
//            }
//          }
//         }
//        }
//        return transportationOrganizations;
//    } 
       
     public static DoctorOrg getDoctorOrganizations(NetworkHelp environment, Users users)
    {
       DoctorOrg doctorOrg = null;
        try
        {
        for(Network network : environment.getNetworkList())
        {
         if(network.equals(users.getNetwork()))
         {
          for(Enterprise enterprise : network.getEnterprisesDirectory().getEnterprisesList())
          {
            if(enterprise.getEnterprisesType().equals(Enterprise.EnterprisesType.Hospital))
            {
            for(Org org : enterprise.getOrganizationsDirectory().getOrganizationsList())
            {
             if(org instanceof DoctorOrg)
             {
              doctorOrg = (DoctorOrg) org;
             }
            }
            }
          }
         }
        }
        }
        catch(NullPointerException npe)
        {
          npe.printStackTrace();
         return null;
        }
        return doctorOrg;
    }   
     
      public static ManagerOrg getManagerOrganizations(NetworkHelp environment, Users users)
    {
        ManagerOrg managerOrg = null;
        try
        {
        for(Network network : environment.getNetworkList())
        {
         if(network.equals(users.getNetwork()))
         {
          for(Enterprise enterprise : network.getEnterprisesDirectory().getEnterprisesList())
          {
            if(enterprise.getEnterprisesType().equals(Enterprise.EnterprisesType. HealthHub))
            {
            for(Org org : enterprise.getOrganizationsDirectory().getOrganizationsList())
            {
             if(org instanceof ManagerOrg)
             {
              managerOrg = (ManagerOrg) org;
             }
            }
            }
          }
         }
        }
        }
        catch(NullPointerException npe)
        {
          npe.printStackTrace();
         return null;
        }
        return managerOrg;
    }  
      
    
}
