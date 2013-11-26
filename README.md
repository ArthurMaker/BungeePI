BungeeAPI
=========

Provide a sime wrapper & api for any server withing to use BungeeCord. This in no way interacts with player data inside a Server. It only recieves and sends data to and fro.

Contains custom events, player handler, server handlers.

Recieve Channel Events
==========
RecieveForwardEvent -- Called when the "Forward" channel is used

RecieveGetServerEvent -- Called when the "GetServer" channel is used

RecieveGetServersEvent -- Called when the "GetServers" channel is used

RecieveIPEvent -- Called when the "IP" channel is used

RecieveOtherEvent -- Called when a channel that is not a BungeeCord channel is used

RecievePlayerCountEvent -- Called when the "PlayerCount" channel is used

RecievePlayerListEvent -- Called when the "PlayerList" channel is used

Send Channel Events
==========
SendConnectEvent -- Called when you send the "Connect" channel

SendConnectOtherEvent -- Called when you send the "ConnectOther" channel

SendForwardEvent -- Called when you send the "Forward" channel

SendMessageEvent -- Called when you send the "Message" channel
