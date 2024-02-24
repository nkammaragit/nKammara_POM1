package com.letzAutomate.qa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil2 {

	public static String renameFileWithTimestamp(String filePath) {
		File file = new File(filePath);
		String newFileName = null;
		// Check if the file exists
		if (file.exists()) {
			// Get the current timestamp
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
			String timestamp = dateFormat.format(new Date());

			// Get the file extension
			int dotIndex = filePath.lastIndexOf('.');
			String extension = "";
			if (dotIndex >= 0 && dotIndex < filePath.length() - 1) {
				extension = filePath.substring(dotIndex);
			}

			// Construct the new file name with timestamp
			newFileName = file.getParent() + File.separator + "Extent_" + timestamp + extension;

			// Create a new File object with the new file name
			File newFile = new File(newFileName);

			// Rename the file
			if (file.renameTo(newFile)) {

				System.out.println("File renamed successfully to: " + newFileName);
				return newFileName ;

			} else {
				System.err.println("Failed to rename the file.");
			}
		} else {
			System.err.println("File not found: " + filePath);
		}
		return newFileName ;
	}
}
