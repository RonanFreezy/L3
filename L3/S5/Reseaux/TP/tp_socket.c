#include <sys/socket.h>
#include <netinet/in.h>  
#include <stdio.h>
#include <unistd.h>


void f(){

    int sock = socket(AF_INET,SOCK_DGRAM, 17);

    struct sockaddr_in sin;
    sin.sin_family = AF_INET;
    sin.sin_port = htons(12345);
    sin.sin_addr.s_addr = htonl(INADDR_ANY);
    
    int i, ret;
    for (i=0; i<8; i++) {
    sin.sin_zero[i] = 0;
    }


    ret = bind(sock, (struct sockaddr *)&sin, sizeof(struct sockaddr_in));
    if (ret<0) {
    printf("error");
    } 

    char buffer[1024];
    struct sockaddr_in rcv;
    socklen_t taille_rcv=sizeof(rcv);

    
    
    while(1){
        int res =recvfrom(sock, buffer, 1024,0, (struct sockaddr *)&rcv, &taille_rcv);
        if (res>0){
            if(buffer[0]=='q'&& buffer[1]=='u'&& buffer[2]=='i'&& buffer[3]=='t'){
                printf("fermeture du serveur\n");
                close(sock);
                return;
            }
            buffer[res]='\0';
            printf("%s",buffer);
        }
    }
}

void g(){
    int sock = socket(AF_INET,SOCK_STREAM, 6);

        struct sockaddr_in sin;
        sin.sin_family = AF_INET;
        sin.sin_port = htons(12345);
        sin.sin_addr.s_addr = htonl(INADDR_ANY);
        
        int i, ret;
        for (i=0; i<8; i++) {
        sin.sin_zero[i] = 0;
        }


        ret = biwindow.autoDetectColorSchemend(sock, (struct sockaddr *)&sin, sizeof(struct sockaddr_in));
        if (ret<0) {
        printf("error");
        } 
}

int main(){
    f();
    return 0;
}