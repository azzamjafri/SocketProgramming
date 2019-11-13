import java.io.*;
import java.net.*;
public class ChatClient
{
  public static void main(String[] args) throws Exception
  {
     Socket sock = new Socket("127.0.0.1", 3000);
                               
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
                              
     OutputStream ostream = sock.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(ostream, true);
 
                            
     InputStream istream = sock.getInputStream();
     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
     System.out.println("Start the chitchat, type and press Enter key\nType 'over' to end the conversation");
 
     String receiveMessage, sendMessage;               
     while(true)
     {
        sendMessage = keyRead.readLine();   
        pwrite.println(sendMessage);        
        if(sendMessage.equals("over"))
          break;
        pwrite.flush();                     
        if((receiveMessage = receiveRead.readLine()) != null) 
        {
            System.out.println(receiveMessage); 
            if(receiveMessage.equals("over")){
              System.out.println("Server ended the convo.....");
              break;
            }
        }         
      }               
    }                    
}                        