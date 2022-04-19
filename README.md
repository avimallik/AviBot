# AviBot

AviBot is one kind of Simple and Basic Virtual Assistant that can perform Specific
task Based on it's Integrated Logic. virtual assistant is also called "ChatBot" .
ChatBot is Computer Application or Software That Lead or Abide By 
"Artificial Intellegence". AviBot Has Ability to Captures Voice From Microphone By 
Using the "Sphinix4", A Voice/Speech Recognition "Java" Library. Which is 
Developed By "carnegie mellon university (CMU)" & Take Decision basis of it's 
"acoustic model", "Dictionary training","Language Model" file . AviBot has ability
to run Some Common windows application and voice chat conversation with user  
in this application i use a Aditional feature which is Text to Speech Detection


<b>Author :</b> <br>
Arunav Mallik Avi (Arm Avi), <br>
Department of Computer Science and Engineering, 
National University, Bangladesh<br>

## Code Description

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
                   System.out.println("Not Working");
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
                 ...
                 ...
                 here you implement Any Command
                 ...
                 ...
                 
              }
       }
       
when Sphinix Configuration manager set all the resourses, Then it start to detect the voice. For the voice command app we.definitely need to check that what type of command is the user giving hence we need the recognizer to display the result that what command has it recognized from the speech.

For that we will use the getHypothesis() method from the SpeechResult object, using a while loop we will be able to get all the recognized speech that the user will speak.The command variable will store the recognized speech from the user (The command that you speak) in string format hence we can compare whether the recognized command matches any from our list of commands and then execute the command. Like That if i say "open browser" the voice command matches with the dictionary list which is include first by using congfiguration if the voice command is matches with the dictionary list command then AviBot Launch or start the "google chorme"
the process to launch windows Application i use windows "CMD command" under the java Runtime.getRuntime.exec() method by passing CMD string.  

       //TextToSpeech
      private static final String VOICEAGENTNAME = "kevin16";  
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

     
 class TextToSpeech is responsible for converting text to speech. here is global String varible which is the Voice model and responsible to say my text to converting it to voice
     
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
                 
   in this code the TextToSpeech generator = new TextToSpeech("google chrome opening") the generator Object convert the  "google chrome opening" string to the voice and it is perform after the openning of the browser.
     thats it. Mainly it is a voice synthesize application if our voice command is Matches with the Language Dictionary instruction or String it perform or run it By using Control Structure      
    ScreenShoot : <br/>
    ![gitimage](https://user-images.githubusercontent.com/21225215/36890145-0895790a-1e27-11e8-89c2-d048e7e30b1a.png)
     
