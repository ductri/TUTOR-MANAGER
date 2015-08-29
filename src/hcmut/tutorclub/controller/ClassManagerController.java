package hcmut.tutorclub.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.ServiceException;

import hcmut.tutorclub.model.classmanager.Class;
import hcmut.tutorclub.model.classmanager.Student;

public class ClassManagerController implements IClassManagerController {

	private static final String SHEET_NAME = "DICH-VU.xlsx";
	private static final String WORKSHEET_NAME = "GIA SƯ 2015";
	private static final String KEYWORD = "mssv";
	private static final String SHEETS_SCOPE = "https://spreadsheets.google.com/feeds";
	
	private Credential credential;
	private boolean hasCredential;
	
	public ClassManagerController() {
		
		hasCredential = false;
	}
	
	@Override
	public List<Class> findClassNotHandOver() throws IOException, ServiceException {
		if (credential == null)
			return null;
		
        SpreadsheetService service = new SpreadsheetService("My service");
        service.setOAuth2Credentials(credential);
        
        URL SPREADSHEET_FEED_URL = new URL(
                "https://spreadsheets.google.com/feeds/spreadsheets/private/full");
        
        SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL, SpreadsheetFeed.class);
        List<SpreadsheetEntry> spreadsheets = feed.getEntries();
        SpreadsheetEntry spreadsheetEntry = null;
        // Iterate through all of the spreadsheets returned
        for (SpreadsheetEntry spreadsheet : spreadsheets) {
          if (spreadsheet.getTitle().getPlainText().equals(SHEET_NAME)) {
        	  spreadsheetEntry = spreadsheet;
        	  break;
          }  
        }
        if (spreadsheetEntry != null) {
        	WorksheetFeed worksheetFeed = service.getFeed(spreadsheetEntry.getWorksheetFeedUrl(),
	        			WorksheetFeed.class);
        	List<WorksheetEntry> worksheets = worksheetFeed.getEntries();
        	WorksheetEntry worksheetEntry = null;
        	for (WorksheetEntry worksheet:worksheets) {
        		if (worksheet.getTitle().getPlainText().equals(WORKSHEET_NAME)) {
        			worksheetEntry = worksheet;
        			break;
        		}
        	}
        	
        	ListFeed listFeed = service.getFeed(worksheetEntry.getListFeedUrl(), ListFeed.class);
        	List<Class> classes = new ArrayList<Class>();
        	
        	for (ListEntry row:listFeed.getEntries()) {
        		if (row.getCustomElements().getValue(KEYWORD) == null) {
        			Class classEntry = new Class();
        			Set<String> headers = row.getCustomElements().getTags();
	        		Iterator<String> itrHeaders = headers.iterator(); 
	        		
	        		classEntry.setId(row.getCustomElements().getValue((String)itrHeaders.next()));
	        		classEntry.setDateReceive(row.getCustomElements().getValue((String)itrHeaders.next()));
	        		classEntry.setDateHandOver(row.getCustomElements().getValue((String)itrHeaders.next()));
	        		classEntry.setParentName(row.getCustomElements().getValue((String)itrHeaders.next()));
	        		classEntry.setSex(row.getCustomElements().getValue((String)itrHeaders.next()));
	        		classEntry.setPhone(row.getCustomElements().getValue((String)itrHeaders.next()));
	        		classEntry.setAdddress(row.getCustomElements().getValue((String)itrHeaders.next()));
	        		classEntry.setGrade(row.getCustomElements().getValue((String)itrHeaders.next()));
	        		classEntry.setSubjects(row.getCustomElements().getValue((String)itrHeaders.next()));
	        		classEntry.setSchedule(row.getCustomElements().getValue((String)itrHeaders.next()));
	        		classEntry.setOthers(row.getCustomElements().getValue((String)itrHeaders.next()));
	        		classes.add(classEntry);
        		}
        	}
        	return classes;
        } else {
        	return null;
        }
        
		
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class> findClassHandOver2Student(String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handOverClass(Student student) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isAuthorization() {
		return hasCredential;
	};

	@Override
	public void authorize() throws IOException, GeneralSecurityException {
		HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
    	JacksonFactory jsonFactory = new JacksonFactory();
    	GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
    			jsonFactory, new InputStreamReader(
    					ClassManagerController.class.getResourceAsStream("/client_secrets.json")));
    	Collection<String> scopes = Collections.singleton(SHEETS_SCOPE);
    	File file = new File("oauth_store");
    	DataStoreFactory dataStoreFactory = new FileDataStoreFactory(file);
    	
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
        		transport, jsonFactory, clientSecrets, scopes).setDataStoreFactory(dataStoreFactory).build();
        
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
        		.authorize("");
        hasCredential = true;
        this.credential = credential;
	}
	
}
