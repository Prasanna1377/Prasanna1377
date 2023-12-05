package ui.Controller;

import Business.NetworkHelp;
import Business.Functions.SysValidations;
import Business.Enterprises.Enterprise;
import Business.Organizations.*;
//import Business.Organizations.TransportationOrg;
import Business.RequestFramework.*;
import Business.userAccount.Users;
import Business.RequestFramework.RequestFramework;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author patil
 */
public class ControllerWorkArea extends javax.swing.JPanel {
    private JPanel userProcessContainer;
   private Enterprise enterprise;
   private NetworkHelp environment;
   private Users users;
   private HelperOrg ho;
//    private SponsorOrg so1 ;
    private PatientOrg hsOrg;
//    private TransportationOrg transOrg;
    private List<Entry<String, Integer>> topHelperList;
     private List<Entry<String, Integer>> topSponsorList;
    
    /**
     * Creates new form HeartHelpEnterpriseManagerWorkArea
     */
    public ControllerWorkArea(JPanel userProcessContainer, Enterprise enterprise, NetworkHelp environment, Users users) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.environment = environment;
        this.users = users;
        valueLabel.setText(enterprise.getName());
      //  setBackground(new Color(182,201,233));
        populatePieChartData();
        populateTextFields();
        
        viewDetailedReportBtn.setVisible(false);
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        
         Color c1 = new Color(210,240,114);
         Color c2 = new Color(210,240,114);
     
        GradientPaint gp = new GradientPaint(w/4, 0, c2, w/4, h, c1);
        setOpaque( false );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        setOpaque( true );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valueLabel = new javax.swing.JLabel();
        manageEnt1 = new javax.swing.JLabel();
        manageEnt2 = new javax.swing.JLabel();
        pieChartPanel = new javax.swing.JPanel();
        top3HelpersBtn = new javax.swing.JButton();
        totalHelpReq = new javax.swing.JLabel();
        totSenDevReq = new javax.swing.JLabel();
        totSenDevReqField = new javax.swing.JTextField();
        totHelpReqField = new javax.swing.JTextField();
        viewDetailedReportBtn = new javax.swing.JButton();

        valueLabel.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        valueLabel.setText("<value>");

        manageEnt1.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        manageEnt1.setText("Health Onboard Controller Dashboard");

        manageEnt2.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        manageEnt2.setText("Enterprise :");

        javax.swing.GroupLayout pieChartPanelLayout = new javax.swing.GroupLayout(pieChartPanel);
        pieChartPanel.setLayout(pieChartPanelLayout);
        pieChartPanelLayout.setHorizontalGroup(
            pieChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        pieChartPanelLayout.setVerticalGroup(
            pieChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        top3HelpersBtn.setBackground(new java.awt.Color(0, 153, 255));
        top3HelpersBtn.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        top3HelpersBtn.setForeground(new java.awt.Color(255, 255, 255));
        top3HelpersBtn.setText("View Top 3 Helpers");
        top3HelpersBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        top3HelpersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                top3HelpersBtnActionPerformed(evt);
            }
        });

        totalHelpReq.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        totalHelpReq.setText("Total No. of GetHelp Requests");

        totSenDevReq.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        totSenDevReq.setText("Total No. of Sensor Requests");

        totSenDevReqField.setEditable(false);
        totSenDevReqField.setBackground(new java.awt.Color(0, 153, 255));

        totHelpReqField.setEditable(false);
        totHelpReqField.setBackground(new java.awt.Color(0, 153, 255));

        viewDetailedReportBtn.setBackground(new java.awt.Color(0, 153, 255));
        viewDetailedReportBtn.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        viewDetailedReportBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewDetailedReportBtn.setText("View Detailed Report");
        viewDetailedReportBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewDetailedReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailedReportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageEnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(viewDetailedReportBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(top3HelpersBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(totalHelpReq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(manageEnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(totSenDevReq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totSenDevReqField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totHelpReqField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(pieChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(pieChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(manageEnt1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valueLabel)
                            .addComponent(manageEnt2))
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalHelpReq)
                            .addComponent(totHelpReqField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totSenDevReq)
                            .addComponent(totSenDevReqField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(top3HelpersBtn)
                        .addGap(57, 57, 57)
                        .addComponent(viewDetailedReportBtn)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void top3HelpersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_top3HelpersBtnActionPerformed
       findTop3Volunteers();
       if(topHelperList!=null && topSponsorList!=null && !(topHelperList.isEmpty()) && !(topSponsorList.isEmpty()) )
       {
       viewDetailedReportBtn.setVisible(true);
       }
    }//GEN-LAST:event_top3HelpersBtnActionPerformed

    private void viewDetailedReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailedReportBtnActionPerformed
       if(topHelperList == null || topSponsorList == null || topHelperList.isEmpty() && topSponsorList.isEmpty())
       {
        JOptionPane.showMessageDialog(null, " No Data to display as of now!","warning", JOptionPane.WARNING_MESSAGE);
        return;     
       }
        ViewDetailedReport vdrjp = new ViewDetailedReport(userProcessContainer, topHelperList, topSponsorList);
        userProcessContainer.add("ViewDetailedReportJPanel", vdrjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewDetailedReportBtnActionPerformed
    
      public void populateTextFields()
      {
          int totalHelpReq = 0;
          int totalTransportReq = 0;
          String totalDonorReq = "";
          int totalAmountDonated =0;
          try
          {
//      if(so1!=null){
//      totalDonorReq = String.valueOf(so1.getRequestPipeline().getRequestList().size());
//              
//        for(Users sponsorAccount : so1.getUserDirectory().getUserList())
//      {
//       if(!sponsorAccount.getRequestPipeline().getRequestList().isEmpty())
//       {
//         for(RequestFramework wrkrequest : sponsorAccount.getRequestPipeline().getRequestList())
//         {  
//           if(wrkrequest.getReqMessage().equalsIgnoreCase("Donated Money"))
//             {
//                 SponsorshipRequestFramework sponsorRequest = (SponsorshipRequestFramework)wrkrequest;
//                totalAmountDonated+= Integer.parseInt(sponsorRequest.getSponsorShip().getAmount());
//             }
//        
//          }
//         }
//         
//       }
//         } 
      if(ho!=null)
      {
          for(RequestFramework requestFramework : ho.getRequestPipeline().getRequestList())
          {
             if(requestFramework.getReqMessage().equalsIgnoreCase("Need GetHelp"))
             {
               totalHelpReq++;     
             }
             
             
           }
          for(Users users : ho.getUserDirectory().getUserList())
          {
           if(!users.getRequestPipeline().getRequestList().isEmpty())
           {
            for(RequestFramework req : users.getRequestPipeline().getRequestList())
            {
              if(req.getReqMessage().equalsIgnoreCase("Need GetHelp"))
             {
               totalHelpReq++;     
             }   
            }
           }
          }
      } 
//      if(transOrg!=null)
//      {
//           for(RequestFramework requestFramework : transOrg.getRequestPipeline().getRequestList())
//          {
//              if(requestFramework.getReqMessage().equals("Need Transport"))
//              {
//              totalTransportReq++;    
//              }
//          }
//      }   
          totHelpReqField.setText(String.valueOf(totalHelpReq));
          totSenDevReqField.setText(totalDonorReq);
//          totTransReqField.setText(String.valueOf(totalTransportReq));
//          donatedAmntField.setText(String.valueOf(totalAmountDonated));
          }
          catch(Exception e)
          {
         JOptionPane.showMessageDialog(null, " Data is not availble for few Org!","warning", JOptionPane.WARNING_MESSAGE);
         return;      
          }
      }
    
    public void populatePieChartData()
    {
       DefaultPieDataset dataSet = new DefaultPieDataset();
       int totalHelpSeekers = 0;
       int totalVolunteers = 0;
       int totalDonors = 0;
       int totalDrivers = 0;
       try
       {
       for(Org org : enterprise.getOrganizationsDirectory().getOrganizationsList())
       {
          if(org instanceof PatientOrg)
          {
          this.hsOrg = (PatientOrg) org;
           totalHelpSeekers = org.getPersonDirectory().getCustomerLsit().size();
          }
       }
       try
       {
         this.ho = SysValidations.getHelperOrganizations(environment, users);
       }
        catch(NullPointerException npe)
       {
        JOptionPane.showMessageDialog(null, " Voluteer Organination does not exist!","warning", JOptionPane.WARNING_MESSAGE);
        return; 
       }
       if(ho!=null)
       {
        totalVolunteers = ho.getPersonDirectory().getHelperList().size();
       }
        
//        this.so1 = SysValidations.getSponsorOrganizations(environment, users);
//        if(so1!=null)
//        {
//        totalDonors = so1.getPersonDirectory().getPersonList().size();
//        }
//        this.transOrg = SysValidations.getTransportationOrganizations(environment, users);
//        if(transOrg!=null)
//        {
//        totalDrivers = transOrg.getPersonDirectory().getPersonList().size();
//        }
         
         dataSet.setValue("Total No of GetHelp Seekers",totalHelpSeekers);
         dataSet.setValue("Total No of Volunteers", totalVolunteers );
//         dataSet.setValue("Total No of Donors",totalDonors);
//         dataSet.setValue("Total No of Drivers",totalDrivers);
//     
         JFreeChart  chart = ChartFactory.createPieChart3D("Pie Chart for "+ users.getNetwork().getCity(), dataSet, true, true, Locale.ENGLISH);
            chart.setBackgroundPaint(Color.WHITE);
            chart.getTitle().setPaint(Color.BLUE);
          ChartPanel chartpanel = new ChartPanel(chart);
        chartpanel.setDomainZoomable(true);

        pieChartPanel.setLayout(new BorderLayout());
        pieChartPanel.add(chartpanel, BorderLayout.EAST); 
        pieChartPanel.setVisible(true);
       }
       
       catch(NullPointerException npe)
       {
        JOptionPane.showMessageDialog(null, " No Data to display as of now!","warning", JOptionPane.WARNING_MESSAGE);
        return; 
       }
        
    }
    
    public void findTop3Volunteers()
    {
     int noOfRequests = 0;  
     HashMap<String, Integer> volMap = new HashMap<>(); 
      try
      {
     for(Users helperAccount : ho.getUserDirectory().getUserList())
      {
        if(!helperAccount.getRequestPipeline().getRequestList().isEmpty())
       {
         for(RequestFramework requestFramework : helperAccount.getRequestPipeline().getRequestList() )
         {
          if(requestFramework.getReqMessage().equalsIgnoreCase("Need GetHelp") &&
                  requestFramework.getStatusOfRequest().equalsIgnoreCase("Completed") )
          {
              HelpRequestFrameworkFramework nhwr = (HelpRequestFrameworkFramework) requestFramework;
          if(nhwr.getRequestOutcome().equalsIgnoreCase(ManagerRequestFrameworkFramework.REQUEST_ACCEPT))
          {
          ++noOfRequests;    
          }
          }
         }
          volMap.put(helperAccount.getPerson().getName(), noOfRequests);
          noOfRequests = 0;
         }
        
       }
     
          System.out.println("volMap >>>>>>" +volMap.toString());
            
          List<Entry<String, Integer>> list = new LinkedList<>(volMap.entrySet());
        
          Collections.sort(list, new Comparator<Entry<String, Integer>>()
            {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2)
            {
               if(o1.getValue()>o2.getValue())
               {
                return 1;
               }
                else if(o1.getValue()<o2.getValue())
                {
                    return -1;
                }
                return 0;
            }
             
            });
          Collections.reverse(list);
          System.out.println("After Sort "+list.toString());
          
          topHelperList = list;
          
          DefaultCategoryDataset  dataSet = new DefaultCategoryDataset();
          int count = 0;
        
            if(volMap.entrySet().size()<=3)
            {
           for (Entry<String, Integer> entry : list)
            {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
            dataSet.setValue(entry.getValue(), "No of GetHelp Requests", entry.getKey());
            }
            }
            else  if(volMap.entrySet().size()>3)
            {
            for (Entry<String, Integer> entry : list)
            {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
            dataSet.setValue(entry.getValue(), "No of GetHelp Requests", entry.getKey());
            count ++;
            if(count == 3)
            {
              break;
            }
            }
            }
             JFreeChart barchart = ChartFactory.createBarChart(" Top 3 Volunteers by no of Requests " ," Volunteer Name " ,"No of GetHelp Requests", dataSet,PlotOrientation.VERTICAL, false, true, false);
             barchart.setBackgroundPaint(Color.WHITE);
             barchart.getTitle().setPaint(Color.BLUE);
             CategoryPlot plot = barchart.getCategoryPlot();
             plot.setBackgroundPaint(Color.CYAN);
             
            ChartFrame frame = new ChartFrame("Bar Chart for Top 3 Volunteers ", barchart);
            frame.setVisible(true);
            frame.setSize(450,350);
            
      }
      catch(NullPointerException npe)
       {
        npe.printStackTrace();
        JOptionPane.showMessageDialog(null, " No Data to display as of now!","warning", JOptionPane.WARNING_MESSAGE);
        return; 
       
       }
      
    }
    
     public void findTop3Donors()
    {
        
//     int noOfRequests = 0;  
//     int donatedAmount = 0;
//     HashMap<String, Integer> donorMap = new HashMap<>(); 
//     HashMap<String, Integer> donorAmountMap = new HashMap<>();
//      try
//      {
//     if(so1 ==null)
//     {
//     JOptionPane.showMessageDialog(null, "Donor Organization does not exist!","warning", JOptionPane.WARNING_MESSAGE);
//        return;    
//     }
//     for(Users donorAccount : so1.getUserDirectory().getUserList())
//      {
//             System.out.println("request"+donorAccount.getName());
//        if(!donorAccount.getRequestPipeline().getRequestList().isEmpty())
//       {
//           System.out.println("request"+donorAccount.getName());
//        for(RequestFramework wrkrequest : donorAccount.getRequestPipeline().getRequestList() )
//         {  
//           if(wrkrequest.getReqMessage().equalsIgnoreCase("Donated Money"))
//             {
//                 SponsorshipRequestFramework donationRequest = (SponsorshipRequestFramework)wrkrequest;
//                donatedAmount+= Integer.parseInt(donationRequest.getSponsorShip().getAmount());
//               ++noOfRequests; 
//             }
//           if(wrkrequest.getReqMessage().equalsIgnoreCase("Need Sensor Device"))
//           {
//               SensorRequestFramework nsdwr = (SensorRequestFramework)wrkrequest;
//               if(nsdwr.getSponsorshipRequestOutcome().equalsIgnoreCase(ManagerRequestFrameworkFramework.REQUEST_ACCEPT))
//               {
//               ++noOfRequests; 
//               }
//           }
//          }
//          noOfRequests+=donatedAmount;  
//         donorMap.put(donorAccount.getPerson().getName(), noOfRequests);
//         noOfRequests=0;
//        }
//         
//       }
//
//         List<Entry<String, Integer>> list = new LinkedList<>(donorMap.entrySet());
//        
//          Collections.sort(list, new Comparator<Entry<String, Integer>>()
//            {
//            public int compare(Entry<String, Integer> o1,
//                    Entry<String, Integer> o2)
//            {
//               return o1.getValue().compareTo(o2.getValue());
//             }
//            });
//          Collections.reverse(list);
//          
//          topSponsorList = list;
//          
//          DefaultCategoryDataset  dataSet = new DefaultCategoryDataset();
//          int count = 0;
//        
//            if(donorMap.entrySet().size()<=3)
//            {
//           for (Entry<String, Integer> entry : list)
//            {
//            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
//            dataSet.setValue(entry.getValue(), "Values", entry.getKey());
//            }
//            }
//            else  if(donorMap.entrySet().size()>3)
//            {
//            for (Entry<String, Integer> entry : list)
//            {
//            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
//            dataSet.setValue(entry.getValue(), "Values", entry.getKey());
//            count ++;
//            if(count == 3)
//            {
//                break;
//            }
//            }
//            }
//             JFreeChart barchart = ChartFactory.createBarChart(" Top 3 Donors " ," Donor Name " ,"No of Requests", dataSet,PlotOrientation.VERTICAL, false, true, false);
//             barchart.setBackgroundPaint(Color.WHITE);
//             barchart.getTitle().setPaint(Color.BLUE);
//             CategoryPlot plot = barchart.getCategoryPlot();
//             plot.setBackgroundPaint(Color.CYAN);
//            ChartFrame frame = new ChartFrame("Bar Chart for Top 3 Donors ", barchart);
//            frame.setVisible(true);
//            frame.setSize(450,350);
//         
//      }
//      catch(NullPointerException npe)
//       {
//        JOptionPane.showMessageDialog(null, " No Data to display as of now!","warning", JOptionPane.WARNING_MESSAGE);
//        return; 
//       }
      
   }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel manageEnt1;
    private javax.swing.JLabel manageEnt2;
    private javax.swing.JPanel pieChartPanel;
    private javax.swing.JButton top3HelpersBtn;
    private javax.swing.JTextField totHelpReqField;
    private javax.swing.JLabel totSenDevReq;
    private javax.swing.JTextField totSenDevReqField;
    private javax.swing.JLabel totalHelpReq;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JButton viewDetailedReportBtn;
    // End of variables declaration//GEN-END:variables
}