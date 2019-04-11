package lab06;

import java.io.InputStream;

public class WebClient2
{

	public String getContent(ConnectionFactory connectionFactory) {
		StringBuffer content = new StringBuffer();
		try {
			InputStream is = connectionFactory.getData();
			int count;
			while (-1 != (count = is.read())) {
		content.append(new String(Character.toChars(count)));
			}
		} catch (Exception e) {
			return null;
		}
		return content.toString();
	}

}
