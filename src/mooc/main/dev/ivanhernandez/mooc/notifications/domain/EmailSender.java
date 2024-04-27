package dev.ivanhernandez.mooc.notifications.domain;

public interface EmailSender {
	void send(Email email);
}
