package com.activemq.artemis;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ArtemisProducer {

	public static void main(String[] args) throws JMSException {
		// TODO Auto-generated method stub
	    String url = ActiveMQConnection.DEFAULT_BROKER_URL;
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("Test.Queue");
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        String text = "Hey World";
        TextMessage message = session.createTextMessage(text);
        System.out.println("Trying to send message.....");
        producer.send(message);
        session.close();
        connection.close();
	}

}
