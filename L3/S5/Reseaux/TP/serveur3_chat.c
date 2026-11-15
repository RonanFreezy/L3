#include <stdlib.h>
#include <sys/socket.h>
#include <netinet/in.h>  
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <arpa/inet.h>



void affiche_message(int sock){

    char buffer[1024];
    struct sockaddr_in rcv;
    socklen_t taille_rcv=sizeof(rcv);

    while(1){
        int res =recv(sock,&buffer,1024,0);
        if (res>0){
            if(buffer[0]=='q'&& buffer[1]=='u'&& buffer[2]=='i'&& buffer[3]=='t'){
                return;
            }
            buffer[res]='\0';
            printf("%s\n",buffer);
        }
    }

}

void serveur(){
    int sock = socket(AF_INET,SOCK_STREAM, 6);

    struct sockaddr_in sin;
    sin.sin_family = AF_INET;
    sin.sin_port = htons(12345);
    sin.sin_addr.s_addr = htonl(INADDR_ANY);
    
    int i, ret;
    for (i=0; i<8; i++) {
        sin.sin_zero[i] = 0;
        }

    ret = bind(sock, (struct sockaddr *)&sin, sizeof(struct sockaddr_in));
    if (ret<0){
        printf("error\n"); 
        exit(-1);
    } 

    listen(sock, 3);
    
    struct sockaddr_in rcv;
    socklen_t taille_rcv=sizeof(rcv);

    int so[3];
    for(int i=0;i<3;i++){
        so[i]=accept(sock,(struct sockaddr *)&rcv, &taille_rcv);
    }

    for(int i=0;i<3;i++){
        pid_t pid=fork();
        if(pid==0){ //client
            close(sock);
        }
        else {
            close(so[i]);
        }
    }

}

int main(){
    //f();
    serveur();
    return 0;
}