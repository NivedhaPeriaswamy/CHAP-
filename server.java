import java.io.*;
import java.sql.Struct;
import java.util.*;
public class Server {
	Client a,b,c,d,e;
	String uname;
	String pwd[]=new String[20];
	String[] challenge=new String[20];
	
	void chalenge()
	{
	//randomize();
	Random rand=new Random();
	int n=rand.nextInt()%16;
	char ch;
	for(int i=0;i<n;i++)
	{
		
	int a=65+rand.nextInt()%(122-65+1);	
	challenge[i]=Integer.toString(a);
	}
	}
	String hash[]=new String[50];
	void hashh()
	{
		for(int i=challenge.length;i<(challenge.length+pwd.length);i++){
			challenge[i]=pwd[i-challenge.length];
		}
	
	MD5 md5;
	strcpy(hash,md5.digestString(challenge));
	}
	String client_message[]=new String[2000];
	
	public static void main(String[] args){
		 int l,i=0;
	     int j=0;
	     int socket_desc ,client_sock, c , read_size;
	     struct sockaddr_in server , client;
	     socket_desc = socket(AF_INET , SOCK_STREAM , 0);
	        if (socket_desc == -1)
	        {

	                System.out.println("Could not create socket");

	        }
	        puts("Socket created");
	        server.sin_family = AF_INET;
	        server.sin_addr.s_addr = INADDR_ANY;
	        server.sin_port = htons( 8860 );
	        if( bind(socket_desc,(struct sockaddr *)&server , sizeof(server)) < 0)
	        {
	                perror("bind failed. Error");
	                return 1;
	        }
	        puts("bind done");
	        listen(socket_desc , 3);
	        puts("Waiting for incoming connections...");
	        c = sizeof(struct sockaddr_in);
	        client_sock = accept(socket_desc, (struct sockaddr *)&client, (socklen_t*)&c);
	        if (client_sock < 0)
	        {
	                perror("accept failed");
	                return 1;
	        }
	        puts("A client initiation connection ...Authentication starts");
	    	
            if((read_size=recv(client_sock,client_message,2000,0))>0)
           	{
                    int len1=strlen(client_message);
                    client_message[len1]='\0';
		sleep(5);
                    System.out.println("\nUsername of client : \t"<<client_message<<"\n");
                    if(strcmp(client_message,"Hemalatha")==0)
                    	strcpy(pwd,"dsch");
                    	else if(strcmp(client_message,"Lakshmi Priya")==0)
                    	strcpy(pwd,"Surprise");
                    	else if(strcmp(client_message,"Sharmadha")==0)
                    	strcpy(pwd,"Ramajayam");
                    	else if(strcmp(client_message,"Abinaya")==0)
                    	strcpy(pwd,"Yuvan");
                    	else if(strcmp(client_message,"Sangavi")==0)
                    	strcpy(pwd,"Sangs");
                    	else 
                    	strcpy(pwd,"Preni");
                    	}
            puts("\n You : \n ");
            sleep(5);
            chalenge();
	        int len=strlen(challenge);
                challenge[len]='\0';
                System.out.println("Challenge  value : "+challenge+"");
                System.out.println("Sending challenge value to client..."); 
                sleep(5);
                send(client_sock , challenge , strlen(challenge),0);
                    
     		String ch[]=new string[10];
     		if((read_size=recv(client_sock,ch,50,0))>0)
                     {
                             int len1=strlen(ch);
                             ch[len1]='\0';
                             System.out.println(" Hash value received from Client :"+ch+"");
     		hashh();
     sleep(5);
     System.out.println("Computed hash value:"+hash+" ");
     		if(strcmp(hash,ch)==0)
     		System.out.println(" BOTH HASH VALUES MATCH !! CONNECTION ESTABLISHED !!");	        
     	 }
             	

     return 0;
     }
	}
}
