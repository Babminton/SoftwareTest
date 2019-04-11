/**
 * 
 */
package lab06;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


import org.junit.Test;

/**
  @author zeng
  @date 2019年4月11日 上午9:42:36
  @Descripton
 */
public class WebClientTest1 {

	@Test
	public void testGetContentOk() throws Exception {
	MockHttpURLConnection mockConnection = new MockHttpURLConnection();
	mockConnection.setExpectedInputStream(
	new ByteArrayInputStream("It works".getBytes()));
	//创建一个MockHttpURlConnection，为了在其上调用getInputStream方法时返回包含"It works"字符流。
	TestableWebClient client=new TestableWebClient();
	client.setHttpURLConnection(mockConnection);
	//同上，mockURl调用openConnection时，反回一个MockHttpURLConnection 
	
	String result = client.getContent(new URL("http://localhost"));
	
	assertEquals("It works", result);
	}

	private class TestableWebClient extends WebClient1{
		
			private HttpURLConnection connection;
			public void setHttpURLConnection(HttpURLConnection connection) {
				this.connection = connection;
				}
			public HttpURLConnection createHttpURLConnection(URL url)
						throws IOException {
					return this.connection;
				}

	}
	private class MockHttpURLConnection extends HttpURLConnection{

	     private InputStream stream;
	     public MockHttpURLConnection()
	     {
	         super( null );
	     }
	    protected MockHttpURLConnection(URL url)
	     {
	         super( url );
	     }
	       public void setExpectedInputStream( InputStream stream )
	     {
	         this.stream = stream;
	     }
	       public InputStream getInputStream()
	    	        throws IOException
	    	    {
	    	        return this.stream;
	    	    }
	    	       public void disconnect()
	    	    {
	    	    }
	    	    public void connect()
	    	        throws IOException
	    	    {
	    	    }
	    	    public boolean usingProxy()
	    	    {
	    	        return false;
	    	    }
	    	}


	}


