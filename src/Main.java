import java.util.Scanner;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;


public class  Main{

    private static final String TASK_QUEUE_NAME = "task";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

            Scanner inp = new Scanner(System.in);

            String message = inp.nextLine();

            channel.basicPublish("", TASK_QUEUE_NAME,
                   null,
                    message.getBytes());
            System.out.println(" Sent " + message);

        channel.close();
        connection.close();




    }

}