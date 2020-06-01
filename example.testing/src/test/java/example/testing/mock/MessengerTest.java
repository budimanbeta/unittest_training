package example.testing.mock;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;


import static org.mockito.Mockito.*;

public class MessengerTest {

	private static final String CLIENT_EMAIL = "some@email.com";
	private static final String MSG_CONTENT = "Dear John! You are promoted.";

	@Test
	public void dummyObjectTest() {
		TemplateEngine templateEngine = mock(TemplateEngine.class);
		MailServer mailServer = mock(MailServer.class);
		Client client = mock(Client.class);
		Messenger sut = new Messenger(mailServer, templateEngine);

		Template template = mock(Template.class);

		sut.sendMessage(client, template);
	}

	@Test
	public void stubTest() {
		TemplateEngine templateEngine = mock(TemplateEngine.class);
		MailServer mailServer = mock(MailServer.class);
		Client client = mock(Client.class);
		Messenger sut = new Messenger(mailServer, templateEngine);
		Template template = mock(Template.class);

		when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);
	}

	@Test
	public void shouldSendEmail() {
		Template template = mock(Template.class);
		Client client = mock(Client.class);
		MailServer mailServer = mock(MailServer.class);
		TemplateEngine templateEngine = mock(TemplateEngine.class);
		Messenger sut = new Messenger(mailServer, templateEngine);
		when(client.getEmail()).thenReturn(CLIENT_EMAIL);
		when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);
		sut.sendMessage(client, template);
		
		verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
	}

}
