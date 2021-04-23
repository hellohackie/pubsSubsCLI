# pubsSubsCLI
A normal producer consumer based CLI application

## To compile this program
use any java ide with jdk 8 or higher then run CLIApplication for the same.

## To run the CLI application one need to follow certain rules like given below
    * to add user just run `addUser userName role` this one
    * to add topic just run `addTopic topicName userName`this one
    * to subscribeTopic just run `subscribeTopic topicName userName`
    * to add message just run `postEvent messageBodyId messageBodyTopicName messageBodyText`
    * to process all events just run `processMessages`
    * to get exit from cli process just run `Exit`

### KEY points to NOTE
    * messageBodyId is `integer` type
    * role are of type `ADMIN` or `USER`