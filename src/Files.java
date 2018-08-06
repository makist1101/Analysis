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
	
	public void download(boolean onlyNew) {
		if (Analysis.downloadStuff) {
			long startDownloadTimeStamp = System.currentTimeMillis();
			downloadFiles(Common.linkToBasicFixtures, Common.pathToBasicFixtures);
			downloadFiles(Common.linkToExtraFixtures, Common.pathToExtraFixtures);
			downloadExtra(1);
			downloadExtra(2);
			
			downloadBasicNew(3);
			downloadBasicNew(2);
			downloadBasicNew(1);
			if (!onlyNew) {
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
			for (int j = 0; j < Common.leaguesInputRestS.length; j++) {
				downloadFiles(Common.linkToExtraData + Common.leaguesInputRestS[j] + ".csv",
						Common.pathToNewData + Common.leaguesOutputRestS[j] + ".0000" + ".csv");
			}
			break;
		case 1:
			for (int j = 0; j < Common.leaguesInputRestW.length; j++) {
				downloadFiles(Common.linkToExtraData + Common.leaguesInputRestW[j] + ".csv",
						Common.pathToNewData + Common.leaguesOutputRestW[j] + ".0000" + ".csv");
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
				for (int j = 0; j < Common.leaguesInputThird.length; j++) {
					downloadFiles(Common.linkToBasicData + Common.seasonsOldInput[i] + Common.leaguesInputThird[j] + ".csv",
							Common.pathToOldData + Common.leaguesOutputThird[j] + Common.seasonsOldOutput[i] + ".csv");
				}
			}
			break;
		case 2:
			for (int i = 0; i < Common.seasonsOldInput.length; i++) {
				for (int j = 0; j < Common.leaguesInputSecond.length; j++) {
					downloadFiles(Common.linkToBasicData + Common.seasonsOldInput[i] + Common.leaguesInputSecond[j] + ".csv",
							Common.pathToOldData + Common.leaguesOutputSecond[j] + Common.seasonsOldOutput[i] + ".csv");
				}
			}
			break;
		case 1:
			for (int i = 0; i < Common.seasonsOldInput.length; i++) {
				for (int j = 0; j < Common.leaguesInputFirst.length; j++) {
					downloadFiles(Common.linkToBasicData + Common.seasonsOldInput[i] + Common.leaguesInputFirst[j] + ".csv",
							Common.pathToOldData + Common.leaguesOutputFirst[j] + Common.seasonsOldOutput[i] + ".csv");
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
				for(int j=0;j<Common.leaguesInputThird.length;j++){
					downloadFiles(Common.linkToBasicData+Common.seasonsNewInput[i]+Common.leaguesInputThird[j]+".csv",
							Common.pathToNewData+Common.leaguesOutputThird[j]+Common.seasonsNewOutput[i]+".csv");
				}
			}
			break;
		case 2:
			for(int i=0;i<Common.seasonsNewInput.length;i++){
				for(int j	=0;j<Common.leaguesInputSecond.length;j++){
					downloadFiles(Common.linkToBasicData+Common.seasonsNewInput[i]+Common.leaguesInputSecond[j]+".csv",
							Common.pathToNewData+Common.leaguesOutputSecond[j]+Common.seasonsNewOutput[i]+".csv");
				}
			}
			break;
		case 1:
			for(int i=0;i<Common.seasonsNewInput.length;i++){
				for(int j=0;j<Common.leaguesInputFirst.length;j++){
					downloadFiles(Common.linkToBasicData+Common.seasonsNewInput[i]+Common.leaguesInputFirst[j]+".csv",
							Common.pathToNewData+Common.leaguesOutputFirst[j]+Common.seasonsNewOutput[i]+".csv");
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
				System.out.println("OK->" + URLName);
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
				System.out.println("Extra file"+folderNewData.listFiles()[i].getName());
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
				System.out.println("Extra file:"+folderOldData.listFiles()[i].getName());
			}
		}
	}

	public List<File> getData(){
		return listOfData;
	}
	
	public Files() {
		listOfData = new ArrayList<File>();		
		download(true);
		createData();
	}
	
}
