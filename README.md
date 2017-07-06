# AviBot

AviBot is one kind of Simple and Basic Virtual Assistant that can perform Specific
task Basis of it's Integrated Logic. virtual assistant is also called "ChatBot" .
ChatBot is Computer Application or Software That Lead or Abide By 
"Artificial Intellegence". AviBot Has Ability to Captures Voice From Microphone By 
Using the "Sphinix4", A Voice/Speech Recognition "Java" Library. Which is 
Developed By "carnegie mellon university (CMU)" & Take Decision basis of it's 
"acoustic model", "Dictionary training","Language Model" file . AviBot has ability
to run Some Common windows application and voice chat conversation with user  

in this application i use a Aditional feature which is Text to Speech Detection
the code is
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
