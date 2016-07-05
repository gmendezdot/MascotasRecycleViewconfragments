package com.example.gerardomd.mascotasrecycleview;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {

    private Button send;
    private TextView name,email,mensaje,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        name = (TextView) findViewById(R.id.name2);
        email = (TextView) findViewById(R.id.email2);
        mensaje = (TextView) findViewById(R.id.mensaje2);
        password = (TextView) findViewById(R.id.password2);
        send = (Button) findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.starttls.enable", "true");
                Session session = Session.getInstance(props, null);

                try {
                    MimeMessage msg = new MimeMessage(session);
                    msg.setFrom(email.getText().toString());
                    msg.setRecipients(Message.RecipientType.TO,
                            email.getText().toString());
                    msg.setSubject(name.getText().toString());
                    msg.setSentDate(new Date());
                    msg.setText(mensaje.getText().toString());
                    Transport.send(msg, email.getText().toString(), password.getText().toString());
                } catch (MessagingException mex) {
                    System.out.println("send failed, exception: " + mex);
                }


            }
        });


    }
/*

    public void send(){

        Properties props = new Properties();
        props.put("mail.smtp.host", "my-mail-server");
        Session session = Session.getInstance(props, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom("gmendezdot@gmail.com");
            msg.setRecipients(Message.RecipientType.TO,
                    "gmendezdot@gmail.com");
            msg.setSubject("JavaMail hello world example");
            msg.setSentDate(new Date());
            msg.setText("Hello, world!\n");
            Transport.send(msg, "gmendezdot@gmail.com", "dot6545752whipet");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }



    }
*/

}
