import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

public class Files {
	
	public List<File> listOfData;
	
	public void download() {
		if (Analysis.downloadFiles) {
			long startDownloadTimeStamp = System.currentTimeMillis();
			downloadFiles(Common.linkToBasicFixtures, Common.pathToBasicFixtures);
			downloadFiles(Common.linkToExtraFixtures, Common.pathToExtraFixtures);
			downloadExtra(1);
			downloadExtra(2);
			
			downloadBasicNew(3);
			downloadBasicNew(2);
			downloadBasicNew(1);
			if (!Analysis.downloadOnlyNewFiles) {
				downloadBasicOld(3);
				downloadBasicOld(2);
				downloadBasicOld(1);
			}
			System.out.println("Download completed in:"+(System.currentTimeMillis()-startDownloadTimeStamp)+"ms");
		}
	}

	public void downloadExtra(int option) {
		switch (option) {
		case 2:
			for (int j = 0; j < Common.leaguesExtraStartW.length; j++) {
				downloadFiles(Common.linkToExtraData + Common.leaguesExtraStartW[j] + ".csv",
						Common.pathToNewData + Common.fixCodeDiv(Common.leaguesExtraStartW[j]) + ".0000" + ".csv");
			}
			break;
		case 1:
			for (int j = 0; j < Common.leaguesExtraStartS.length; j++) {
				downloadFiles(Common.linkToExtraData + Common.leaguesExtraStartS[j] + ".csv",
						Common.pathToNewData + Common.fixCodeDiv(Common.leaguesExtraStartS[j]) + ".0000" + ".csv");
			}
			break;
		default:
			break;
		}
	}

	public void downloadBasicOld(int option) {
		switch (option) {
		case 3:
			for (int i = 0; i < Common.seasonsOldInput.length; i++) {
				for (int j = 0; j < Common.leaguesThird.length; j++) {
					downloadFiles(Common.linkToBasicData + Common.seasonsOldInput[i] + Common.leaguesThird[j] + ".csv",
							Common.pathToOldData + Common.fixCodeDiv(Common.leaguesThird[j]) + Common.seasonsOldOutput[i] + ".csv");
				}
			}
			break;
		case 2:
			for (int i = 0; i < Common.seasonsOldInput.length; i++) {
				for (int j = 0; j < Common.leaguesSecond.length; j++) {
					downloadFiles(Common.linkToBasicData + Common.seasonsOldInput[i] + Common.leaguesSecond[j] + ".csv",
							Common.pathToOldData + Common.fixCodeDiv(Common.leaguesSecond[j]) + Common.seasonsOldOutput[i] + ".csv");
				}
			}
			break;
		case 1:
			for (int i = 0; i < Common.seasonsOldInput.length; i++) {
				for (int j = 0; j < Common.leaguesFirst.length; j++) {
					downloadFiles(Common.linkToBasicData + Common.seasonsOldInput[i] + Common.leaguesFirst[j] + ".csv",
							Common.pathToOldData + Common.fixCodeDiv(Common.leaguesFirst[j]) + Common.seasonsOldOutput[i] + ".csv");
				}
			}
			break;
		default:
			break;
		}
	}

	public void downloadBasicNew(int option) {
		switch(option) {
		case 3:
			for(int i=0;i<Common.seasonsNewInput.length;i++){
				for(int j=0;j<Common.leaguesThird.length;j++){
					downloadFiles(Common.linkToBasicData+Common.seasonsNewInput[i]+Common.leaguesThird[j]+".csv",
							Common.pathToNewData+Common.fixCodeDiv(Common.leaguesThird[j])+Common.seasonsNewOutput[i]+".csv");
				}
			}
			break;
		case 2:
			for(int i=0;i<Common.seasonsNewInput.length;i++){
				for(int j	=0;j<Common.leaguesSecond.length;j++){
					downloadFiles(Common.linkToBasicData+Common.seasonsNewInput[i]+Common.leaguesSecond[j]+".csv",
							Common.pathToNewData+Common.fixCodeDiv(Common.leaguesSecond[j])+Common.seasonsNewOutput[i]+".csv");
				}
			}
			break;
		case 1:
			for(int i=0;i<Common.seasonsNewInput.length;i++){
				for(int j=0;j<Common.leaguesFirst.length;j++){
					downloadFiles(Common.linkToBasicData+Common.seasonsNewInput[i]+Common.leaguesFirst[j]+".csv",
							Common.pathToNewData+Common.fixCodeDiv(Common.leaguesFirst[j])+Common.seasonsNewOutput[i]+".csv");
				}
			}
			break;
			default:break;
		}
		
	}
	
	public boolean exists(String URLName) {
		try {
			HttpURLConnection.setFollowRedirects(false);
			// HttpURLConnection.setInstanceFollowRedirects(false);// note : you may also need
			HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();
			con.setRequestMethod("HEAD");
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				//System.out.println("OK->" + URLName);
				return true;
			} else {
				System.out.println("Cyka Blyat->" + URLName);
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void downloadFiles(String inputpath, String outputpath) {
		if (exists(inputpath)) {
			try {
				URL website = new URL(inputpath);
				ReadableByteChannel rbc = Channels.newChannel(website.openStream());
				FileOutputStream fos = new FileOutputStream(outputpath);
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				fos.close();
				rbc.close();
			} catch (FileNotFoundException e) {
				System.out.println("The file " + inputpath + " was not found.");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void createData() {
		File folderNewData = new File(Common.pathToNewData);
		File folderOldData = new File(Common.pathToOldData);

		String fileName;
		for (int i = 0; i < folderNewData.listFiles().length; i++) {
			fileName = folderNewData.listFiles()[i].getName();
			if (folderNewData.listFiles()[i].isFile() 
					&& fileName.substring(fileName.lastIndexOf('.') + 1).equals("csv")
					&& !fileName.equalsIgnoreCase(Common.basicFixtures)
					&& !fileName.equalsIgnoreCase(Common.extraFixtures)) {
				listOfData.add(folderNewData.listFiles()[i]);
			} else {
				System.out.println("Alert:Extra file "+folderNewData.listFiles()[i].getName());
			}
		}

		for (int i = 0; i < folderOldData.listFiles().length; i++) {
			fileName = folderOldData.listFiles()[i].getName();
			if (folderOldData.listFiles()[i].isFile() 
					&& fileName.substring(fileName.lastIndexOf('.') + 1).equals("csv")
					&& !fileName.equalsIgnoreCase(Common.basicFixtures)
					&& !fileName.equalsIgnoreCase(Common.extraFixtures)) {
				listOfData.add(folderOldData.listFiles()[i]);
			} else {
				System.out.println("Alert:Extra file "+folderOldData.listFiles()[i].getName());
			}
		}
	}

	public List<File> getData(){
		return listOfData;
	}
	
	public Files() {
		listOfData = new ArrayList<File>();		
		download();
		createData();
	}
	
}
