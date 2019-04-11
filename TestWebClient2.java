/**
 * 
 */
package lab06;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

/**
  @author zeng
  @date 2019年4月11日 上午10:43:25
  @Descripton
 */
public class TestWebClient2 {
	@Test
	public void testGetContentOk() throws Exception {
MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
mockConnectionFactory.setData(new ByteArrayInputStream("It works"
				.getBytes()));
		WebClient2 client = new WebClient2();
		String result = client.getContent(mockConnectionFactory);
		Assert.assertEquals("It works", result);
	}
  private class MockConnectionFactory implements ConnectionFactory
  {

	private InputStream inputstream;
	@Override
	public InputStream getData() throws Exception {
		
		return this.inputstream;
	}
	public void setData(InputStream inputstream){
		this.inputstream=inputstream;
	}
	
}

}
