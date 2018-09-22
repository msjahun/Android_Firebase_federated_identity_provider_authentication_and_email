package com.example.dc.firebaseauthentication.Classes;

import java.util.Date;

public class NotificationLog {

    public String Id;
    public String MessageText;
    public String MessageLabel;
    public String DeliveryDate;
    public String Title;
    public String Target;
    public Date ExpiryDate;
    public String NotificationType;

    public NotificationLog(String id, String messageText, String messageLabel, String deliveryDate, String title, String target, Date expiryDate, String notificationType) {
        Id = id;
        MessageText = messageText;
        MessageLabel = messageLabel;
        DeliveryDate = deliveryDate;
        Title = title;
        Target = target;
        ExpiryDate = expiryDate;
        NotificationType = notificationType;
    }
}
