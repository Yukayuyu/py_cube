package common.dataIO;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.*;

public class Zipper {
	/**
	 * Search the tgrDir for files, ignore sub folders, add all files to zip. output directory : tgrDir/zipResult/;
	 * Existing ZIP file will be overridden.
	 * qResultフォルダーに全てのファイルを圧縮し、結果をqResult/zipResultに入れる。
	 * 制限：先にqResult/zipResult フォルダーを作る必要がある。 * 
	 * @param args
	 * @throws IOException
	 */
	public static void zip() throws IOException {
		String rootDir = common.util.FilePath.getDefaultRootDir();
		File tgrDir = new File(rootDir + File.separator + "qResult");
		File zipOut = new File(rootDir + File.separator + "qResult" + File.separator + "zipResult" + File.separator
		        + "EMPInfo.zip");
		// 圧縮実行
		compressDirectory(zipOut, tgrDir);
	}

	private static void compressDirectory(final File destination, final File dir) throws IOException {
		byte[] buf = new byte[4096];
		ZipOutputStream zos = null;
		InputStream is = null;

		// ZIP対象フォルダ配下の全ファイルを取得
		List<File> files = new ArrayList<File>();
		getFiles(dir, files);

		try {
			// ZIP出力オブジェクトを取得
			zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(destination)),
			        Charset.forName("UTF-8"));

			// 全ファイルをZIPに格納
			for (File file : files) {
				// ZIP化実施ファイルの情報をオブジェクトに設定
				ZipEntry entry = new ZipEntry(file.getName());
				zos.putNextEntry(entry);

				// ZIPファイルに情報を書き込む
				is = new BufferedInputStream(new FileInputStream(file));
				int len = 0;
				while ((len = is.read(buf)) > 0) {
					zos.write(buf, 0, len);
				}
			}
			// 処理の最後にストリームは常に閉じる
		} finally {
			if (zos != null) {
				zos.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}

	private static void getFiles(final File tgrDir, final List<File> files) {
		// ファイル取得対象フォルダ直下のファイル,ディレクトリを走査
		for (File f : tgrDir.listFiles()) {
			// ファイルの場合はファイル一覧に追加
			if (f.isFile()) {
				files.add(f);
				// ディレクトリの場合は無視する
			} else if (f.isDirectory()) {
				continue;
			}
		}
	}

}
