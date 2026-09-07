# Plan

- Modèle en couches
- Protocole IP
- Protocole TCP
- Protocole UDP
- Routage (Interne)
- ICMP
- DHCP/NAT

## Modèles en couches

Modèle introduit par l'ISO -> OSI (Open Systems Interconnection)

Le modèle OSI est théorique (recommandation).

7 couches pour dialoguer entre plusieurs machines de natures différentes sur un même réseau.

### 7 Couches (du plus abstrait au plus rationnel)

> X.25 est le seul protocole à respecter toutes les règles de l'OSI.

- 7. Application
- 6. Présentation
- 5. Session
- 4. Transport
- 3. Réseau
- 2. Liaison
- 1. Physique

> Dans ce cours (Réseau 1), on va se focaliser sur le transport et le réseau.

#### 7. Application

Navigateur web / mail
<br>HTTP, etc.

#### 6. Présentation

Modification des données -> chiffrement

#### 5. Session

RPC / PPTP / PAP

RPC (Remote Procedure Call)
<br>PPTP (Point-to-Point Tunneling Protocol)
<br>PAP (Password Authentication Protocol)

#### 4. Transport

TCP / UDP
> La notion de port va être abordée.

<br>UDP est utilisé dans le streaming et le jeu vidéo.
<br>TCP est plus utilisé dans le web.

#### 3. Réseau

IP (Internet Protocol) IPv4 / IPv6
<br>Adresse IP (Adresse logique)

#### 2. Liaison

Adressage physique
<br>Protocole d'accès au média
<br>MAC : Media Access Control (codé sur 48 bits en hexadécimal), identifiant unique.

#### 1. Physique

- Réseau Ethernet
- Wi-Fi
- 4G / 5G

| A | | B |
|---|---|---|
| 7 | -> | 7 |
| 6 | -> | 6 |
| 5 | -> | 5 |
| 4 | -> | 4 |
| 3 | -> | 3 |
| 2 | -> | 2 |
| 1 | -> | 1 |

A veut communiquer avec B. La couche envoyée doit être la même que celle reçue.

### Fonctionnement

Encapsulation / Désencapsulation
<br>Multiplexage / Démultiplexage

Avant d'encapsuler, on passe à la couche en dessous.
<br>Quand on encapsule, on ajoute des informations :
- Le protocole de chiffrement, etc.

**A :**
7. Message -> 6. On le chiffre -> 5. On encapsule -> etc.

En couche 1, on peut envoyer les informations de A à B (physiquement).

B reçoit les informations et désencapsule jusqu'à la couche désirée grâce aux informations ajoutées pendant la phase d'encapsulation.

### Avantages

Modularité au niveau des protocoles.
<br>Ex. : ajouter un nouveau moyen de communication nécessite uniquement de modifier la couche n° 1.

### Inconvénients

La taille des messages est plus importante (surcoût dû aux en-têtes).

## IP Internet Protocol

> Internet = le Reseaux des Reseaux

### Plan:

- But du protocol IP
- Adressages Logique ,Classe d'Adresse
- Structure des Paquets(Datagrame IP)
- Fragmentation
- Principe du Routage

### IP couche 3

le but est de permettre l'interconnexion avec pluisieur reseaux de nature diff 

__Plusieur caracteristique :__

- Adressage logique
- une facon de router / acheminer les paquets 
- la remise de paquets

IPv4: 32 bits
IPv6: 128 bits

Notation pointée: 192.110.2.37 pour ipv4
code en hexa pour les ipv6

Adressage Logique:

- decoupe en adresse reseaux
- adresse machine sur le reseaux

ipv6 64 bit Adressage Reseaux/64bit adressage machine

ipv4 decoupage varriable