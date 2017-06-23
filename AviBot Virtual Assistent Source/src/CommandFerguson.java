
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.awt.Color;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arm_AVI
 */

public class CommandFerguson extends javax.swing.JFrame {

    //Text to Speech Recognition class
    /*
    class TextToVoice{
       VoiceManager voiceManager;
       Voice ttsPulation;
       //String stringRtn;
       public void generateVoice(String stringRtn){
         System.setProperty("mbrola.base", "mbrola/");
         voiceManager = VoiceManager.getInstance();
         ttsPulation = voiceManager.getVoice("mbrola_us1");
         ttsPulation.allocate();
         ttsPulation.speak(stringRtn);
       }
    }
    */
    
    private static final String VOICEAGENTNAME = "kevin16";  
    
    //TextToSpeech Class & Components
    class TextToSpeech{
      String word;
      VoiceManager voiceManager;
      Voice ttsPulation;
      TextToSpeech(String word){
         this.word = word;
         voiceManager = VoiceManager.getInstance();
         ttsPulation = voiceManager.getVoice(VOICENAME);
         ttsPulation.allocate();
         ttsPulation.speak(word);
      }
      
      @Override
      public String toString(){
          return word;
      }
    }
    

     //VoiceDetection Class & Components
    class VoiceDetection extends Thread{
        
       Configuration configuration = new Configuration();
       LiveSpeechRecognizer voiceRecognize;
       
       @Override
       public void run(){
         configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
         configuration.setDictionaryPath("knowledgeBase/test.dic");
         configuration.setLanguageModelPath("knowledgeBase/test.lm");
         
           try {
               voiceRecognize = new LiveSpeechRecognizer(configuration);
               } catch (IOException ex) {
           }
           
           voiceRecognize.startRecognition(true);
           SpeechResult vManupulation ;
           while((vManupulation = voiceRecognize.getResult()) != null){
             String voiceToText = vManupulation.getHypothesis();
              
             //Now Machine Take Decision Basis Of Trainnig Date using this Control Structure 
             
             //Browser Open Command
              if(voiceToText.equalsIgnoreCase("open browser")){
                  //System.out.println("open magnifier");
                  voiceTxtCapture.setText(voiceToText);
                   TextToSpeech generator = new TextToSpeech("google chrome opening");
                 try {
                     Runtime.getRuntime().exec("cmd /c start chrome");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
              }
              
              //Browser close
              else if(voiceToText.equalsIgnoreCase("close browser")){
                  //System.out.println("Exit Browsser");
                  TextToSpeech generator = new TextToSpeech("google chrome closing");
                  voiceTxtCapture.setText(voiceToText);
                 try {
                     Runtime.getRuntime().exec("taskkill /IM chrome.exe");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                 }
              }
              
              //open facebook
              else if(voiceToText.equalsIgnoreCase("facebook")){
                 TextToSpeech generator = new TextToSpeech("facebook make friend");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("cmd /c start chrome \"https://www.facebook.com/");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                 }
              }
              
              //open google
                else if(voiceToText.equalsIgnoreCase("google")){
                 TextToSpeech generator = new TextToSpeech("google search everything");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("cmd /c start chrome \"https://www.google.com/");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                 }
              }
               
                //open youtube
                 else if(voiceToText.equalsIgnoreCase("youtube")){
                 TextToSpeech generator = new TextToSpeech("video in you tube");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("cmd /c start chrome \"https://www.youtube.com/");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                 }
              }
                     
              //gmail
                 else if(voiceToText.equalsIgnoreCase("mail")){
                 TextToSpeech generator = new TextToSpeech("gmail opening");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("cmd /c start chrome \"https://www.gmail.com/");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                 }
              } 
                     
               //eject drive
                 else if(voiceToText.equalsIgnoreCase("open drive")){
                 TextToSpeech generator = new TextToSpeech("drive ejected");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"batchFile\\OpticalDriveEject.vbs");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                 }
              } 
                 
                //open paint
                 else if(voiceToText.equalsIgnoreCase("open paint")){
                 TextToSpeech generator = new TextToSpeech("paint opening");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Windows\\System32\\mspaint.exe");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                 }
                }
                 
                 //close paint
                    else if(voiceToText.equalsIgnoreCase("exit paint")){
                 TextToSpeech generator = new TextToSpeech("close paint");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("TASKKILL /IM mspaint.exe");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
                
                    
                  //scan 
                 else if(voiceToText.equalsIgnoreCase("run d")){
                 TextToSpeech generator = new TextToSpeech("virus scanning");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("C:\\Program Files\\Windows Defender\\MSASCui.exe -QuickScan");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
                    
                 
                 //open taskmanager
                     else if(voiceToText.equalsIgnoreCase("open taskmanager")){
                 TextToSpeech generator = new TextToSpeech("taskmanager opening");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Windows\\System32\\Taskmgr.exe");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
                   
                 //open mediaplayer
                 else if(voiceToText.equalsIgnoreCase("open mediaplayer")){
                 TextToSpeech generator = new TextToSpeech("enjoy music");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Program Files (x86)\\Windows Media Player\\wmplayer.exe");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }   
                    
                 //exit mediaplayer
                   else if(voiceToText.equalsIgnoreCase("close mediaplayer")){
                 TextToSpeech generator = new TextToSpeech("closing mediaplayer");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("TASKKILL /IM wmplayer.exe");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                   }
                } 
                  
                   //open notepad
                 else if(voiceToText.equalsIgnoreCase("open note")){
                 TextToSpeech generator = new TextToSpeech("write stuff");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Windows\\System32\\notepad.exe");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
                 
                   //close notepad
                 else if(voiceToText.equalsIgnoreCase("close note")){
                 TextToSpeech generator = new TextToSpeech("closing notepad");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("taskkill /IM notepad.exe");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
                 
                  //AI Name
                 else if(voiceToText.equalsIgnoreCase("your name")){
                 TextToSpeech generator = new TextToSpeech("my name is ovi bot");
                 voiceTxtCapture.setText(voiceToText);
                 }
                 
                 //AI Age
                 else if(voiceToText.equalsIgnoreCase("your age")){
                 TextToSpeech generator = new TextToSpeech("i dont know but i think i was born when t rex was in the earth especially in sunamgonj");
                 voiceTxtCapture.setText(voiceToText);
                 }
                 
                 
                 // hi
                 else if(voiceToText.equalsIgnoreCase("hi")){
                 TextToSpeech generator = new TextToSpeech("how can i help you maharaja");
                 voiceTxtCapture.setText(voiceToText);
                 }
                 
                 
                 //who makes tou
                 else if(voiceToText.equalsIgnoreCase("who makes you")){
                 TextToSpeech generator = new TextToSpeech("arunav mallik ovi a k a a r m ovi");
                 voiceTxtCapture.setText(voiceToText);
                 }
                 
                 
                 //who made you
                 else if(voiceToText.equalsIgnoreCase("who made you")){
                 TextToSpeech generator = new TextToSpeech("arunav mallik ovi a k a a r m ovi");
                 voiceTxtCapture.setText(voiceToText);
                 }
                 
                 //sleep windows 
                 else if(voiceToText.equalsIgnoreCase("reboot")){
                 TextToSpeech generator = new TextToSpeech("rebooting system");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("shutdown -r -f -t 00");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
                 
                 /*
                  //shoutdown windows 
                 else if(voiceToText.equalsIgnoreCase("shutdown")){
                 TextToSpeech generator = new TextToSpeech("shuting down system");
                 voiceTxtCapture.setText(voiceToText);
                  try {
                     Runtime.getRuntime().exec("shutdown -s -f -t 00");
                 } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
                 */
                 
                 
                 //say time
                 else if(voiceToText.equalsIgnoreCase("say time")){
                  Date date = new Date();
                  SimpleDateFormat sdf = new SimpleDateFormat("hh mm a");
                 TextToSpeech generator = new TextToSpeech(sdf.format(date));
                 voiceTxtCapture.setText(voiceToText);
                 }
                 
                 //check ip
                 else if(voiceToText.equalsIgnoreCase("check i p")){
                 try {
                     InetAddress ip = InetAddress.getLocalHost();
                     TextToSpeech generator = new TextToSpeech(ip.getHostAddress());
                 } catch (UnknownHostException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                 }
                    voiceTxtCapture.setText(voiceToText);
                 }
                 
                 /*
                         
                 //bye
                  else if(voiceToText.equalsIgnoreCase("bye")){
                    voiceTxtCapture.setText(voiceToText);
                    TextToSpeech generator = new TextToSpeech("bye see you next time");
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                 }
                   System.exit(0);
                 
                 }
                 */
              
                  //tree
                   else if(voiceToText.equalsIgnoreCase("run tree")){
                    voiceTxtCapture.setText(voiceToText);
                    TextToSpeech generator = new TextToSpeech("runnig system tree structure");
                   try {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"batchFile\\treeStructure.bat");
                   } catch (IOException ex) {
                     Logger.getLogger(CommandFerguson.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   System.exit(0);
                 
                 }
                 
                   //Sing a song
                 else if(voiceToText.equalsIgnoreCase("sing a song")){
                    voiceTxtCapture.setText(voiceToText);
                    TextToSpeech generator = new TextToSpeech("Everybo  daay, yeaaa ah, Rock your booo  daay, yeaaa  ah,  Rock  your  bodyright,  Backstreet,  back, alright");
                   }
                 
                 //wow
                   else if(voiceToText.equalsIgnoreCase("wow")){
                    voiceTxtCapture.setText(voiceToText);
                    TextToSpeech generator = new TextToSpeech("thank you maharaja, i will try to entertaine and help you with my best");
                   }
                 
                   //instruction
                   else if(voiceToText.equalsIgnoreCase("instruction")){
                    voiceTxtCapture.setText(voiceToText);
                    TextToSpeech generator = new TextToSpeech("see my instruction");
                    instructionList open = new instructionList();
                    open.setVisible(true);
                   }
                 
                   //how are you
                      else if(voiceToText.equalsIgnoreCase("how are you")){
                    voiceTxtCapture.setText(voiceToText);
                    TextToSpeech generator = new TextToSpeech("i am fine and what about you maharaja");
                    instructionList open = new instructionList();
                    open.setVisible(true);
                   }
                      
                    
              else if((vManupulation = voiceRecognize.getResult()) != null){
                  TextToSpeech generator = new TextToSpeech("try to detecting");
                }
           }
       }
     }
    
    public CommandFerguson() {
        initComponents();
    }

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        systemStatus = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        voiceTxtCapture = new javax.swing.JTextField();
        commandSheetLoad = new javax.swing.JButton();
        startVoiceAgent = new javax.swing.JButton();
        signalStatus = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Avi Bot");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(91, 91, 91));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Output Status");

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        systemStatus.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 15)); // NOI18N
        systemStatus.setForeground(new java.awt.Color(204, 204, 204));
        systemStatus.setText("Voice Agent Is not Activated !");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(systemStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(systemStatus)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Arm_AVI\\Desktop\\Practice\\Java_Prac\\CommandFerguson\\images\\edi2.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Arm_AVI\\Desktop\\Practice\\Java_Prac\\CommandFerguson\\images\\edi.png")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("You Say :");

        voiceTxtCapture.setEditable(false);
        voiceTxtCapture.setBackground(new java.awt.Color(204, 204, 204));
        voiceTxtCapture.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(voiceTxtCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(voiceTxtCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        commandSheetLoad.setBackground(new java.awt.Color(51, 51, 51));
        commandSheetLoad.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        commandSheetLoad.setForeground(new java.awt.Color(204, 204, 204));
        commandSheetLoad.setText("Instruction Sheet");
        commandSheetLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandSheetLoadActionPerformed(evt);
            }
        });

        startVoiceAgent.setBackground(new java.awt.Color(51, 51, 51));
        startVoiceAgent.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        startVoiceAgent.setForeground(new java.awt.Color(204, 204, 204));
        startVoiceAgent.setText("Start Agent");
        startVoiceAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startVoiceAgentActionPerformed(evt);
            }
        });

        signalStatus.setBackground(new java.awt.Color(200, 0, 0));

        javax.swing.GroupLayout signalStatusLayout = new javax.swing.GroupLayout(signalStatus);
        signalStatus.setLayout(signalStatusLayout);
        signalStatusLayout.setHorizontalGroup(
            signalStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );
        signalStatusLayout.setVerticalGroup(
            signalStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Arm_AVI\\Desktop\\Practice\\Java_Prac\\CommandFerguson\\images\\ediBan2.png")); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Arm_AVI\\Desktop\\Practice\\Java_Prac\\CommandFerguson\\images\\logo.png")); // NOI18N

        jLabel7.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("A Java Virtual Assistant");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel7)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(signalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(startVoiceAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(commandSheetLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(signalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(commandSheetLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(startVoiceAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setText("Option");
        jMenu1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 12)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem5.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 12)); // NOI18N
        jMenuItem5.setText("Sphinix");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 12)); // NOI18N
        jMenuItem3.setText("Clear Field");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 12)); // NOI18N
        jMenuItem1.setText("Exit Stytem");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setBackground(new java.awt.Color(102, 102, 102));
        jMenu3.setText("About");
        jMenu3.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 12)); // NOI18N
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 12)); // NOI18N
        jMenuItem2.setText("View About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(102, 102, 102));
        jMenu4.setText("Help");
        jMenu4.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 12)); // NOI18N
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 12)); // NOI18N
        jMenuItem6.setText("View Help");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static final String VOICENAME = "kevin16";
    private void startVoiceAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startVoiceAgentActionPerformed
       VoiceDetection voiceDetection = new VoiceDetection();
       voiceDetection.start();
       systemStatus.setText("Voice Agent is Activated:");
       systemStatus.setForeground(Color.green);
       signalStatus.setBackground(Color.green);
       
        
            /*
            Voice voice;
            VoiceManager vm = VoiceManager.getInstance();
            voice = vm.getVoice(VOICENAME);
            voice.allocate();
            try {
            voice.speak("voice agent is activated");
            } catch (Exception e) {
            }
            */
            
     
       TextToSpeech generator = new TextToSpeech("Agent Activated");
       
       
    }//GEN-LAST:event_startVoiceAgentActionPerformed

    private void commandSheetLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandSheetLoadActionPerformed
     instructionList open = new instructionList();
      open.setVisible(true);
    }//GEN-LAST:event_commandSheetLoadActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       About open = new About();
       open.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       voiceTxtCapture.setText("");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
          try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"http://my.fit.edu/~vkepuska/ece5527/Projects/Fall2011/Burgos,%20Wilson/sphinx4-1.0beta6/sphinx4-1.0beta6/");
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error! File Not Found");
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
         instructionList open = new instructionList();
         open.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CommandFerguson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommandFerguson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommandFerguson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommandFerguson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CommandFerguson().setVisible(true);
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton commandSheetLoad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel signalStatus;
    private javax.swing.JButton startVoiceAgent;
    private javax.swing.JLabel systemStatus;
    private javax.swing.JTextField voiceTxtCapture;
    // End of variables declaration//GEN-END:variables
}
