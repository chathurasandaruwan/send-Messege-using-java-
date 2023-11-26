import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {

    public static final String ACCOUNT_SID = "your_account_sid";
    public static final String AUTH_TOKEN = "your_auth_token";
    public static final String TWILIO_PHONE_NUMBER = "your_twilio_phone_number";
    public static final String TO_PHONE_NUMBER = "recipient_phone_number";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Replace with your actual Twilio phone number and recipient phone number
        sendSms(TWILIO_PHONE_NUMBER, TO_PHONE_NUMBER, "Hello, this is a test message from Java!");
    }

    private static void sendSms(String from, String to, String messageBody) {
        Message message = Message.creator(
                        new PhoneNumber(to),
                        new PhoneNumber(from),
                        messageBody)
                .create();

        System.out.println("SMS sent successfully. SID: " + message.getSid());
    }
}
