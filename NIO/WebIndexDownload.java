import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class WebDownload {

	private final static Charset charset = Charset.forName("UTF-8");
	private SocketChannel clientChannel;

	public void download() {
		connect();
		sendRequest();
		readResponse();
	}

	//发送GET请求到CSDN的文档中心
	private void sendRequest() {
		//使用channel.write方法，它需要CharByte类型的参数，使用
		//Charset.encode(String)方法转换字符串。
		try {
			clientChannel.write(charset.encode("GET / HTTP/1.1\r\nHOST:\r\n\r\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readResponse(){
		ByteBuffer buff = ByteBuffer.allocate(10240);//创建1024字节的缓冲
		
		try {
			// -1 if the channel has reached end-of-stream
			while(clientChannel.read(buff)!=-1){
				buff.flip();//flip方法在读缓冲区字节操作之前调用。
				
				System.out.println(charset.decode(buff));
				
				buff.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean connect() {
		InetSocketAddress socketAddr = new InetSocketAddress("www.washingtonpost.com", 80);
		try {
			clientChannel = SocketChannel.open();
			clientChannel.connect(socketAddr);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static void main(String[] args) {
		new WebDownload().download();
	}

}
