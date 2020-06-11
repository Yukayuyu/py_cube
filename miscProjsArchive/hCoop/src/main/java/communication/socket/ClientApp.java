package communication.socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import communication.javaMail.MailSender;
import communication.javaMail.Mailable;

/**
 * ソケット通信(クライアント側)
 */
class ClientEntity {
	public static final Logger logger = LogManager.getLogger("ClientyEntity");

	void run(String filePath) {
		logger.info("clientStart");
		File file = new File(filePath);
		FileInputStream fileIn = null;
		Socket cSocket = null;
//		BufferedReader csInput = null;
		PrintWriter writer = null;
		BufferedReader serverResponse = null;
		byte[] buffer = new byte[8192]; // or 4096, or more
		int count;
		try {
			// IPアドレスとポート番号を指定してクライアント側のソケットを作成
//			cSocket = new Socket("127.0.0.1", 8765);
			cSocket = new Socket("192.168.3.26", 8765);

			// ファイルinputStreamを作成
			fileIn = new FileInputStream(file);
			OutputStream out = cSocket.getOutputStream();

			// クライアント側からサーバへの送信用
			writer = new PrintWriter(cSocket.getOutputStream(), true);

			// サーバ側からの受取用
			serverResponse = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));

			while ((count = fileIn.read(buffer)) > 0) {
				out.write(buffer, 0, count);
			}
			System.out.println("送信完了");
			logger.info("file sent");
		} catch (Exception e) {
			logger.error("Logger: socket connection fail, abnormal exit on client");
			logger.error(e);
			e.printStackTrace();
		} finally {
			try {
				if (serverResponse != null) {
					serverResponse.close();
				}
				if (writer != null) {
					writer.close();
				}
				if (fileIn != null) {
					fileIn.close();
				}
				if (cSocket != null) {
					cSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("クライアント側終了です");
			logger.info("zip sent");
			try {
				Mailable sender = new MailSender();
				String title = "zip is sent";
				String text = "zip sent successfully to server";
				sender.send(title, text);
			} catch (Exception e) {
				System.out.println("Failed to send mail. Check communication.javaMail ");
			}
		}
	}
}

public class ClientApp {
	public static void main(String[] args) {
		ClientEntity c1 = new ClientEntity();
		String dirBase = common.util.FilePath.getDefaultRootDir();
		//target to be sent
		String tgrTBS= dirBase + File.separator + "qResult" + File.separator + "zipResult" + File.separator + "EMPInfo.zip";
		c1.run(tgrTBS);
	}
}
