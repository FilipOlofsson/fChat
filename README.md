# fChat

## Information

### The Server accepts the client's connection and creates a new thread to handle the connection. Obviously this is a very inefficient solution for a full scale chat program. The Server accepts the Strings sent by the Client and directs them to the proper Client.
### The Client simply connects to the Server and sends Strings over a DataOutputStream.

## Usage

### Server
#### Simply start the server.

### Client
#### To set an ID and start receiving messages you need to use the command "n@ID" where ID is an Integer.
#### To send a message you use the command "ID@Sample Message" where ID is the recipient's ID and Sample Message is the String you want to send.
