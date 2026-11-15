#include <sys/socket.h>
#include <netinet/in.h>  
#include <stdio.h>
#include <unistd.h>
#include <arpa/inet.h>


void c(int port,char* ip){
    int sock = socket(AF_INET,SOCK_STREAM, 6);

    struct sockaddr_in sin;
    sin.sin_family = AF_INET;
    sin.sin_port = htons(port);
    inet_aton(ip,&sin.sin_addr);
    
    int i, ret;
    for (i=0; i<8; i++) {
        sin.sin_zero[i] = 0;
        }

    ret= connect(sock,(struct sockaddr *)&sin,sizeof(struct sockaddr_in));
    if (ret < 0) {
        perror("Erreur de connexion au serveur");
        close(sock);
        return;
    }
    
    char buffer[1024];
/*
    buffer[0]='h';
    buffer[1]='e';
    buffer[2]='l';
    buffer[3]='l';
    buffer[4]='o'; 
    ssize_t sent_bytes = send(sock, buffer, 5, 0);
    if (sent_bytes < 0) {
        perror("Erreur lors de l'envoi");
    } else {
        printf("Message envoyé!\n");
    }*/

    buffer[0]='q';
    buffer[1]='u';
    buffer[2]='i';
    buffer[3]='t';
    ssize_t sent_bytes = send(sock, buffer, 4, 0);
    if (sent_bytes < 0) {
        perror("Erreur lors de l'envoi");
    } else {
        printf("Message envoyé!\n");
    }

    close(sock);
}



int main(){
    //f();
    //g();
    c(12345,"127.0.0.1");
    return 0;
}