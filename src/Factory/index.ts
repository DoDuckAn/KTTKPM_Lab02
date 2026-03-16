type NotificationChannel = "email" | "sms" | "push";

interface MessageService {
  send(recipient: string, message: string): string;
}

class EmailService implements MessageService {
  send(recipient: string, message: string): string {
    return `Email sent to ${recipient}: ${message}`;
  }
}

class SmsService implements MessageService {
  send(recipient: string, message: string): string {
    return `SMS sent to ${recipient}: ${message}`;
  }
}

class PushService implements MessageService {
  send(recipient: string, message: string): string {
    return `Push notification delivered to ${recipient}: ${message}`;
  }
}

class MessageServiceFactory {
  static create(channel: NotificationChannel): MessageService {
    switch (channel) {
      case "email":
        return new EmailService();
      case "sms":
        return new SmsService();
      case "push":
        return new PushService();
    }
  }
}

export function runFactoryDemo(): void {
  const samples: Array<{ channel: NotificationChannel; recipient: string }> = [
    { channel: "email", recipient: "student@example.com" },
    { channel: "sms", recipient: "+84901234567" },
    { channel: "push", recipient: "mobile-app-user" }
  ];

  samples.forEach(({ channel, recipient }) => {
    const service = MessageServiceFactory.create(channel);
    console.log(`[${channel}] ${service.send(recipient, "Factory pattern is working.")}`);
  });
}

if (require.main === module) {
  runFactoryDemo();
}