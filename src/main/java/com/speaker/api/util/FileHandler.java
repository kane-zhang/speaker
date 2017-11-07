package com.speaker.api.util;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandler {

	public static boolean saveFile(String path, String fileName, byte[] bytes) {
		FileOutputStream fos = null;
		boolean isSuccesful = false;

		try {
			fos = new FileOutputStream(path + System.getProperty("file.separator") + fileName);
			fos.write(bytes);
			isSuccesful = true;
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return isSuccesful;
	}
}
