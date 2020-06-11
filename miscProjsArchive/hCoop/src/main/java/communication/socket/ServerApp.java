package communication.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ソケット通信(サーバー側)
 */
class ServerEntity {
	void run(String dstPath) {
		File dstFile = new File(dstPath);
		OutputStream out = null;
		byte[] buffer = new byte[8192]; // or 4096, or more
		int count = 0;
		ServerSocket sSocket = null;
		Socket socket = null;
		PrintWriter writer = null;

		try {
			// IPアドレスとポート番号を指定してサーバー側のソケットを作成
			sSocket = new ServerSocket();
			// ! sSocket.bind(new InetSocketAddress("127.0.0.1", 8765));
			sSocket.bind(new InetSocketAddress(8765));
			System.out.println("クライアントからの接続待ち");
			// クライアントからの要求を待ち続けます
			socket = sSocket.accept();

			InputStream in = socket.getInputStream();
			out = new FileOutputStream(dstFile);

			// サーバーからクライアントへの送信用
			writer = new PrintWriter(socket.getOutputStream(), true);
			while ((count = in.read(buffer)) > 0) {
				out.write(buffer, 0, count);
			}
			System.out.println("ファイル受け取り完了");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
				if (socket != null) {
					socket.close();
				}
				if (sSocket != null) {
					sSocket.close();
				}
				System.out.println("サーバー側終了です");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ServerApp {
	public static void main(String[] args) {
		ServerEntity s1 = new ServerEntity();
		String dirBase = new File("").getAbsolutePath();
		String dstPath= dirBase + File.separator + "qResult" + File.separator + "zipResult" + File.separator + "EMPInfo.zip";
		s1.run(dstPath);
	}
}
