package com.kaushal.controller;

import com.kaushal.model.Topic;
import com.kaushal.model.User;
import com.kaushal.model.Message;

import java.util.*;

public class CommandController {
    private HashMap<String,User> users = new HashMap<String,User>();
    private HashMap<String,Topic> topics = new HashMap<String,Topic>();
    private HashMap<Integer, Message> messages = new HashMap<Integer, Message>();

    public void insideCLI(){
        Scanner sc = new Scanner(System.in);
        String command;

        while(true) {
            System.out.println("Please run below commands as directed.");
            // System.out.println("NOTE: please don't add any spaces while writing ")
            System.out.println("addUser userName role");
            System.out.println("addTopic topicName userName");
            System.out.println("subscribeTopic topicName userName");
            System.out.println("postEvent messageBodyId messageBodyTopicName messageBodyText");
            System.out.println("processMessages");
            System.out.println("Exit");
            command = sc.nextLine();
            List<String> cmd = new ArrayList<String>();
            cmd = Arrays.asList(command.split(" "));
            switch (cmd.get(0)) {
                case "addUser":
                    User user = new User(cmd.get(2), cmd.get(1));
                    System.out.println("User Added successfully");
                    users.put(user.getName(), user);
                    break;
                case "addTopic":
                    if (users.get(cmd.get(2)).getType()==0){
                        Topic topic = new Topic(cmd.get(1));
                        System.out.println("Topic Added successfully");
                        topics.put(topic.getName(), topic);
                    }else
                        System.out.println("Not Permitted!");
                    break;
                case "subscribeTopic":
                    Topic topic = topics.get(cmd.get(1));
                    topic.addUsers(cmd.get(2));
                    topics.put(cmd.get(1), topic);
                    System.out.println("Topic subscribed successfully");
                    break;
                case "postEvent":
                    int id = Integer.parseInt(cmd.get(1));
                    String name = cmd.get(2);
                    List<String> sb = cmd.subList(3, cmd.size());
                    String txt = String.join(" ", sb);
                    Message message = new Message(id, txt, name);
                    messages.put(id, message);
                    Topic topic1 = topics.get(name);
                    topic1.addMessage(message);
                    topics.put(name, topic1);
                    System.out.println("Message pushed successfully");
                    break;
                case "processMessages":
                    Iterator iterator = topics.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry mapEntry = (Map.Entry) iterator.next();
                        Topic topic2 = (Topic) mapEntry.getValue();
                        List<Message> messageList = topic2.getMessageList();
                        if (messageList.size()>0){
                            for(int i=0; i<messageList.size(); i++){
                                List<String> userList = (List<String>) topic2.getUserList();
                                for(int j=0; j<userList.size(); j++) {
                                    System.out.println("{");
                                    System.out.println("\ttopic: " + topic2.getName());
                                    System.out.println("\tmessage: " + messageList.get(i).getText());
                                    System.out.println("\tsentTo: " + userList.get(j));
                                    System.out.println("}");
                                }
                            }
                        }
                    }
                    break;
                case "Exit":
                    System.out.println("Exiting Now! Thanks for using me.");
                    System.exit(1);
                default:
                    System.out.println("You have entered wrong command. Please check again!");
                    System.out.println("Command: " + cmd.get(0));
            }
        }
    }
}