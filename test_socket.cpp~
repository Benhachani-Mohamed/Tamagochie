   #include <sys/types.h>
#include <sys/socket.h>

#include <errno.h>
  #include <netinet/in.h>	//sockaddr_in
 // #include <netinet/ip.h> 
  
  #include <arpa/inet.h>	//inet_addr
  
      #include <unistd.h>	//close
         
         
       //  #include <fcntl.h>
         
       #include <thread>         // std::thread
       
#include <iostream>
using namespace std;
int csock;

bool continu = true;

void envoie(){

	string lol;
	while(continu){
	

	
		cout<<": ";
		 lol="";
		 getline(cin,lol);
		 
		 send(csock, lol.c_str(), 32, 0);
		if(continu) 
			continu=!(lol=="/q");
	}
	lol="/q";
	send(csock, lol.c_str(), 32, 0);
}


int main(){

	int descripteur = socket(AF_INET ,SOCK_STREAM,0);
 //Configuration de la connexion 
     sockaddr_in sin;
    /* Configuration */
            sin.sin_addr.s_addr    =inet_addr("10.122.1.213");   /* Adresse IP automatique */
            sin.sin_family         = AF_INET;             /* Protocole familial (IP) */
            sin.sin_port           = htons(6000);         /* Listage du port */
        
        
            sockaddr_in csin;
            socklen_t recsize = sizeof(csin);
            

        int  sock_err = bind(descripteur, (sockaddr*)&sin, sizeof(sin));
          
          
              sock_err = listen(descripteur, 5);
          
          
              char buffer[32] = "Bonjour !";
            if(sock_err != -1)
                {
                             cout<<"Vous etes "<<inet_ntoa(sin.sin_addr) <<" sur le port "<<htons(sin.sin_port)<<"\n";
                		cout<<"wait"<<endl;
                                csock = accept(descripteur, (sockaddr*)&csin, &recsize);

                      thread re(envoie);
                     while(continu){
				
				recv(csock, buffer, 32, 0);

				if(buffer[0] == '/' && buffer[1]=='q'){
					continu = false;
					send(csock, buffer, 32, 0);
				}
				else		
					cout<<" msg recue : "<<buffer<<endl;
				
				
	//}
			}
	             		re.join();                // pauses until first finishes
	             		
	             		
		            /* Il ne faut pas oublier de fermer la connexion (fermée dans les deux sens) */
		            cout<<"le soket du client a etait fermer"<<endl;
		           close(csock);

              }
          
          
          
          
          
          
          
          

          
          
          
      /*    
         if(connect(descripteur, (sockaddr*)&sin, sizeof(sin)) != -1)
            cout<<"Connexion à "<<inet_ntoa(sin.sin_addr) <<" sur le port "<<htons(sin.sin_port)<<"\n";
        else
            cout<<"Impossible de se connecter\n";
 
        /* On ferme la socket précédemment ouverte */
       	cout<<"le soket du serveur a etait fermer"<<endl;
        close(descripteur);
 
    return 0;
 
}
