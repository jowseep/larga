package com.example.proj.GmailAPI;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class GmailAPI {

    private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.GMAIL_LABELS);
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String user = "me";
	static Gmail service = null;
	private static File filePath = new File(System.getProperty("user.dir") + "/credentials.json");
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

	public static void main(String[] args) throws IOException, GeneralSecurityException {
		getAccessToken();

	}

	public static Gmail getGmailService() throws IOException, GeneralSecurityException {

		InputStream in = new FileInputStream(filePath); // Read credentials.json
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		Credential authorize = new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
				.setJsonFactory(JSON_FACTORY)
				.setClientSecrets(clientSecrets.getDetails().getClientId().toString(),
						clientSecrets.getDetails().getClientSecret().toString())
				.build().setAccessToken(getAccessToken()).setRefreshToken(
						"REFRESH_TOKEN");//Should replace this

		// Create Gmail service
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, authorize)
				.setApplicationName(GmailAPI.APPLICATION_NAME).build();

		return service;
	}
	private static String getAccessToken() {

		try {
			Map<String, Object> params = new LinkedHashMap<>();
			params.put("grant_type", "refresh_token");
			params.put("client_id", "CLIENT_ID"); //Should replace this
			params.put("client_secret", "CLIENT_SECRET"); //Should replace this
			params.put("refresh_token",
					"REFRESH_TOKEN"); //Should replace this

			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, Object> param : params.entrySet()) {
				if (postData.length() != 0) {
					postData.append('&');
				}
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");

			URL url = new URL("https://accounts.google.com/o/oauth2/token");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setRequestMethod("POST");
			con.getOutputStream().write(postDataBytes);

			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuffer buffer = new StringBuffer();
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				buffer.append(line);
			}

			JSONObject json = new JSONObject(buffer.toString());
			String accessToken = json.getString("access_token");
			return accessToken;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

    // public static Gmail getGmailService() {
    //     return null;
    // }

    // private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
    // private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    // private static final String user = "me";
    // private static final String TOKENS_DIRECTORY_PATH = "tokens";

    // private static final List<String> SCOPES = Collections.singletonList(GmailScopes.GMAIL_LABELS);
    // private static File filePath = new File(System.getProperty("user.dir") + "/credentials.json");

    // private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
    //     InputStream in = new FileInputStream(filePath);
    //     GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

    //     GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
    //             HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
    //             .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
    //             .setAccessType("offline")
    //             .build();
    //     LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8080).build();
    //     Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize(user);
    //     return credential;
    // }

    // public static void main(String[] args) throws IOException, GeneralSecurityException {
    //     final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    //     Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
    //             .setApplicationName(APPLICATION_NAME)
    //             .build();

    //     String user = "jowseep@gmail.com";
    //     ListLabelsResponse listResponse = service.users().labels().list(user).execute();
    //     List<Label> labels = listResponse.getLabels();
    //     if (labels.isEmpty()) {
    //         System.out.println("No labels found.");
    //     } else {
    //         System.out.println("Labels:");
    //         for (Label label : labels) {
    //             System.out.printf("- %s\n", label.getName());
    //         }
    //     }
    // }
}
