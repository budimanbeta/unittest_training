package example.testing.mock;

public interface TemplateEngine extends Template{

	String prepareMessage(Template template, Client client);

}
