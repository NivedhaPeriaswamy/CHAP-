

public class Client4 {
	String challenge;
	String hash;
	String pwd="gayu";
	String user="gayu";
	
	void hashh()
	{

	challenge=challenge+pwd;
	MD5 md5;
	strcpy(hash,md5.digestString(challenge));
	}
	public static void main(String[] args){
		 int size=0;
	        int sock;
	        int j=0,l=0,i=0;
	        char ch='0';
	        struct sockaddr_in server;
	        String server_reply;
	        sock = socket(AF_INET , SOCK_STREAM , 0);
	        if (sock == -1)
	        {

	                System.out.println("Could not create socket");

	        }
	        puts("Socket created");
	        server.sin_addr.s_addr = inet_addr("127.0.0.1");
	        server.sin_family = AF_INET;
	        server.sin_port = htons( 8860);
	        if (connect(sock , (struct sockaddr *)&server , sizeof(server)) < 0)
	        {

	                perror("connect failed. Error");
	                return 1;
	        }
	        puts("Connected");
		sleep(2);
	        System.out.println(" Sending Username to Server for authentication..");
		sleep(2);
		   
        l=strlen(user);
        send(sock,user,l,0);
        for(j=0;j<100;j++)
        server_reply[j]='\0';
        size=0;
        if( (size=recv(sock,server_reply,2000,0))>0 )
        {
                int j=strlen(server_reply);
                server_reply[j]='\0';
                System.out.println(" Challenge value sent by the Server  : ");
sleep(5);
System.out.println(server_reply);
      
}
strcpy(challenge,server_reply);
hashh();
sleep(5);
System.out.println("Computed Hash value :"+hash);
send(sock,hash,50,0);		
return 0;

	}

}
