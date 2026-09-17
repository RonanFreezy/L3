# Q0

Le modele OSI est un modele theorique qui par empaquetement des information parvient a trasmetre des information sur le reseaux.

- **1 :** physique( les cable)

- **2 :** Liaison : mac

- **3 :** reseaux le protocol IP

- **4 :** Transport 

# Q1

- http :HyperText Transfer Protocol, permet d'envoyer des donne pour un navigateur

- pop : Post Office Protocol ,permet d'acceder au mail et les telechargeant sur le client

- imap : Interactive Message Access Protocol permet d'acceder directement au mail sur un serveur sans passer pas le download du client

- smtp : Simple Mail Transfer Protocol , permet d'envoyer des mail

- bootp : Bootstrap Protocol, permet de recupeer les fichier d'un demarage en reseaux

- ppp : Point-To-Point ,connexion entre 2 machine d'un reseaux*

- mac : Media acces Protocol,

# Q2

- http: 7

- pop : 7

- imap : 7

- smtp : 7

- bootp : 7

- ppp : 2

- mac : 2

# Q3

le principe d'encapsulation et de rajouter d'est donne pour apres avoir transmis l'information vai la couche 1, pour retrouver les meme information .

# Q5

| Protocol   | Port   |
|:----------:|:------:|
| http/https | 80/443 |
| pop3       | 110    |
| imap       | 143    |
| smtp       | 25     |
| bootp      | 67/68  |
| ppp        | -      |
| mac        | -      |

# Q6

la commande nous donne l'ip associe au nom de domaine via le DNS.

# Q7

elle envoie des paquet a une machine sur le reseaux

# Q8

```shell
C:\Windows\System32>tracert uca.fr

Détermination de l’itinéraire vers uca.fr [193.49.117.66]
avec un maximum de 30 sauts :

  1     2 ms     1 ms     1 ms  172.27.151.254
  2     2 ms     1 ms     2 ms  172.27.27.254
  3    57 ms     3 ms     2 ms  192.168.7.254
  4     2 ms     3 ms     3 ms  192.168.7.2
  5    12 ms    10 ms    11 ms  195.221.120.22
  6     5 ms     9 ms     6 ms  193.49.117.1
  7     3 ms     4 ms     4 ms  ucaweb03.infra.dsi.uca.fr [193.49.117.66]
```

# Q9

| Commande Linux | Action principale                                   | Équivalent Windows (`cmd`)                                                                       |
|:-------------- |:--------------------------------------------------- |:------------------------------------------------------------------------------------------------ |
| `netstat -tp`  | Connexions TCP actives + Nom du programme           | `netstat -bano -p tcp`                                                                           |
| `netstat -ltp` | Ports TCP en écoute (Listening) + Nom du programme  | `netstat -ban -p tcp` (puis chercher `LISTENING`) ou :`netstat -ban -p tcp \| findstr LISTENING` |
| `netstat -up`  | Connexions et ports UDP + Nom du programme          | `netstat -bano -p udp`                                                                           |
| `netstat -i`   | Statistiques des interfaces réseau (Wi-Fi/Ethernet) | `netsh interface ipv4 show subinterfaces`(ou `netstat -e` pour les stats globales de paquets)    |
| `netstat -r`   | Table de routage de la machine (les chemins réseau) | `netstat -r` ou `route print`                                                                    |
